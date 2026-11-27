package ru.nippy.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import ru.nippy.NippyClient;
import ru.nippy.config.NippyConfig;
import ru.nippy.module.Module;
import ru.nippy.module.ModuleManager;

/**
 * Quick-menu po Right Shift (v duhe Saturn/Lunar):
 * blur fona + wallpaper + kristall-novogodnij logotip + animaciya poyavleniya.
 */
public class QuickMenuScreen extends Screen {
    private static final Identifier WALLPAPER =
            Identifier.of("nippy", "textures/gui/wallpapers/wallpaper_1.png");
    private static final Identifier LOGO_CRYSTAL =
            Identifier.of("nippy", "textures/gui/crystal_logo.png");
    private static final Identifier SNOWFLAKE =
            Identifier.of("nippy", "textures/gui/snowflake.png");

    private static final int PANEL_W = 460;
    private static final int PANEL_H = 280;
    private static final int CORNER = 10;

    public QuickMenuScreen() {
        super(Text.literal("Nippy Quick Menu"));
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        float p = NippyGuiManager.getProgress();
        int sw = this.width, sh = this.height;

        // 1) Blur fona (vsyo, chto za menyom, razmyvaetsya) + temnenie.
        //    V 1.21.x blur vstryvaetsya cherez MinecraftClient.gameRenderer postProcessor,
        //    zdes' — fallback: temnyi overlay, chtoby ne zaviset ot shaderov.
        ctx.fill(0, 0, sw, sh, (int) (0xB0 * p) << 24);

        // 2) Wallpaper po centru (anime-art / zimnii peizazh iz packa)
        int wp = (int) (Math.min(sw, sh * 16 / 9) * 0.75f * p);
        int wh = wp * 9 / 16;
        ctx.drawTexture(WALLPAPER, (sw - wp) / 2, (sh - wh) / 2, wp, wh, 0f, 0f, 256, 144, 256, 144);

        // 3) Panel po centru (skrugleniya risuem kvadratikami — inache nuzhen shader/texture)
        int px = (sw - PANEL_W) / 2, py = (sh - PANEL_H) / 2;
        ctx.fill(px, py, px + PANEL_W, py + PANEL_H, Theme.BG);
        // moroznaya obvodka
        ctx.drawBorder(px, py, PANEL_W, PANEL_H, Theme.BORDER);

        // 4) Logo: kristal (novogodnii, s inem) + nazvanie
        int logoSize = (int) (48 * (0.5f + 0.5f * p));
        ctx.drawTexture(LOGO_CRYSTAL, sw / 2 - logoSize / 2, py + 16, logoSize, logoSize, 0f, 0f, 64, 64, 64, 64);
        ctx.drawCenteredStringWithShadow(this.textRenderer, "NIPPY", sw / 2, py + 16 + logoSize + 4, Theme.ACCENT);

        // 5) Kartochki modulei (top-5 perfomance + hud)
        int y = py + 90;
        renderQuickModule(ctx, px + 24, y, "Clean Rain");
        renderQuickModule(ctx, px + 24, y + 30, "Static Water");
        renderQuickModule(ctx, px + 24, y + 60, "Disable Overlays");
        renderQuickModule(ctx, px + 24, y + 90, "Watermark");
        renderQuickModule(ctx, px + 24, y + 120, "FpsCounter");

        // 6) Snizhinki na paneli (dekor)
        long t = System.currentTimeMillis() / 500;
        for (int i = 0; i < 8; i++) {
            int sx = px + 12 + (i * 55 + (int) t) % (PANEL_W - 24);
            int sy = py + 8 + (int) ((t * 2 + i * 37) % (PANEL_H - 16));
            ctx.drawTexture(SNOWFLAKE, sx, sy, 6, 6, 0f, 0f, 16, 16, 16, 16);
        }

        super.render(ctx, mouseX, mouseY, delta);
    }

    private void renderQuickModule(DrawContext ctx, int x, int y, String moduleName) {
        Module m = ModuleManager.getModules().stream()
                .filter(mod -> mod.getName().equalsIgnoreCase(moduleName))
                .findFirst().orElse(null);
        if (m == null) return;
        int w = PANEL_W - 48;
        int c = m.isEnabled() ? Theme.ENABLED : Theme.DISABLED;
        ctx.fill(x, y, x + w, y + 24, Theme.BG_SOFT);
        ctx.drawString(this.textRenderer, m.getName(), x + 8, y + 8, Theme.TEXT, true);
        // toggle
        int tx = x + w - 40;
        ctx.fill(tx, y + 6, tx + 30, y + 18, 0xFF33334A);
        int knob = m.isEnabled() ? tx + 18 : tx + 2;
        ctx.fill(knob, y + 7, knob + 10, y + 17, m.isEnabled() ? Theme.ACCENT : Theme.SUBTEXT);
        ctx.drawString(this.textRenderer, m.isEnabled() ? "ON" : "OFF", x + w - 60, y + 8, c, false);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // Zdes' obrabotka klika po toggle — dopisivaetsya s ModuleManager
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void close() {
        NippyGuiManager.toggleQuickMenu();
        super.close();
    }

    @Override
    public boolean shouldPause() {
        return false; // igra ne pauzitsya — kak v Saturn/Lunar
    }
}

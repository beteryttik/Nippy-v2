package ru.nippy.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.Click;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import ru.nippy.module.ModuleManager;

import java.util.ArrayList;
import java.util.List;

public class QuickMenuScreen extends Screen {
    private static final Identifier WALLPAPER = Identifier.of("nippy", "textures/gui/wallpaper.png");
    private static final Identifier LOGO_CRYSTAL = Identifier.of("nippy", "textures/gui/logo.png");
    private static final Identifier SNOWFLAKE = Identifier.of("nippy", "textures/gui/snowflake.png");

    private static final int PANEL_W = 220;
    private static final int PANEL_H = 200;

    private final List<ModuleCard> cards = new ArrayList<>();
    private int scroll;
    private float snowTimer;

    public QuickMenuScreen() {
        super(Text.literal("Nippy"));
        ModuleManager.getModules().forEach(m -> cards.add(new ModuleCard(m)));
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        int sw = this.width;
        int sh = this.height;

        int wp = Math.min(sw, 256);
        int wh = Math.min(sh, 144);
        ctx.drawTexture(RenderPipelines.GUI_TEXTURED, WALLPAPER,
                (sw - wp) / 2, (sh - wh) / 2, 0f, 0f, wp, wh, 256, 144);

        int px = (sw - PANEL_W) / 2;
        int py = (sh - PANEL_H) / 2;

        ctx.fill(px, py, px + PANEL_W, py + PANEL_H, Theme.PANEL);
        ctx.drawStrokedRectangle(px, py, PANEL_W, PANEL_H, Theme.BORDER);

        int logoSize = 24;
        ctx.drawTexture(RenderPipelines.GUI_TEXTURED, LOGO_CRYSTAL,
                sw / 2 - logoSize / 2, py + 10, 0f, 0f, logoSize, logoSize, 64, 64);
        ctx.drawCenteredTextWithShadow(this.textRenderer, "NIPPY",
                sw / 2, py + 10 + logoSize + 4, Theme.ACCENT);

        int y = py + 44 - scroll;
        for (ModuleCard card : cards) {
            y += card.render(ctx, this.textRenderer, px + 8, y, PANEL_W - 16);
        }

        float sx = (float) ((sw / 2.0 + Math.cos(snowTimer) * sw / 3.0) % sw);
        float sy = (snowTimer * 12f) % sh;
        ctx.drawTexture(RenderPipelines.GUI_TEXTURED, SNOWFLAKE,
                (int) sx, (int) sy, 0f, 0f, 6, 6, 16, 16);

        super.render(ctx, mouseX, mouseY, delta);
    }

    @Override
    public void tick() {
        super.tick();
        snowTimer += 0.05f;
    }

    @Override
    public boolean mouseClicked(Click click, boolean doubled) {
        double mouseX = click.x();
        double mouseY = click.y();

        int px = (this.width - PANEL_W) / 2;
        int py = (this.height - PANEL_H) / 2;

        int y = py + 44 - scroll;
        for (ModuleCard card : cards) {
            if (card.mouseClicked(mouseX, mouseY, px + 8, y, PANEL_W - 16)) {
                return true;
            }
            y += card.getLastHeight();
        }
        return super.mouseClicked(click, doubled);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontal, double vertical) {
        scroll = Math.max(0, scroll - (int) (vertical * 12));
        return super.mouseScrolled(mouseX, mouseY, horizontal, vertical);
    }
}

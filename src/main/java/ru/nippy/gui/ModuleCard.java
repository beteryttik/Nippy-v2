package ru.nippy.gui;

import net.minecraft.client.gui.DrawContext;
import ru.nippy.module.Module;
import ru.nippy.module.Setting;

/**
 * Kartochka modulya dlya polnogo menu (v duhe ReallyVisuals):
 * nazvanie, opisanie, status, fioletovyi toggle, rashryatie nastroek.
 */
public class ModuleCard {
    private static final int PADDING = 12;
    private static final int CORNER = 8;

    private final Module module;
    private boolean expanded;
    private int x, y, width, height;

    public ModuleCard(Module module) { this.module = module; }

    public void setBounds(int x, int y, int w, int h) { this.x = x; this.y = y; this.width = w; this.height = h; }
    public Module getModule() { return module; }

    public void render(DrawContext ctx, int mouseX, int mouseY) {
        boolean hovered = mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
        ctx.fill(x, y, x + width, y + height, hovered ? Theme.BG_SOFT : Theme.BG);
        ctx.drawBorder(x, y, width, height, module.isEnabled() ? Theme.ACCENT : Theme.BORDER);

        ctx.drawString(ctx.getTextRenderer(), module.getName(), x + PADDING, y + PADDING, Theme.TEXT, true);
        ctx.drawString(ctx.getTextRenderer(), module.getDescription(), x + PADDING, y + PADDING + 12, Theme.SUBTEXT, true);

        // toggle
        int tx = x + width - PADDING - 34;
        ctx.fill(tx, y + PADDING, tx + 30, y + PADDING + 14, 0xFF33334A);
        int knob = module.isEnabled() ? tx + 18 : tx + 2;
        ctx.fill(knob, y + PADDING + 2, knob + 10, y + PADDING + 12,
                module.isEnabled() ? Theme.ACCENT : Theme.SUBTEXT);

        // status
        String st = module.isEnabled() ? "ENABLED" : "DISABLED";
        int sc = module.isEnabled() ? Theme.ENABLED : Theme.DISABLED;
        ctx.drawString(ctx.getTextRenderer(), st, tx - ctx.getTextRenderer().getWidth(st) - 8, y + PADDING, sc, true);

        // arrow
        if (!module.getSettings().isEmpty()) {
            ctx.drawString(ctx.getTextRenderer(), expanded ? "v" : ">", x + width - PADDING - 8, y + height - 16, Theme.SUBTEXT, true);
        }

        if (expanded) {
            int sy = y + height;
            ctx.fill(x, sy, x + width, sy + module.getSettings().size() * 18 + 8, Theme.BG_SOFT);
            int i = 0;
            for (Setting s : module.getSettings()) {
                ctx.drawString(ctx.getTextRenderer(), s.getName(), x + PADDING, sy + 4 + i * 18, Theme.TEXT, true);
                i++;
            }
        }
    }

    public boolean onClick(double mx, double my) {
        if (mx < x || mx > x + width || my < y || my > y + height) return false;
        int tx = x + width - PADDING - 34;
        if (my >= y && my <= y + 30) {
            if (mx >= tx && mx <= tx + 30) { module.toggle(); return true; }
        }
        if (!module.getSettings().isEmpty() && my >= y + height - 24) { expanded = !expanded; return true; }
        return false;
    }
}

package ru.nippy.gui;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import ru.nippy.module.Module;
import ru.nippy.module.Setting;

public class ModuleCard {
    private static final int PADDING = 8;
    private static final int HEIGHT = 26;

    private final Module module;
    private boolean expanded;
    private int lastHeight = HEIGHT;

    public ModuleCard(Module module) {
        this.module = module;
    }

    public Module getModule() { return module; }
    public int getLastHeight() { return lastHeight; }

    public int render(DrawContext ctx, TextRenderer font, int x, int y, int width) {
        ctx.fill(x, y, x + width, y + HEIGHT, Theme.PANEL);
        ctx.drawStrokedRectangle(x, y, width, HEIGHT,
                module.isEnabled() ? Theme.ACCENT : Theme.BORDER);

        ctx.drawText(font, module.getName(), x + PADDING, y + PADDING, Theme.TEXT, true);

        String st = module.isEnabled() ? "ON" : "OFF";
        ctx.drawText(font, st, x + width - PADDING - font.getWidth(st), y + PADDING,
                module.isEnabled() ? Theme.ON : Theme.OFF, true);
        ctx.drawText(font, expanded ? "v" : ">", x + width - PADDING - 8, y + PADDING,
                Theme.SUBTEXT, true);

        int total = HEIGHT;
        if (expanded) {
            ctx.drawText(font, module.getDescription(), x + PADDING, y + HEIGHT, Theme.SUBTEXT, true);
            int sy = y + HEIGHT + 12;
            for (Setting s : module.getSettings()) {
                ctx.drawText(font, (s.getValue() ? "[x] " : "[ ] ") + s.getName(),
                        x + PADDING, sy, Theme.TEXT, true);
                sy += 12;
            }
            total = HEIGHT + 14 + module.getSettings().size() * 12;
        }
        lastHeight = total;
        return total;
    }

    /** true, если клик попал в карточку и был обработан */
    public boolean mouseClicked(double mouseX, double mouseY, int x, int y, int width) {
        if (mouseX < x || mouseX > x + width) return false;
        if (mouseY < y || mouseY > y + lastHeight) return false;

        if (mouseX > x + width - 24) {
            expanded = !expanded;
        } else {
            module.toggle();
        }
        return true;
    }
}

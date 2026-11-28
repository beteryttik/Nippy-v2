package ru.nippy.gui;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import ru.nippy.module.BooleanSetting;
import ru.nippy.module.Module;
import ru.nippy.module.ModeSetting;
import ru.nippy.module.Setting;
import ru.nippy.module.SliderSetting;

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
                ctx.drawText(font, settingLabel(s), x + PADDING, sy, Theme.TEXT, true);
                sy += 12;
            }
            total = HEIGHT + 14 + module.getSettings().size() * 12;
        }
        lastHeight = total;
        return total;
    }

    private String settingLabel(Setting s) {
        if (s instanceof BooleanSetting b) {
            return (b.get() ? "[x] " : "[ ] ") + s.getName();
        }
        if (s instanceof SliderSetting sl) {
            return s.getName() + ": " + sl.getInt();
        }
        if (s instanceof ModeSetting ms) {
            return s.getName() + ": " + ms.getSelected();
        }
        return s.getName();
    }

    public boolean mouseClicked(double mouseX, double mouseY, int x, int y, int width) {
        if (mouseX < x || mouseX > x + width) return false;
        if (mouseY < y || mouseY > y + lastHeight) return false;

        if (mouseY <= y + HEIGHT) {
            // клик по шапке: правая часть — стрелка раскрытия, остальное — вкл/выкл
            if (mouseX > x + width - 24) {
                expanded = !expanded;
            } else {
                module.toggle();
            }
            return true;
        }

        // клик по настройкам
        int idx = (int) ((mouseY - (y + HEIGHT + 12)) / 12);
        if (idx >= 0 && idx < module.getSettings().size()) {
            Setting s = module.getSettings().get(idx);
            if (s instanceof BooleanSetting b) b.toggle();
            if (s instanceof ModeSetting m) m.cycle();
            return true;
        }
        return true;
    }
}

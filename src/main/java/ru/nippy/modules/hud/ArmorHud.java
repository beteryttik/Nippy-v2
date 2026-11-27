package ru.nippy.modules.hud;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class ArmorHud extends Module {
    public ArmorHud() {
        super("ArmorHUD", Category.HUD, "Броня на экране");
        bool("Enabled", true); mode("Layout", "Horizontal", "Vertical");
    }

}

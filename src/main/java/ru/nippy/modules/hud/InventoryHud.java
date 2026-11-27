package ru.nippy.modules.hud;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class InventoryHud extends Module {
    public InventoryHud() {
        super("InventoryHUD", Category.HUD, "Инвентарь на экране");
        bool("Enabled", false);
    }

}

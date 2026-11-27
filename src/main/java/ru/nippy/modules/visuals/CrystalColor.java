package ru.nippy.modules.visuals;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class CrystalColor extends Module {
    public CrystalColor() {
        super("CrystalColor", Category.VISUALS, "Цвет энд-кристаллов");
        bool("Enabled", true); mode("Color", "Purple", "Ice", "Rainbow");
    }

}

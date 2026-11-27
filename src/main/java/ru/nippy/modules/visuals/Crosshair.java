package ru.nippy.modules.visuals;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Crosshair extends Module {
    public Crosshair() {
        super("Crosshair", Category.VISUALS, "Кастомный прицел");
        bool("Enabled", true); mode("Style", "Dot", "Cross", "Circle"); slider("Thickness", 2, 1, 5);
    }

}

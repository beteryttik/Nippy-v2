package ru.nippy.modules.performance;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class StaticWater extends Module {
    public StaticWater() {
        super("StaticWater", Category.PERFORMANCE, "Статичная вода (FPS+)");
        bool("Enabled", false);
    }

}

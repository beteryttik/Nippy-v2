package ru.nippy.modules.world;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class SkyColor extends Module {
    public SkyColor() {
        super("SkyColor", Category.WORLD, "Кастомный цвет неба");
        bool("Enabled", true); slider("Red", 180, 0, 255); slider("Green", 102, 0, 255); slider("Blue", 255, 0, 255);
    }

}

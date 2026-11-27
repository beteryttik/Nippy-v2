package ru.nippy.modules.world;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class CustomFog extends Module {
    public CustomFog() {
        super("CustomFog", Category.WORLD, "Кастомный туман мира");
        bool("Enabled", true); slider("Density", 50, 0, 100); mode("Type", "Linear", "Exponential");
    }

}

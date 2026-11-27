package ru.nippy.modules.world;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Bright extends Module {
    public Bright() {
        super("Bright", Category.WORLD, "Повышенная яркость");
        bool("Enabled", true); slider("Gamma", 150, 100, 500);
    }

}

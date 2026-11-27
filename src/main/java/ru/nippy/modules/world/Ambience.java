package ru.nippy.modules.world;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Ambience extends Module {
    public Ambience() {
        super("Ambience", Category.WORLD, "Атмосферные эффекты");
        bool("Enabled", true); mode("Mood", "Winter", "Night", "Sunset"); slider("Intensity", 40, 0, 100);
    }

}

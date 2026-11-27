package ru.nippy.modules.world;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class WaveEffect extends Module {
    public WaveEffect() {
        super("WaveEffect", Category.WORLD, "Эффект волн на воде");
        bool("Enabled", true); slider("Amplitude", 30, 0, 100); slider("Speed", 50, 0, 200);
    }

}

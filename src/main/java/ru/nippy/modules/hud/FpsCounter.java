package ru.nippy.modules.hud;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class FpsCounter extends Module {
    public FpsCounter() {
        super("FpsCounter", Category.HUD, "Счётчик FPS");
        bool("Enabled", true); slider("Size", 100, 50, 200); bool("Colored", true);
    }

}

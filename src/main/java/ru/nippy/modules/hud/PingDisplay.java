package ru.nippy.modules.hud;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class PingDisplay extends Module {
    public PingDisplay() {
        super("PingDisplay", Category.HUD, "Пинг на экране");
        bool("Enabled", true);
    }

}

package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class KillSound extends Module {
    public KillSound() {
        super("KillSound", Category.UTILS, "Звук при убийстве");
        bool("Enabled", true); slider("Volume", 80, 0, 100);
    }

}

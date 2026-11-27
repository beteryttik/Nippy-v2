package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class BetterNear extends Module {
    public BetterNear() {
        super("BetterNear", Category.UTILS, "Список игроков рядом");
        bool("Enabled", true); slider("Range", 32, 8, 128);
    }

}

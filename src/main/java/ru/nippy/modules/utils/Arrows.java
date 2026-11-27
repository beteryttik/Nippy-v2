package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Arrows extends Module {
    public Arrows() {
        super("Arrows", Category.UTILS, "Индикаторы направления игроков");
        bool("Enabled", true); slider("Range", 64, 16, 128);
    }

}

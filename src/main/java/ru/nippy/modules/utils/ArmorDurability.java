package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class ArmorDurability extends Module {
    public ArmorDurability() {
        super("ArmorDurability", Category.UTILS, "Показ прочности брони");
        bool("Percent", true); bool("Colors", true);
    }

}

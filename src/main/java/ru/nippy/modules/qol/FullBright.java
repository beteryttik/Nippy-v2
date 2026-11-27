package ru.nippy.modules.qol;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class FullBright extends Module {
    public FullBright() {
        super("FullBright", Category.QOL, "Полная яркость без понижения");
        bool("Enabled", true);
    }

}

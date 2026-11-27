package ru.nippy.modules.qol;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class FreeLook extends Module {
    public FreeLook() {
        super("FreeLook", Category.QOL, "Свободный обзор (third person)");
        bool("Enabled", true);
    }

}

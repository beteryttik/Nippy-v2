package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Cape extends Module {
    public Cape() {
        super("Cape", Category.UTILS, "Кастомный плащ");
        bool("Enabled", true); mode("Style", "Nippy", "Vanilla");
    }

}

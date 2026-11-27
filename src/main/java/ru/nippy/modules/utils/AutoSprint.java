package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class AutoSprint extends Module {
    public AutoSprint() {
        super("AutoSprint", Category.UTILS, "Авто-спринт");
        bool("OnlyForward", true);
    }

}

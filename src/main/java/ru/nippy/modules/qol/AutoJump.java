package ru.nippy.modules.qol;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class AutoJump extends Module {
    public AutoJump() {
        super("AutoJump", Category.QOL, "Авто-прыжок");
        bool("Enabled", false);
    }

}

package ru.nippy.modules.qol;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class NoHurtCam extends Module {
    public NoHurtCam() {
        super("NoHurtCam", Category.QOL, "Убрать тряску камеры при уроне");
        bool("Enabled", true);
    }

}

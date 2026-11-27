package ru.nippy.modules.qol;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Zoom extends Module {
    public Zoom() {
        super("Zoom", Category.QOL, "Зум по клавише");
        bool("Enabled", true); slider("Factor", 4, 2, 10);
    }

}

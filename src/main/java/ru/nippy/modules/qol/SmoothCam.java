package ru.nippy.modules.qol;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class SmoothCam extends Module {
    public SmoothCam() {
        super("SmoothCam", Category.QOL, "Плавная камера");
        bool("Enabled", true); slider("Smoothness", 50, 0, 100);
    }

}

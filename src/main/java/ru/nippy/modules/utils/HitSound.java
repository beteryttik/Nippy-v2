package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class HitSound extends Module {
    public HitSound() {
        super("HitSound", Category.UTILS, "Звук при попадании");
        bool("Enabled", true); slider("Volume", 80, 0, 100); mode("Sound", "Snow", "Pop", "Bell");
    }

}

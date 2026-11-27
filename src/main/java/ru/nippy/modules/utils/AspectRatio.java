package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class AspectRatio extends Module {
    public AspectRatio() {
        super("AspectRatio", Category.UTILS, "Изменение соотношения сторон");
        bool("Enabled", false); slider("Width", 100, 50, 200);
    }

}

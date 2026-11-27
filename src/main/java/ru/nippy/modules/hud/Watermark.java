package ru.nippy.modules.hud;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Watermark extends Module {
    public Watermark() {
        super("Watermark", Category.HUD, "Водяной знак Nippy");
        bool("Enabled", true); slider("Opacity", 80, 20, 100);
    }

}

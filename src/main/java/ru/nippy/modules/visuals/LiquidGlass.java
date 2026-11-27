package ru.nippy.modules.visuals;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class LiquidGlass extends Module {
    public LiquidGlass() {
        super("LiquidGlass", Category.VISUALS, "Эффект стекла на интерфейсе");
        bool("Enabled", true); slider("Blur", 30, 0, 100);
    }

}

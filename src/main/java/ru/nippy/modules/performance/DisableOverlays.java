package ru.nippy.modules.performance;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class DisableOverlays extends Module {
    public DisableOverlays() {
        super("DisableOverlays", Category.PERFORMANCE, "Отключение оверлеев зелий (FPS+)");
        bool("Enabled", false);
    }

}

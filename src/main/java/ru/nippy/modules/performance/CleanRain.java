package ru.nippy.modules.performance;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class CleanRain extends Module {
    public CleanRain() {
        super("CleanRain", Category.PERFORMANCE, "Отключение частиц дождя (FPS+)");
        bool("Enabled", true);
    }
    @Override
public void onTick() {
            // Меme: управляется через MixinWorldRenderer
        }
}

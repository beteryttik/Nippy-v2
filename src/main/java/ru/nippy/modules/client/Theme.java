package ru.nippy.modules.client;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Theme extends Module {
    public Theme() {
        super("Theme", Category.CLIENT, "Тема клиента (фиолетовый зимний)");
        mode("Preset", "Frost Purple", "Night", "Neon"); slider("Opacity", 90, 50, 100);
    }

}

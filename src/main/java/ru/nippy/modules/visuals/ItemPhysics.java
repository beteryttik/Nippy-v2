package ru.nippy.modules.visuals;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class ItemPhysics extends Module {
    public ItemPhysics() {
        super("ItemPhysics", Category.VISUALS, "Физика дропнутых предметов");
        bool("Enabled", true);
    }

}

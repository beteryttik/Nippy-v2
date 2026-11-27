package ru.nippy.modules.client;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Globals extends Module {
    public Globals() {
        super("Globals", Category.CLIENT, "Глобальные настройки клиента");
        bool("CheckUpdates", true);
    }

}

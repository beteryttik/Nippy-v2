package ru.nippy.modules.client;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class ConfigManager extends Module {
    public ConfigManager() {
        super("ConfigManager", Category.CLIENT, "Менеджер конфигов");
        bool("AutoSave", true);
    }

}

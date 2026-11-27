package ru.nippy.modules.client;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Language extends Module {
    public Language() {
        super("Language", Category.CLIENT, "Язык клиента");
        mode("Lang", "RU", "EN");
    }

}

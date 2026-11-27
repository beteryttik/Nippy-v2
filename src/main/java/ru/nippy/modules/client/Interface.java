package ru.nippy.modules.client;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class Interface extends Module {
    public Interface() {
        super("Interface", Category.CLIENT, "Настройки интерфейса");
        slider("UiScale", 100, 50, 200); bool("Blur", true); bool("Animations", true);
    }

}

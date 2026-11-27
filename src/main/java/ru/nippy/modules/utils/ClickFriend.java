package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class ClickFriend extends Module {
    public ClickFriend() {
        super("ClickFriend", Category.UTILS, "Клик по игроку = добавить в друзья");
        bool("Enabled", true);
    }

}

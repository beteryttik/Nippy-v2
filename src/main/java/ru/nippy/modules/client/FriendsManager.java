package ru.nippy.modules.client;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class FriendsManager extends Module {
    public FriendsManager() {
        super("FriendsManager", Category.CLIENT, "Управление друзьями");
        bool("Enabled", true);
    }

}

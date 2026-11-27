package ru.nippy.modules.utils;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class FakePlayer extends Module {
    public FakePlayer() {
        super("FakePlayer", Category.UTILS, "Спавн фейкового игрока для тестов");
        bool("Enabled", false);
    }

}

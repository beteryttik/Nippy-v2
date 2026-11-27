package ru.nippy.modules.client;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class GuiSounds extends Module {
    public GuiSounds() {
        super("GuiSounds", Category.CLIENT, "Звуки интерфейса");
        bool("Enabled", true); slider("Volume", 60, 0, 100);
    }

}

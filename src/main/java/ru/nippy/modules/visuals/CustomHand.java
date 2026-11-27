package ru.nippy.modules.visuals;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class CustomHand extends Module {
    public CustomHand() {
        super("CustomHand", Category.VISUALS, "Кастомная анимация руки");
        bool("Enabled", true); slider("SwingSpeed", 100, 50, 200);
    }

}

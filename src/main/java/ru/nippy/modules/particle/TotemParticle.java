package ru.nippy.modules.particle;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class TotemParticle extends Module {
    public TotemParticle() {
        super("Totem Particle", Category.PARTICLE, "Кастомные частицы тотема");
        bool("Enabled", true); slider("Density", 50, 0, 100);
    }

}

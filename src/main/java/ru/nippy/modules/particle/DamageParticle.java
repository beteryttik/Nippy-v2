package ru.nippy.modules.particle;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class DamageParticle extends Module {
    public DamageParticle() {
        super("Damage Particle", Category.PARTICLE, "Частицы урона");
        bool("Enabled", true); mode("Color", "Purple", "Red", "Rainbow"); slider("Count", 8, 1, 32);
    }

}

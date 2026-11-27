package ru.nippy.modules.particle;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class JumpParticle extends Module {
    public JumpParticle() {
        super("Jump Particle", Category.PARTICLE, "Частицы при прыжке");
        bool("Enabled", true); bool("SnowDust", true);
    }

}

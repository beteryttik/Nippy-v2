package ru.nippy.modules.particle;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class KillParticle extends Module {
    public KillParticle() {
        super("Kill Particle", Category.PARTICLE, "Эффект при убийстве");
        bool("Enabled", true); mode("Effect", "Burst", "Twinkle");
    }

}

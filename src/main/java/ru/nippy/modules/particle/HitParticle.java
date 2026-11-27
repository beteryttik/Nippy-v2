package ru.nippy.modules.particle;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class HitParticle extends Module {
    public HitParticle() {
        super("Hit Particle", Category.PARTICLE, "Частицы при ударе");
        bool("Enabled", true); slider("Size", 100, 10, 300); mode("Style", "Spark", "Ring", "Burst");
    }

}

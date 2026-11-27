package ru.nippy.modules.particle;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class ParticleTrail extends Module {
    public ParticleTrail() {
        super(" ParticleTrail", Category.PARTICLE, "След за игроком");
        bool("Enabled", false); slider("EveryTicks", 2, 1, 20); mode("Shape", "Snowflake", "Star");
    }

}

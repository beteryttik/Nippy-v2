package ru.nippy.module;

import ru.nippy.modules.hud.ArmorHud;
import ru.nippy.modules.hud.FpsCounter;
import ru.nippy.modules.hud.InventoryHud;
import ru.nippy.modules.hud.PingDisplay;
import ru.nippy.modules.hud.Watermark;
import ru.nippy.modules.particle.DamageParticle;
import ru.nippy.modules.particle.HitParticle;
import ru.nippy.modules.particle.JumpParticle;
import ru.nippy.modules.particle.KillParticle;
import ru.nippy.modules.particle.ParticleTrail;
import ru.nippy.modules.particle.TotemParticle;
import ru.nippy.modules.performance.CleanRain;
import ru.nippy.modules.performance.DisableOverlays;
import ru.nippy.modules.performance.StaticWater;
import ru.nippy.modules.qol.SmoothCam;
import ru.nippy.modules.utils.ArmorDurability;
import ru.nippy.modules.utils.Arrows;
import ru.nippy.modules.utils.AspectRatio;
import ru.nippy.modules.utils.AutoSprint;
import ru.nippy.modules.utils.BetterNear;
import ru.nippy.modules.utils.Cape;
import ru.nippy.modules.utils.ClickFriend;
import ru.nippy.modules.utils.FakePlayer;
import ru.nippy.modules.utils.HitSound;
import ru.nippy.modules.utils.KillSound;
import ru.nippy.modules.visuals.CrystalColor;
import ru.nippy.modules.visuals.Crosshair;
import ru.nippy.modules.visuals.CustomHand;
import ru.nippy.modules.visuals.ItemPhysics;
import ru.nippy.modules.visuals.LiquidGlass;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();

    public static void init() {
        // hud
        modules.add(new FpsCounter());
        modules.add(new PingDisplay());
        modules.add(new Watermark());
        modules.add(new ArmorHud());
        modules.add(new InventoryHud());
        // visuals
        modules.add(new CustomHand());
        modules.add(new ItemPhysics());
        modules.add(new LiquidGlass());
        modules.add(new CrystalColor());
        modules.add(new Crosshair());
        // performance
        modules.add(new StaticWater());
        modules.add(new CleanRain());
        modules.add(new DisableOverlays());
        // utils
        modules.add(new HitSound());
        modules.add(new Cape());
        modules.add(new Arrows());
        modules.add(new ArmorDurability());
        modules.add(new ClickFriend());
        modules.add(new BetterNear());
        modules.add(new FakePlayer());
        modules.add(new AutoSprint());
        modules.add(new KillSound());
        modules.add(new AspectRatio());
        // particle
        modules.add(new KillParticle());
        modules.add(new DamageParticle());
        modules.add(new ParticleTrail());
        modules.add(new JumpParticle());
        modules.add(new HitParticle());
        modules.add(new TotemParticle());
        // qol
        modules.add(new SmoothCam());
        modules.add(new ZoomModule());
        modules.add(new NoFogModule());
    }

    public static List<Module> getModules() { return modules; }

    public static boolean isEnabled(Class<? extends Module> type) {
        for (Module m : modules) {
            if (type.isInstance(m) && m.isEnabled()) return true;
        }
        return false;
    }
}

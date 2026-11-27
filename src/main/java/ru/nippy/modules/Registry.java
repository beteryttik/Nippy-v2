package ru.nippy.modules;

import java.util.List;

public final class Registry {
    private Registry() {}

    public static void registerAll(List<ru.nippy.module.Module> list) {
        list.add(new ru.nippy.modules.world.CustomFog());
        list.add(new ru.nippy.modules.world.SkyColor());
        list.add(new ru.nippy.modules.world.Ambience());
        list.add(new ru.nippy.modules.world.Bright());
        list.add(new ru.nippy.modules.world.CustomWeather());
        list.add(new ru.nippy.modules.world.BlockHighlighter());
        list.add(new ru.nippy.modules.world.WaveEffect());
        list.add(new ru.nippy.modules.particle.DamageParticle());
        list.add(new ru.nippy.modules.particle.HitParticle());
        list.add(new ru.nippy.modules.particle.JumpParticle());
        list.add(new ru.nippy.modules.particle.KillParticle());
        list.add(new ru.nippy.modules.particle.TotemParticle());
        list.add(new ru.nippy.modules.particle.ParticleTrail());
        list.add(new ru.nippy.modules.utils.AutoSprint());
        list.add(new ru.nippy.modules.utils.ArmorDurability());
        list.add(new ru.nippy.modules.utils.AspectRatio());
        list.add(new ru.nippy.modules.utils.Arrows());
        list.add(new ru.nippy.modules.utils.Cape());
        list.add(new ru.nippy.modules.utils.ClickFriend());
        list.add(new ru.nippy.modules.utils.FakePlayer());
        list.add(new ru.nippy.modules.utils.HitSound());
        list.add(new ru.nippy.modules.utils.KillSound());
        list.add(new ru.nippy.modules.utils.BetterNear());
        list.add(new ru.nippy.modules.client.Theme());
        list.add(new ru.nippy.modules.client.Interface());
        list.add(new ru.nippy.modules.client.ConfigManager());
        list.add(new ru.nippy.modules.client.CustomLoading());
        list.add(new ru.nippy.modules.client.FriendsManager());
        list.add(new ru.nippy.modules.client.Globals());
        list.add(new ru.nippy.modules.client.GuiSounds());
        list.add(new ru.nippy.modules.client.Language());
        list.add(new ru.nippy.modules.hud.FpsCounter());
        list.add(new ru.nippy.modules.hud.PingDisplay());
        list.add(new ru.nippy.modules.hud.ArmorHud());
        list.add(new ru.nippy.modules.hud.InventoryHud());
        list.add(new ru.nippy.modules.hud.Watermark());
        list.add(new ru.nippy.modules.qol.AutoJump());
        list.add(new ru.nippy.modules.qol.NoHurtCam());
        list.add(new ru.nippy.modules.qol.SmoothCam());
        list.add(new ru.nippy.modules.qol.FreeLook());
        list.add(new ru.nippy.modules.qol.Zoom());
        list.add(new ru.nippy.modules.qol.FullBright());
        list.add(new ru.nippy.modules.visuals.Crosshair());
        list.add(new ru.nippy.modules.visuals.CustomHand());
        list.add(new ru.nippy.modules.visuals.ItemPhysics());
        list.add(new ru.nippy.modules.visuals.CrystalColor());
        list.add(new ru.nippy.modules.visuals.LiquidGlass());
        list.add(new ru.nippy.modules.performance.CleanRain());
        list.add(new ru.nippy.modules.performance.StaticWater());
        list.add(new ru.nippy.modules.performance.DisableOverlays());
    }
}

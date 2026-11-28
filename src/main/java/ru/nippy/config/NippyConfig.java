package ru.nippy.config;

import net.fabricmc.loader.api.FabricLoader;
import ru.nippy.module.Module;
import ru.nippy.module.ModuleManager;
import ru.nippy.modules.performance.CleanRain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public final class NippyConfig {
    private static final Path FILE =
            FabricLoader.getInstance().getConfigDir().resolve("nippy.properties");

    /** Флаг для миксина MixinWorldRenderer (отключение дождя). */
    public static boolean disableRain = false;

    private NippyConfig() {}

    public static void load() {
        if (!Files.exists(FILE)) { save(); return; }
        try (InputStream in = Files.newInputStream(FILE)) {
            Properties props = new Properties();
            props.load(in);
            for (Module m : ModuleManager.getModules()) {
                String v = props.getProperty("module." + m.getName() + ".enabled");
                if (v != null) m.setEnabled(Boolean.parseBoolean(v));
            }
            // синхронизируем флаг с состоянием модуля CleanRain
            disableRain = ModuleManager.isEnabled(CleanRain.class);
        } catch (IOException e) {
            System.err.println("[Nippy] config read failed: " + e.getMessage());
        }
    }

    public static void save() {
        try {
            Files.createDirectories(FILE.getParent());
            Properties props = new Properties();
            for (Module m : ModuleManager.getModules()) {
                props.setProperty("module." + m.getName() + ".enabled",
                        Boolean.toString(m.isEnabled()));
            }
            try (OutputStream out = Files.newOutputStream(FILE)) {
                props.store(out, "Nippy Client config");
            }
        } catch (IOException e) {
            System.err.println("[Nippy] config save failed: " + e.getMessage());
        }
    }
}

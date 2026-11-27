package ru.nippy.config;

import java.io.IOException;
import java.nio.file.*;
import java.util.Properties;

public class NippyConfig {
    private static final Path FILE = Path.of("config", "nippy.properties");
    private static final Properties PROPS = new Properties();

    public static boolean disableRain = true;
    public static boolean staticWater = false;
    public static boolean disableOverlays = false;
    public static boolean quickMenuEnabled = true;
    public static int accentColor = 0xFFA666FF;

    public static void load() {
        if (Files.exists(FILE)) {
            try {
                PROPS.load(Files.newInputStream(FILE));
                disableRain = Boolean.parseBoolean(PROPS.getProperty("disableRain", "true"));
                staticWater = Boolean.parseBoolean(PROPS.getProperty("staticWater", "false"));
                disableOverlays = Boolean.parseBoolean(PROPS.getProperty("disableOverlays", "false"));
                quickMenuEnabled = Boolean.parseBoolean(PROPS.getProperty("quickMenuEnabled", "true"));
                accentColor = (int) Long.parseLong(PROPS.getProperty("accentColor", "FFA666FF"), 16);
            } catch (IOException e) {
                ru.nippy.Nippy.LOGGER.warn("[Nippy] Failed to load config", e);
            }
        }
        save();
    }

    public static void save() {
        PROPS.setProperty("disableRain", String.valueOf(disableRain));
        PROPS.setProperty("staticWater", String.valueOf(staticWater));
        PROPS.setProperty("disableOverlays", String.valueOf(disableOverlays));
        PROPS.setProperty("quickMenuEnabled", String.valueOf(quickMenuEnabled));
        PROPS.setProperty("accentColor", String.format("%08X", accentColor));
        try {
            Files.createDirectories(FILE.getParent());
            PROPS.store(Files.newOutputStream(FILE), "Nippy Client config");
        } catch (IOException e) {
            ru.nippy.Nippy.LOGGER.warn("[Nippy] Failed to save config", e);
        }
    }
}

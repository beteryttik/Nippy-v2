package ru.nippy.gui;

public final class Theme {
    private Theme() {}

    public static int ACCENT = 0xFFA666FF;      // fioletovyi akcent
    public static int ACCENT_DIM = 0xFF7A4CC9;
    public static int BG = 0xEE242436;           // temno-seryi panel
    public static int BG_SOFT = 0xEE1F1F2B;
    public static int TEXT = 0xFFF5F5FA;
    public static int SUBTEXT = 0xFFA0A0B8;
    public static int BORDER = 0x40FFFFFF;       // "inoi" obvodka
    public static int ENABLED = 0xFF81C784;
    public static int DISABLED = 0xFFE57373;

    public static void applyPreset(String preset) {
        switch (preset) {
            case "Night" -> ACCENT = 0xFF6C8CFF;
            case "Neon" -> ACCENT = 0xFFCE1DFF;
            default -> ACCENT = 0xFFA666FF; // Frost Purple
        }
    }
}

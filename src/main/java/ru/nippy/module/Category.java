package ru.nippy.module;

public enum Category {
    WORLD("World", 0xFF4FC3F7),
    PARTICLE("Particle", 0xFFBA68C8),
    UTILS("Utils", 0xFFFFB74D),
    CLIENT("Client", 0xFFA666FF),
    HUD("HUD", 0xFF81C784),
    QOL("QoL", 0xFFFF8A65),
    VISUALS("Visuals", 0xFF4DD0E1),
    PERFORMANCE("Performance", 0xFFFFD54F);

    public final String label;
    public final int color;

    Category(String label, int color) { this.label = label; this.color = color; }
}

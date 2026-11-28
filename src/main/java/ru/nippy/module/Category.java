package ru.nippy.module;

public enum Category {
    HUD("HUD"),
    VISUALS("Visuals"),
    PERFORMANCE("Performance"),
    UTILS("Utils"),
    PARTICLE("Particles"),
    QOL("QoL"),
    CLIENT("Client"),      // <-- Добавлено для модулей из папки client/
    WORLD("World");        // <-- Добавлено для модулей из папки world/

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

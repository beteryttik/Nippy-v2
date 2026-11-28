package ru.nippy.module;

public class NoFogModule extends Module {
    private static NoFogModule instance;

    public NoFogModule() {
        super("NoFog", Category.VISUALS, "Убирает туман в мире");
        instance = this;
    }

    public static NoFogModule get() { return instance; }
}

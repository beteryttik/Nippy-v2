package ru.nippy.module;

public class ZoomModule extends Module {
    private static ZoomModule instance;
    public final SliderSetting factor = slider("Factor", 4, 2, 10);
    public final BooleanSetting smooth = bool("Smooth", true);

    public ZoomModule() {
        super("Zoom", Category.QOL, "Сильно приближает камеру");
        instance = this;
    }

    public static ZoomModule get() { return instance; }
}

package ru.nippy.modules.world;

import ru.nippy.module.Category;
import ru.nippy.module.Module;

public class CustomWeather extends Module {
    public CustomWeather() {
        super("CustomWeather", Category.WORLD, "Управление погодой");
        bool("Enabled", true); mode("Weather", "Clear", "Snow", "Rain");
    }

}

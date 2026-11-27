package ru.nippy.module;

import java.util.ArrayList;
import java.util.List;

public abstract class Module {
    private final String name;
    private final Category category;
    private final String description;
    private boolean enabled;
    private final List<Setting> settings = new ArrayList<>();

    protected Module(String name, Category category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() { return name; }
    public Category getCategory() { return category; }
    public String getDescription() { return description; }
    public boolean isEnabled() { return enabled; }
    public List<Setting> getSettings() { return settings; }

    protected BooleanSetting bool(String n, boolean d) { BooleanSetting s = new BooleanSetting(n, d); settings.add(s); return s; }
    protected SliderSetting slider(String n, float d, float min, float max) { SliderSetting s = new SliderSetting(n, d, min, max, 1); settings.add(s); return s; }
    protected ModeSetting mode(String n, String... m) { ModeSetting s = new ModeSetting(n, m); settings.add(s); return s; }

    public void toggle() {
        enabled = !enabled;
        if (enabled) onEnable(); else onDisable();
    }

    protected void onEnable() {}
    protected void onDisable() {}
    public void onTick() {}
}

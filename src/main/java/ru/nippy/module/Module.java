package ru.nippy.module;

import java.util.ArrayList;
import java.util.List;

public abstract class Module {
    private final String name;
    private final Category category;
    private final String description;
    private final List<Setting> settings = new ArrayList<>();
    private boolean enabled;

    protected Module(String name, String description) {
        this(name, Category.UTILS, description);
    }

    protected Module(String name, Category category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() { return name; }
    public Category getCategory() { return category; }
    public String getDescription() { return description; }
    public List<Setting> getSettings() { return settings; }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        onToggle(enabled);
    }

    public void toggle() { setEnabled(!enabled); }

    protected BooleanSetting bool(String name, boolean def) {
        BooleanSetting s = new BooleanSetting(name, def);
        settings.add(s);
        return s;
    }

    protected SliderSetting slider(String name, int def, int min, int max) {
        SliderSetting s = new SliderSetting(name, def, min, max);
        settings.add(s);
        return s;
    }

    protected ModeSetting mode(String name, String... modes) {
        ModeSetting s = new ModeSetting(name, modes);
        settings.add(s);
        return s;
    }

    public void onTick() {}

    protected void onToggle(boolean state) {}
}

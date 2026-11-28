package ru.nippy.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Module {
    private final String name;
    private final String description;
    private final List<Setting> settings = new ArrayList<>();
    private boolean enabled;

    protected Module(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isEnabled() { return enabled; }
    public List<Setting> getSettings() { return Collections.unmodifiableList(settings); }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        onToggle(enabled);
    }

    public void toggle() { setEnabled(!enabled); }

    protected void addSetting(Setting s) { settings.add(s); }

    protected void onToggle(boolean state) {}
}

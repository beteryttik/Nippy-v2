package ru.nippy.module;

public class BooleanSetting extends Setting {
    public BooleanSetting(String name, boolean def) {
        super(name, def);
    }

    public boolean get() {
        return value instanceof Boolean b && b;
    }

    public void set(boolean v) { value = v; }

    public void toggle() { value = !(value instanceof Boolean b && b); }
}

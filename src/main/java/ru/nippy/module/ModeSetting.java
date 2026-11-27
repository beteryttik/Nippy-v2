package ru.nippy.module;

public class ModeSetting extends Setting {
    private final String[] modes;
    private int index;
    public ModeSetting(String name, String... modes) { super(name); this.modes = modes; }
    public String get() { return modes[index]; }
    public void cycle() { index = (index + 1) % modes.length; }
    public String[] getModes() { return modes; }
}

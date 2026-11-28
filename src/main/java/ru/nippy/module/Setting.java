package ru.nippy.module;

public class Setting {
    private final String name;
    private boolean value;

    public Setting(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; }
    public boolean getValue() { return value; }
    public void setValue(boolean value) { this.value = value; }
    public void toggle() { value = !value; }
}

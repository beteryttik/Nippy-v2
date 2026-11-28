package ru.nippy.module;

public class Setting {
    protected final String name;
    protected Object value;

    public Setting(String name) {
        this.name = name;
        this.value = null;
    }

    public Setting(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; }

    public Object getValue() { return value; }

    public void setValue(Object value) { this.value = value; }
}

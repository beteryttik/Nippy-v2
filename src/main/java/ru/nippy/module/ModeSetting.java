package ru.nippy.module;

public class ModeSetting extends Setting {
    protected String[] modes;
    protected int index;

    public ModeSetting(String name, String... modes) {
        super(name);
        this.modes = modes;
        this.index = 0;
        if (modes.length > 0) this.value = modes[0];
    }

    public String getSelected() {
        return modes.length > 0 ? modes[index] : "";
    }

    public void cycle() {
        index = (index + 1) % modes.length;
        value = modes[index];
    }

    public void set(String mode) {
        for (int i = 0; i < modes.length; i++) {
            if (modes[i].equals(mode)) {
                index = i;
                value = mode;
            }
        }
    }

    public String[] getModes() { return modes; }
}

package ru.nippy.module;

public class SliderSetting extends Setting {
    protected int min, max, step;

    public SliderSetting(String name, int def, int min, int max) {
        this(name, def, min, max, 1);
    }

    public SliderSetting(String name, int def, int min, int max, int step) {
        super(name);
        this.value = def;
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public int getInt() {
        return value instanceof Integer i ? i : min;
    }

    public void setInt(int v) {
        value = Math.max(min, Math.min(max, v));
    }

    public int getMin() { return min; }
    public int getMax() { return max; }
    public int getStep() { return step; }
}

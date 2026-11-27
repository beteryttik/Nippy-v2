package ru.nippy.module;

public class SliderSetting extends Setting {
    private float value;
    private final float min, max, step;
    public SliderSetting(String name, float def, float min, float max, float step) {
        super(name); this.value = def; this.min = min; this.max = max; this.step = step;
    }
    public float get() { return value; }
    public void set(float v) { value = Math.max(min, Math.min(max, v)); }
    public float getMin() { return min; }
    public float getMax() { return max; }
}

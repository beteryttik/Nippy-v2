package ru.nippy.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();

    public static void init() {
        modules.add(new ZoomModule());
        modules.add(new NoFogModule());
        modules.add(new HudModule());
    }

    public static List<Module> getModules() { return modules; }

    public static boolean isEnabled(Class<? extends Module> type) {
        for (Module m : modules) {
            if (type.isInstance(m)) return m.isEnabled();
        }
        return false;
    }
}

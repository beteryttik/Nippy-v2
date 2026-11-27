package ru.nippy.module;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {
    private static final List<Module> MODULES = new ArrayList<>();

    public static void init() {
        ru.nippy.modules.Registry.registerAll(MODULES);
    }

    public static void register(Module m) { MODULES.add(m); }
    public static List<Module> getModules() { return MODULES; }

    public static List<Module> byCategory(Category c) {
        return MODULES.stream().filter(m -> m.getCategory() == c).collect(Collectors.toList());
    }
}

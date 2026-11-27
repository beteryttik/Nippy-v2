package ru.nippy.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import ru.nippy.gui.NippyGuiManager;
import ru.nippy.module.ModuleManager;

public final class TickHandler {
    private TickHandler() {}

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            NippyGuiManager.tick();
            ModuleManager.getModules().forEach(m -> { if (m.isEnabled()) m.onTick(); });
        });
    }
}

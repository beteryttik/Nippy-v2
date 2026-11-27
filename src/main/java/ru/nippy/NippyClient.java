package ru.nippy;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import ru.nippy.gui.NippyGuiManager;
import ru.nippy.module.ModuleManager;

public class NippyClient implements ClientModInitializer {
    public static final String MOD_ID = "nippy";
    public static KeyBinding OPEN_MENU;

    @Override
    public void onInitializeClient() {
        OPEN_MENU = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nippy.open_menu", GLFW.GLFW_KEY_RIGHT_SHIFT, "key.categories.nippy"));

        ModuleManager.init();
        NippyConfig.load();
        ru.nippy.event.TickHandler.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (OPEN_MENU.wasPressed()) {
                NippyGuiManager.toggleQuickMenu();
            }
        });

        Nippy.LOGGER.info("[Nippy] Client initialized. {} modules loaded.", ModuleManager.getModules().size());
    }
}

package ru.nippy;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import ru.nippy.gui.QuickMenuScreen;
import ru.nippy.module.ModuleManager;

public class NippyClient implements ClientModInitializer {
    public static final String MOD_ID = "nippy";
    private static KeyBinding openMenu;

    @Override
    public void onInitializeClient() {
        NippyConfig.load();
        ModuleManager.init();

        openMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nippy.open_menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                KeyBinding.Category.create(Identifier.of(MOD_ID, "main"))
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenu.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(new QuickMenuScreen());
                }
            }
        });
    }
}

package ru.nippy.gui;

import net.minecraft.client.MinecraftClient;

public class NippyGuiManager {
    private static boolean isOpen = false;
    private static float animationProgress = 0f;
    private static final float SPEED = 0.18f;

    public static void toggleQuickMenu() {
        isOpen = !isOpen;
        if (isOpen) {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.currentScreen == null) {
                mc.setScreen(new QuickMenuScreen());
            }
        } else if (MinecraftClient.getInstance().currentScreen instanceof QuickMenuScreen) {
            MinecraftClient.getInstance().setScreen(null);
        }
    }

    public static void tick() {
        if (isOpen) animationProgress = Math.min(animationProgress + SPEED, 1.0f);
        else animationProgress = Math.max(animationProgress - SPEED, 0.0f);
    }

    public static float getProgress() { return animationProgress; }
    public static boolean isOpen() { return isOpen; }
}

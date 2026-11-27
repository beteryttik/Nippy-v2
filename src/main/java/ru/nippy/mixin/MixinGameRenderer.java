package ru.nippy.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.nippy.config.NippyConfig;

/**
 * DisableOverlays: otklyuchaem overlei effektov zeliy (spidery, nausea i td).
 */
@Mixin(GameRenderer.class)
public class MixinGameRenderer {

    @Inject(method = "render", at = @At("HEAD"))
    private void nippy$overlayHook(CallbackInfo ci) {
        // TODO: esli NippyConfig.disableOverlays — propuskaet risovanie overlay-effektov
    }
}

package ru.nippy.mixin;

import net.minecraft.client.render.FogRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.nippy.config.NippyConfig;

/**
 * Custom Fog: podmenyaem parametry tumana.
 * Target-metod proveryay na 1.21.11 (v novykh versiyakh on perenosit v Environment/FogType).
 */
@Mixin(FogRenderer.class)
public class MixinFogRenderer {

    @Inject(method = "applyFog", at = @At("TAIL"))
    private void nippy$customFog(CallbackInfo ci) {
        // TODO: podmena parametrov tumana, esli modul' CustomFog vkluchen
    }
}

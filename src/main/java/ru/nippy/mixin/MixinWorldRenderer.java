package ru.nippy.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.nippy.config.NippyConfig;

/**
 * Clean Rain: preryvaem render/spawn chastic dozhdya.
 * Vnimanie: imya metoda (renderRain / method_...) sver na Yarn mappings 1.21.11!
 * Esli metoda net pod etim imenem — naidi tochnyi target cherez unmerge/mappings.
 */
@Mixin(WorldRenderer.class)
public class MixinWorldRenderer {

    @Inject(method = "renderWeather", at = @At("HEAD"), cancellable = true)
    private void nippy$disableRain(CallbackInfo ci) {
        if (NippyConfig.disableRain) {
            ci.cancel();
        }
    }
}

package ru.nippy.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.nippy.module.ModuleManager;
import ru.nippy.module.NoFogModule;

/**
 * Туман в новых версиях переехал в RenderPipeline, поэтому таргетимся
 * по intermediary-имени. Если в рантайме не применится — мод всё равно
 * запустится (defaultRequire: 0 в nippy.mixins.json).
 */
@Mixin(targets = "net.minecraft.class_758")
public class MixinFogRenderer {

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private void nippy$noFog(CallbackInfo ci) {
        if (ModuleManager.isEnabled(NoFogModule.class)) {
            ci.cancel();
        }
    }
}

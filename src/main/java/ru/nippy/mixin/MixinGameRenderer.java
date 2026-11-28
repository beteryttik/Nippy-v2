package ru.nippy.mixin;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.nippy.module.ModuleManager;
import ru.nippy.module.ZoomModule;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {

    @Inject(method = "getFov", at = @At("RETURN"), cancellable = true)
    private void nippy$zoom(Camera camera, float tickDelta, boolean changingFov,
                            CallbackInfoReturnable<Float> cir) {
        if (ModuleManager.isEnabled(ZoomModule.class)) {
            cir.setReturnValue(cir.getReturnValue() / 4.0f);
        }
    }
}

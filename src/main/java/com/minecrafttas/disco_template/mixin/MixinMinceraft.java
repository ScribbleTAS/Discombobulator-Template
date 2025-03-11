package com.minecrafttas.disco_template.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//#1.19.4
//$$@Mixin(net.minecraft.client.gui.components.LogoRenderer.class)
//#def
@Mixin(net.minecraft.client.gui.screens.TitleScreen.class)
//#end
public class MixinMinceraft {
	
	@Shadow
	@Mutable
	//#1.19.4
//$$	private boolean showEasterEgg;
	//#def
	private boolean minceraftEasterEgg;
	//#end
	
	//#1.19.4
//$$	@Inject(method = "renderLogo", at = @At("HEAD"))
	//#def
	@Inject(method = "init", at = @At("HEAD"))
	//#end
	public void inject_init(CallbackInfo ci) {
		//#1.19.4
//$$		showEasterEgg = true;
		//#def
		minceraftEasterEgg = true;
		//#end
	}
}

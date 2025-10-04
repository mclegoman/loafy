/*
    Loafy
    Contributor(s): dannytaylor
    Github: https://github.com/mclegoman/loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.mixin.client;

import com.mclegoman.loafy.config.LoafyConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
	@Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/GameOptions;<init>(Lnet/minecraft/client/MinecraftClient;Ljava/io/File;)V"))
	private void loafy$init(RunArgs runArgs, CallbackInfo ci) {
		System.out.println("*turns all your items into bread*");
		LoafyConfig.init();
	}
}

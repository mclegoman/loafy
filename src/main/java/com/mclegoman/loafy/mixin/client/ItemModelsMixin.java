/*
    Loafy
    Contributor(s): dannytaylor
    Github: https://github.com/mclegoman/loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.mixin.client;

import com.mclegoman.loafy.config.LoafyConfig;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(BakedModelManager.class)
public abstract class ItemModelsMixin {
	@Shadow private Map<Identifier, ItemModel> bakedItemModels;

	@Inject(at = @At("RETURN"), method = "getItemModel", cancellable = true)
	private void loafy$getItem(Identifier id, CallbackInfoReturnable<ItemModel> cir) {
		cir.setReturnValue(this.bakedItemModels.getOrDefault(LoafyConfig.getItemId(), cir.getReturnValue()));
	}
}
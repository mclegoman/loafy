/*
    Loafy
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.mixin.client;

import net.minecraft.client.render.item.ItemModels;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemModels.class)
public abstract class ItemModelsMixin {
	@Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"), method = "getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;")
	private Item loafy$getItem(ItemStack instance) {
		return Items.BREAD;
	}
}
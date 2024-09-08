/*
    Loafy
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.mixin.client;

import com.mclegoman.loafy.config.LoafyConfig;
import net.minecraft.component.ComponentHolder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements ComponentHolder {
	@Shadow public abstract Item getItem();
	@Inject(method = "getName", at = @At("HEAD"), cancellable = true)
	private void loafy$getName(CallbackInfoReturnable<Text> cir) {
		if (!this.getItem().getDefaultStack().isOf(LoafyConfig.getItemStack().getItem())) {
			if (this.get(DataComponentTypes.CUSTOM_NAME) == null) {
				cir.setReturnValue(LoafyConfig.getItemStack().getName());
			}
		}
	}
}

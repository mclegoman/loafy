/*
    Loafy
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.mixin.common;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Collection;

@Mixin(ItemGroup.EntriesImpl.class)
public abstract class ItemGroupMixin {
	@Shadow @Final public Collection<ItemStack> parentTabStacks;
	@Inject(at = @At("HEAD"), method = "add", cancellable = true)
	public void loafy$add(ItemStack stack, ItemGroup.StackVisibility visibility, CallbackInfo ci) {
		// If the category already has the stack, we just silently fail instead of crashing the game.
		// This happens because of enchantment, books, horns, etc, have custom components that we just override with bread.
		if (this.parentTabStacks.contains(stack) && visibility != ItemGroup.StackVisibility.SEARCH_TAB_ONLY) ci.cancel();
	}
}
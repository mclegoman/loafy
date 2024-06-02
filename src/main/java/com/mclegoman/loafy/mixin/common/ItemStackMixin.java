/*
    Loafy
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.mixin.common;

import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@Shadow public abstract ComponentMap getComponents();
	@Shadow public abstract boolean isOf(Item item);
	@Shadow public abstract boolean isEmpty();
	@Inject(at = @At("RETURN"), method = "getComponents", cancellable = true)
	public void loafy$getComponents(CallbackInfoReturnable<ComponentMap> cir) {
		if (!this.isOf(Items.BREAD)) cir.setReturnValue(!this.isEmpty() ? Items.BREAD.getDefaultStack().getComponents() : ComponentMap.EMPTY);
	}
	@Inject(at = @At("RETURN"), method = "useOnBlock", cancellable = true)
	public void loafy$useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		if (!this.isOf(Items.BREAD)) cir.setReturnValue(ActionResult.PASS);
	}
	@Inject(at = @At("RETURN"), method = "useOnEntity", cancellable = true)
	public void loafy$useOnEntity(PlayerEntity user, LivingEntity entity, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
		if (!this.isOf(Items.BREAD)) cir.setReturnValue(ActionResult.PASS);
	}
	@Inject(at = @At("RETURN"), method = "getName", cancellable = true)
	public void loafy$getName(CallbackInfoReturnable<Text> cir) {
		if (!this.isOf(Items.BREAD) && this.getComponents().get(DataComponentTypes.CUSTOM_NAME) == null) cir.setReturnValue(Items.BREAD.getName());
	}
}
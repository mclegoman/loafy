/*
    Loafy
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.config;

import me.magistermaks.simple_config.SimpleConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

public class LoafyConfig {
	protected static final String id = "loafy";
	protected static SimpleConfig config;
	protected static ConfigProvider configProvider;
	private static String itemId = "minecraft:bread";
	private static ItemStack item = Items.BREAD.getDefaultStack();
	public static void init() {
		try {
			configProvider = new ConfigProvider();
			create();
			config = SimpleConfig.of(id).provider(configProvider).request();
			assign();
			item = Registries.ITEM.get(Identifier.of(itemId)).getDefaultStack();
		} catch (Exception error) {
			System.out.println(error.getLocalizedMessage());
		}
	}
	protected static void create() {
		configProvider.add(new Pair<>("item", "minecraft:bread"));
	}
	protected static void assign() {
		itemId = config.getOrDefault("item", "minecraft:bread");
	}
	public static ItemStack getItemStack() {
		return ((item.getItem() == Items.AIR) && !itemId.equalsIgnoreCase("minecraft:air")) ? Items.BREAD.getDefaultStack() : item;
	}
}

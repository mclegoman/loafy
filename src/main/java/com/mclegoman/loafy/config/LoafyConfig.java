/*
    Loafy
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.config;

import me.magistermaks.simple_config.SimpleConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

public class LoafyConfig {
	protected static final String id = "loafy";
	protected static SimpleConfig config;
	protected static ConfigProvider configProvider;
	public static String itemId = "minecraft:bread";
	public static ItemStack item;
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
}

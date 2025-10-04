/*
    Loafy
    Contributor(s): dannytaylor
    Github: https://github.com/mclegoman/loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.config;

import me.magistermaks.simple_config.SimpleConfig;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

public class LoafyConfig {
	protected static final String id = "loafy";
	protected static SimpleConfig config;
	protected static ConfigProvider configProvider;
	private static Identifier itemId = Identifier.of("minecraft:bread");
	private static Item item;

	public static void init() {
		try {
			configProvider = new ConfigProvider();
			create();
			config = SimpleConfig.of(id).provider(configProvider).request();
			assign();
			item = Registries.ITEM.get(LoafyConfig.getItemId()).asItem();
		} catch (Exception error) {
			System.out.println(error.getLocalizedMessage());
		}
	}

	protected static void create() {
		configProvider.add(new Pair<>("item", "minecraft:bread"));
	}

	protected static void assign() {
		String id = config.getOrDefault("item", "minecraft:bread");
		try {
			itemId = Identifier.of(id);
		} catch (Exception error) {
			System.err.println("There was an error setting itemId to '" + id + "', defaulting to 'minecraft:bread': " + error);
			itemId = Identifier.of("minecraft:bread");
		}
	}

	public static Identifier getItemId() {
		return itemId;
	}

	public static Item getItem() {
		return item != null ? item : Items.BREAD;
	}
}

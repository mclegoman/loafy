/*
    Loafy
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Loafy
    Licence: GNU LGPLv3
*/

package com.mclegoman.loafy.client;

import com.mclegoman.loafy.config.LoafyConfig;

public class Loafy {
	public static void onInitializeClient() {
		System.out.println("*turns all your items into bread*");
		LoafyConfig.init();
	}
}

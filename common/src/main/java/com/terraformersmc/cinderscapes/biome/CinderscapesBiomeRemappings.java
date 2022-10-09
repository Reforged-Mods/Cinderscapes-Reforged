package com.terraformersmc.cinderscapes.biome;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class CinderscapesBiomeRemappings {
	public static void onRemap(RegistryEvent.MissingMappings<Biome> event){
		Cinderscapes.LOGGER.info("Missing mappings");
		for (RegistryEvent.MissingMappings.Mapping<Biome> map : event.getMappings(Cinderscapes.NAMESPACE)) {
			Cinderscapes.LOGGER.info(map.key);
			if (map.key.getPath().equals("quartz_canyon")){
				Biome[] biome = new Biome[1];
				CinderscapesBiomes.BIOMES.forEach((k, v) -> {
					if (k.getPath().equals("quartz_cavern")){
						map.remap(v);
					}
				});

			}
		}
	}

	public static void init(){
		MinecraftForge.EVENT_BUS.addGenericListener(Biome.class, CinderscapesBiomeRemappings::onRemap);
	}
}

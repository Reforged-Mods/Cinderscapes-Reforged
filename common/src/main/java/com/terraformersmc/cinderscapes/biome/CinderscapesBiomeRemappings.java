package com.terraformersmc.cinderscapes.biome;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CinderscapesBiomeRemappings {
	private static void onRemap(RegistryEvent.MissingMappings<Biome> event){
		for (RegistryEvent.MissingMappings.Mapping<Biome> map : event.getMappings(Cinderscapes.NAMESPACE)) {
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

	public static void init() {
		FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Biome.class, CinderscapesBiomeRemappings::onRemap);
	}
}

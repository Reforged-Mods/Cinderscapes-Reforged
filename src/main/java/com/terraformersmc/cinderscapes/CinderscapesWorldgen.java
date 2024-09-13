package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.surfacebuilders.CinderscapesSurfaceBuilders;
import com.terraformersmc.cinderscapes.biomegen.CinderscapesBiomeAPIGeneration;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CinderscapesWorldgen {

	public CinderscapesWorldgen(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}

	private void setup(final FMLCommonSetupEvent e) {
		Cinderscapes.LOGGER.info("Enabling Cinderscapes' Fabric Biome API worldgen module.");
		Cinderscapes.callbackWhenInitialized(CinderscapesSurfaceBuilders::init);
		CinderscapesBiomeAPIGeneration.init();
	}
}

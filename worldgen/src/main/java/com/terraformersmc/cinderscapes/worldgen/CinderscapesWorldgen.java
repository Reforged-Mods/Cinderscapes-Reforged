package com.terraformersmc.cinderscapes.worldgen;

import com.google.common.collect.ImmutableSet;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.mixin.worldgen.CarverAccessor;
import com.terraformersmc.cinderscapes.surfacebuilders.CinderscapesSurfaceBuilders;
import com.terraformersmc.cinderscapes.worldgen.CinderscapesBiomeAPIGeneration;
import net.minecraft.block.Block;
import net.minecraft.world.gen.carver.Carver;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("cinderscapes_worldgen")
public class CinderscapesWorldgen {

	public CinderscapesWorldgen(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}

	private void setup(final FMLCommonSetupEvent e) {
		Cinderscapes.LOGGER.info("Enabling Cinderscapes' Fabric Biome API worldgen module.");
		((CarverAccessor) Carver.NETHER_CAVE).setAlwaysCarvableBlocks(ImmutableSet.<Block>builder().addAll(((CarverAccessor) Carver.NETHER_CAVE).getAlwaysCarvableBlocks()).add(CinderscapesBlocks.UMBRAL_NYLIUM, CinderscapesBlocks.UMBRAL_WART_BLOCK).build());
		Cinderscapes.callbackWhenInitialized(CinderscapesSurfaceBuilders::init);
		CinderscapesBiomeAPIGeneration.init();
	}
}

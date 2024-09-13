package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BlockTagProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Cinderscapes.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CinderscapesDatagen{

	public static void onInitializeDataGenerator(DataGenerator dataGenerator, ExistingFileHelper helper){
		dataGenerator.addProvider(new CinderscapesBiomeTagProvider(dataGenerator, helper));
		dataGenerator.addProvider(new CinderscapesLootTableProvider(dataGenerator));
		BlockTagProvider provider = new CinderscapesBlockTagProvider(dataGenerator, helper);
		dataGenerator.addProvider(provider);
		dataGenerator.addProvider(new CinderscapesItemTagProvider(dataGenerator, provider, helper));
		dataGenerator.addProvider(new CinderscapesRecipeProvider(dataGenerator));
	}

	@SubscribeEvent
	public static void onGatherDataEvent(GatherDataEvent event){
		onInitializeDataGenerator(event.getGenerator(), event.getExistingFileHelper());
	}
}

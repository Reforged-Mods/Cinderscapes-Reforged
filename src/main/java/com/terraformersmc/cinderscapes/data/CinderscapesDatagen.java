package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BlockTagProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinderscapes.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CinderscapesDatagen{

	public static void onInitializeDataGenerator(DataGenerator dataGenerator, ExistingFileHelper helper){
		dataGenerator.addProvider(true, new CinderscapesBiomeTagProvider(dataGenerator, helper));
		dataGenerator.addProvider(true, new CinderscapesLootTableProvider(dataGenerator));
		BlockTagProvider provider = new CinderscapesBlockTagProvider(dataGenerator, helper);
		dataGenerator.addProvider(true, provider);
		dataGenerator.addProvider(true, new CinderscapesItemTagProvider(dataGenerator, provider, helper));
		dataGenerator.addProvider(true, new CinderscapesRecipeProvider(dataGenerator));
	}

	@SubscribeEvent
	public static void onGatherDataEvent(GatherDataEvent event){
		onInitializeDataGenerator(event.getGenerator(), event.getExistingFileHelper());
	}
}

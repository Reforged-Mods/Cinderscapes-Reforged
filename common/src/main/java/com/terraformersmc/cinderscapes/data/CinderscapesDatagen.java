package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.devtech.arrp.api.RRPEvent;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinderscapes.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CinderscapesDatagen{
	public static final RuntimeResourcePack RUNTIME_RESOURCE_PACK = RuntimeResourcePack.create("cinderscapes:dynamic");

	public static void init(){
		CinderscapesBiomeTagProvider.init();
		CinderscapesBlockTagProvider.init();
		CinderscapesBlockTagProvider.init();
		CinderscapesItemTagProvider.init();

	}

	@SubscribeEvent
	public static void onResourcePackAddAfter(RRPEvent.AfterVanilla event){
		event.addPack(RUNTIME_RESOURCE_PACK);
	}

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		dataGenerator.addProvider(CinderscapesRecipeProvider::new);
	}
}

package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.devtech.arrp.api.RRPEvent;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinderscapes.NAMESPACE, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CinderscapesDatagen{
	public static final RuntimeResourcePack RUNTIME_RESOURCE_PACK = RuntimeResourcePack.create("cinderscapes:dynamic");

	public static void init(){
		CinderscapesBiomeTagProvider.init();
		CinderscapesBlockTagProvider.init();
		CinderscapesBlockLootTableProvider.init();
		CinderscapesItemTagProvider.init();
		CinderscapesRecipeProvider.init();
		RUNTIME_RESOURCE_PACK.dump();
	}

	@SubscribeEvent
	public static void onResourcePackAddAfter(RRPEvent.AfterVanilla event){
		event.addPack(RUNTIME_RESOURCE_PACK);
	}

	public static Identifier tagID(TagKey<?> key){
		return new Identifier(key.id().getNamespace(), key.registry().getValue().getPath() + "/" + key.id().getPath());
	}
}

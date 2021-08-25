package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.client.CinderscapesClient;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesConfiguredFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesConfiguredSurfaces;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesGroups;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.init.CinderscapesTrades;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.server.network.SpawnLocating;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(value = Cinderscapes.ID)
public class Cinderscapes {

	public static final String ID = "cinderscapes";
	public static final Logger LOGGER = LogManager.getLogger();

	public Cinderscapes(){
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CinderscapesConfig.COMMON_SPEC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

		CinderscapesItems.init();
		CinderscapesBlocks.init();
		CinderscapesDecorators.init();
		CinderscapesFeatures.init();
		CinderscapesSurfaces.init();
		CinderscapesGroups.init();
		CinderscapesBiomes.init();
		CinderscapesSoundEvents.init();
		CinderscapesTrades.init();

		CinderscapesBiomes.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
		CinderscapesDecorators.DECORATORS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CinderscapesFeatures.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
		CinderscapesSurfaces.SURFACE_BUILDERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CinderscapesSoundEvents.SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CinderscapesItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());


	}

	@OnlyIn(Dist.CLIENT)
	private void clientSetup(final FMLClientSetupEvent e){
		CinderscapesClient.onInitializeClient(e);
	}

	private void setup(final FMLCommonSetupEvent e) {
		e.enqueueWork(() -> {
			CinderscapesConfiguredFeatures.init();
			CinderscapesConfiguredSurfaces.init();
		});
		CinderscapesBiomes.initBiomeAdd();
		NoiseCollisionChecker.init(e);
		onInitialize();
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CinderscapesItems.BRAMBLE_BERRIES.get(), 0.3f);
	}

	@SubscribeEvent
	public void onRegister(final RegistryEvent.Register<?> event){
		if (event.getRegistry() == ForgeRegistries.BLOCKS){
			for (Identifier id : CinderscapesBlocks.BLOCKS.keySet()) {
				Block block = CinderscapesBlocks.BLOCKS.get(id);
				if (block.getRegistryName() == null){
					block.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(block);
			}
		}
		if (event.getRegistry() == ForgeRegistries.ITEMS){
			for (Identifier id : CinderscapesBlocks.ITEMS.keySet()) {
				BlockItem item = CinderscapesBlocks.ITEMS.get(id);
				if (item.getRegistryName() == null){
					item.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(item);
			}
		}

	}

	public void onInitialize() {
		try {
			SpawnRestriction.register(EntityType.ZOGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZoglinEntity::canMobSpawn);
		} catch (IllegalStateException ignored) {}


	}

	public static Identifier id(String path) {
		return new Identifier(ID, path);
	}

	public static String idAsString(String path){
		return id(path).toString();
	}
}
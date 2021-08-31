package com.terraformersmc.cinderscapes;

import com.google.common.collect.ImmutableSet;
import com.terraformersmc.cinderscapes.client.CinderscapesClient;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesConfiguredFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesDecorators;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesGroups;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.init.CinderscapesSurfaces;
import com.terraformersmc.cinderscapes.init.CinderscapesTags;
import com.terraformersmc.cinderscapes.init.CinderscapesTrades;
import com.terraformersmc.cinderscapes.mixin.CarverAccessor;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
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
import net.minecraftforge.fml.loading.FMLEnvironment;
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
		FMLJavaModLoadingContext.get().getModEventBus().register(this);

		CinderscapesItems.init();
		CinderscapesBlocks.init();
		CinderscapesDecorators.init();
		CinderscapesFeatures.init();
		CinderscapesSurfaces.init();
		CinderscapesGroups.init();
		CinderscapesBiomes.init();
		CinderscapesSoundEvents.init();
		CinderscapesTrades.init();
		if (FMLEnvironment.dist.isClient()){
			CinderscapesClient.addSigns();
		}


	}

	@OnlyIn(Dist.CLIENT)
	private void clientSetup(final FMLClientSetupEvent e){
		CinderscapesClient.onInitializeClient(e);
	}

	private void setup(final FMLCommonSetupEvent e) {
		e.enqueueWork(() -> {
			CinderscapesConfiguredFeatures.init();
			CinderscapesTags.init();
		});
		((CarverAccessor) Carver.NETHER_CAVE).setAlwaysCarvableBlocks(ImmutableSet.<Block>builder().addAll(((CarverAccessor) Carver.NETHER_CAVE).getAlwaysCarvableBlocks()).add(CinderscapesBlocks.UMBRAL_NYLIUM).build());
		CinderscapesBiomes.initBiomeAdd();
		NoiseCollisionChecker.init(e);
		onInitialize();
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CinderscapesItems.BRAMBLE_BERRIES, 0.3f);
	}

	@SubscribeEvent
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void onRegister(final RegistryEvent.Register<?> event){
		if (event.getRegistry() == ForgeRegistries.FEATURES){
			for (Identifier id : CinderscapesFeatures.FEATURES.keySet()){
				Feature<?> feature = CinderscapesFeatures.FEATURES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.SURFACE_BUILDERS){
			for (Identifier id : CinderscapesSurfaces.SURFACE_BUILDERS.keySet()){
				SurfaceBuilder<?> feature = CinderscapesSurfaces.SURFACE_BUILDERS.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.DECORATORS){
			for (Identifier id : CinderscapesDecorators.DECORATORS.keySet()){
				Decorator<?> feature = CinderscapesDecorators.DECORATORS.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.SOUND_EVENTS){
			for (Identifier id : CinderscapesSoundEvents.SOUND_EVENTS.keySet()){
				SoundEvent feature = CinderscapesSoundEvents.SOUND_EVENTS.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
		if (event.getRegistry() == ForgeRegistries.BIOMES){
			for (Identifier id : CinderscapesBiomes.BIOMES.keySet()){
				Biome feature = CinderscapesBiomes.BIOMES.get(id);
				if (feature.getRegistryName() == null){
					feature.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(feature);
			}
		}
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
			for (Identifier id : CinderscapesItems.ITEMS.keySet()) {
				Item item = CinderscapesItems.ITEMS.get(id);
				if (item.getRegistryName() == null){
					item.setRegistryName(id);
				}
				((IForgeRegistry)event.getRegistry()).register(item);
			}
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
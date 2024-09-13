package com.terraformersmc.cinderscapes;

import com.terraformersmc.cinderscapes.biome.CinderscapesBiomeRemappings;
import com.terraformersmc.cinderscapes.client.CinderscapesClient;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.cinderscapes.data.CinderscapesDatagen;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesConfiguredFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesFeatures;
import com.terraformersmc.cinderscapes.init.CinderscapesGroups;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.init.CinderscapesPlacementModifierTypes;
import com.terraformersmc.cinderscapes.init.CinderscapesSoundEvents;
import com.terraformersmc.cinderscapes.init.CinderscapesTrades;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import com.terraformersmc.cinderscapes.tag.CinderscapesItemTags;
import com.terraformersmc.cinderscapes.util.NoiseCollisionChecker;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(Cinderscapes.NAMESPACE)
public class Cinderscapes {
	public static final String NAMESPACE = "cinderscapes";
	public static final Logger LOGGER = LogManager.getLogger(StringUtils.capitalize(NAMESPACE));

	public static List<Item> HIDDEN_ITEMS = new ArrayList<>();

	private static Boolean initialized = false;
	private static final ArrayList<Runnable> runnables = new ArrayList<>(1);

	public Cinderscapes(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
		try {
			SpawnRestriction.register(EntityType.ZOGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZoglinEntity::canMobSpawn);
			SpawnRestriction.register(EntityType.ZOMBIFIED_PIGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZombifiedPiglinEntity::canMobSpawn);
		} catch (IllegalStateException ignored) { }
		DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CinderscapesClient::new);
		CinderscapesGroups.init();
	}

	private void setup(final FMLCommonSetupEvent e) {
		CinderscapesBlocks.registerCompostableBlocks();
		e.enqueueWork(CinderscapesConfiguredFeatures::init);
		//((CarverAccessor) Carver.NETHER_CAVE).setAlwaysCarvableBlocks(ImmutableSet.<Block>builder().addAll(((CarverAccessor) Carver.NETHER_CAVE).getAlwaysCarvableBlocks()).add(CinderscapesBlocks.UMBRAL_NYLIUM).build());
		NoiseCollisionChecker.init();
		onInitialize();
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CinderscapesItems.BRAMBLE_BERRIES, 0.3f);
	}

	@SubscribeEvent
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void onRegister(final RegistryEvent.Register<?> event){
		ModContainer previous = ModLoadingContext.get().getActiveContainer();
		ModLoadingContext.get().setActiveContainer(ModList.get().getModContainerById(NAMESPACE).isPresent() ? ModList.get().getModContainerById(NAMESPACE).get() : previous);
		if (event.getRegistry() == ForgeRegistries.FEATURES){
			for (Identifier id : CinderscapesFeatures.FEATURES.keySet()){
				Feature<?> feature = CinderscapesFeatures.FEATURES.get(id);
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
			CinderscapesConfig.init();
			CinderscapesBlocks.init();
			CinderscapesItems.init();
			CinderscapesBlockTags.init();
			CinderscapesItemTags.init();
			CinderscapesPlacementModifierTypes.init();
			CinderscapesFeatures.init();
			CinderscapesBiomes.init();
			CinderscapesSoundEvents.init();
			CinderscapesTrades.init();
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
		ModLoadingContext.get().setActiveContainer(previous);
	}

	public void onInitialize() {
		try {
			SpawnRestriction.register(EntityType.ZOGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZoglinEntity::canMobSpawn);
			SpawnRestriction.register(EntityType.ZOMBIFIED_PIGLIN, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZombifiedPiglinEntity::canMobSpawn);
		} catch (IllegalStateException ignored) { }

		if (!ModList.get().isLoaded("cinderscapes_worldgen")) {
			Cinderscapes.LOGGER.info("No Cinderscapes worldgen module present; Cinderscapes biomes will not generate.");
		}

		// At this point Cinderscapes is completely initialized.
		initialized = true;
		for (Runnable callback : runnables) {
			callback.run();
		}
	}

	public static void callbackWhenInitialized(Runnable callback) {
		if (initialized) {
			callback.run();
		} else {
			runnables.add(callback);
		}
	}

	public static Identifier id(String path) {
		return new Identifier(NAMESPACE, path);
	}
}

package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.feature.*;
import com.terraformersmc.cinderscapes.feature.config.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlobsFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// TODO: Check
public class CinderscapesFeatures {

    public static final Map<Identifier, Feature<?>> FEATURES = new LinkedHashMap<>();

    public static Feature<DefaultFeatureConfig> ASH_TOP_LAYER = register("ash_top_layer", new AshTopLayerFeature());
    public static Feature<ShaleFeatureConfig> SHALE_FEATURE = register("shale", new ShaleFeature());

    public static Feature<DefaultFeatureConfig> BLACKSTONE_WEEPING_VINES = register("blackstone_weeping_vines", new BlackstoneWeepingVinesFeature());
    public static Feature<CrystalShardFeatureConfig> CRYSTAL_SHARD_FEATURE = register("crystal_shard", new CrystalShardFeature());;
    public static Feature<DefaultFeatureConfig> ASH_PILE = register("ash_pile", new AshPileFeature());

    public static Feature<CanopiedHugeFungusFeatureConfig> CANOPIED_HUGE_FUNGUS = register("canopied_huge_fungus", new CanopiedHugeFungusFeature());

    public static CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_CONFIG;
    public static CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_NOT_PLANTED_CONFIG;
    public static Feature<DefaultFeatureConfig> SHROOMLIGHT_BUSH = register("shroomlight_bush", new ShroomlightBushFeature());
    public static Feature<DefaultFeatureConfig> UMBRAL_VINE = register("umbral_vine", new UmbralVineFeature());

    public static Feature<DefaultFeatureConfig> DEAD_TREE = register("dead_tree", new DeadTreeFeature());

    public static Feature<PolypiteQuartzFeatureConfig> POLYPITE_QUARTZ = register("polypite_quartz", new PolypiteQuartzFeature());

    public static Feature<VegetationFeatureConfig> VEGETATION = register("vegetation", new VegetationFeature());
    public static VegetationFeatureConfig LUMINOUS_GROVE_VEGETATION_CONFIG;
    public static VegetationFeatureConfig ASHY_SHOALS_VEGETATION_CONFIG;
    public static VegetationFeatureConfig QUARTZ_CAVERN_VEGETATION_CONFIG;

    public static RandomPatchFeatureConfig TALL_PHOTOFERN_CONFIG;
    public static RandomPatchFeatureConfig LUMINOUS_POD_CONFIG;

    public static RandomPatchFeatureConfig BRAMBLE_BERRY_BUSH_CONFIG;

    public static ReplaceBlobsFeatureConfig SOUL_SAND_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig SOUL_SOIL_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig GRAVEL_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig CRIMSON_NYLIUM_REPLACE_CONFIG;
    public static ReplaceBlobsFeatureConfig BLACKSTONE_REPLACE_CONFIG;

    public static void init() {
        UMBRAL_FUNGUS_CONFIG = new CanopiedHugeFungusFeatureConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), CinderscapesBlocks.UMBRAL_HYPHAE.getDefaultState(), CinderscapesBlocks.UMBRAL_STEM.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState(), CinderscapesBlocks.UMBRAL_FLESH_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
        UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = UMBRAL_FUNGUS_CONFIG.withPlanted(false);

        LUMINOUS_GROVE_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(Blocks.WARPED_ROOTS.getDefaultState(), 1)
                        .add(Blocks.NETHER_SPROUTS.getDefaultState(), 1)
                        .add(Blocks.WARPED_FUNGUS.getDefaultState(), 1)
                        .add(CinderscapesBlocks.PHOTOFERN.getDefaultState(), 2)
                        .add(CinderscapesBlocks.TWILIGHT_FESCUES.getDefaultState(), 5)
                        .add(CinderscapesBlocks.TWILIGHT_TENDRILS.getDefaultState(), 5)
                        .add(CinderscapesBlocks.UMBRAL_FUNGUS.getDefaultState(), 2).build()),
                Arrays.asList(
                        CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState()
                )
        );

        QUARTZ_CAVERN_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(CinderscapesBlocks.CRYSTINIUM.getDefaultState(), 1).build()),
                Arrays.asList(
                        Blocks.NETHERRACK.getDefaultState()
                )
        );

        ASHY_SHOALS_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(CinderscapesBlocks.SCORCHED_SHRUB.getDefaultState(), 2)
                        .add(CinderscapesBlocks.SCORCHED_SPROUTS.getDefaultState(), 5)
                        .add(CinderscapesBlocks.SCORCHED_TENDRILS.getDefaultState(), 5)
                        .add(CinderscapesBlocks.PYRACINTH.getDefaultState(), 1).build()),
                Arrays.asList(
                        Blocks.NETHERRACK.getDefaultState(),
                        Blocks.GRAVEL.getDefaultState(),
                        Blocks.BLACKSTONE.getDefaultState(),
                        Blocks.SOUL_SOIL.getDefaultState(),
                        Blocks.BASALT.getDefaultState()
                ),
                Arrays.asList(
                        CinderscapesBlocks.ASH.getDefaultState()
                )
        );

        TALL_PHOTOFERN_CONFIG = ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(CinderscapesBlocks.TALL_PHOTOFERN.getDefaultState())), List.of(), 64);
        LUMINOUS_POD_CONFIG = ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(CinderscapesBlocks.LUMINOUS_POD.getDefaultState())), List.of(), 64);
        BRAMBLE_BERRY_BUSH_CONFIG = ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(((BrambleBerryBushBlock) CinderscapesBlocks.BRAMBLE_BERRY_BUSH).getGenerationState())), List.of(), 64);

        IntProvider spread = UniformIntProvider.create(3, 7);
        SOUL_SAND_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), spread);
        SOUL_SOIL_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), spread);
        GRAVEL_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), spread);
        CRIMSON_NYLIUM_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.CRIMSON_NYLIUM.getDefaultState(), spread);
        BLACKSTONE_REPLACE_CONFIG = new ReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), spread);
    }

    private static <T extends FeatureConfig> Feature<T> register(String name, Feature<T> feature){
        FEATURES.put(Cinderscapes.id(name), feature);
        RegistryKey.of(Registry.FEATURE_KEY, Cinderscapes.id(name));
        return feature;
    }
}

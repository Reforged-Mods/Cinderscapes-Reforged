package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.feature.AshPileFeature;
import com.terraformersmc.cinderscapes.feature.AshTopLayerFeature;
import com.terraformersmc.cinderscapes.feature.BlackstoneLavaShaleFeature;
import com.terraformersmc.cinderscapes.feature.BlackstoneShaleFeature;
import com.terraformersmc.cinderscapes.feature.BlackstoneWeepingVinesFeature;
import com.terraformersmc.cinderscapes.feature.CanopiedHugeFungusFeature;
import com.terraformersmc.cinderscapes.feature.CeilingShardFeature;
import com.terraformersmc.cinderscapes.feature.DeadTreeFeature;
import com.terraformersmc.cinderscapes.feature.FloorShardFeature;
import com.terraformersmc.cinderscapes.feature.PolypiteQuartzFeature;
import com.terraformersmc.cinderscapes.feature.ShaleFeature;
import com.terraformersmc.cinderscapes.feature.ShroomlightBushFeature;
import com.terraformersmc.cinderscapes.feature.UmbralVineFeature;
import com.terraformersmc.cinderscapes.feature.VegetationFeature;
import com.terraformersmc.cinderscapes.feature.config.CanopiedHugeFungusFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.PolypiteQuartzFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.SimpleStateFeatureConfig;
import com.terraformersmc.cinderscapes.feature.config.VegetationFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.NetherrackReplaceBlobsFeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.DoublePlantPlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

// TODO: Check
public class CinderscapesFeatures {

    public static final Map<Identifier, Feature<?>> FEATURES = new LinkedHashMap<>();

    public static Feature<DefaultFeatureConfig> ASH_TOP_LAYER = register("ash_top_layer", new AshTopLayerFeature());
    public static Feature<SimpleStateFeatureConfig> SHALE_FEATURE = register("shale", new ShaleFeature());

    public static Feature<DefaultFeatureConfig> BLACKSTONE_SHALE = register("blackstone_shale", new BlackstoneShaleFeature());
    public static Feature<DefaultFeatureConfig> BLACKSTONE_LAVA_SHALE = register("blackstone_lava_shale", new BlackstoneLavaShaleFeature());
    public static Feature<DefaultFeatureConfig> BLACKSTONE_WEEPING_VINES = register("blackstone_weeping_vines", new BlackstoneWeepingVinesFeature());
    public static Feature<SimpleStateFeatureConfig> CEILING_SHARD = register("ceiling_shard", new CeilingShardFeature());
    public static Feature<SimpleStateFeatureConfig> FLOOR_SHARD = register("floor_shard", new FloorShardFeature());
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
    public static VegetationFeatureConfig QUARTZ_CANYON_VEGETATION_CONFIG;

    public static RandomPatchFeatureConfig TALL_PHOTOFERN_CONFIG;
    public static RandomPatchFeatureConfig LUMINOUS_POD_CONFIG;

    public static RandomPatchFeatureConfig BRAMBLE_BERRY_BUSH_CONFIG;

    public static NetherrackReplaceBlobsFeatureConfig SOUL_SAND_REPLACE_CONFIG;
    public static NetherrackReplaceBlobsFeatureConfig SOUL_SOIL_REPLACE_CONFIG;
    public static NetherrackReplaceBlobsFeatureConfig GRAVEL_REPLACE_CONFIG;
    public static NetherrackReplaceBlobsFeatureConfig CRIMSON_NYLIUM_REPLACE_CONFIG;
    public static NetherrackReplaceBlobsFeatureConfig BLACKSTONE_REPLACE_CONFIG;

    public static void init() {

        UMBRAL_FUNGUS_CONFIG = new CanopiedHugeFungusFeatureConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), CinderscapesBlocks.UMBRAL_STEM.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState(), CinderscapesBlocks.UMBRAL_FLESH_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
        UMBRAL_FUNGUS_NOT_PLANTED_CONFIG = new CanopiedHugeFungusFeatureConfig(UMBRAL_FUNGUS_CONFIG.soilBlock, UMBRAL_FUNGUS_CONFIG.stemBlock, UMBRAL_FUNGUS_CONFIG.canopyBlock, UMBRAL_FUNGUS_CONFIG.fleshBlock, UMBRAL_FUNGUS_CONFIG.decorationBlock, false);

        LUMINOUS_GROVE_VEGETATION_CONFIG = new VegetationFeatureConfig(
            new WeightedBlockStateProvider()
                .addState(Blocks.WARPED_ROOTS.getDefaultState(), 1)
                .addState(Blocks.NETHER_SPROUTS.getDefaultState(), 1)
                .addState(Blocks.WARPED_FUNGUS.getDefaultState(), 1)
                .addState(CinderscapesBlocks.PHOTOFERN.getDefaultState(), 2)
                .addState(CinderscapesBlocks.TWILIGHT_FESCUES.getDefaultState(), 5)
                .addState(CinderscapesBlocks.TWILIGHT_TENDRILS.getDefaultState(), 5)
                .addState(CinderscapesBlocks.UMBRAL_FUNGUS.getDefaultState(), 2),
            Arrays.asList(
                CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState()
            )
        );

        QUARTZ_CANYON_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedBlockStateProvider()
                        .addState(CinderscapesBlocks.CRYSTINIUM.getDefaultState(), 1),
                Arrays.asList(
                        Blocks.NETHERRACK.getDefaultState()
                )
        );

        ASHY_SHOALS_VEGETATION_CONFIG = new VegetationFeatureConfig(
                new WeightedBlockStateProvider()
                        .addState(CinderscapesBlocks.SCORCHED_SHRUB.getDefaultState(), 2)
                        .addState(CinderscapesBlocks.SCORCHED_SPROUTS.getDefaultState(), 5)
                        .addState(CinderscapesBlocks.SCORCHED_TENDRILS.getDefaultState(), 5)
                        .addState(CinderscapesBlocks.PYRACINTH.getDefaultState(), 1),
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

        TALL_PHOTOFERN_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CinderscapesBlocks.TALL_PHOTOFERN.getDefaultState()), new DoublePlantPlacer())).tries(64).cannotProject().build();
        LUMINOUS_POD_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(CinderscapesBlocks.LUMINOUS_POD.getDefaultState()), new DoublePlantPlacer())).tries(64).cannotProject().build();
        BRAMBLE_BERRY_BUSH_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(((BrambleBerryBushBlock) CinderscapesBlocks.BRAMBLE_BERRY_BUSH).getGenerationState()), SimpleBlockPlacer.INSTANCE)).tries(64).cannotProject().build();

        UniformIntDistribution spread = UniformIntDistribution.of(3, 4); // 3-7
        SOUL_SAND_REPLACE_CONFIG = new NetherrackReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SAND.getDefaultState(), spread);
        SOUL_SOIL_REPLACE_CONFIG = new NetherrackReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.SOUL_SOIL.getDefaultState(), spread);
        GRAVEL_REPLACE_CONFIG = new NetherrackReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.GRAVEL.getDefaultState(), spread);
        CRIMSON_NYLIUM_REPLACE_CONFIG = new NetherrackReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.CRIMSON_NYLIUM.getDefaultState(), spread);
        BLACKSTONE_REPLACE_CONFIG = new NetherrackReplaceBlobsFeatureConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.BLACKSTONE.getDefaultState(), spread);
    }

    private static <T extends FeatureConfig> Feature<T> register(String name, Feature<T> feature){
        FEATURES.put(Cinderscapes.id(name), feature);
        RegistryKey.of(Registry.FEATURE_KEY, Cinderscapes.id(name));
        return feature;
    }
}

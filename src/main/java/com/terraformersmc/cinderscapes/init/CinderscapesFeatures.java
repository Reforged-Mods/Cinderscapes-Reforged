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
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NetherrackReplaceBlobsFeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.DoublePlantPlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;

import static com.terraformersmc.cinderscapes.Cinderscapes.idAsString;

// TODO: Check
public class CinderscapesFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Cinderscapes.ID);

    public static RegistryObject<Feature<DefaultFeatureConfig>> ASH_TOP_LAYER = FEATURES.register(idAsString("ash_top_layer"), AshTopLayerFeature::new);
    public static RegistryObject<Feature<SimpleStateFeatureConfig>> SHALE_FEATURE = FEATURES.register(idAsString("shale"), ShaleFeature::new);

    public static RegistryObject<Feature<DefaultFeatureConfig>> BLACKSTONE_SHALE = FEATURES.register(idAsString("blackstone_shale"), BlackstoneShaleFeature::new);
    public static RegistryObject<Feature<DefaultFeatureConfig>> BLACKSTONE_LAVA_SHALE = FEATURES.register(idAsString("blackstone_lava_shale"), BlackstoneLavaShaleFeature::new);
    public static RegistryObject<Feature<DefaultFeatureConfig>> BLACKSTONE_WEEPING_VINES = FEATURES.register(idAsString("blackstone_weeping_vines"), BlackstoneWeepingVinesFeature::new);
    public static RegistryObject<Feature<SimpleStateFeatureConfig>> CEILING_SHARD = FEATURES.register(idAsString("ceiling_shard"), CeilingShardFeature::new);
    public static RegistryObject<Feature<SimpleStateFeatureConfig>> FLOOR_SHARD = FEATURES.register(idAsString("floor_shard"), FloorShardFeature::new);
    public static RegistryObject<Feature<DefaultFeatureConfig>> ASH_PILE = FEATURES.register(idAsString("ash_pile"), AshPileFeature::new);

    public static RegistryObject<Feature<CanopiedHugeFungusFeatureConfig>> CANOPIED_HUGE_FUNGUS = FEATURES.register(idAsString("canopied_huge_fungus"), CanopiedHugeFungusFeature::new);

    public static CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_CONFIG;
    public static CanopiedHugeFungusFeatureConfig UMBRAL_FUNGUS_NOT_PLANTED_CONFIG;
    public static RegistryObject<Feature<DefaultFeatureConfig>> SHROOMLIGHT_BUSH = FEATURES.register(idAsString("shroomlight_bush"), ShroomlightBushFeature::new);
    public static RegistryObject<Feature<DefaultFeatureConfig>> UMBRAL_VINE = FEATURES.register(idAsString("umbral_vine"), UmbralVineFeature::new);

    public static RegistryObject<Feature<DefaultFeatureConfig>> DEAD_TREE = FEATURES.register(idAsString("dead_tree"), DeadTreeFeature::new);

    public static RegistryObject<Feature<PolypiteQuartzFeatureConfig>> POLYPITE_QUARTZ = FEATURES.register(idAsString("polypite_quartz"), PolypiteQuartzFeature::new);

    public static RegistryObject<Feature<VegetationFeatureConfig>> VEGETATION = FEATURES.register(idAsString("vegetation"), VegetationFeature::new);
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
}

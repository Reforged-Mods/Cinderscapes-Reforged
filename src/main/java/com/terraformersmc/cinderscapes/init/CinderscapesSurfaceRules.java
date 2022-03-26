package com.terraformersmc.cinderscapes.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.mixin.MaterialRuleContextAccessor;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

// Contains all of the surface builders and surface configs added by Cinderscapes
public class CinderscapesSurfaceRules {
    // Acts as a kind of local registry for surface builders added by Cinderscapes
    public static final Map<Identifier, SurfaceBuilder> SURFACE_BUILDERS = new LinkedHashMap<>();
    //static final Map<Identifier, ConfiguredSurfaceBuilder> CONFIGURED_SURFACE_BUILDERS = new HashMap<>();

    /////////////////////
    // SURFACE CONFIGS //
    /////////////////////
    public static final MaterialRules.MaterialRule LUMINOUS_NYLIUM_RULE = MaterialRules.condition(MaterialRules.biome(CinderscapesBiomes.LUMINOUS_GROVE),
            MaterialRules.condition(
                    MaterialRules.not(MaterialRules.noiseThreshold(NoiseParametersKeys.NETHERRACK, 0.54)),
                    MaterialRules.condition(
                            MaterialRules.aboveY(YOffset.fixed(31), 0),
                            MaterialRules.sequence(
                                    MaterialRules.condition(
                                            MaterialRules.noiseThreshold(NoiseParametersKeys.NETHER_WART, 1.17),
                                            MaterialRules.block(CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState())),
                                    MaterialRules.block(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState())))));
    //public static final TernarySurfaceConfig LUMINOUS_NYLIUM_CONFIG = new TernarySurfaceConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState());
    //public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CONFIGURED_LUMINOUS_GROVE = add("luminous_grove", SurfaceBuilder.NETHER_FOREST.withConfig(LUMINOUS_NYLIUM_CONFIG));
    //static final TernarySurfaceConfig ASHY_SHOALS_CONFIG = new TernarySurfaceConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState());
    public static final MaterialRules.MaterialRule ASHY_SHOALS_RULE = MaterialRules.condition(MaterialRules.biome(CinderscapesBiomes.ASHY_SHOALS),
            MaterialRules.condition(MaterialRules.not(MaterialRules.aboveY(YOffset.fixed(32), 0)),
                    MaterialRules.condition(new PositionRule(0), MaterialRules.block(Blocks.MAGMA_BLOCK.getDefaultState()))
            )
        );

    public static final MaterialRules.MaterialRule BEDROCK_FLOOR = MaterialRules.condition(MaterialRules.verticalGradient("bedrock_floor", YOffset.getBottom(), YOffset.aboveBottom(5)), MaterialRules.block(Blocks.BEDROCK.getDefaultState()));
    public static final MaterialRules.MaterialRule BEDROCK_ROOF = MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(5), YOffset.getTop())), MaterialRules.block(Blocks.BEDROCK.getDefaultState()));
    public static final MaterialRules.MaterialRule CIMDERSCAPES_NETHER_RULES = MaterialRules.sequence(BEDROCK_FLOOR, BEDROCK_ROOF, ASHY_SHOALS_RULE, MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, LUMINOUS_NYLIUM_RULE));

    //////////////////////
    // SURFACE BUILDERS //
    //////////////////////
    //public static final SurfaceBuilder ASHY_SHOALS = add("ashy_shoals", new AshyShoalsSurfaceBuilder());
    //public static final ConfiguredSurfaceBuilder CONFIGURED_ASHY_SHOALS = add("ashy_shoals", ASHY_SHOALS.withConfig(ASHY_SHOALS_CONFIG));


    record PositionRule(int unused) implements MaterialRules.MaterialCondition {
        static final Codec<PositionRule> CONDITION_CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.fieldOf("unused").forGetter(PositionRule::unused)).apply(instance, PositionRule::new));

        @Override
        public Codec<? extends MaterialRules.MaterialCondition> codec() {
            return CONDITION_CODEC;
        }

        @Override
        public MaterialRules.BooleanSupplier apply(MaterialRules.MaterialRuleContext context) {
            return () -> {
                MaterialRuleContextAccessor accessor = ((MaterialRuleContextAccessor) ((Object) context));
                BlockPos pos = new BlockPos(accessor.getX(), accessor.getY(), accessor.getZ());
                if (accessor.getChunk().getBlockState(pos).getBlock() == Blocks.LAVA) {
                    //Cinderscapes.LOGGER.info(pos.toString());
                    if (accessor.getChunk().getBlockState(pos.up()).isAir() /*|| (accessor.getChunk().random.nextBoolean() && chunk.getBlockState(pos.up(2)).isAir())*/){
                        return true;
                    }
                }
                return false;
            };
        }
    }

    /**
     * Adds a surface builder to the Cinderscapes local registry
     * @param name    The path of the surface builder within the Cinderscapes namespace
     * @param s       The surface builder to be added to the local registry
     * @param <S>     The specific class type of the surface builder
     * @return The surface builder that was registered in the Cinderscapes local surface builder registry
     */
    /*private static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S s) {
        SURFACE_BUILDERS.put(Cinderscapes.id(name), s);
        RegistryKey.of(Registry.MATERIAL_RULE_KEY, Cinderscapes.id(name));
        return s;
    }*/

    /**
     * Initializes the surface builders added by Cinderscapes
     */
    public static void init() {
        Registry.register(Registry.MATERIAL_CONDITION, new Identifier(Cinderscapes.NAMESPACE,"position_rule"), PositionRule.CONDITION_CODEC);
    }

    /*static <SC extends SurfaceConfig> ConfiguredSurfaceBuilder<SC> add(String name, ConfiguredSurfaceBuilder<SC> s) {
        CONFIGURED_SURFACE_BUILDERS.put(Cinderscapes.id(name), s);

        return s;
    }*/
}

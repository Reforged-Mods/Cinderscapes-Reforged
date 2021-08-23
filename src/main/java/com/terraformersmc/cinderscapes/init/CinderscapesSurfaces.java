package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.surfacebuilder.AshyShoalsSurfaceBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// Contains all of the surface builders and surface configs added by Cinderscapes
public class CinderscapesSurfaces {
    // Acts as a kind of local registry for surface builders added by Cinderscapes
    private static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Cinderscapes.ID);

    /////////////////////
    // SURFACE CONFIGS //
    /////////////////////
    public static final TernarySurfaceConfig LUMINOUS_NYLIUM_CONFIG = new TernarySurfaceConfig(CinderscapesBlocks.UMBRAL_NYLIUM.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), CinderscapesBlocks.UMBRAL_WART_BLOCK.getDefaultState());
    static final TernarySurfaceConfig ASHY_SHOALS_CONFIG = new TernarySurfaceConfig(Blocks.NETHERRACK.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), Blocks.MAGMA_BLOCK.getDefaultState());

    //////////////////////
    // SURFACE BUILDERS //
    //////////////////////
    public static final RegistryObject<SurfaceBuilder<TernarySurfaceConfig>> ASHY_SHOALS = add("ashy_shoals", new AshyShoalsSurfaceBuilder());

    /**
     * Adds a surface builder to the Cinderscapes local registry
     * @param name    The path of the surface builder within the Cinderscapes namespace
     * @param s       The surface builder to be added to the local registry
     * @param <S>     The specific class type of the surface builder
     * @return The surface builder that was registered in the Cinderscapes local surface builder registry
     */
    private static <S extends SurfaceBuilder<? extends SurfaceConfig>> RegistryObject<S> add(String name, S s) {
        return SURFACE_BUILDERS.register(Cinderscapes.idAsString(name), () -> s);
    }

    /**
     * Initializes the surface builders added by Cinderscapes
     */
    public static void init() {
    }
}

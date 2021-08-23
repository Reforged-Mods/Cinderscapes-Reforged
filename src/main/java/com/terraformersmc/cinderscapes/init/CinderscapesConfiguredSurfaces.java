package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.HashMap;
import java.util.Map;

public class CinderscapesConfiguredSurfaces {
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CONFIGURED_ASHY_SHOALS = add("ashy_shoals", CinderscapesSurfaces.ASHY_SHOALS.get().withConfig(CinderscapesSurfaces.ASHY_SHOALS_CONFIG));
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CONFIGURED_LUMINOUS_GROVE = add("luminous_grove", SurfaceBuilder.NETHER_FOREST.withConfig(CinderscapesSurfaces.LUMINOUS_NYLIUM_CONFIG));
    static final Map<Identifier, ConfiguredSurfaceBuilder<? extends SurfaceConfig>> CONFIGURED_SURFACE_BUILDERS = new HashMap<>();

    private static <SC extends SurfaceConfig> ConfiguredSurfaceBuilder<SC> add(String name, ConfiguredSurfaceBuilder<SC> s) {
        CONFIGURED_SURFACE_BUILDERS.put(Cinderscapes.id(name), s);
        return s;
    }

    public static void init(){
    }
}

package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.decorator.CountSafelistRangeCeilingDecorator;
import com.terraformersmc.cinderscapes.decorator.CountSafelistRangeFloorDecorator;
import com.terraformersmc.cinderscapes.decorator.config.CountSafelistRangeDecoratorConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// TODO: Check
public class CinderscapesDecorators {

    public static final DeferredRegister<Decorator<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.DECORATORS, Cinderscapes.ID);

    public static RegistryObject<Decorator<CountSafelistRangeDecoratorConfig>> COUNT_CEILING = add("count_safelist_range_ceiling", new CountSafelistRangeCeilingDecorator());
    public static RegistryObject<Decorator<CountSafelistRangeDecoratorConfig>> COUNT_FLOOR = add("count_safelist_range_floor", new CountSafelistRangeFloorDecorator());

    public static void init() {
    }

    private static RegistryObject<Decorator<CountSafelistRangeDecoratorConfig>> add(String name, Decorator<CountSafelistRangeDecoratorConfig> config){
        return DECORATORS.register(new Identifier(Cinderscapes.ID, name).toString(), () -> config);
    }
}

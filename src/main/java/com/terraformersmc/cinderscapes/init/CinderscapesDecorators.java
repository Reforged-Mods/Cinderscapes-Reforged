package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.decorator.CountSafelistRangeCeilingDecorator;
import com.terraformersmc.cinderscapes.decorator.CountSafelistRangeFloorDecorator;
import com.terraformersmc.cinderscapes.decorator.config.CountSafelistRangeDecoratorConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.LinkedHashMap;
import java.util.Map;

// TODO: Check
public class CinderscapesDecorators {

    public static final Map<Identifier, Decorator<?>> DECORATORS = new LinkedHashMap<>();

    public static Decorator<CountSafelistRangeDecoratorConfig> COUNT_CEILING = add("count_safelist_range_ceiling", new CountSafelistRangeCeilingDecorator());
    public static Decorator<CountSafelistRangeDecoratorConfig> COUNT_FLOOR = add("count_safelist_range_floor", new CountSafelistRangeFloorDecorator());

    public static void init() {
    }

    private static Decorator<CountSafelistRangeDecoratorConfig> add(String name, Decorator<CountSafelistRangeDecoratorConfig> config){
        DECORATORS.put(Cinderscapes.id(name), config);
        RegistryKey.of(Registry.DECORATOR_KEY, Cinderscapes.id(name));
        return config;
    }
}

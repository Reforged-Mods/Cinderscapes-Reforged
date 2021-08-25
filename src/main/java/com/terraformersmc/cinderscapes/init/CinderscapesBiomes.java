package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.biome.AshyShoalsBiome;
import com.terraformersmc.cinderscapes.biome.BlackstoneShalesBiome;
import com.terraformersmc.cinderscapes.biome.LuminousGroveBiome;
import com.terraformersmc.cinderscapes.biome.QuartzCanyonBiome;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CinderscapesBiomes {

    // Acts as a kind of local registry for Cinderscape's custom biomes

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Cinderscapes.ID);

    public static final RegistryObject<Biome> BLACKSTONE_SHALES = add("blackstone_shales", BlackstoneShalesBiome::create);
    public static final RegistryObject<Biome> QUARTZ_CANYON = add("quartz_canyon", QuartzCanyonBiome::create);
    public static final RegistryObject<Biome> LUMINOUS_GROVE = add("luminous_grove", LuminousGroveBiome::create, BiomeDictionary.Type.FOREST);
    public static final RegistryObject<Biome> ASHY_SHOALS = add("ashy_shoals", AshyShoalsBiome::create, BiomeDictionary.Type.SANDY);

    // Required because something referencing this class has to be called in order to force the
    // static initializer to run (Minecraft's Bootstrap class does similar things)
    public static void init() {
    }

    public static void initBiomeAdd(){
        if (CinderscapesConfig.BIOME_OPTIONS.ENABLE_ASHY_SHOALS) {
            NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("ashy_shoals")), AshyShoalsBiome.NOISE_POINT);
        }
        if (CinderscapesConfig.BIOME_OPTIONS.ENABLE_LUMINOUS_GROVE) {
            NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("luminous_grove")), LuminousGroveBiome.NOISE_POINT);
        }
        if (CinderscapesConfig.BIOME_OPTIONS.ENABLE_QUARTZ_CANYON) {
            NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("quartz_canyon")), QuartzCanyonBiome.NOISE_POINT);
        }
        if (CinderscapesConfig.BIOME_OPTIONS.ENABLE_BLACKSTONE_SHALES) {
            NetherBiomes.addNetherBiome(RegistryKey.of(Registry.BIOME_KEY, Cinderscapes.id("blackstone_shales")), BlackstoneShalesBiome.NOISE_POINT);
        }
    }

    private static RegistryObject<Biome> add(String s, Supplier<Biome> b) {
        Identifier id = Cinderscapes.id(s);
        RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, id);
        BiomeDictionary.addTypes(key, new BiomeDictionary.Type[]{BiomeDictionary.Type.NETHER, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY});
        return BIOMES.register(id.toString(), b);
    }

    private static RegistryObject<Biome> add(String s, Supplier<Biome> b, BiomeDictionary.Type special) {
        Identifier id = Cinderscapes.id(s);
        RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, id);
        BiomeDictionary.addTypes(key, new BiomeDictionary.Type[]{BiomeDictionary.Type.NETHER, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, special});
        return BIOMES.register(id.toString(), b);
    }

}

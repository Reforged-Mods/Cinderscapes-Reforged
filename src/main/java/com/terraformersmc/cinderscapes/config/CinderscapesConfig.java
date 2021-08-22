package com.terraformersmc.cinderscapes.config;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CinderscapesConfig {

    public static final CommonConfig COMMON_CONFIG;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {

        final Pair<CommonConfig, ForgeConfigSpec> COMMON_PAIR = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_CONFIG = COMMON_PAIR.getLeft();
        COMMON_SPEC = COMMON_PAIR.getRight();

    }

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent e) {
        if (e.getConfig().getSpec() == COMMON_SPEC) bakeCommonConfig();

    }

    public static final CinderscapesConfig INSTANCE = new CinderscapesConfig();

    public static final BiomeOptions BIOME_OPTIONS = new BiomeOptions();

    public boolean ENABLE_ASH_FALL;

    public static class CommonConfig{
        public ForgeConfigSpec.BooleanValue ENABLE_ASHY_SHOALS, ENABLE_BLACKSTONE_SHALES, ENABLE_LUMINOUS_GROVE, ENABLE_QUARTZ_CANYON;
        public ForgeConfigSpec.BooleanValue ENABLE_ASH_FALL;

        public CommonConfig(ForgeConfigSpec.Builder builder) {

            builder.push("World");

            ENABLE_ASHY_SHOALS = builder.comment("Enable Ashy Shoals biome - Default: true")
                    .translation(Cinderscapes.ID + ".config.ashy_shoals")
                    .worldRestart()
                    .define("ENABLE_ASHY_SHOALS", true);

            ENABLE_BLACKSTONE_SHALES = builder.comment("Enable Blackstone Shales biome - Default: true")
                    .translation(Cinderscapes.ID + ".config.blackstone_shales")
                    .worldRestart()
                    .define("ENABLE_BLACKSTONE_SHALES", true);

            ENABLE_LUMINOUS_GROVE = builder.comment("Enable Luminous Grove biome - Default: true")
                    .translation(Cinderscapes.ID + ".config.luminous_grove")
                    .worldRestart()
                    .define("ENABLE_LUMINOUS_GROVE", true);

            ENABLE_QUARTZ_CANYON = builder.comment("Enable Quartz Canyon biome - Default: true")
                    .translation(Cinderscapes.ID + ".config.quartz_canyon")
                    .worldRestart()
                    .define("ENABLE_QUARTZ_CANYON", true);

            builder.pop();

            ENABLE_ASH_FALL = builder.comment("Enable falling ash - Default: true")
                    .translation(Cinderscapes.ID + ".config.ash_fall")
                    .worldRestart()
                    .define("ENABLE_ASH_FALL", true);

        }
    }

    public static class BiomeOptions {
        public boolean ENABLE_ASHY_SHOALS, ENABLE_BLACKSTONE_SHALES, ENABLE_LUMINOUS_GROVE, ENABLE_QUARTZ_CANYON;
    }

    private static void bakeCommonConfig() {
        INSTANCE.ENABLE_ASH_FALL = COMMON_CONFIG.ENABLE_ASH_FALL.get();

        BIOME_OPTIONS.ENABLE_ASHY_SHOALS = COMMON_CONFIG.ENABLE_ASHY_SHOALS.get();
        BIOME_OPTIONS.ENABLE_BLACKSTONE_SHALES = COMMON_CONFIG.ENABLE_BLACKSTONE_SHALES.get();
        BIOME_OPTIONS.ENABLE_LUMINOUS_GROVE = COMMON_CONFIG.ENABLE_LUMINOUS_GROVE.get();
        BIOME_OPTIONS.ENABLE_QUARTZ_CANYON = COMMON_CONFIG.ENABLE_QUARTZ_CANYON.get();
    }
}

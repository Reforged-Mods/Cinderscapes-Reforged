package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.sound.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CinderscapesSoundEvents {

	// Acts as a kind of local registry for sound events added by Cinderscapes
	private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Cinderscapes.ID);

	public static final RegistryObject<SoundEvent> ASHY_SHOALS_MUSIC = add("music.nether.ashy_shoals");
	public static final RegistryObject<SoundEvent> BLACKSTONE_SHALES_MUSIC = add("music.nether.blackstone_shales");
	public static final RegistryObject<SoundEvent> LUMINOUS_GROVE_MUSIC = add("music.nether.luminous_grove");
	public static final RegistryObject<SoundEvent> QUARTZ_CANYON_MUSIC = add("music.nether.quartz_canyon");
	
	public static final RegistryObject<SoundEvent> MENU_MUSIC = add("music.menu");

	public static final RegistryObject<SoundEvent> MUSIC_DISC_LUMINOUS_PLANTATION = add("music_disc.luminous_plantation");
	public static final RegistryObject<SoundEvent> MUSIC_DISC_CHILLING_IN_HELL = add("music_disc.chilling_in_hell");

	private static RegistryObject<SoundEvent> add(String id) {
		return SOUND_EVENTS.register(Cinderscapes.idAsString(id), () -> new SoundEvent(Cinderscapes.id(id)));
	}

	public static void init() {
	}

}

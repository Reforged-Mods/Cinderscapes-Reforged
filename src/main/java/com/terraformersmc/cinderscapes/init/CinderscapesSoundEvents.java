package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public class CinderscapesSoundEvents {

	// Acts as a kind of local registry for sound events added by Cinderscapes
	public static final Map<Identifier, SoundEvent> SOUND_EVENTS = new LinkedHashMap<>();

	public static final SoundEvent ASHY_SHOALS_MUSIC = add("music.nether.ashy_shoals");
	public static final SoundEvent BLACKSTONE_SHALES_MUSIC = add("music.nether.blackstone_shales");
	public static final SoundEvent LUMINOUS_GROVE_MUSIC = add("music.nether.luminous_grove");
	public static final SoundEvent QUARTZ_CANYON_MUSIC = add("music.nether.quartz_canyon");
	
	public static final SoundEvent MENU_MUSIC = add("music.menu");

	public static final SoundEvent MUSIC_DISC_LUMINOUS_PLANTATION = add("music_disc.luminous_plantation");
	public static final SoundEvent MUSIC_DISC_CHILLING_IN_HELL = add("music_disc.chilling_in_hell");

	private static SoundEvent add(String id) {
		SoundEvent event = new SoundEvent(Cinderscapes.id(id));
		SOUND_EVENTS.put(Cinderscapes.id(id), event);
		return event;
	}

	public static void init() {
	}

}

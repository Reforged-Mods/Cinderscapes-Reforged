package com.terraformersmc.cinderscapes.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Rarity;

public class CinderscapesMusicDiscItem extends MusicDiscItem {
    public CinderscapesMusicDiscItem(int comparatorOutput, SoundEvent sound) {
        super(comparatorOutput, sound, new Settings().maxCount(1).group(ItemGroup.MISC).rarity(Rarity.RARE));
    }
}

package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraftforge.common.Tags;

public class CinderscapesTags {
    public static final Tag.Identified<Block> ASH_PERMEABLE = BlockTags.register(Cinderscapes.idAsString("ash_permeable"));

    public static void init() {
    }
}

package com.terraformersmc.cinderscapes.mixin;

import net.minecraft.block.Block;
import net.minecraft.world.gen.carver.Carver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(Carver.class)
public interface CarverAccessor {
    @Accessor
    Set<Block> getAlwaysCarvableBlocks();

    @Accessor
    void setAlwaysCarvableBlocks(Set<Block> carvableBlocks);
}

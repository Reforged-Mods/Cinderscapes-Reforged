package com.terraformersmc.cinderscapes.mixin;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.carver.CaveCarver;
import net.minecraft.world.gen.carver.NetherCaveCarver;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mixin(Carver.class)
public interface CarverAccessor {

    @Accessor
    Set<Block> getAlwaysCarvableBlocks();

    @Accessor
    void setAlwaysCarvableBlocks(Set<Block> carvableBlocks);
}

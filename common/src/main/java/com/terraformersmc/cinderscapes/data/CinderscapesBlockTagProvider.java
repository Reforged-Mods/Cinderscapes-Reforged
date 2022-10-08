package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;

import static com.terraformersmc.cinderscapes.data.CinderscapesDatagen.RUNTIME_RESOURCE_PACK;

public class CinderscapesBlockTagProvider{

	public static void init(){
		RUNTIME_RESOURCE_PACK.addTag(BlockTags.ENDERMAN_HOLDABLE.id(), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_FUNGUS.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_NYLIUM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.FLOWER_POTS.id(), JTag.tag()
				.add(CinderscapesBlocks.POTTED_CRYSTINIUM.getRegistryName())
				.add(CinderscapesBlocks.POTTED_LUMINOUS_POD.getRegistryName())
				.add(CinderscapesBlocks.POTTED_PHOTOFERN.getRegistryName())
				.add(CinderscapesBlocks.POTTED_POLYPITE_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.POTTED_PYRACINTH.getRegistryName())
				.add(CinderscapesBlocks.POTTED_SCORCHED_SHRUB.getRegistryName())
				.add(CinderscapesBlocks.POTTED_SCORCHED_TENDRILS.getRegistryName())
				.add(CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS.getRegistryName())
				.add(CinderscapesBlocks.POTTED_UMBRAL_FUNGUS.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.LOGS.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_STEM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.NON_FLAMMABLE_WOOD.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_BUTTON.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_DOOR.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_FENCE.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_FENCE_GATE.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_PLANKS.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_SIGN.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_TRAPDOOR.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_WALL_SIGN.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_BUTTON.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_DOOR.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_FENCE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_FENCE_GATE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_PLANKS.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_SIGN.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_SLAB.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_STEM.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_TRAPDOOR.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_WALL_SIGN.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.NYLIUM.id(), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_NYLIUM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.PLANKS.id(), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_PLANKS.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_PLANKS.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.SLABS.id(), JTag.tag()
				.add(CinderscapesBlocks.ROSE_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_SLAB.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.SMALL_FLOWERS.id(), JTag.tag()
				.add(CinderscapesBlocks.CRYSTINIUM.getRegistryName())
				.add(CinderscapesBlocks.PYRACINTH.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_TENDRILS.getRegistryName())
				.add(CinderscapesBlocks.TWILIGHT_TENDRILS.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.STAIRS.id(), JTag.tag()
				.add(CinderscapesBlocks.ROSE_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.STANDING_SIGNS.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_SIGN.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_SIGN.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.STANDING_SIGNS.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_WALL_SIGN.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_WALL_SIGN.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.WART_BLOCKS.id(), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_WART_BLOCK.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.WOODEN_BUTTONS.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_BUTTON.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_BUTTON.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.WOODEN_DOORS.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_DOOR.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_DOOR.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.WOODEN_FENCES.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_FENCE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_FENCE.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.WOODEN_PRESSURE_PLATES.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.WOODEN_SLABS.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_SLAB.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_SLAB.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.WOODEN_STAIRS.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_STAIRS.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.WOODEN_TRAPDOORS.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_TRAPDOOR.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_TRAPDOOR.getRegistryName()));


		// tool block tags
		RUNTIME_RESOURCE_PACK.addTag(BlockTags.AXE_MINEABLE.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.getRegistryName())
				.add(CinderscapesBlocks.TWILIGHT_VINE_BLOCK.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_FUNGUS.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_STEM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.HOE_MINEABLE.id(), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_FLESH_BLOCK.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_WART_BLOCK.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.PICKAXE_MINEABLE.id(), JTag.tag()
				.add(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK.getRegistryName())
				.add(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.getRegistryName())
				.add(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK.getRegistryName())
				.add(CinderscapesBlocks.CRYSTALLINE_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.NODZOL.getRegistryName())
				.add(CinderscapesBlocks.ROSE_QUARTZ_BLOCK.getRegistryName())
				.add(CinderscapesBlocks.ROSE_QUARTZ_BRICKS.getRegistryName())
				.add(CinderscapesBlocks.ROSE_QUARTZ_ORE.getRegistryName())
				.add(CinderscapesBlocks.ROSE_QUARTZ_PILLAR.getRegistryName())
				.add(CinderscapesBlocks.ROSE_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.ROSE_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_ORE.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_ORE.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_ORE.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_NYLIUM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(BlockTags.SHOVEL_MINEABLE.id(), JTag.tag()
				.add(CinderscapesBlocks.ASH.getRegistryName())
				.add(CinderscapesBlocks.ASH_BLOCK.getRegistryName()));


		// local block tags
		RUNTIME_RESOURCE_PACK.addTag(CinderscapesBlockTags.ASH_PERMEABLE.id(), JTag.tag()
				.tag(BlockTags.NYLIUM.id())
				.add(CinderscapesBlocks.ASH.getRegistryName())
				.add(CinderscapesBlocks.ASH_BLOCK.getRegistryName())
				.add(Blocks.BASALT.getRegistryName())
				.add(Blocks.BEDROCK.getRegistryName())
				.add(Blocks.BLACKSTONE.getRegistryName())
				.add(Blocks.GLOWSTONE.getRegistryName())
				.add(Blocks.GRAVEL.getRegistryName())
				.add(Blocks.LAVA.getRegistryName())
				.add(Blocks.NETHERRACK.getRegistryName())
				.add(Blocks.SOUL_SAND.getRegistryName())
				.add(Blocks.SOUL_SOIL.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesBlockTags.SCORCHED_STEMS.id(), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesBlockTags.UMBRAL_STEMS.id(), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.getRegistryName()));
	}
}

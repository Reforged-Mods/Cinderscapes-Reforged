package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.tag.CinderscapesBlockTags;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;

import static com.terraformersmc.cinderscapes.data.CinderscapesDatagen.RUNTIME_RESOURCE_PACK;

public class CinderscapesBlockTagProvider{

	public static void init(){
		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.ENDERMAN_HOLDABLE), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_FUNGUS.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_NYLIUM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.FLOWER_POTS), JTag.tag()
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

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.LOGS), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_STEM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.NON_FLAMMABLE_WOOD), JTag.tag()
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

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.NYLIUM), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_NYLIUM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.PLANKS), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_PLANKS.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_PLANKS.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.SLABS), JTag.tag()
				.add(CinderscapesBlocks.ROSE_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_SLAB.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.SMALL_FLOWERS), JTag.tag()
				.add(CinderscapesBlocks.CRYSTINIUM.getRegistryName())
				.add(CinderscapesBlocks.PYRACINTH.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_TENDRILS.getRegistryName())
				.add(CinderscapesBlocks.TWILIGHT_TENDRILS.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.STAIRS), JTag.tag()
				.add(CinderscapesBlocks.ROSE_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.STANDING_SIGNS), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_SIGN.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_SIGN.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.STANDING_SIGNS), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_WALL_SIGN.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_WALL_SIGN.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.WART_BLOCKS), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_WART_BLOCK.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.WOODEN_BUTTONS), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_BUTTON.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_BUTTON.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.WOODEN_DOORS), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_DOOR.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_DOOR.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.WOODEN_FENCES), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_FENCE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_FENCE.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.WOODEN_PRESSURE_PLATES), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.WOODEN_SLABS), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_SLAB.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_SLAB.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.WOODEN_STAIRS), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_STAIRS.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_STAIRS.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.WOODEN_TRAPDOORS), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_TRAPDOOR.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_TRAPDOOR.getRegistryName()));


		// tool block tags
		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.AXE_MINEABLE), JTag.tag()
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

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.HOE_MINEABLE), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_FLESH_BLOCK.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_WART_BLOCK.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.PICKAXE_MINEABLE), JTag.tag()
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

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(BlockTags.SHOVEL_MINEABLE), JTag.tag()
				.add(CinderscapesBlocks.ASH.getRegistryName())
				.add(CinderscapesBlocks.ASH_BLOCK.getRegistryName()));


		// local block tags
		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(CinderscapesBlockTags.ASH_PERMEABLE), JTag.tag()
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

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(CinderscapesBlockTags.SCORCHED_STEMS), JTag.tag()
				.add(CinderscapesBlocks.SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.SCORCHED_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_SCORCHED_STEM.getRegistryName()));

		RUNTIME_RESOURCE_PACK.addTag(CinderscapesDatagen.tagID(CinderscapesBlockTags.UMBRAL_STEMS), JTag.tag()
				.add(CinderscapesBlocks.UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.UMBRAL_STEM.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE.getRegistryName())
				.add(CinderscapesBlocks.STRIPPED_UMBRAL_STEM.getRegistryName()));
	}
}

package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.tag.BiomeTags;

import static com.terraformersmc.cinderscapes.data.CinderscapesDatagen.RUNTIME_RESOURCE_PACK;

public class CinderscapesBiomeTagProvider {

	public static void init() {
		// biome categories
		RUNTIME_RESOURCE_PACK.addTag(BiomeTags.IS_NETHER.id(), JTag.tag()
				.add(CinderscapesBiomes.ASHY_SHOALS.getValue())
				.add(CinderscapesBiomes.LUMINOUS_GROVE.getValue())
				.add(CinderscapesBiomes.BLACKSTONE_SHALES.getValue())
				.add(CinderscapesBiomes.QUARTZ_CAVERN.getValue()));

		/*this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), ConventionalBiomeTags.NETHER_FORESTS.id()))
				.add(CinderscapesBiomes.LUMINOUS_GROVE);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), ConventionalBiomeTags.WASTELAND.id()))
				.add(CinderscapesBiomes.ASHY_SHOALS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), ConventionalBiomeTags.VEGETATION_SPARSE.id()))
				.add(CinderscapesBiomes.BLACKSTONE_SHALES);*/


		// biome structure generation tags
		RUNTIME_RESOURCE_PACK.addTag(BiomeTags.BASTION_REMNANT_HAS_STRUCTURE.id(), JTag.tag()
				.add(CinderscapesBiomes.ASHY_SHOALS.getValue())
				.add(CinderscapesBiomes.LUMINOUS_GROVE.getValue()));
		RUNTIME_RESOURCE_PACK.addTag(BiomeTags.NETHER_FOSSIL_HAS_STRUCTURE.id(), JTag.tag().add(CinderscapesBiomes.ASHY_SHOALS.getValue()));
	}
}

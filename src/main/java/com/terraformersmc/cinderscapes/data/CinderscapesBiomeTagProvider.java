package com.terraformersmc.cinderscapes.data;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BiomeTagProvider;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagKey;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CinderscapesBiomeTagProvider extends BiomeTagProvider {

	protected CinderscapesBiomeTagProvider(DataGenerator arg, ExistingFileHelper helper) {
		super(arg, Cinderscapes.NAMESPACE, helper);
	}

	@Override
	protected void configure() {
		// biome categories
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.IS_NETHER.id()))
				.add(CinderscapesBiomes.ASHY_SHOALS)
				.add(CinderscapesBiomes.BLACKSTONE_SHALES)
				.add(CinderscapesBiomes.LUMINOUS_GROVE)
				.add(CinderscapesBiomes.QUARTZ_CAVERN);

		/*this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), ConventionalBiomeTags.NETHER_FORESTS.id()))
				.add(CinderscapesBiomes.LUMINOUS_GROVE);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), ConventionalBiomeTags.WASTELAND.id()))
				.add(CinderscapesBiomes.ASHY_SHOALS);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), ConventionalBiomeTags.VEGETATION_SPARSE.id()))
				.add(CinderscapesBiomes.BLACKSTONE_SHALES);*/


		// biome structure generation tags
		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.BASTION_REMNANT_HAS_STRUCTURE.id()))
				.add(CinderscapesBiomes.ASHY_SHOALS)
				.add(CinderscapesBiomes.LUMINOUS_GROVE);

		this.getOrCreateTagBuilder(TagKey.of(this.registry.getKey(), BiomeTags.NETHER_FOSSIL_HAS_STRUCTURE.id()))
				.add(CinderscapesBiomes.ASHY_SHOALS);
	}
}

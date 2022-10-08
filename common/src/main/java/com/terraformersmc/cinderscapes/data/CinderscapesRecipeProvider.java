package com.terraformersmc.cinderscapes.data;

import com.google.common.collect.ImmutableMap;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import com.terraformersmc.cinderscapes.tag.CinderscapesItemTags;
import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JKeys;
import net.devtech.arrp.json.recipe.JPattern;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;
import java.util.List;

import static com.terraformersmc.cinderscapes.data.CinderscapesDatagen.RUNTIME_RESOURCE_PACK;

public class CinderscapesRecipeProvider {
	public static void init() {
		// vanilla recipes
		createShapedRecipe(ImmutableMap.of("T", Items.REDSTONE_TORCH, "Q", CinderscapesItemTags.QUARTZ, "S", Tags.Items.STONE), Items.COMPARATOR, null, " T ", "TQT", "SSS");
		createShapedRecipe(ImmutableMap.of("G", Tags.Items.GLASS_COLORLESS, "Q", CinderscapesItemTags.QUARTZ, "W", ItemTags.WOODEN_SLABS), Items.DAYLIGHT_DETECTOR, null, "GGG", "QQQ", "WWW");
		createShapedRecipe(ImmutableMap.of("C", Tags.Items.COBBLESTONE, "Q", CinderscapesItemTags.QUARTZ, "R", Items.REDSTONE), Items.OBSERVER, null, "CCC", "RRQ", "CCC");


		// misc. recipes
		createShapedRecipe(ImmutableMap.of("A", CinderscapesBlocks.ASH_BLOCK), CinderscapesBlocks.ASH, 6, null, "ash", "AAA");
		createShapedRecipe(ImmutableMap.of("a", CinderscapesItems.ASH_PILE), CinderscapesBlocks.ASH_BLOCK, null, "aa", "aa");
		offerShapelessRecipe(Items.GUNPOWDER, null, 1, CinderscapesItemTags.SULFURS, ItemTags.COALS, Items.BONE_MEAL);


		// quartz recipes
		offerChiseledBlockRecipe(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_SLAB);
		offerStonecuttingRecipe(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
		offerSmelting(List.of(CinderscapesBlocks.ROSE_QUARTZ_ORE), CinderscapesItems.ROSE_QUARTZ, 0.2f, 200, "misc");
		createShapedRecipe(ImmutableMap.of("q", CinderscapesItems.ROSE_QUARTZ), CinderscapesBlocks.ROSE_QUARTZ_BLOCK, null, "qq", "qq");
		offerPolishedStoneRecipe(CinderscapesBlocks.ROSE_QUARTZ_BRICKS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
		offerStonecuttingRecipe(CinderscapesBlocks.ROSE_QUARTZ_BRICKS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
		offerBlasting(List.of(CinderscapesBlocks.ROSE_QUARTZ_ORE), CinderscapesItems.ROSE_QUARTZ, 0.2f, 100, "misc");
		createShapedRecipe(ImmutableMap.of("Q", CinderscapesBlocks.ROSE_QUARTZ_BLOCK), CinderscapesBlocks.ROSE_QUARTZ_PILLAR, 2, null, "rose_quartz_pillar", "Q", "Q");
		offerStonecuttingRecipe(CinderscapesBlocks.ROSE_QUARTZ_PILLAR, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
		createSlabRecipe(CinderscapesBlocks.ROSE_QUARTZ_SLAB, List.of(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_PILLAR));
		offerStonecuttingRecipe(CinderscapesBlocks.ROSE_QUARTZ_SLAB, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, 2);
		createStairsRecipe(CinderscapesBlocks.ROSE_QUARTZ_STAIRS, List.of(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_BLOCK, CinderscapesBlocks.ROSE_QUARTZ_PILLAR));
		offerStonecuttingRecipe(CinderscapesBlocks.ROSE_QUARTZ_STAIRS, CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
		offerSmelting(List.of(CinderscapesBlocks.ROSE_QUARTZ_BLOCK), CinderscapesBlocks.SMOOTH_ROSE_QUARTZ, 0.1f, 200, "building_blocks");
		createSlabRecipe(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
		offerStonecuttingRecipe(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ, 2);
		createStairsRecipe(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
		offerStonecuttingRecipe(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);

		offerChiseledBlockRecipe(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_SLAB);
		offerStonecuttingRecipe(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
		offerSmelting(List.of(CinderscapesBlocks.SMOKY_QUARTZ_ORE), CinderscapesItems.SMOKY_QUARTZ, 0.2f, 200, "misc");
		createShapedRecipe(ImmutableMap.of("q", CinderscapesItems.SMOKY_QUARTZ), CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, null, "qq", "qq");
		offerPolishedStoneRecipe(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
		offerStonecuttingRecipe(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
		offerBlasting(List.of(CinderscapesBlocks.SMOKY_QUARTZ_ORE), CinderscapesItems.SMOKY_QUARTZ, 0.2f, 100, "misc");
		createShapedRecipe(ImmutableMap.of("Q", CinderscapesBlocks.SMOKY_QUARTZ_BLOCK), CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, 2, null, "smoky_quartz_pillar", "Q", "Q");
		offerStonecuttingRecipe(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
		createSlabRecipe(CinderscapesBlocks.SMOKY_QUARTZ_SLAB, List.of(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR));
		offerStonecuttingRecipe(CinderscapesBlocks.SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, 2);
		createStairsRecipe(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS, List.of(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK, CinderscapesBlocks.SMOKY_QUARTZ_PILLAR));
		offerStonecuttingRecipe(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS, CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
		offerSmelting(List.of(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK), CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ, 0.1f, 200, "building_blocks");
		createSlabRecipe(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
		offerStonecuttingRecipe(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ, 2);
		createStairsRecipe(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
		offerStonecuttingRecipe(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);

		offerChiseledBlockRecipe(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_SLAB);
		offerStonecuttingRecipe(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
		offerSmelting(List.of(CinderscapesBlocks.SULFUR_QUARTZ_ORE), CinderscapesItems.SULFUR_QUARTZ, 0.2f, 200, "misc");
		createShapedRecipe(ImmutableMap.of("q", CinderscapesItems.SULFUR_QUARTZ), CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, null, "qq", "qq");
		offerPolishedStoneRecipe(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
		offerStonecuttingRecipe(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
		offerBlasting(List.of(CinderscapesBlocks.SULFUR_QUARTZ_ORE), CinderscapesItems.SULFUR_QUARTZ, 0.2f, 100, "misc");
		createShapedRecipe(ImmutableMap.of("Q", CinderscapesBlocks.SULFUR_QUARTZ_BLOCK), CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, 2, null, "sulfur_quartz_pillar", "Q", "Q");
		offerStonecuttingRecipe(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
		createSlabRecipe(CinderscapesBlocks.SULFUR_QUARTZ_SLAB, List.of(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR));
		offerStonecuttingRecipe(CinderscapesBlocks.SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, 2);
		createStairsRecipe(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS, List.of(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK, CinderscapesBlocks.SULFUR_QUARTZ_PILLAR));
		offerStonecuttingRecipe(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS, CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
		offerSmelting(List.of(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK), CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ, 0.1f, 200, "building_blocks");
		createSlabRecipe(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
		offerStonecuttingRecipe(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ, 2);
		createStairsRecipe(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
		offerStonecuttingRecipe(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS, CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);


		// wood recipes
		offerSingleOutputShapelessRecipe(CinderscapesBlocks.SCORCHED_BUTTON, CinderscapesBlocks.SCORCHED_PLANKS, "redstone");
		createDoorRecipe(CinderscapesBlocks.SCORCHED_DOOR, CinderscapesBlocks.SCORCHED_PLANKS);
		createFenceRecipe(CinderscapesBlocks.SCORCHED_FENCE, CinderscapesBlocks.SCORCHED_PLANKS);
		createFenceGateRecipe(CinderscapesBlocks.SCORCHED_FENCE_GATE, CinderscapesBlocks.SCORCHED_PLANKS);
		createShapedRecipe(ImmutableMap.of("L", CinderscapesBlocks.SCORCHED_STEM), CinderscapesBlocks.SCORCHED_HYPHAE, 3, "bark", "scorched_hyphae", "LL", "LL");
		offerPlanksRecipe(CinderscapesBlocks.SCORCHED_PLANKS, CinderscapesItemTags.SCORCHED_STEMS);
		createPressurePlateRecipe(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE, CinderscapesBlocks.SCORCHED_PLANKS);
		createSignRecipe(CinderscapesItems.SCORCHED_SIGN, CinderscapesBlocks.SCORCHED_PLANKS);
		createSlabRecipe(CinderscapesBlocks.SCORCHED_SLAB, CinderscapesBlocks.SCORCHED_PLANKS);
		createStairsRecipe(CinderscapesBlocks.SCORCHED_STAIRS, CinderscapesBlocks.SCORCHED_PLANKS);
		createTrapdoorRecipe(CinderscapesBlocks.SCORCHED_TRAPDOOR, CinderscapesBlocks.SCORCHED_PLANKS);
		createShapedRecipe(ImmutableMap.of("L", CinderscapesBlocks.STRIPPED_SCORCHED_STEM), CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE, 3, "bark", "stripped_scorched_hyphae", "LL", "LL");

		offerSingleOutputShapelessRecipe(CinderscapesBlocks.UMBRAL_BUTTON, CinderscapesBlocks.UMBRAL_PLANKS, "redstone");
		createDoorRecipe(CinderscapesBlocks.UMBRAL_DOOR, CinderscapesBlocks.UMBRAL_PLANKS);
		createFenceRecipe(CinderscapesBlocks.UMBRAL_FENCE, CinderscapesBlocks.UMBRAL_PLANKS);
		createFenceGateRecipe(CinderscapesBlocks.UMBRAL_FENCE_GATE, CinderscapesBlocks.UMBRAL_PLANKS);
		createShapedRecipe(ImmutableMap.of("L", CinderscapesBlocks.UMBRAL_STEM), CinderscapesBlocks.UMBRAL_HYPHAE, 3, "bark", "umbral_hyphae", "LL", "LL");
		offerPlanksRecipe(CinderscapesBlocks.UMBRAL_PLANKS, CinderscapesItemTags.UMBRAL_STEMS);
		createPressurePlateRecipe(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE, CinderscapesBlocks.UMBRAL_PLANKS);
		createSignRecipe(CinderscapesItems.UMBRAL_SIGN, CinderscapesBlocks.UMBRAL_PLANKS);
		createSlabRecipe(CinderscapesBlocks.UMBRAL_SLAB, CinderscapesBlocks.UMBRAL_PLANKS);
		createStairsRecipe(CinderscapesBlocks.UMBRAL_STAIRS, CinderscapesBlocks.UMBRAL_PLANKS);
		createTrapdoorRecipe(CinderscapesBlocks.UMBRAL_TRAPDOOR, CinderscapesBlocks.UMBRAL_PLANKS);
		createShapedRecipe(ImmutableMap.of("L", CinderscapesBlocks.STRIPPED_UMBRAL_STEM), CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE, 3, "bark", "stripped_umbral_hyphae", "LL", "LL");
	}

	private static void createShapedRecipe(ImmutableMap<String, Object> keys, ItemConvertible output, int amount, @Nullable String group, String id, String... pattern){
		JKeys keys1 = JKeys.keys();
		keys.forEach((s, o) -> {
			if (o instanceof ItemConvertible itemConvertible){
				keys1.key(s, JIngredient.ingredient().item(itemConvertible.asItem()));
			} else if (o instanceof TagKey<?> tagKey){
				keys1.key(s, JIngredient.ingredient().tag(tagKey.id().toString()));
			} else if (o instanceof JIngredient ingredient){
				keys1.key(s, ingredient);
			}
		});
		JRecipe recipe = JRecipe.shaped(JPattern.pattern(pattern), keys1, JResult.itemStack(output.asItem(), amount));
		if (group != null) recipe.group(group);
		RUNTIME_RESOURCE_PACK.addRecipe(new Identifier("cinderscapes", id), recipe);
	}

	private static void createShapedRecipe(ImmutableMap<String, Object> keys, ItemConvertible output, @Nullable String group, String... pattern){
		createShapedRecipe(keys, output, 1, group, output.asItem().getRegistryName().getPath(), pattern);
	}

	protected static void createDoorRecipe(ItemConvertible output, ItemConvertible input) {
		createShapedRecipe(ImmutableMap.of("I", input), output, 3, null, output.asItem().getRegistryName().getPath(), "II", "II", "II");
	}

	protected static void createFenceRecipe(ItemConvertible output, ItemConvertible input) {
		createShapedRecipe(ImmutableMap.of("W", input, "S", Items.STICK), output, 3, null, output.asItem().getRegistryName().getPath(), "WSW", "WSW");
	}

	protected static void createFenceGateRecipe(ItemConvertible output, ItemConvertible input) {
		createShapedRecipe(ImmutableMap.of("W", input, "S", Items.STICK), output, 3, null, output.asItem().getRegistryName().getPath(), "SWS", "SWS");
	}

	private static void offerSmelting(List<ItemConvertible> inputs, ItemConvertible output, float experience, int cookingTime, String group){
		if (inputs.size() > 0) {
			JIngredient ingredient = JIngredient.ingredient();
			inputs.forEach(i -> ingredient.item(i.asItem()));
			RUNTIME_RESOURCE_PACK.addRecipe(new Identifier("cinderscapes", output.asItem().getRegistryName().getPath() + "_from_smelting_" + inputs.get(0).asItem().getRegistryName().getPath()), JRecipe.smelting(ingredient, JResult.item(output.asItem())).experience(experience).cookingTime(cookingTime).group(group));
		}
	}

	private static void offerBlasting(List<ItemConvertible> inputs, ItemConvertible output, float experience, int cookingTime, String group){
		if (inputs.size() > 0) {
			JIngredient ingredient = JIngredient.ingredient();
			inputs.forEach(i -> ingredient.item(i.asItem()));
			RUNTIME_RESOURCE_PACK.addRecipe(new Identifier("cinderscapes", output.asItem().getRegistryName().getPath() + "_from_blasting_" + inputs.get(0).asItem().getRegistryName().getPath()), JRecipe.blasting(ingredient, JResult.item(output.asItem())).experience(experience).cookingTime(cookingTime).group(group));
		}
	}

	private static void offerStonecuttingRecipe(ItemConvertible output, ItemConvertible input, int count){
		RUNTIME_RESOURCE_PACK.addRecipe(new Identifier("cinderscapes", output.asItem().getRegistryName().getPath() + "_from_" + input.asItem().getRegistryName().getPath() + "_stonecutting"), JRecipe.stonecutting(JIngredient.ingredient().item(input.asItem()), JResult.itemStack(output.asItem(), count)));
	}

	private static void offerStonecuttingRecipe(ItemConvertible output, ItemConvertible input){
		offerStonecuttingRecipe(output, input, 1);
	}

	protected static void offerSingleOutputShapelessRecipe(ItemConvertible output, ItemConvertible input, @Nullable String group) {
		offerShapelessRecipe(output, input, group, 1);
	}

	protected static void offerShapelessRecipe(ItemConvertible output, ItemConvertible input, @Nullable String group, int outputCount) {
		offerShapelessRecipe(output, group, outputCount, input);
	}

	protected static void offerShapelessRecipe(ItemConvertible output, @Nullable String group, int outputCount, Object... input) {
		JIngredients ingredients = JIngredients.ingredients();
		for (Object object : input) {
			if (object instanceof TagKey<?> tagKey){
				ingredients.add(JIngredient.ingredient().tag(tagKey.id().toString()));
			} else if (object instanceof ItemConvertible itemConvertible){
				ingredients.add(JIngredient.ingredient().item(itemConvertible.asItem()));
			}
		}
		JRecipe recipe = JRecipe.shapeless(ingredients, JResult.itemStack(output.asItem(), outputCount));
		if (group != null) recipe.group(group);
		RUNTIME_RESOURCE_PACK.addRecipe(output.asItem().getRegistryName(), recipe);
	}

	protected static void offerPlanksRecipe(ItemConvertible output, TagKey<Item> input) {
		offerShapelessRecipe(output, "planks", 4, input);
	}

	protected static void createPressurePlateRecipe(ItemConvertible output, ItemConvertible input) {
		createShapedRecipe(ImmutableMap.of("W", input), output, null, "WW");
	}

	protected static void createSlabRecipe(ItemConvertible output, List<ItemConvertible> input) {
		JIngredient ingredient = JIngredient.ingredient();
		input.forEach(i -> ingredient.item(i.asItem()));
		createShapedRecipe(ImmutableMap.of("X", ingredient), output, 6, null, output.asItem().getRegistryName().getPath(), "XXX");
	}

	protected static void createStairsRecipe(ItemConvertible output, List<ItemConvertible> input) {
		JIngredient ingredient = JIngredient.ingredient();
		input.forEach(i -> ingredient.item(i.asItem()));
		createShapedRecipe(ImmutableMap.of("X", ingredient), output, 4, null, output.asItem().getRegistryName().getPath(), "X  ", "XX ", "XXX");
	}

	protected static void createSlabRecipe(ItemConvertible output, ItemConvertible input) {
		createSlabRecipe(output, List.of(input));
	}

	protected static void createStairsRecipe(ItemConvertible output, ItemConvertible input) {
		createStairsRecipe(output, List.of(input));
	}

	protected static void createTrapdoorRecipe(ItemConvertible output, ItemConvertible input) {
		createShapedRecipe(ImmutableMap.of("X", input), output, 2, null, output.asItem().getRegistryName().getPath(), "XXX", "XXX");
	}

	protected static void createSignRecipe(ItemConvertible output, ItemConvertible input) {
		createShapedRecipe(ImmutableMap.of("W", input, "S", Items.STICK), output, 3, "sign", output.asItem().getRegistryName().getPath(), "WWW", "WWW", " S ");
	}

	public static void offerPolishedStoneRecipe(ItemConvertible output, ItemConvertible input) {
		createShapedRecipe(ImmutableMap.of("S", input), output, 4, null, output.asItem().getRegistryName().getPath(), "SS", "SS");
	}

	public static void offerChiseledBlockRecipe(ItemConvertible output, ItemConvertible input) {
		createShapedRecipe(ImmutableMap.of("X", input), output, null, "X", "X");
	}
}

package com.terraformersmc.cinderscapes.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.cinderscapes.init.CinderscapesItems;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JLootTable;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

import static com.terraformersmc.cinderscapes.data.CinderscapesDatagen.RUNTIME_RESOURCE_PACK;
import static net.devtech.arrp.json.loot.JLootTable.condition;
import static net.devtech.arrp.json.loot.JLootTable.entry;
import static net.devtech.arrp.json.loot.JLootTable.function;
import static net.devtech.arrp.json.loot.JLootTable.pool;

public class CinderscapesBlockLootTableProvider {

	public static void init() {
		// simple blocks
		addDrop(CinderscapesBlocks.ASH_BLOCK);
		addDrop(CinderscapesBlocks.CHISELED_ROSE_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.CHISELED_SULFUR_QUARTZ_BLOCK);
		addOreDrop(CinderscapesBlocks.CRYSTALLINE_QUARTZ, Items.QUARTZ);
		addOreDrop(CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ, CinderscapesItems.ROSE_QUARTZ);
		addOreDrop(CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ, CinderscapesItems.SMOKY_QUARTZ);
		addOreDrop(CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ, CinderscapesItems.SULFUR_QUARTZ);
		addDrop(CinderscapesBlocks.CRYSTINIUM);
		addShearDrop(CinderscapesBlocks.GHASTLY_ECTOPLASM);
		addShearDrop(CinderscapesBlocks.PHOTOFERN);
		addOreDrop(CinderscapesBlocks.POLYPITE_QUARTZ, Items.QUARTZ);
		addOreDrop(CinderscapesBlocks.POLYPITE_ROSE_QUARTZ, CinderscapesItems.ROSE_QUARTZ);
		addOreDrop(CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ, CinderscapesItems.SMOKY_QUARTZ);
		addOreDrop(CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ, CinderscapesItems.SULFUR_QUARTZ);
		addDrop(CinderscapesBlocks.PYRACINTH);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_BRICKS);
		addOreDrop(CinderscapesBlocks.ROSE_QUARTZ_ORE, CinderscapesItems.ROSE_QUARTZ);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_PILLAR);
		addSlabDrop(CinderscapesBlocks.ROSE_QUARTZ_SLAB);
		addDrop(CinderscapesBlocks.ROSE_QUARTZ_STAIRS);
		addShearDrop(CinderscapesBlocks.SCORCHED_SHRUB);
		addShearDrop(CinderscapesBlocks.SCORCHED_SPROUTS);
		addShearDrop(CinderscapesBlocks.SCORCHED_TENDRILS);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_BRICKS);
		addOreDrop(CinderscapesBlocks.SMOKY_QUARTZ_ORE, CinderscapesItems.SMOKY_QUARTZ);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_PILLAR);
		addSlabDrop(CinderscapesBlocks.SMOKY_QUARTZ_SLAB);
		addDrop(CinderscapesBlocks.SMOKY_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ);
		addSlabDrop(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_SLAB);
		addDrop(CinderscapesBlocks.SMOOTH_ROSE_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ);
		addSlabDrop(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_SLAB);
		addDrop(CinderscapesBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ);
		addSlabDrop(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_SLAB);
		addDrop(CinderscapesBlocks.SMOOTH_SULFUR_QUARTZ_STAIRS);
		addDrop(CinderscapesBlocks.SULFUR_BLOCK);
		addOreDrop(CinderscapesBlocks.SULFUR_ORE, CinderscapesItems.SULFUR);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_BLOCK);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_BRICKS);
		addOreDrop(CinderscapesBlocks.SULFUR_QUARTZ_ORE, CinderscapesItems.SULFUR_QUARTZ);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_PILLAR);
		addSlabDrop(CinderscapesBlocks.SULFUR_QUARTZ_SLAB);
		addDrop(CinderscapesBlocks.SULFUR_QUARTZ_STAIRS);
		addShearDrop(CinderscapesBlocks.TWILIGHT_FESCUES);
		addShearDrop(CinderscapesBlocks.TWILIGHT_TENDRILS);
		addDrop(CinderscapesBlocks.TWILIGHT_VINE_BLOCK);
		addDrop(CinderscapesBlocks.UMBRAL_FLESH_BLOCK);
		addDropWithSilkTouch(CinderscapesBlocks.UMBRAL_NYLIUM, Blocks.NETHERRACK);
		addDrop(CinderscapesBlocks.UMBRAL_WART_BLOCK);


		// wood building blocks
		// TODO: Consider bringing over the WoodBlocks interface from Terrestria
		addDrop(CinderscapesBlocks.SCORCHED_BUTTON);
		addDoorDrop(CinderscapesBlocks.SCORCHED_DOOR);
		addDrop(CinderscapesBlocks.SCORCHED_FENCE);
		addDrop(CinderscapesBlocks.SCORCHED_FENCE_GATE);
		addDrop(CinderscapesBlocks.SCORCHED_HYPHAE);
		addDrop(CinderscapesBlocks.SCORCHED_PLANKS);
		addDrop(CinderscapesBlocks.SCORCHED_PRESSURE_PLATE);
		addDrop(CinderscapesBlocks.SCORCHED_SIGN);
		addSlabDrop(CinderscapesBlocks.SCORCHED_SLAB);
		addDrop(CinderscapesBlocks.SCORCHED_STAIRS);
		addDrop(CinderscapesBlocks.SCORCHED_STEM);
		addDrop(CinderscapesBlocks.SCORCHED_TRAPDOOR);
		addDrop(CinderscapesBlocks.SCORCHED_WALL_SIGN);
		addDrop(CinderscapesBlocks.STRIPPED_SCORCHED_STEM);
		addDrop(CinderscapesBlocks.STRIPPED_SCORCHED_HYPHAE);

		addDrop(CinderscapesBlocks.UMBRAL_BUTTON);
		addDoorDrop(CinderscapesBlocks.UMBRAL_DOOR);
		addDrop(CinderscapesBlocks.UMBRAL_FENCE);
		addDrop(CinderscapesBlocks.UMBRAL_FENCE_GATE);
		addDrop(CinderscapesBlocks.UMBRAL_FUNGUS);
		addDrop(CinderscapesBlocks.UMBRAL_HYPHAE);
		addDrop(CinderscapesBlocks.UMBRAL_PLANKS);
		addDrop(CinderscapesBlocks.UMBRAL_PRESSURE_PLATE);
		addDrop(CinderscapesBlocks.UMBRAL_SIGN);
		addSlabDrop(CinderscapesBlocks.UMBRAL_SLAB);
		addDrop(CinderscapesBlocks.UMBRAL_STAIRS);
		addDrop(CinderscapesBlocks.UMBRAL_STEM);
		addDrop(CinderscapesBlocks.UMBRAL_TRAPDOOR);
		addDrop(CinderscapesBlocks.UMBRAL_WALL_SIGN);
		addDrop(CinderscapesBlocks.STRIPPED_UMBRAL_STEM);
		addDrop(CinderscapesBlocks.STRIPPED_UMBRAL_HYPHAE);


		// potted things
		addPottedPlantDrop(CinderscapesBlocks.POTTED_CRYSTINIUM);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_LUMINOUS_POD);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_PHOTOFERN);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_POLYPITE_QUARTZ);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_PYRACINTH);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_SCORCHED_SHRUB);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_SCORCHED_TENDRILS);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS);
		addPottedPlantDrop(CinderscapesBlocks.POTTED_UMBRAL_FUNGUS);


		// tall plant drops
		addTallPlantDrop(CinderscapesBlocks.LUMINOUS_POD, CinderscapesBlocks.LUMINOUS_POD);
		addTallPlantDrop(CinderscapesBlocks.TALL_PHOTOFERN, CinderscapesBlocks.PHOTOFERN);


		Identifier blockID = CinderscapesBlocks.BRAMBLE_BERRY_BUSH.getRegistryName();
		JsonObject age = new JsonObject();
		age.addProperty("age", 3);
		JsonObject count = new JsonObject();
		count.addProperty("type", "minecraft:uniform");
		count.addProperty("min", 2);
		count.addProperty("max", 3);
		JsonObject bonusMultiplier = new JsonObject();
		bonusMultiplier.addProperty("bonusMultiplier", 1);
		JsonObject age2 = new JsonObject();
		age2.addProperty("age", 2);
		JsonObject count2 = new JsonObject();
		count2.addProperty("type", "minecraft:uniform");
		count2.addProperty("min", 1);
		count2.addProperty("max", 2);
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.name("cinderscapes:bramble_berries"))
						.condition(new JCondition().condition("minecraft:block_state_property")
								.parameter("block", blockID)
								.parameter("properties", age))
						.function(function("minecraft:set_count")
								.parameter("count", count)
								.parameter("add", false))
						.function(function("minecraft:apply_bonus")
								.parameter("enchantment", "minecraft:fortune")
								.parameter("formula", "minecraft:uniform_bonus_count")
								.parameter("parameters", bonusMultiplier))
						.function(function("minecraft:explosion_decay")))
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.name("cinderscapes:bramble_berries"))
						.condition(new JCondition().condition("minecraft:block_state_property")
								.parameter("block", blockID)
								.parameter("properties", age2))
						.function(function("minecraft:set_count")
								.parameter("count", count2)
								.parameter("add", false))
						.function(function("minecraft:apply_bonus")
								.parameter("enchantment", "minecraft:fortune")
								.parameter("formula", "minecraft:uniform_bonus_count")
								.parameter("parameters", bonusMultiplier))
						.function(function("minecraft:explosion_decay")))
		);

		/*// berry drops
		addDrop(CinderscapesBlocks.BRAMBLE_BERRY_BUSH, block -> BlockLootTableGenerator.applyExplosionDecay(block, LootTable.builder()
			.pool(
				LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(CinderscapesBlocks.BRAMBLE_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BrambleBerryBushBlock.AGE, 3)))
					.with(ItemEntry.builder(CinderscapesItems.BRAMBLE_BERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 3.0f)))
					.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
			)
			.pool(
				LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(CinderscapesBlocks.BRAMBLE_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BrambleBerryBushBlock.AGE, 2)))
					.with(ItemEntry.builder(CinderscapesItems.BRAMBLE_BERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
					.apply(ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE))
			)
		));


		// multi-layer drops
		addDrop(CinderscapesBlocks.ASH, block -> LootTable.builder().pool(LootPool.builder().conditionally(
			EntityPropertiesLootCondition
				.create(LootContext.EntityTarget.THIS)).with(AlternativeEntry.builder(AlternativeEntry.builder(
                    ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 1))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 2)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 3)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 4)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 5)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(5))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 6)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6))),
                	ItemEntry.builder(CinderscapesItems.ASH_PILE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 7)))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7))),
	                ItemEntry.builder(CinderscapesItems.ASH_PILE).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(8)))
				)
				.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))).invert()),
                	AlternativeEntry.builder(
                        ItemEntry.builder(CinderscapesBlocks.ASH).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 1))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 2))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 3))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 4))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(5))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 5))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(6))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 6))),
                        ItemEntry.builder(CinderscapesBlocks.ASH).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(7))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(AshLayerBlock.LAYERS, 7))),
                        ItemEntry.builder(CinderscapesBlocks.ASH_BLOCK)
                	)
        		))
		));*/
	}

	private static void addDrop(Block block){
		Identifier blockID = block.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.name(blockID.toString()))
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	private static void addSlabDrop(Block slab) {
		Identifier blockID = slab.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.function(function("minecraft:set_count")
										.condition(condition("minecraft:block_state_property")
												.parameter("block", blockID.toString())
												.parameter("properties", blockStringProperty("type", "double")))
										.parameter("count", 2))
								.function("minecraft:explosion_decay")
								.name(blockID.toString()))
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	private static void addDoorDrop(Block door) {
		Identifier blockID = door.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.condition(condition("minecraft:block_state_property")
										.parameter("block", blockID.toString())
										.parameter("properties", blockStringProperty("half", "lower")))
								.name(blockID.toString()))
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	public static void addOreDrop(Block block, Item item){
		Identifier blockID = block.getRegistryName();
		Identifier itemID = item.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.bonus(0)
						.entry(entry()
								.type("minecraft:alternatives")
								.child(entry()
										.type("minecraft:item")
										.condition(condition("minecraft:match_tool")
												.parameter("predicate", silkTouchPredicate()))
										.name(blockID.toString()))
								.child(entry()
										.type("minecraft:item")
										.function(function("minecraft:apply_bonus")
												.parameter("enchantment", "minecraft:fortune")
												.parameter("formula", "minecraft:ore_drops"))
										.function(function("minecraft:explosion_decay"))
										.name(itemID.toString())
								)
						)
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	public static void addDropWithSilkTouch(Block silk, Block nonSilk){
		Identifier silkID = silk.getRegistryName();
		Identifier nonSilkID = nonSilk.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(silkID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.bonus(0)
						.entry(entry()
								.type("minecraft:alternatives")
								.child(entry()
										.type("minecraft:item")
										.condition(condition("minecraft:match_tool")
												.parameter("predicate", silkTouchPredicate()))
										.name(silkID.toString()))
								.child(entry()
										.type("minecraft:item")
										.function(function("minecraft:set_count")
												.parameter("count", 1))
										.function(function("minecraft:explosion_decay"))
										.name(nonSilkID.toString())
								)
						)
						.condition(condition("minecraft:survives_explosion")))
		);
	}

	private static void addShearDrop(Block block) {
		Identifier blockID = block.getRegistryName();
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.name(blockID.toString()))
						.condition(condition("minecraft:match_tool")
								.parameter("predicate", shearsPredicate())))
		);
	}

	private static void addTallPlantDrop(Block block, Block drop) {
		RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(block.getRegistryName()), JLootTable.loot("minecraft:block")
				.pool(pool()
						.rolls(1)
						.entry(entry()
								.type("minecraft:item")
								.name(drop.getRegistryName().toString()))
						.condition(condition("minecraft:match_tool")
								.parameter("predicate", shearsPredicate()))
						.function(function("minecraft:set_count").parameter("count", 2).parameter("add", false)))
		);
	}

	private static void addPottedPlantDrop(Block block){
		if (block instanceof FlowerPotBlock flowerPot){
			Identifier blockID = block.getRegistryName();
			RUNTIME_RESOURCE_PACK.addLootTable(blockTableID(blockID), JLootTable.loot("minecraft:block")
					.pool(pool()
							.rolls(1)
							.entry(entry()
									.type("minecraft:item")
									.name("minecraft:flower_pot"))
							.condition(condition("minecraft:survives_explosion")))
					.pool(pool()
							.rolls(1)
							.entry(entry()
									.type("minecraft:item")
									.name(flowerPot.getContent().getRegistryName().toString()))
							.condition(condition("minecraft:survives_explosion")))
			);
		}

	}

	private static JsonObject blockStringProperty(String name, String value) {
		var property = new JsonObject();
		property.addProperty(name, value);

		return property;
	}

	private static JsonObject silkTouchPredicate() {
		var level = new JsonObject();
		level.addProperty("min", 1);

		var silkTouch = new JsonObject();
		silkTouch.addProperty("enchantment", "minecraft:silk_touch");
		silkTouch.add("levels", level);

		JsonArray enchantments = new JsonArray();
		enchantments.add(silkTouch);

		var predicate = new JsonObject();
		predicate.add("enchantments", enchantments);

		return predicate;
	}

	private static JsonObject shearsPredicate() {
		JsonArray items = new JsonArray();
		items.add("minecraft:shears");
		var predicate = new JsonObject();
		predicate.add("items", items);
		return predicate;
	}

	private static void addDrops(ArrayList<Block> blocks) {
		for (var block : blocks) {
			addDrop(block);
		}
	}

	private static Identifier blockTableID(Identifier blockID) {
		return new Identifier(blockID.getNamespace(), "blocks/" + blockID.getPath());
	}
}

package com.terraformersmc.cinderscapes.init;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.block.AshLayerBlock;
import com.terraformersmc.cinderscapes.block.BrambleBerryBushBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesCanopiedFungusBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNetherPlantBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNetherTallPlantBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesNyliumBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesOreBlock;
import com.terraformersmc.cinderscapes.block.CinderscapesTransparentBlock;
import com.terraformersmc.cinderscapes.block.CrystiniumBlock;
import com.terraformersmc.cinderscapes.block.GhastlyEctoplasmBlock;
import com.terraformersmc.cinderscapes.block.PhotofernBlock;
import com.terraformersmc.cinderscapes.block.PolypiteQuartzBlock;
import com.terraformersmc.cinderscapes.block.PottedCrystiniumBlock;
import com.terraformersmc.cinderscapes.block.PottedPyracinthBlock;
import com.terraformersmc.cinderscapes.block.PyracinthBlock;
import com.terraformersmc.cinderscapes.config.CinderscapesConfig;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.utils.TerraformBlockSettings;
import com.terraformersmc.terraform.wood.block.StrippableLogBlock;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WoodenButtonBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CinderscapesBlocks {

    // Acts as a kind of local registry for block items added by Cinderscapes
    public static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    // Acts as a kind of local registry for blocks added by Cinderscapes
    public static final List<Block> BLOCKS = new ArrayList<>();

    /////////////////
    // Ashy Shoals //
    /////////////////

    public static final Block STRIPPED_SCORCHED_STEM = withItem("stripped_scorched_stem", new PillarBlock(TerraformBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_STEM = withItem("scorched_stem", new StrippableLogBlock(() -> STRIPPED_SCORCHED_STEM, MapColor.CLEAR, TerraformBlockSettings.copyOf(Blocks.WARPED_STEM).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);

    public static final Block STRIPPED_SCORCHED_HYPHAE = withItem("stripped_scorched_hyphae", new PillarBlock(TerraformBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_HYPHAE = withItem("scorched_hyphae", new StrippableLogBlock(() -> STRIPPED_SCORCHED_HYPHAE, MapColor.CLEAR, TerraformBlockSettings.copyOf(Blocks.WARPED_HYPHAE).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);

    public static final Block SCORCHED_PLANKS = withItem("scorched_planks", new Block(TerraformBlockSettings.copyOf(Blocks.WARPED_PLANKS).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_SLAB = withItem("scorched_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_SLAB).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_PRESSURE_PLATE = withItem("scorched_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, TerraformBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_FENCE = withItem("scorched_fence", new FenceBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_FENCE).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.DECORATIONS);
    public static final Block SCORCHED_TRAPDOOR = withItem("scorched_trapdoor", new TrapdoorBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_FENCE_GATE = withItem("scorched_fence_gate", new FenceGateBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_STAIRS = withItem("scorched_stairs", new StairsBlock(SCORCHED_PLANKS.getDefaultState(), TerraformBlockSettings.copyOf(Blocks.WARPED_STAIRS).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SCORCHED_BUTTON = withItem("scorched_button", new WoodenButtonBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_BUTTON).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_DOOR = withItem("scorched_door", new DoorBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_DOOR).mapColor(MapColor.LIGHT_GRAY)), ItemGroup.REDSTONE);
    public static final Block SCORCHED_SIGN = add("scorched_sign", new TerraformSignBlock(Cinderscapes.id("entity/signs/scorched"), TerraformBlockSettings.copyOf(Blocks.WARPED_SIGN).mapColor(MapColor.LIGHT_GRAY)));
    public static final Block SCORCHED_WALL_SIGN = add("scorched_wall_sign", new TerraformWallSignBlock(Cinderscapes.id("entity/signs/scorched"), TerraformBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).mapColor(MapColor.LIGHT_GRAY).dropsLike(SCORCHED_SIGN)));
    public static final Item SCORCHED_SIGN_ITEM = CinderscapesItems.add("scorched_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), SCORCHED_SIGN, SCORCHED_WALL_SIGN));

    public static final Block SCORCHED_SHRUB = withItem("scorched_shrub", new CinderscapesNetherPlantBlock(Settings.copy(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 14.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_SCORCHED_SHRUB = add("potted_scorched_shrub", new FlowerPotBlock(SCORCHED_SHRUB, Settings.copy(Blocks.POTTED_DEAD_BUSH)));

    public static final Block SCORCHED_SPROUTS = withItem("scorched_sprouts", new CinderscapesNetherPlantBlock(Settings.copy(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block SCORCHED_TENDRILS = withItem("scorched_tendrils", new CinderscapesNetherPlantBlock(Settings.copy(Blocks.DEAD_BUSH), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_SCORCHED_TENDRILS = add("potted_scorched_tendrils", new FlowerPotBlock(SCORCHED_TENDRILS, Settings.copy(Blocks.POTTED_WARPED_ROOTS)));

    public static final Block ASH = withItem("ash", new AshLayerBlock(TerraformBlockSettings.copyOf(Blocks.SNOW)), ItemGroup.DECORATIONS);
    public static final Block ASH_BLOCK = withItem("ash_block", new Block(TerraformBlockSettings.copyOf(Blocks.SNOW_BLOCK)), ItemGroup.DECORATIONS);

    public static final Block PYRACINTH = withItem("pyracinth", new PyracinthBlock(), ItemGroup.DECORATIONS);
    public static final Block POTTED_PYRACINTH = add("potted_pyracinth", new PottedPyracinthBlock());

    ////////////////////
    // Luminous Grove //
    ////////////////////

    // Umbral Nylia

    public static final Block STRIPPED_UMBRAL_STEM = withItem("stripped_umbral_stem", new PillarBlock(TerraformBlockSettings.copyOf(Blocks.STRIPPED_WARPED_STEM).mapColor(MapColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_STEM = withItem("umbral_stem", new StrippableLogBlock(() -> STRIPPED_UMBRAL_STEM, MapColor.CLEAR, TerraformBlockSettings.copyOf(Blocks.WARPED_STEM).mapColor(MapColor.BLUE)), ItemGroup.BUILDING_BLOCKS);

    public static final Block STRIPPED_UMBRAL_HYPHAE = withItem("stripped_umbral_hyphae", new PillarBlock(TerraformBlockSettings.copyOf(Blocks.STRIPPED_WARPED_HYPHAE).mapColor(MapColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_HYPHAE = withItem("umbral_hyphae", new StrippableLogBlock(() -> STRIPPED_UMBRAL_HYPHAE, MapColor.CLEAR, TerraformBlockSettings.copyOf(Blocks.WARPED_HYPHAE).mapColor(MapColor.BLUE)), ItemGroup.BUILDING_BLOCKS);

    public static final Block UMBRAL_NYLIUM = withItem("umbral_nylium", new CinderscapesNyliumBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_NYLIUM).mapColor(MapColor.BLUE)), ItemGroup.BUILDING_BLOCKS);

    // No, that lambda cannot be replaced with a method reference.
    public static final Block UMBRAL_FUNGUS = withItem("umbral_fungus", new CinderscapesCanopiedFungusBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_FUNGUS).mapColor(MapColor.BLUE).luminance(15), () -> CinderscapesConfiguredFeatures.CANOPIED_HUGE_FUNGUS_PLANTED.value()), ItemGroup.DECORATIONS);
    public static final Block POTTED_UMBRAL_FUNGUS = add("potted_umbral_fungus", new FlowerPotBlock(UMBRAL_FUNGUS, TerraformBlockSettings.copyOf(Blocks.POTTED_WARPED_FUNGUS)));

    public static final Block UMBRAL_WART_BLOCK = withItem("umbral_wart_block", new CinderscapesTransparentBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.BLUE).nonOpaque()), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_FLESH_BLOCK = withItem("umbral_flesh_block", new CinderscapesTransparentBlock(TerraformBlockSettings.copyOf(UMBRAL_WART_BLOCK).luminance(15)), ItemGroup.BUILDING_BLOCKS);

    public static final Block UMBRAL_PLANKS = withItem("umbral_planks", new Block(TerraformBlockSettings.copyOf(Blocks.WARPED_PLANKS).mapColor(MapColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_SLAB = withItem("umbral_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_SLAB).mapColor(MapColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_PRESSURE_PLATE = withItem("umbral_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, TerraformBlockSettings.copyOf(Blocks.WARPED_PRESSURE_PLATE).mapColor(MapColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_FENCE = withItem("umbral_fence", new FenceBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_FENCE).mapColor(MapColor.BLUE)), ItemGroup.DECORATIONS);
    public static final Block UMBRAL_TRAPDOOR = withItem("umbral_trapdoor", new TrapdoorBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_TRAPDOOR).mapColor(MapColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_FENCE_GATE = withItem("umbral_fence_gate", new FenceGateBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_FENCE_GATE).mapColor(MapColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_STAIRS = withItem("umbral_stairs", new StairsBlock(UMBRAL_PLANKS.getDefaultState(), TerraformBlockSettings.copyOf(Blocks.WARPED_STAIRS).mapColor(MapColor.BLUE)), ItemGroup.BUILDING_BLOCKS);
    public static final Block UMBRAL_BUTTON = withItem("umbral_button", new WoodenButtonBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_BUTTON).mapColor(MapColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_DOOR = withItem("umbral_door", new DoorBlock(TerraformBlockSettings.copyOf(Blocks.WARPED_DOOR).mapColor(MapColor.BLUE)), ItemGroup.REDSTONE);
    public static final Block UMBRAL_SIGN = add("umbral_sign", new TerraformSignBlock(Cinderscapes.id("entity/signs/umbral"), TerraformBlockSettings.copyOf(Blocks.WARPED_SIGN).mapColor(MapColor.BLUE)));
    public static final Block UMBRAL_WALL_SIGN = add("umbral_wall_sign", new TerraformWallSignBlock(Cinderscapes.id("entity/signs/umbral"), TerraformBlockSettings.copyOf(Blocks.WARPED_WALL_SIGN).mapColor(MapColor.BLUE).dropsLike(UMBRAL_SIGN)));
    public static final Item UMBRAL_SIGN_ITEM = CinderscapesItems.add("umbral_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), UMBRAL_SIGN, UMBRAL_WALL_SIGN));

    // Other

    public static final Block TWILIGHT_VINE_BLOCK = withItem("twilight_vine_block", new Block(TerraformBlockSettings.of(Material.SOLID_ORGANIC).strength(1.0F).sounds(BlockSoundGroup.NETHER_STEM)), ItemGroup.DECORATIONS);
    public static final Block TWILIGHT_TENDRILS = withItem("twilight_tendrils", new CinderscapesNetherPlantBlock(TerraformBlockSettings.copy(Blocks.WARPED_ROOTS).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_TWILIGHT_TENDRILS = add("potted_twilight_tendrils", new FlowerPotBlock(TWILIGHT_TENDRILS, TerraformBlockSettings.copyOf(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
    public static final Block TWILIGHT_FESCUES = withItem("twilight_fescues", new CinderscapesNetherPlantBlock(TerraformBlockSettings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 5.0, 14.0)), ItemGroup.DECORATIONS);

    public static Block PHOTOFERN = withItem("photofern", new PhotofernBlock(), ItemGroup.DECORATIONS);
    public static final Block POTTED_PHOTOFERN = add("potted_photofern", new FlowerPotBlock(PHOTOFERN, Settings.copy(Blocks.POTTED_FERN)));

    public static final Block TALL_PHOTOFERN = withItem("tall_photofern", new CinderscapesNetherTallPlantBlock(Settings.copy(Blocks.WARPED_ROOTS), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);

    public static final Block LUMINOUS_POD = withItem("luminous_pod", new CinderscapesNetherTallPlantBlock(Settings.copy(Blocks.WARPED_ROOTS).luminance((state) -> 15), (state) -> Block.createCuboidShape(2.0, 0, 2.0, 14.0, 16.0, 14.0)), ItemGroup.DECORATIONS);
    public static final Block POTTED_LUMINOUS_POD = add("potted_luminous_pod", new FlowerPotBlock(LUMINOUS_POD, Settings.copy(Blocks.POTTED_WARPED_ROOTS).luminance((state) -> 15)));
    public static final Block GHASTLY_ECTOPLASM = withItem("ghastly_ectoplasm", new GhastlyEctoplasmBlock(Settings.of(Material.ORGANIC_PRODUCT).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS)), ItemGroup.DECORATIONS);

    ///////////
    // Other //
    ///////////

    public static final Block SULFUR_BLOCK = withItem("sulfur_block", new Block(TerraformBlockSettings.of(Material.AGGREGATE).strength(0.5F, 0.5f)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_ORE = addOre("sulfur_ore", ItemGroup.BUILDING_BLOCKS, 2, MapColor.YELLOW);

    public static final Block BRAMBLE_BERRY_BUSH = add("bramble_berry_bush", new BrambleBerryBushBlock(Settings.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final Item BRAMBLE_BERRIES = CinderscapesItems.add("bramble_berries", new AliasedBlockItem(CinderscapesBlocks.BRAMBLE_BERRY_BUSH, new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1F).alwaysEdible().snack().statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 0), 0.8F).build())));

    ///////////////////
    // Quartz Canyon //
    ///////////////////

    public static final Block CRYSTINIUM = withItem("crystinium", new CrystiniumBlock(), ItemGroup.DECORATIONS);
    public static final Block POTTED_CRYSTINIUM = add("potted_crystinium", new PottedCrystiniumBlock());

    public static final Block CRYSTALLINE_QUARTZ = withItem("crystalline_quartz", new CinderscapesTransparentBlock(Settings.copy(Blocks.QUARTZ_BLOCK).sounds(BlockSoundGroup.GLASS).nonOpaque().allowsSpawning(CinderscapesBlocks::never).solidBlock(CinderscapesBlocks::never).suffocates(CinderscapesBlocks::never).blockVision(CinderscapesBlocks::never)), ItemGroup.BUILDING_BLOCKS);
    public static final Block POLYPITE_QUARTZ = withItem("polypite_quartz", new PolypiteQuartzBlock(Settings.copy(CRYSTALLINE_QUARTZ)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_QUARTZ = add("potted_polypite_quartz", new FlowerPotBlock(POLYPITE_QUARTZ, Settings.copy(Blocks.FLOWER_POT)));

    // Sulfur Quartz

    public static final Block POLYPITE_SULFUR_QUARTZ = withItem("polypite_sulfur_quartz", new PolypiteQuartzBlock(TerraformBlockSettings.copyOf(POLYPITE_QUARTZ).mapColor(MapColor.YELLOW)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_SULFUR_QUARTZ = add("potted_polypite_sulfur_quartz", new FlowerPotBlock(POLYPITE_SULFUR_QUARTZ, TerraformBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block SULFUR_QUARTZ_ORE = addOre("sulfur_quartz_ore", ItemGroup.BUILDING_BLOCKS, 1, MapColor.YELLOW);
    public static final Block SULFUR_QUARTZ_BLOCK = withItem("sulfur_quartz_block", new Block(TerraformBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_SULFUR_QUARTZ_BLOCK = withItem("chiseled_sulfur_quartz_block", new Block(TerraformBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_PILLAR = withItem("sulfur_quartz_pillar", new PillarBlock(TerraformBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_STAIRS = withItem("sulfur_quartz_stairs", new StairsBlock(SULFUR_QUARTZ_BLOCK.getDefaultState(), TerraformBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_SLAB = withItem("sulfur_quartz_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.QUARTZ_SLAB).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ = withItem("smooth_sulfur_quartz", new Block(TerraformBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ_STAIRS = withItem("smooth_sulfur_quartz_stairs", new StairsBlock(SMOOTH_SULFUR_QUARTZ.getDefaultState(), TerraformBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SULFUR_QUARTZ_SLAB = withItem("smooth_sulfur_quartz_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SULFUR_QUARTZ_BRICKS = withItem("sulfur_quartz_bricks", new Block(TerraformBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRYSTALLINE_SULFUR_QUARTZ = withItem("crystalline_sulfur_quartz", new CinderscapesTransparentBlock(TerraformBlockSettings.copyOf(CRYSTALLINE_QUARTZ).mapColor(MapColor.YELLOW)), ItemGroup.BUILDING_BLOCKS);

    // Rose Quartz

    public static final Block POLYPITE_ROSE_QUARTZ = withItem("polypite_rose_quartz", new PolypiteQuartzBlock(TerraformBlockSettings.copyOf(POLYPITE_QUARTZ).mapColor(MapColor.PINK)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_ROSE_QUARTZ = add("potted_polypite_rose_quartz", new FlowerPotBlock(POLYPITE_ROSE_QUARTZ, TerraformBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block ROSE_QUARTZ_ORE = addOre("rose_quartz_ore", ItemGroup.BUILDING_BLOCKS, 1, MapColor.PINK);
    public static final Block ROSE_QUARTZ_BLOCK = withItem("rose_quartz_block", new Block(TerraformBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_ROSE_QUARTZ_BLOCK = withItem("chiseled_rose_quartz_block", new Block(TerraformBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_PILLAR = withItem("rose_quartz_pillar", new PillarBlock(TerraformBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_STAIRS = withItem("rose_quartz_stairs", new StairsBlock(ROSE_QUARTZ_BLOCK.getDefaultState(), TerraformBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_SLAB = withItem("rose_quartz_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.QUARTZ_SLAB).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ = withItem("smooth_rose_quartz", new Block(TerraformBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ_STAIRS = withItem("smooth_rose_quartz_stairs", new StairsBlock(SMOOTH_ROSE_QUARTZ.getDefaultState(), TerraformBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_ROSE_QUARTZ_SLAB = withItem("smooth_rose_quartz_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block ROSE_QUARTZ_BRICKS = withItem("rose_quartz_bricks", new Block(TerraformBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRYSTALLINE_ROSE_QUARTZ = withItem("crystalline_rose_quartz", new CinderscapesTransparentBlock(TerraformBlockSettings.copyOf(CRYSTALLINE_QUARTZ).mapColor(MapColor.PINK)), ItemGroup.BUILDING_BLOCKS);

    // Smoky Quartz

    public static final Block POLYPITE_SMOKY_QUARTZ = withItem("polypite_smoky_quartz", new PolypiteQuartzBlock(TerraformBlockSettings.copyOf(POLYPITE_QUARTZ).mapColor(MapColor.GRAY)), ItemGroup.DECORATIONS);
    public static final Block POTTED_POLYPITE_SMOKY_QUARTZ = add("potted_polypite_smoky_quartz", new FlowerPotBlock(POLYPITE_SMOKY_QUARTZ, TerraformBlockSettings.copyOf(Blocks.FLOWER_POT)));

    public static final Block SMOKY_QUARTZ_ORE = addOre("smoky_quartz_ore", ItemGroup.BUILDING_BLOCKS, 1, MapColor.GRAY);
    public static final Block SMOKY_QUARTZ_BLOCK = withItem("smoky_quartz_block", new Block(TerraformBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CHISELED_SMOKY_QUARTZ_BLOCK = withItem("chiseled_smoky_quartz_block", new Block(TerraformBlockSettings.copyOf(Blocks.QUARTZ_BLOCK).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_PILLAR = withItem("smoky_quartz_pillar", new PillarBlock(TerraformBlockSettings.copyOf(Blocks.QUARTZ_PILLAR).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_STAIRS = withItem("smoky_quartz_stairs", new StairsBlock(SMOKY_QUARTZ_BLOCK.getDefaultState(), TerraformBlockSettings.copyOf(Blocks.QUARTZ_STAIRS).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_SLAB = withItem("smoky_quartz_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.QUARTZ_SLAB).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ = withItem("smooth_smoky_quartz", new Block(TerraformBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ_STAIRS = withItem("smooth_smoky_quartz_stairs", new StairsBlock(SMOOTH_SMOKY_QUARTZ.getDefaultState(), TerraformBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_STAIRS).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOOTH_SMOKY_QUARTZ_SLAB = withItem("smooth_smoky_quartz_slab", new SlabBlock(TerraformBlockSettings.copyOf(Blocks.SMOOTH_QUARTZ_SLAB).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block SMOKY_QUARTZ_BRICKS = withItem("smoky_quartz_bricks", new Block(TerraformBlockSettings.copyOf(Blocks.QUARTZ_BRICKS).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);
    public static final Block CRYSTALLINE_SMOKY_QUARTZ = withItem("crystalline_smoky_quartz", new CinderscapesTransparentBlock(TerraformBlockSettings.copyOf(CRYSTALLINE_QUARTZ).mapColor(MapColor.GRAY)), ItemGroup.BUILDING_BLOCKS);

    public static final Block NODZOL = add("nodzol", new Block(Settings.copy(Blocks.NETHERRACK)));

    private static Block addOre(String name, ItemGroup tab, int miningLevel, MapColor color) {
        CinderscapesOreBlock block = new CinderscapesOreBlock(TerraformBlockSettings.copyOf(Blocks.NETHER_QUARTZ_ORE).mapColor(color).sounds(BlockSoundGroup.NETHER_ORE).requiresTool());
        return withItem(name, block, tab);
    }

    private static <B extends Block> B withItem(String name, B block, ItemGroup tab) {
        B block1 = add(name, block);
        CinderscapesItems.add(name, new BlockItem(block, new Item.Settings().group(tab)));
        return block1;
    }

    private static <B extends Block> B add(String name, B block) {
        ForgeRegistries.BLOCKS.register(Identifier.of(Cinderscapes.NAMESPACE, name), block);
        BLOCKS.add(block);
        return block;
    }

    public static void init() {
        CinderscapesItems.add("nodzol", new BlockItem(CinderscapesBlocks.NODZOL, new Item.Settings()));
        if (!CinderscapesConfig.INSTANCE.easterEggs) {
            Cinderscapes.HIDDEN_ITEMS.add(CinderscapesBlocks.NODZOL.asItem());
        }
    }


    public static void addCompostables() {
        Object2FloatMap<ItemConvertible> compostingRegistry = ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE;
        float BERRY_CHANCE = compostingRegistry.getFloat(Items.SWEET_BERRIES);
        float FLOWER_CHANCE = compostingRegistry.getFloat(Items.POPPY);
        float FUNGUS_CHANCE = compostingRegistry.getFloat(Items.CRIMSON_FUNGUS);
        float GRASS_CHANCE = compostingRegistry.getFloat(Items.GRASS);
        float WART_BLOCK_CHANCE = compostingRegistry.getFloat(Items.NETHER_WART_BLOCK);

        compostingRegistry.put(BRAMBLE_BERRIES, BERRY_CHANCE);

        compostingRegistry.put(SCORCHED_SHRUB, GRASS_CHANCE);
        compostingRegistry.put(SCORCHED_SPROUTS, GRASS_CHANCE);
        compostingRegistry.put(SCORCHED_TENDRILS, GRASS_CHANCE);
        compostingRegistry.put(TWILIGHT_FESCUES, GRASS_CHANCE);
        compostingRegistry.put(TWILIGHT_TENDRILS, GRASS_CHANCE);

        compostingRegistry.put(CRYSTINIUM, FLOWER_CHANCE);
        compostingRegistry.put(GHASTLY_ECTOPLASM, FLOWER_CHANCE);
        compostingRegistry.put(LUMINOUS_POD, FLOWER_CHANCE);
        compostingRegistry.put(PHOTOFERN, FLOWER_CHANCE);
        compostingRegistry.put(PYRACINTH, FLOWER_CHANCE);
        compostingRegistry.put(TALL_PHOTOFERN, FLOWER_CHANCE);
        compostingRegistry.put(UMBRAL_FUNGUS, FUNGUS_CHANCE);

        compostingRegistry.put(TWILIGHT_VINE_BLOCK, WART_BLOCK_CHANCE);
        compostingRegistry.put(UMBRAL_FLESH_BLOCK, WART_BLOCK_CHANCE);
        compostingRegistry.put(UMBRAL_WART_BLOCK, WART_BLOCK_CHANCE);
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockView blockView, BlockPos pos, EntityType<?> entityType) {
        return false;
    }
}

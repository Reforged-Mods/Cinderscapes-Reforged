package com.terraformersmc.cinderscapes.client;

import com.terraformersmc.cinderscapes.Cinderscapes;
import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")
public class CinderscapesClient {

    public CinderscapesClient(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addSigns);
        MinecraftForge.EVENT_BUS.addListener(this::onTooltipEvent);
    }

    public void addSigns(TextureStitchEvent.Pre event) {
        if (event.getAtlas().getId().equals(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE)){
            event.addSprite(Cinderscapes.id("entity/signs/umbral"));
            TexturedRenderLayers.addWoodType(CinderscapesBlocks.UMBRAL_SIGN_TYPE);
            event.addSprite(Cinderscapes.id("entity/signs/scorched"));
            TexturedRenderLayers.addWoodType(CinderscapesBlocks.SCORCHED_SIGN_TYPE);
        }
    }

    private void clientSetup(FMLClientSetupEvent event) {
        // TODO: Find a more elegant way to add blocks to their render layers
        event.enqueueWork(() -> {
            addArrayToLayer(RenderLayer.getTranslucent(),
                    CinderscapesBlocks.UMBRAL_WART_BLOCK,
                    CinderscapesBlocks.CRYSTALLINE_SULFUR_QUARTZ,
                    CinderscapesBlocks.CRYSTALLINE_QUARTZ,
                    CinderscapesBlocks.CRYSTALLINE_ROSE_QUARTZ,
                    CinderscapesBlocks.CRYSTALLINE_SMOKY_QUARTZ,
                    CinderscapesBlocks.GHASTLY_ECTOPLASM
            );
            addArrayToLayer(RenderLayer.getCutout(),
                    CinderscapesBlocks.PHOTOFERN,
                    CinderscapesBlocks.POTTED_PHOTOFERN,
                    CinderscapesBlocks.TALL_PHOTOFERN,
                    CinderscapesBlocks.LUMINOUS_POD,
                    CinderscapesBlocks.POTTED_LUMINOUS_POD,
                    CinderscapesBlocks.TWILIGHT_FESCUES,
                    CinderscapesBlocks.TWILIGHT_TENDRILS,
                    CinderscapesBlocks.POTTED_TWILIGHT_TENDRILS,
                    CinderscapesBlocks.UMBRAL_FUNGUS,
                    CinderscapesBlocks.POTTED_UMBRAL_FUNGUS,
                    CinderscapesBlocks.SCORCHED_SHRUB,
                    CinderscapesBlocks.POTTED_SCORCHED_SHRUB,
                    CinderscapesBlocks.SCORCHED_SPROUTS,
                    CinderscapesBlocks.BRAMBLE_BERRY_BUSH,
                    CinderscapesBlocks.PYRACINTH,
                    CinderscapesBlocks.POTTED_PYRACINTH,
                    CinderscapesBlocks.CRYSTINIUM,
                    CinderscapesBlocks.POTTED_CRYSTINIUM,
                    CinderscapesBlocks.SCORCHED_TENDRILS,
                    CinderscapesBlocks.POTTED_SCORCHED_TENDRILS,
                    CinderscapesBlocks.UMBRAL_DOOR,
                    CinderscapesBlocks.POLYPITE_ROSE_QUARTZ,
                    CinderscapesBlocks.POTTED_POLYPITE_ROSE_QUARTZ,
                    CinderscapesBlocks.POLYPITE_QUARTZ,
                    CinderscapesBlocks.POTTED_POLYPITE_QUARTZ,
                    CinderscapesBlocks.POLYPITE_SMOKY_QUARTZ,
                    CinderscapesBlocks.POTTED_POLYPITE_SMOKY_QUARTZ,
                    CinderscapesBlocks.POLYPITE_SULFUR_QUARTZ,
                    CinderscapesBlocks.POTTED_POLYPITE_SULFUR_QUARTZ
            );
        });
    }

    private void onTooltipEvent(ItemTooltipEvent event){
        if (event.getItemStack().isOf(CinderscapesBlocks.NODZOL.asItem())) {
            event.getToolTip().add(Text.translatable("block.cinderscapes.nodzol.description").setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
        }
    }

    public static void addArrayToLayer(RenderLayer layer, Block... blocks){
        for (Block block : blocks) {
            RenderLayers.setRenderLayer(block, layer);
        }
    }
}

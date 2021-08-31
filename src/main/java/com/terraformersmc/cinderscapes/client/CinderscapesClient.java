package com.terraformersmc.cinderscapes.client;

import com.terraformersmc.cinderscapes.init.CinderscapesBlocks;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("unused")
@OnlyIn(Dist.CLIENT)
public class CinderscapesClient {

    public static void addSigns(){
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ((TerraformSignBlock) CinderscapesBlocks.UMBRAL_SIGN).getTexture()));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ((TerraformSignBlock) CinderscapesBlocks.SCORCHED_SIGN).getTexture()));
    }

    public static void onInitializeClient(FMLClientSetupEvent event) {
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

    public static void addArrayToLayer(RenderLayer layer, Block... blocks){
        for (Block block : blocks) {
            RenderLayers.setRenderLayer(block, layer);
        }
    }
}

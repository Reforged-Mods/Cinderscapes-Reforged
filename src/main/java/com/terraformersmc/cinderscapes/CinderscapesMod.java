package com.terraformersmc.cinderscapes;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(value = Cinderscapes.NAMESPACE)
public class CinderscapesMod {
    public CinderscapesMod(){
        new Cinderscapes();
        if (FMLEnvironment.dist.isClient()){

        }
    }
}

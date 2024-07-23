package net.wafflebitez.coordinatemod;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.wafflebitez.coordinatemod.client.config.Config;
import net.wafflebitez.coordinatemod.client.gui.ConfigScreen;

@Mod("coordinate_mod")
public class CoordinateMod {

    public CoordinateMod() {
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        ConfigScreen.registerConfigScreen();
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
    
}
package net.wafflebitez.coordinatemod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("coordinate_mod")
public class CoordinateMod {

    public CoordinateMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

}
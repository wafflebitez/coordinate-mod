package net.wafflebitez.coordinatemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.wafflebitez.coordinatemod.client.gui.CoordinateOverlay;

public class CoordinateModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new CoordinateOverlay());
    }
}

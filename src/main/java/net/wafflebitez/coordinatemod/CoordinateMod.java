package net.wafflebitez.coordinatemod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.wafflebitez.coordinatemod.client.gui.CoordinateOverlay;

public class CoordinateMod implements ModInitializer {

	@Override
	public void onInitialize() {
		HudRenderCallback.EVENT.register(new CoordinateOverlay());
	}

}
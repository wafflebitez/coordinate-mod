package net.wafflebitez.coordinatemod.client.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;

@Environment(EnvType.CLIENT)
public class CoordinateOverlay implements HudRenderCallback {

    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        if (player != null) {
            int h = client.getWindow().getScaledHeight();
            int x = (int) Math.floor(player.getX());
            int y = (int) Math.floor(player.getY());
            int z = (int) Math.floor(player.getZ());
            String coordinates = String.format("Position: %d, %d, %d", x, y, z);

            int posY = h / 6;
            int padding = 2;
            // apparently shit's fucked and the shadow adds an extra px on padding
            // this just makes it look nice
            int shadowOffset = 1;
            int offset = 5;
            int textWidth = client.textRenderer.getWidth(coordinates);
            int textHeight = client.textRenderer.fontHeight;

            drawContext.fill(0, posY - padding, offset + textWidth + padding, posY + textHeight + padding - shadowOffset, 0x90000000);
            drawContext.drawTextWithShadow(client.textRenderer, coordinates, offset, posY, 0xFFFFFF);
        }
    }
}

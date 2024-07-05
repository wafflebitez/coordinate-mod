package net.wafflebitez.coordinatemod.client.gui;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber(modid = "coordinate_mod", value = {Dist.CLIENT})
public class CoordinateOverlay {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void onCustomizeGuiOverlay(CustomizeGuiOverlayEvent event) {
        int h = event.getWindow().getGuiScaledHeight();

        Player player = Minecraft.getInstance().player;

        if (player != null) {
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
            int textWidth = Minecraft.getInstance().font.width(coordinates);
            int textHeight = Minecraft.getInstance().font.lineHeight;

            event.getGuiGraphics().fill(
                    0,
                    posY - padding,
                    offset + textWidth + padding,
                    posY + textHeight + padding - shadowOffset,
                    0x90000000
            );
            event.getGuiGraphics().drawString(
                    Minecraft.getInstance().font,
                    coordinates,
                    offset,
                    posY,
                    0xFFFFFF,
                    true
            );
        }
    }
}
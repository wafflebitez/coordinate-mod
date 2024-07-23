package net.wafflebitez.coordinatemod.client.gui;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;
import net.wafflebitez.coordinatemod.client.config.Config;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = "coordinate_mod", value = {Dist.CLIENT})
public class CoordinateOverlay {

    public static final HashMap<String, Integer> COLORS = new HashMap<String, Integer>() {{
        put("white", 0xFFFFFF);
        put("black", 0x000000);
        put("gray", 0x808080);
        put("red", 0xFF0000);
        put("green", 0x00FF00);
        put("blue", 0x0000FF);
        put("yellow", 0xFFFF00);
        put("purple", 0xFF00FF);
        put("cyan", 0x00FFFF);
        put("orange", 0xFFA500);
        put("brown", 0xA52A2A);
        put("lime", 0x32CD32);
        put("pink", 0xFFC0CB);
        put("light_gray", 0xD3D3D3);
        put("light_blue", 0xADD8E6);
        put("light_green", 0x90EE90);
    }};

    public static int fontColorHex;
    
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
            fontColorHex = COLORS.get(Config.FONT_COLOR.get());

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
                    fontColorHex,
                    true
            );
        }
    }
}
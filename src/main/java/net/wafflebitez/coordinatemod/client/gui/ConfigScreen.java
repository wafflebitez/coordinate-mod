package net.wafflebitez.coordinatemod.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.wafflebitez.coordinatemod.client.config.Config;
import net.wafflebitez.coordinatemod.client.gui.CoordinateOverlay;

import java.util.ArrayList;
import java.util.List;

public class ConfigScreen extends Screen {

    private final Screen parent;
    private String selectedColor;

    protected ConfigScreen(Screen parent) {
        super(Component.literal("Coordinate Mod Config"));
        this.parent = parent;
        this.selectedColor = Config.FONT_COLOR.get();
    }

    @Override
    protected void init() {
        super.init();

        addRenderableWidget(CycleButton.builder(value -> Component.literal((String) value))
                .withValues("white", "black", "blue", "brown", "cyan", "gray", "green", "light_blue", "light_gray", "light_green", "lime", "orange", "pink", "purple", "red", "yellow")
                .withInitialValue(selectedColor)
                .create(this.width / 2 - 100, this.height / 6 + 24, 200, 20,
                        Component.literal("Font Color"), (button, value) -> {
                            selectedColor = (String) value;
                            Config.FONT_COLOR.set((String) value);
                            Config.SPEC.save();
                        }));

        addRenderableWidget(new Button.Builder(Component.literal("Done"), button -> {
            assert this.minecraft != null;
            this.minecraft.setScreen(parent);
        }).pos(this.width / 2 - 100, this.height / 6 + 72)
                .size(200, 20)
                .build());
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        guiGraphics.drawCenteredString(this.font, this.title.getString(), this.width / 2, 15, 0xFFFFFF);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }


    public static void registerConfigScreen() {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((mc, screen) -> new ConfigScreen(screen)));
    }
}
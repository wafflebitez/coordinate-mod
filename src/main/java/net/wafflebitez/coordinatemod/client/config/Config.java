package net.wafflebitez.coordinatemod.client.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<String> FONT_COLOR;

    static {
        FONT_COLOR = BUILDER.comment("Font Color for Coordinate Display")
                            .define("fontColor", "white");

        SPEC = BUILDER.build();
    }

    public static final ForgeConfigSpec SPEC;

}
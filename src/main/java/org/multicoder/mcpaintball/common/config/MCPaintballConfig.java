package org.multicoder.mcpaintball.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MCPaintballConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.BooleanValue FRIENDLY_FIRE;
    public static ForgeConfigSpec.BooleanValue EXPLODE_BLOCKS;
    public static ForgeConfigSpec.BooleanValue WINNER_OP_ONLY;

    public static ForgeConfigSpec.DoubleValue PISTOL_INACCURACY;
    public static ForgeConfigSpec.DoubleValue SHOTGUN_INACCURACY;
    public static ForgeConfigSpec.DoubleValue RIFLE_INACCURACY;
    public static ForgeConfigSpec.DoubleValue BAZOOKA_INACCURACY;
    public static ForgeConfigSpec.DoubleValue SNIPER_INACCURACY;

    static {
        BUILDER.push("MCPaintball Team");
        FRIENDLY_FIRE = BUILDER.comment("Enables/Disables Friendly Fire").define("Friendly_fire", false);
        BUILDER.pop();
        BUILDER.push("MCPaintball World");
        EXPLODE_BLOCKS = BUILDER.comment("Enables/Disables Block Breaking By Explosion").define("blocks_explode", true);
        BUILDER.pop();
        BUILDER.push("MCPaintball Weapons");
        PISTOL_INACCURACY = BUILDER.comment("The Inaccuracy Of The Pistol, Lower The Better").defineInRange("pistol_accuracy", 0.5, 0.0, 1.0);
        SHOTGUN_INACCURACY = BUILDER.comment("The Inaccuracy Of The Shotgun, Lower The Better").defineInRange("shotgun_accuracy", 0.5, 0.0, 1.0);
        RIFLE_INACCURACY = BUILDER.comment("The Inaccuracy Of The Rifle, Lower The Better").defineInRange("rifle_accuracy", 1.5, 0.0, 3.0);
        BAZOOKA_INACCURACY = BUILDER.comment("The Inaccuracy Of The Bazooka, Lower The Better").defineInRange("bazooka_accuracy", 2.3, 0.0, 4.0);
        SNIPER_INACCURACY = BUILDER.comment("The Inaccuracy Of The Sniper, Lower The Better").defineInRange("sniper_accuracy", 2.0, 0.0, 4.0);
        BUILDER.pop();
        BUILDER.push("MCPaintball Server Administration");
        WINNER_OP_ONLY = BUILDER.comment("If This Is Set To False Then The Winner Command Is Available To All Players, If True The Command Is OP Only.").define("win_op_only", true);
        BUILDER.pop();
        BUILDER.push("MCPaintball Gameplay");
        SPEC = BUILDER.build();
    }
}

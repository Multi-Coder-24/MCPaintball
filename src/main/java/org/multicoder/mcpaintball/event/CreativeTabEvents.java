package org.multicoder.mcpaintball.event;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class CreativeTabEvents {

    public static void WeaponsInit(FabricCreativeModeTabOutput output) {
        output.accept(MCPaintballItems.PISTOL);
        output.accept(MCPaintballItems.SHOTGUN);
        output.accept(MCPaintballItems.SNIPER_RIFLE);
        output.accept(MCPaintballItems.ASSAULT_RIFLE);
        output.accept(MCPaintballItems.GRENADE_LAUNCHER);
        output.accept(MCPaintballItems.BURST_RIFLE);
        output.accept(MCPaintballItems.RED_PAINT_GRENADE);
        output.accept(MCPaintballItems.GREEN_PAINT_GRENADE);
        output.accept(MCPaintballItems.BLUE_PAINT_GRENADE);
        output.accept(MCPaintballItems.SMOKE_GRENADE);
        output.accept(MCPaintballItems.EMP_GRENADE);
    }

    public static void UtilityInit(FabricCreativeModeTabOutput output) {
        output.accept(MCPaintballItems.RED_BOOTS);
        output.accept(MCPaintballItems.RED_LEGGINGS);
        output.accept(MCPaintballItems.RED_CHESTPLATE);
        output.accept(MCPaintballItems.RED_HELMET);
        output.accept(MCPaintballItems.GREEN_BOOTS);
        output.accept(MCPaintballItems.GREEN_LEGGINGS);
        output.accept(MCPaintballItems.GREEN_CHESTPLATE);
        output.accept(MCPaintballItems.GREEN_HELMET);
        output.accept(MCPaintballItems.BLUE_BOOTS);
        output.accept(MCPaintballItems.BLUE_LEGGINGS);
        output.accept(MCPaintballItems.BLUE_CHESTPLATE);
        output.accept(MCPaintballItems.BLUE_HELMET);
    }
}

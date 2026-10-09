package org.multicoder.mcpaintball.event;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class CreativeTabEvents {

    public static void weaponsInit(FabricCreativeModeTabOutput output) {
        output.accept(MCPaintballItems.PISTOL);
        output.accept(MCPaintballItems.SHOTGUN);
        output.accept(MCPaintballItems.SNIPER_RIFLE);
        output.accept(MCPaintballItems.ASSAULT_RIFLE);
        output.accept(MCPaintballItems.GRENADE_LAUNCHER);
        output.accept(MCPaintballItems.BURST_RIFLE);
        output.accept(MCPaintballItems.RED_PAINT_GRENADE);
        output.accept(MCPaintballItems.GREEN_PAINT_GRENADE);
        output.accept(MCPaintballItems.BLUE_PAINT_GRENADE);
        output.accept(MCPaintballItems.CYAN_PAINT_GRENADE);
        output.accept(MCPaintballItems.MAGENTA_PAINT_GRENADE);
        output.accept(MCPaintballItems.YELLOW_PAINT_GRENADE);
        output.accept(MCPaintballItems.ORANGE_PAINT_GRENADE);
        output.accept(MCPaintballItems.WHITE_PAINT_GRENADE);
        output.accept(MCPaintballItems.BLACK_PAINT_GRENADE);
        output.accept(MCPaintballItems.SMOKE_GRENADE);
        output.accept(MCPaintballItems.EMP_GRENADE);
        output.accept(MCPaintballItems.SIGHT_GRENADE);
        output.accept(MCPaintballBlocks.RED_PAINT_MINE);
        output.accept(MCPaintballBlocks.GREEN_PAINT_MINE);
        output.accept(MCPaintballBlocks.BLUE_PAINT_MINE);
        output.accept(MCPaintballBlocks.CYAN_PAINT_MINE);
        output.accept(MCPaintballBlocks.MAGENTA_PAINT_MINE);
        output.accept(MCPaintballBlocks.YELLOW_PAINT_MINE);
        output.accept(MCPaintballBlocks.ORANGE_PAINT_MINE);
        output.accept(MCPaintballBlocks.WHITE_PAINT_MINE);
        output.accept(MCPaintballBlocks.BLUE_PAINT_MINE);
        output.accept(MCPaintballBlocks.RED_CLAYMORE_BLOCK);
        output.accept(MCPaintballBlocks.GREEN_CLAYMORE_BLOCK);
        output.accept(MCPaintballBlocks.BLUE_CLAYMORE_BLOCK);
        output.accept(MCPaintballBlocks.CYAN_CLAYMORE_BLOCK);
        output.accept(MCPaintballBlocks.MAGENTA_CLAYMORE_BLOCK);
        output.accept(MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK);
        output.accept(MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK);
        output.accept(MCPaintballBlocks.WHITE_CLAYMORE_BLOCK);
        output.accept(MCPaintballBlocks.BLACK_PAINT_MINE);
    }

    public static void utilityInit(FabricCreativeModeTabOutput output) {
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
        output.accept(MCPaintballItems.CYAN_BOOTS);
        output.accept(MCPaintballItems.CYAN_LEGGINGS);
        output.accept(MCPaintballItems.CYAN_CHESTPLATE);
        output.accept(MCPaintballItems.CYAN_HELMET);
        output.accept(MCPaintballItems.MAGENTA_BOOTS);
        output.accept(MCPaintballItems.MAGENTA_LEGGINGS);
        output.accept(MCPaintballItems.MAGENTA_CHESTPLATE);
        output.accept(MCPaintballItems.MAGENTA_HELMET);
        output.accept(MCPaintballItems.YELLOW_BOOTS);
        output.accept(MCPaintballItems.YELLOW_LEGGINGS);
        output.accept(MCPaintballItems.YELLOW_CHESTPLATE);
        output.accept(MCPaintballItems.YELLOW_HELMET);
        output.accept(MCPaintballItems.ORANGE_BOOTS);
        output.accept(MCPaintballItems.ORANGE_LEGGINGS);
        output.accept(MCPaintballItems.ORANGE_CHESTPLATE);
        output.accept(MCPaintballItems.ORANGE_HELMET);
        output.accept(MCPaintballItems.WHITE_BOOTS);
        output.accept(MCPaintballItems.WHITE_LEGGINGS);
        output.accept(MCPaintballItems.WHITE_CHESTPLATE);
        output.accept(MCPaintballItems.WHITE_HELMET);
        output.accept(MCPaintballItems.BLACK_BOOTS);
        output.accept(MCPaintballItems.BLACK_LEGGINGS);
        output.accept(MCPaintballItems.BLACK_CHESTPLATE);
        output.accept(MCPaintballItems.BLACK_HELMET);

        output.accept(MCPaintballBlocks.RED_GRENADE_STATION);
        output.accept(MCPaintballBlocks.GREEN_GRENADE_STATION);
        output.accept(MCPaintballBlocks.BLUE_GRENADE_STATION);
        output.accept(MCPaintballBlocks.CYAN_GRENADE_STATION);
        output.accept(MCPaintballBlocks.MAGENTA_GRENADE_STATION);
        output.accept(MCPaintballBlocks.YELLOW_GRENADE_STATION);
        output.accept(MCPaintballBlocks.ORANGE_GRENADE_STATION);
        output.accept(MCPaintballBlocks.WHITE_GRENADE_STATION);
        output.accept(MCPaintballBlocks.BLACK_GRENADE_STATION);

        output.accept(MCPaintballBlocks.RED_RESPAWN_STATION);
        output.accept(MCPaintballBlocks.GREEN_RESPAWN_STATION);
        output.accept(MCPaintballBlocks.BLUE_RESPAWN_STATION);
        output.accept(MCPaintballBlocks.CYAN_RESPAWN_STATION);
        output.accept(MCPaintballBlocks.MAGENTA_RESPAWN_STATION);
        output.accept(MCPaintballBlocks.YELLOW_RESPAWN_STATION);
        output.accept(MCPaintballBlocks.ORANGE_RESPAWN_STATION);
        output.accept(MCPaintballBlocks.WHITE_RESPAWN_STATION);
        output.accept(MCPaintballBlocks.BLACK_RESPAWN_STATION);

        output.accept(MCPaintballBlocks.RED_FLAG);
        output.accept(MCPaintballBlocks.GREEN_FLAG);
        output.accept(MCPaintballBlocks.BLUE_FLAG);
        output.accept(MCPaintballBlocks.CYAN_FLAG);
        output.accept(MCPaintballBlocks.MAGENTA_FLAG);
        output.accept(MCPaintballBlocks.YELLOW_FLAG);
        output.accept(MCPaintballBlocks.ORANGE_FLAG);
        output.accept(MCPaintballBlocks.WHITE_FLAG);
        output.accept(MCPaintballBlocks.BLACK_FLAG);
        output.accept(MCPaintballBlocks.CAPTURE_POINT);

        output.accept(MCPaintballBlocks.RED_DOOR);
        output.accept(MCPaintballBlocks.GREEN_DOOR);
        output.accept(MCPaintballBlocks.BLUE_DOOR);
        output.accept(MCPaintballBlocks.CYAN_DOOR);
        output.accept(MCPaintballBlocks.MAGENTA_DOOR);
        output.accept(MCPaintballBlocks.YELLOW_DOOR);
        output.accept(MCPaintballBlocks.ORANGE_DOOR);
        output.accept(MCPaintballBlocks.WHITE_DOOR);
        output.accept(MCPaintballBlocks.BLACK_DOOR);

        output.accept(MCPaintballBlocks.RED_TOWER);
        output.accept(MCPaintballBlocks.GREEN_TOWER);
        output.accept(MCPaintballBlocks.BLUE_TOWER);
        output.accept(MCPaintballBlocks.CYAN_TOWER);
        output.accept(MCPaintballBlocks.MAGENTA_TOWER);
        output.accept(MCPaintballBlocks.YELLOW_TOWER);
        output.accept(MCPaintballBlocks.ORANGE_TOWER);
        output.accept(MCPaintballBlocks.WHITE_TOWER);
        output.accept(MCPaintballBlocks.BLACK_TOWER);

    }
}

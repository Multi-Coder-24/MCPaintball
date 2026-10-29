package org.multicoder.mcpaintball.event;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class CreativeTabEvents {

    public static void weaponsInit(FabricCreativeModeTabOutput output) {
        MCPaintballBlocks.WEAPON_BLOCKS.forEach(output::accept);
        MCPaintballItems.WEAPON_ITEMS.forEach(output::accept);
    }

    public static void utilityInit(FabricCreativeModeTabOutput output) {
        MCPaintballBlocks.UTILITY_BLOCKS.forEach(output::accept);
        MCPaintballItems.UTILITY_ITEMS.forEach(output::accept);
    }
}

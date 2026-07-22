package org.multicoder.mcpaintball.core;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.*;

@SuppressWarnings("unused")
public class MCPaintballBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MCPaintball.MODID);
    public static final DeferredBlock<RedGrenadeStation> RED_GRENADE_STATION = BLOCKS.registerBlock("utility/red_grenade_station",RedGrenadeStation::new);
    public static final DeferredBlock<GreenGrenadeStation> GREEN_GRENADE_STATION = BLOCKS.registerBlock("utility/green_grenade_station",GreenGrenadeStation::new);
    public static final DeferredBlock<BlueGrenadeStation> BLUE_GRENADE_STATION = BLOCKS.registerBlock("utility/blue_grenade_station",BlueGrenadeStation::new);

    public static final DeferredItem<BlockItem> RED_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_GRENADE_STATION);
    public static final DeferredItem<BlockItem> GREEN_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_GRENADE_STATION);
    public static final DeferredItem<BlockItem> BLUE_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_GRENADE_STATION);
}

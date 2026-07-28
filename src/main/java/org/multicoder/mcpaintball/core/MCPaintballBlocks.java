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

    public static final DeferredBlock<GrenadeStationBlock> RED_GRENADE_STATION = BLOCKS.registerBlock("utility/red_grenade_station",GrenadeStationBlock::new);
    public static final DeferredBlock<GrenadeStationBlock> GREEN_GRENADE_STATION = BLOCKS.registerBlock("utility/green_grenade_station",GrenadeStationBlock::new);
    public static final DeferredBlock<GrenadeStationBlock> BLUE_GRENADE_STATION = BLOCKS.registerBlock("utility/blue_grenade_station",GrenadeStationBlock::new);
    public static final DeferredBlock<GrenadeStationBlock> YELLOW_GRENADE_STATION = BLOCKS.registerBlock("utility/yellow_grenade_station",GrenadeStationBlock::new);

    public static final DeferredBlock<RespawnStationBlock> RED_RESPAWN_STATION = BLOCKS.registerBlock("utility/red_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> GREEN_RESPAWN_STATION = BLOCKS.registerBlock("utility/green_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> BLUE_RESPAWN_STATION = BLOCKS.registerBlock("utility/blue_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> YELLOW_RESPAWN_STATION = BLOCKS.registerBlock("utility/yellow_respawn_station",RespawnStationBlock::new);


    public static final DeferredItem<BlockItem> RED_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_GRENADE_STATION);
    public static final DeferredItem<BlockItem> GREEN_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_GRENADE_STATION);
    public static final DeferredItem<BlockItem> BLUE_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_GRENADE_STATION);
    public static final DeferredItem<BlockItem> YELLOW_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(YELLOW_GRENADE_STATION);

    public static final DeferredItem<BlockItem> RED_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_RESPAWN_STATION);
    public static final DeferredItem<BlockItem> GREEN_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_RESPAWN_STATION);
    public static final DeferredItem<BlockItem> BLUE_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_RESPAWN_STATION);
    public static final DeferredItem<BlockItem> YELLOW_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(YELLOW_RESPAWN_STATION);

}

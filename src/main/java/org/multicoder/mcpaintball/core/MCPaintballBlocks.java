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
    public static final DeferredBlock<GrenadeStationBlock> PINK_GRENADE_STATION = BLOCKS.registerBlock("utility/pink_grenade_station",GrenadeStationBlock::new);
    public static final DeferredBlock<GrenadeStationBlock> ORANGE_GRENADE_STATION = BLOCKS.registerBlock("utility/orange_grenade_station",GrenadeStationBlock::new);

    public static final DeferredBlock<RespawnStationBlock> RED_RESPAWN_STATION = BLOCKS.registerBlock("utility/red_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> GREEN_RESPAWN_STATION = BLOCKS.registerBlock("utility/green_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> BLUE_RESPAWN_STATION = BLOCKS.registerBlock("utility/blue_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> YELLOW_RESPAWN_STATION = BLOCKS.registerBlock("utility/yellow_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> PINK_RESPAWN_STATION = BLOCKS.registerBlock("utility/pink_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> ORANGE_RESPAWN_STATION = BLOCKS.registerBlock("utility/orange_respawn_station",RespawnStationBlock::new);

    public static final DeferredBlock<PaintMine> RED_PAINT_MINE = BLOCKS.registerBlock("explosives/red_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> GREEN_PAINT_MINE = BLOCKS.registerBlock("explosives/green_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> BLUE_PAINT_MINE = BLOCKS.registerBlock("explosives/blue_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> YELLOW_PAINT_MINE = BLOCKS.registerBlock("explosives/yellow_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> PINK_PAINT_MINE = BLOCKS.registerBlock("explosives/pink_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> ORANGE_PAINT_MINE = BLOCKS.registerBlock("explosives/orange_paint_mine",PaintMine::new);

    public static final DeferredBlock<FlagBlock> RED_FLAG = BLOCKS.registerBlock("objectives/red_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> GREEN_FLAG = BLOCKS.registerBlock("objectives/green_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> BLUE_FLAG = BLOCKS.registerBlock("objectives/blue_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> YELLOW_FLAG = BLOCKS.registerBlock("objectives/yellow_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> PINK_FLAG = BLOCKS.registerBlock("objectives/pink_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> ORANGE_FLAG = BLOCKS.registerBlock("objectives/orange_flag",FlagBlock::new);


    public static final DeferredItem<BlockItem> RED_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_GRENADE_STATION);
    public static final DeferredItem<BlockItem> GREEN_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_GRENADE_STATION);
    public static final DeferredItem<BlockItem> BLUE_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_GRENADE_STATION);
    public static final DeferredItem<BlockItem> YELLOW_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(YELLOW_GRENADE_STATION);
    public static final DeferredItem<BlockItem> PINK_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(PINK_GRENADE_STATION);
    public static final DeferredItem<BlockItem> ORANGE_GRENADE_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(ORANGE_GRENADE_STATION);

    public static final DeferredItem<BlockItem> RED_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_RESPAWN_STATION);
    public static final DeferredItem<BlockItem> GREEN_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_RESPAWN_STATION);
    public static final DeferredItem<BlockItem> BLUE_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_RESPAWN_STATION);
    public static final DeferredItem<BlockItem> YELLOW_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(YELLOW_RESPAWN_STATION);
    public static final DeferredItem<BlockItem> PINK_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(PINK_RESPAWN_STATION);
    public static final DeferredItem<BlockItem> ORANGE_RESPAWN_STATION_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(ORANGE_RESPAWN_STATION);

    public static final DeferredItem<BlockItem> RED_PAINT_MINE_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_PAINT_MINE);
    public static final DeferredItem<BlockItem> GREEN_PAINT_MINE_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_PAINT_MINE);
    public static final DeferredItem<BlockItem> BLUE_PAINT_MINE_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_PAINT_MINE);
    public static final DeferredItem<BlockItem> YELLOW_PAINT_MINE_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(YELLOW_PAINT_MINE);
    public static final DeferredItem<BlockItem> PINK_PAINT_MINE_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(PINK_PAINT_MINE);
    public static final DeferredItem<BlockItem> ORANGE_PAINT_MINE_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(ORANGE_PAINT_MINE);

    public static final DeferredItem<BlockItem> RED_FLAG_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_FLAG);
    public static final DeferredItem<BlockItem> GREEN_FLAG_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_FLAG);
    public static final DeferredItem<BlockItem> BLUE_FLAG_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_FLAG);
    public static final DeferredItem<BlockItem> YELLOW_FLAG_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(YELLOW_FLAG);
    public static final DeferredItem<BlockItem> PINK_FLAG_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(PINK_FLAG);
    public static final DeferredItem<BlockItem> ORANGE_FLAG_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(ORANGE_FLAG);

}

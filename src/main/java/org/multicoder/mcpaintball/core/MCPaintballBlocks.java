package org.multicoder.mcpaintball.core;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.doors.TeamedDoor;
import org.multicoder.mcpaintball.block.explosives.PaintMine;
import org.multicoder.mcpaintball.block.objectives.CapturePointBlock;
import org.multicoder.mcpaintball.block.objectives.FlagBlock;
import org.multicoder.mcpaintball.block.utility.BasicTowerBlock;
import org.multicoder.mcpaintball.block.utility.GrenadeStationBlock;
import org.multicoder.mcpaintball.block.utility.RespawnStationBlock;

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

    public static final DeferredBlock<TeamedDoor> RED_DOOR = BLOCKS.registerBlock("doors/red_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> GREEN_DOOR = BLOCKS.registerBlock("doors/green_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> BLUE_DOOR = BLOCKS.registerBlock("doors/blue_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> YELLOW_DOOR = BLOCKS.registerBlock("doors/yellow_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> PINK_DOOR = BLOCKS.registerBlock("doors/pink_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> ORANGE_DOOR = BLOCKS.registerBlock("doors/orange_door",TeamedDoor::new);

    public static final DeferredBlock<BasicTowerBlock> RED_TOWER = BLOCKS.registerBlock("utility/red_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> GREEN_TOWER = BLOCKS.registerBlock("utility/green_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> BLUE_TOWER = BLOCKS.registerBlock("utility/blue_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> YELLOW_TOWER = BLOCKS.registerBlock("utility/yellow_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> PINK_TOWER = BLOCKS.registerBlock("utility/pink_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> ORANGE_TOWER = BLOCKS.registerBlock("utility/orange_tower",BasicTowerBlock::new);

    public static final DeferredBlock<CapturePointBlock> CAPTURE_POINT = BLOCKS.registerBlock("objectives/capture_point",CapturePointBlock::new);


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

    public static final DeferredItem<BlockItem> RED_DOOR_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_DOOR);
    public static final DeferredItem<BlockItem> GREEN_DOOR_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_DOOR);
    public static final DeferredItem<BlockItem> BLUE_DOOR_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_DOOR);
    public static final DeferredItem<BlockItem> YELLOW_DOOR_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(YELLOW_DOOR);
    public static final DeferredItem<BlockItem> PINK_DOOR_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(PINK_DOOR);
    public static final DeferredItem<BlockItem> ORANGE_DOOR_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(ORANGE_DOOR);

    public static final DeferredItem<BlockItem> RED_TOWER_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_TOWER);
    public static final DeferredItem<BlockItem> GREEN_TOWER_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_TOWER);
    public static final DeferredItem<BlockItem> BLUE_TOWER_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_TOWER);
    public static final DeferredItem<BlockItem> YELLOW_TOWER_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(YELLOW_TOWER);
    public static final DeferredItem<BlockItem> PINK_TOWER_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(PINK_TOWER);
    public static final DeferredItem<BlockItem> ORANGE_TOWER_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(ORANGE_TOWER);

    public static final DeferredItem<BlockItem> CAPTURE_POINT_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(CAPTURE_POINT);

}

package org.multicoder.mcpaintball.core;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.doors.TeamedDoor;
import org.multicoder.mcpaintball.block.explosives.*;
import org.multicoder.mcpaintball.block.objectives.*;
import org.multicoder.mcpaintball.block.utility.*;

import java.util.function.Function;

public class MCPaintballBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MCPaintball.MODID);

    public static final DeferredBlock<GrenadeStationBlock> RED_GRENADE_STATION = registerBlock("utility/red_grenade_station",GrenadeStationBlock::new);
    public static final DeferredBlock<GrenadeStationBlock> GREEN_GRENADE_STATION = registerBlock("utility/green_grenade_station",GrenadeStationBlock::new);
    public static final DeferredBlock<GrenadeStationBlock> BLUE_GRENADE_STATION = registerBlock("utility/blue_grenade_station",GrenadeStationBlock::new);
    public static final DeferredBlock<GrenadeStationBlock> YELLOW_GRENADE_STATION = registerBlock("utility/yellow_grenade_station",GrenadeStationBlock::new);
    public static final DeferredBlock<GrenadeStationBlock> PINK_GRENADE_STATION = registerBlock("utility/pink_grenade_station",GrenadeStationBlock::new);
    public static final DeferredBlock<GrenadeStationBlock> ORANGE_GRENADE_STATION = registerBlock("utility/orange_grenade_station",GrenadeStationBlock::new);

    public static final DeferredBlock<RespawnStationBlock> RED_RESPAWN_STATION = registerBlock("utility/red_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> GREEN_RESPAWN_STATION = registerBlock("utility/green_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> BLUE_RESPAWN_STATION = registerBlock("utility/blue_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> YELLOW_RESPAWN_STATION = registerBlock("utility/yellow_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> PINK_RESPAWN_STATION = registerBlock("utility/pink_respawn_station",RespawnStationBlock::new);
    public static final DeferredBlock<RespawnStationBlock> ORANGE_RESPAWN_STATION = registerBlock("utility/orange_respawn_station",RespawnStationBlock::new);

    public static final DeferredBlock<PaintMine> RED_PAINT_MINE = registerBlock("explosives/red_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> GREEN_PAINT_MINE = registerBlock("explosives/green_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> BLUE_PAINT_MINE = registerBlock("explosives/blue_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> YELLOW_PAINT_MINE = registerBlock("explosives/yellow_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> PINK_PAINT_MINE = registerBlock("explosives/pink_paint_mine",PaintMine::new);
    public static final DeferredBlock<PaintMine> ORANGE_PAINT_MINE = registerBlock("explosives/orange_paint_mine",PaintMine::new);

    public static final DeferredBlock<FlagBlock> RED_FLAG = registerBlock("objectives/red_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> GREEN_FLAG = registerBlock("objectives/green_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> BLUE_FLAG = registerBlock("objectives/blue_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> YELLOW_FLAG = registerBlock("objectives/yellow_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> PINK_FLAG = registerBlock("objectives/pink_flag",FlagBlock::new);
    public static final DeferredBlock<FlagBlock> ORANGE_FLAG = registerBlock("objectives/orange_flag",FlagBlock::new);

    public static final DeferredBlock<TeamedDoor> RED_DOOR = registerBlock("doors/red_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> GREEN_DOOR = registerBlock("doors/green_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> BLUE_DOOR = registerBlock("doors/blue_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> YELLOW_DOOR = registerBlock("doors/yellow_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> PINK_DOOR = registerBlock("doors/pink_door",TeamedDoor::new);
    public static final DeferredBlock<TeamedDoor> ORANGE_DOOR = registerBlock("doors/orange_door",TeamedDoor::new);

    public static final DeferredBlock<BasicTowerBlock> RED_TOWER = registerBlock("utility/red_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> GREEN_TOWER = registerBlock("utility/green_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> BLUE_TOWER = registerBlock("utility/blue_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> YELLOW_TOWER = registerBlock("utility/yellow_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> PINK_TOWER = registerBlock("utility/pink_tower",BasicTowerBlock::new);
    public static final DeferredBlock<BasicTowerBlock> ORANGE_TOWER = registerBlock("utility/orange_tower",BasicTowerBlock::new);

    public static final DeferredBlock<CapturePointBlock> CAPTURE_POINT = registerBlock("objectives/capture_point",CapturePointBlock::new);

    public static final DeferredBlock<ClaymoreBlock> RED_CLAYMORE_BLOCK = registerBlock("explosives/red_claymore_block",ClaymoreBlock::new);
    public static final DeferredBlock<ClaymoreBlock> GREEN_CLAYMORE_BLOCK = registerBlock("explosives/green_claymore_block",ClaymoreBlock::new);
    public static final DeferredBlock<ClaymoreBlock> BLUE_CLAYMORE_BLOCK = registerBlock("explosives/blue_claymore_block",ClaymoreBlock::new);
    public static final DeferredBlock<ClaymoreBlock> YELLOW_CLAYMORE_BLOCK = registerBlock("explosives/yellow_claymore_block",ClaymoreBlock::new);
    public static final DeferredBlock<ClaymoreBlock> PINK_CLAYMORE_BLOCK = registerBlock("explosives/pink_claymore_block",ClaymoreBlock::new);
    public static final DeferredBlock<ClaymoreBlock> ORANGE_CLAYMORE_BLOCK = registerBlock("explosives/orange_claymore_block",ClaymoreBlock::new);


    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties,T> supplier) {
        DeferredBlock<T> Block = BLOCKS.registerBlock(name, supplier);
        MCPaintballItems.ITEMS.registerSimpleBlockItem(Block);
        return Block;
    }

}

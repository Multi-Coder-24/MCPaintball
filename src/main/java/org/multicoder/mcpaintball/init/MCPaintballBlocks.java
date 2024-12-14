package org.multicoder.mcpaintball.init;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.*;
import org.multicoder.mcpaintball.blocks.*;
import java.util.function.Supplier;

import static org.multicoder.mcpaintball.MCPaintball.MOD_ID;
import static org.multicoder.mcpaintball.init.MCPaintballItems.ITEMS;

public class MCPaintballBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    public static final DeferredBlock<Block> RED_C4 = RegisterBlock("explosives/red_c4", PaintballC4ExplosiveBlock::new);
    public static final DeferredBlock<Block> BLUE_C4 = RegisterBlock("explosives/blue_c4",PaintballC4ExplosiveBlock::new);
    public static final DeferredBlock<Block> GREEN_C4 = RegisterBlock("explosives/green_c4",PaintballC4ExplosiveBlock::new);

    public static final DeferredBlock<Block> RED_TEAM_STATION = RegisterBlock("red_team_station", PaintballTeamStationBlock::new);
    public static final DeferredBlock<Block> GREEN_TEAM_STATION = RegisterBlock("green_team_station",PaintballTeamStationBlock::new);
    public static final DeferredBlock<Block> BLUE_TEAM_STATION = RegisterBlock("blue_team_station",PaintballTeamStationBlock::new);

    public static final DeferredBlock<Block> TEAM_FLAG = RegisterBlock("flag/flag_block", FlagBlock::new);

    public static DeferredBlock<Block> RegisterBlock(String name, Supplier<Block> supplier)
    {
        DeferredBlock<Block> Block = BLOCKS.register(name,supplier);
        ITEMS.registerSimpleBlockItem(Block);
        return Block;
    }

}

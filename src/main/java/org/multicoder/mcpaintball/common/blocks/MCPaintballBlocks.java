package org.multicoder.mcpaintball.common.blocks;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

import java.util.function.Supplier;

public class MCPaintballBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MCPaintball.MOD_ID);

    public static final DeferredBlock<Block> RED_C4 = RegisterBlock("red_c4",PaintballC4ExplosiveBlock::new);
    public static final DeferredBlock<Block> BLUE_C4 = RegisterBlock("blue_c4",PaintballC4ExplosiveBlock::new);
    public static final DeferredBlock<Block> GREEN_C4 = RegisterBlock("green_c4",PaintballC4ExplosiveBlock::new);
    public static final DeferredBlock<Block> SOLO_C4 = RegisterBlock("gray_c4",SoloPaintballC4ExplosiveBlock::new);

    public static final DeferredBlock<Block> RED_TEAM_STATION = RegisterBlock("red_team_station",PaintballTeamStationBlock::new);
    public static final DeferredBlock<Block> GREEN_TEAM_STATION = RegisterBlock("green_team_station",PaintballTeamStationBlock::new);
    public static final DeferredBlock<Block> BLUE_TEAM_STATION = RegisterBlock("blue_team_station",PaintballTeamStationBlock::new);
    public static final DeferredBlock<Block> SOLO_TEAM_STATION = RegisterBlock("gray_team_station",SoloPaintballTeamStationBlock::new);

    public static DeferredBlock<Block> RegisterBlock(String name, Supplier<Block> supplier)
    {
        DeferredBlock<Block> Block = BLOCKS.register(name,supplier);
        MCPaintballItems.ITEMS.registerSimpleBlockItem(Block);
        return Block;
    }

}

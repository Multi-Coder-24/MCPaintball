package org.multicoder.mcpaintball.block.blockitem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.multicoder.mcpaintball.init.tabinit;

public class ExplosivesStationBlockItem extends BlockItem
{

    public ExplosivesStationBlockItem(Block pBlock)
    {
        super(pBlock, new Properties().tab(tabinit.Utility));
    }
}

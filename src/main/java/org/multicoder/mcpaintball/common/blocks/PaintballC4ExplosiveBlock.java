package org.multicoder.mcpaintball.common.blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PaintballC4ExplosiveBlock extends Block
{
    public PaintballC4ExplosiveBlock()
    {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
}

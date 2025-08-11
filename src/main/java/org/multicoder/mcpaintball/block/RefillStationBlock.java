package org.multicoder.mcpaintball.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RefillStationBlock extends Block {
    public RefillStationBlock() {
        super(BlockBehaviour.Properties.of().dynamicShape().noOcclusion());
    }
}

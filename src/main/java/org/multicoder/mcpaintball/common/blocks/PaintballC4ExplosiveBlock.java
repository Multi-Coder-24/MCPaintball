package org.multicoder.mcpaintball.common.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("all")
public class PaintballC4ExplosiveBlock extends Block
{
    public VoxelShape makeShape()
    {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.25, 0, 0.25, 0.75, 0.3125, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0.3125, 0.4375, 0.75, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.3125, 0.4375, 0.375, 0.4375, 0.5625), BooleanOp.OR);

        return shape;
    }

    public PaintballC4ExplosiveBlock()
    {
        super(BlockBehaviour.Properties.of().noOcclusion().destroyTime(3f));
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return makeShape();
    }
}

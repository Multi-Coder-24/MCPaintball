package org.multicoder.mcpaintball.common.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.common.blockentities.SoloC4PaintballBlockEntity;

@SuppressWarnings("all")
public class SoloPaintballC4ExplosiveBlock extends Block implements EntityBlock
{
    public VoxelShape makeShape()
    {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.25, 0, 0.25, 0.75, 0.3125, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0.3125, 0.4375, 0.75, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.3125, 0.4375, 0.375, 0.4375, 0.5625), BooleanOp.OR);

        return shape;
    }

    public SoloPaintballC4ExplosiveBlock()
    {
        super(Properties.of().noOcclusion().destroyTime(3f));
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return makeShape();
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack)
    {
        super.setPlacedBy(level, pos, state, entity, stack);
        if(entity instanceof Player player)
        {
            SoloC4PaintballBlockEntity E = (SoloC4PaintballBlockEntity) level.getBlockEntity(pos);
            E.PlacedBy(player);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_)
    {
        return new SoloC4PaintballBlockEntity(p_153215_,p_153216_);
    }
}

package org.multicoder.mcpaintball.block.flag;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.init.MCPaintballBlocks;
import java.util.List;

@SuppressWarnings("all")
public class RedFlagBlock extends Block {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public RedFlagBlock() {
        super(Properties.of().dynamicShape().noOcclusion().destroyTime(2F).explosionResistance(1200F));
    }


    @Override
    protected @NotNull List<ItemStack> getDrops(BlockState state, LootParams.@NotNull Builder params)
    {
        if(state.getValue(HALF) == DoubleBlockHalf.LOWER){
            return List.of(new ItemStack(MCPaintballBlocks.RED_FLAG_BLOCK_BI.get()));
        }
        return List.of();
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack) {
        level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER),3);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
    }

    @Override
    protected @NotNull BlockState updateShape(BlockState state, Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
                return neighborState.getBlock() instanceof RedFlagBlock && neighborState.getValue(HALF) != doubleblockhalf ? neighborState.setValue(HALF, doubleblockhalf) : Blocks.AIR.defaultBlockState();
        } else {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        }
    }
    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = level.getBlockState(blockpos);
        return state.getValue(HALF) == DoubleBlockHalf.LOWER ? blockstate.isFaceSturdy(level, blockpos, Direction.UP) : blockstate.is(this);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(HALF);
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        return state.getValue(HALF) == DoubleBlockHalf.LOWER? makeShapeBottom() : makeShapeTop();
    }

    public VoxelShape makeShapeTop(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.4375, 0, 0.4375, 0.5625, 0.75, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.75, 0.375, 0.625, 1, 0.625), BooleanOp.OR);

        return shape;
    }
    public VoxelShape makeShapeBottom(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.375, 0, 0.375, 0.625, 0.125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.125, 0.4375, 0.5625, 1, 0.5625), BooleanOp.OR);

        return shape;
    }
}

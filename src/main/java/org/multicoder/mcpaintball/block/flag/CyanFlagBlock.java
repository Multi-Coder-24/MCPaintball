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
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.init.MCPaintballBlocks;

import java.util.List;

@SuppressWarnings("all")
public class CyanFlagBlock extends Block {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public CyanFlagBlock() {
        super(Properties.of().dynamicShape().noOcclusion().destroyTime(2F).explosionResistance(1200F));
    }

    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params)
    {
        if(state.getValue(HALF) == DoubleBlockHalf.LOWER){
            return List.of(new ItemStack(MCPaintballBlocks.CYAN_FLAG_BLOCK_BI.get()));
        }
        return List.of();
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        level.setBlock(pos.above(),(BlockState) state.setValue(HALF, DoubleBlockHalf.UPPER),3);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleblockhalf = (DoubleBlockHalf)state.getValue(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
                return neighborState.getBlock() instanceof CyanFlagBlock && neighborState.getValue(HALF) != doubleblockhalf ? (BlockState)neighborState.setValue(HALF, doubleblockhalf) : Blocks.AIR.defaultBlockState();
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
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
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

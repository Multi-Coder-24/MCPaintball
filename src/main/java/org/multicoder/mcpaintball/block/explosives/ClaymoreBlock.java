package org.multicoder.mcpaintball.block.explosives;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.PushReaction;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.block.entity.ClaymoreBlockEntity;
import org.multicoder.mcpaintball.core.MCPaintballBlockEntities;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;

public class ClaymoreBlock extends BaseEntityBlock {
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public ClaymoreBlock(Properties properties) {
        super(properties.noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = defaultBlockState();
        state = state.setValue(FACING,context.getHorizontalDirection());
        return state;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        super.createBlockStateDefinition(builder);
    }

    @Override
    protected @NonNull MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(ClaymoreBlock::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NonNull BlockPos worldPosition, @NonNull BlockState blockState) {
        if (blockState.getBlock() == MCPaintballBlocks.RED_CLAYMORE_BLOCK) {
            return new ClaymoreBlockEntity(MCPaintballBlockEntities.RED_CLAYMORE_BLOCK_ENTITY,worldPosition, blockState);
        }else if (blockState.getBlock() == MCPaintballBlocks.GREEN_CLAYMORE_BLOCK) {
            return new ClaymoreBlockEntity(MCPaintballBlockEntities.GREEN_CLAYMORE_BLOCK_ENTITY,worldPosition, blockState);
        }else if (blockState.getBlock() == MCPaintballBlocks.BLUE_CLAYMORE_BLOCK) {
            return new ClaymoreBlockEntity(MCPaintballBlockEntities.BLUE_CLAYMORE_BLOCK_ENTITY,worldPosition, blockState);
        }else if (blockState.getBlock() == MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK) {
            return new ClaymoreBlockEntity(MCPaintballBlockEntities.YELLOW_CLAYMORE_BLOCK_ENTITY,worldPosition, blockState);
        }else if (blockState.getBlock() == MCPaintballBlocks.PINK_CLAYMORE_BLOCK) {
            return new ClaymoreBlockEntity(MCPaintballBlockEntities.PINK_CLAYMORE_BLOCK_ENTITY,worldPosition, blockState);
        }else if (blockState.getBlock() == MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK) {
            return new ClaymoreBlockEntity(MCPaintballBlockEntities.ORANGE_CLAYMORE_BLOCK_ENTITY,worldPosition, blockState);
        }
        return null;
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NonNull Level level, @NonNull BlockState state, @NonNull BlockEntityType<T> type) {
        if(!level.isClientSide()){
            if(state.getBlock() == MCPaintballBlocks.RED_CLAYMORE_BLOCK){
                return createTickerHelper(type, MCPaintballBlockEntities.RED_CLAYMORE_BLOCK_ENTITY, ClaymoreBlockEntity::tick);
            }
            else if(state.getBlock() == MCPaintballBlocks.GREEN_CLAYMORE_BLOCK){
                return createTickerHelper(type, MCPaintballBlockEntities.GREEN_CLAYMORE_BLOCK_ENTITY, ClaymoreBlockEntity::tick);
            }else if(state.getBlock() == MCPaintballBlocks.BLUE_CLAYMORE_BLOCK){
                return createTickerHelper(type, MCPaintballBlockEntities.BLUE_CLAYMORE_BLOCK_ENTITY, ClaymoreBlockEntity::tick);
            }else if(state.getBlock() == MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK){
                return createTickerHelper(type, MCPaintballBlockEntities.YELLOW_CLAYMORE_BLOCK_ENTITY, ClaymoreBlockEntity::tick);
            }else if(state.getBlock() == MCPaintballBlocks.PINK_CLAYMORE_BLOCK){
                return createTickerHelper(type, MCPaintballBlockEntities.PINK_CLAYMORE_BLOCK_ENTITY, ClaymoreBlockEntity::tick);
            }else if(state.getBlock() == MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK){
                return createTickerHelper(type, MCPaintballBlockEntities.ORANGE_CLAYMORE_BLOCK_ENTITY, ClaymoreBlockEntity::tick);
            }
        }else {
            return null;
        }
        return null;
    }
}

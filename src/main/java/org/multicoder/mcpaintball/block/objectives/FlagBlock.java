package org.multicoder.mcpaintball.block.objectives;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.data.FlagItemSettings;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class FlagBlock extends Block{

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public FlagBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void playerDestroy(Level level, @NonNull Player player, @NonNull BlockPos pos, @NonNull BlockState state, @Nullable BlockEntity blockEntity, @NonNull ItemStack destroyedWith) {
        if(!level.isClientSide()) {
            if(MCPaintballGameEvents.INSTANCE.matchStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                Block block = state.getBlock();
                int team;
                ItemStack stack;
                int facing;
                if(block == MCPaintballBlocks.RED_FLAG){
                    stack = new ItemStack(MCPaintballItems.RED_FLAG_ITEM);
                    team = 1;
                    facing = state.getValue(FlagBlock.FACING).ordinal();
                } else if (block == MCPaintballBlocks.GREEN_FLAG) {
                    stack = new ItemStack(MCPaintballItems.GREEN_FLAG_ITEM);
                    team = 2;
                    facing = state.getValue(FlagBlock.FACING).ordinal();
                } else if (block == MCPaintballBlocks.BLUE_FLAG) {
                    stack = new ItemStack(MCPaintballItems.BLUE_FLAG_ITEM);
                    team = 3;
                    facing = state.getValue(FlagBlock.FACING).ordinal();
                } else if (block == MCPaintballBlocks.YELLOW_FLAG) {
                    stack = new ItemStack(MCPaintballItems.YELLOW_FLAG_ITEM);
                    team = 4;
                    facing = state.getValue(FlagBlock.FACING).ordinal();
                } else if (block == MCPaintballBlocks.PINK_FLAG) {
                    stack = new ItemStack(MCPaintballItems.PINK_FLAG_ITEM);
                    team = 5;
                    facing = state.getValue(FlagBlock.FACING).ordinal();
                } else if (block == MCPaintballBlocks.ORANGE_FLAG) {
                    stack = new ItemStack(MCPaintballItems.ORANGE_FLAG_ITEM);
                    team = 6;
                    facing = state.getValue(FlagBlock.FACING).ordinal();
                }else{return;}
                stack.set(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(pos,team,facing));
                player.addItem(stack);
            }
        }
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@NonNull BlockPlaceContext context) {
        return Objects.requireNonNull(super.getStateForPlacement(context)).setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NonNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
        super.createBlockStateDefinition(builder);
    }
}

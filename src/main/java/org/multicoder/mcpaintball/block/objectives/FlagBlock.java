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
import net.minecraft.world.level.material.PushReaction;
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
        super(properties.noOcclusion().dynamicShape().destroyTime(2F).pushReaction(PushReaction.BLOCK));
    }

    @Override
    public void playerDestroy(Level level, @NonNull Player player, @NonNull BlockPos pos, @NonNull BlockState state, @Nullable BlockEntity blockEntity, @NonNull ItemStack destroyedWith) {
        if(!level.isClientSide()) {
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                Block block = state.getBlock();
                ItemStack stack;
                int Facing = state.getValue(FACING).ordinal();
                if(block == MCPaintballBlocks.RED_FLAG.get()){
                    stack = new ItemStack(MCPaintballItems.RED_FLAG_ITEM.get());
                    stack.set(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(pos,1,Facing));
                } else if (block == MCPaintballBlocks.GREEN_FLAG.get()) {
                    stack = new ItemStack(MCPaintballItems.GREEN_FLAG_ITEM.get());
                    stack.set(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(pos,2,Facing));
                } else if (block == MCPaintballBlocks.BLUE_FLAG.get()) {
                    stack = new ItemStack(MCPaintballItems.BLUE_FLAG_ITEM.get());
                    stack.set(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(pos,3,Facing));
                } else if (block == MCPaintballBlocks.YELLOW_FLAG.get()) {
                    stack = new ItemStack(MCPaintballItems.YELLOW_FLAG_ITEM.get());
                    stack.set(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(pos,4,Facing));
                } else if (block == MCPaintballBlocks.PINK_FLAG.get()) {
                    stack = new ItemStack(MCPaintballItems.PINK_FLAG_ITEM.get());
                    stack.set(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(pos,5,Facing));
                } else if (block == MCPaintballBlocks.ORANGE_FLAG.get()) {
                    stack = new ItemStack(MCPaintballItems.ORANGE_FLAG_ITEM.get());
                    stack.set(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(pos,6,Facing));
                }else return;
                player.addItem(stack);
            }
        }
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@NonNull BlockPlaceContext context) {
        return Objects.requireNonNull(super.getStateForPlacement(context)).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NonNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
        super.createBlockStateDefinition(builder);
    }
}

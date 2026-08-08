package org.multicoder.mcpaintball.block.objectives;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class CapturePointBlock extends Block {

    public static final IntegerProperty TEAM = IntegerProperty.create("team",0,6);

    public CapturePointBlock(Properties properties) {
        super(properties.noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
        registerDefaultState(defaultBlockState().setValue(TEAM, 0));
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        if(!context.getLevel().isClientSide()) {
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && !MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballGameEvents.INSTANCE.addCapturePoint(context.getClickedPos());
                return super.getStateForPlacement(context);
            }
        }
        return null;
    }

    @Override
    public @NonNull BlockState playerWillDestroy(@NonNull Level level, @NonNull BlockPos pos, @NonNull BlockState state, @NonNull Player player) {
        if(!level.isClientSide()){
            if (MCPaintballGameEvents.INSTANCE.MatchStarted && !MCPaintballGameEvents.INSTANCE.RoundStarted) {
                MCPaintballGameEvents.INSTANCE.removeCapturePoint(pos);
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                if(Objects.requireNonNull(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())).Team != 0){
                    int team = Objects.requireNonNull(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())).Team;
                    state = state.setValue(TEAM, team);
                    level.setBlockAndUpdate(pos, state);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }


    @Override
    public void playerDestroy(@NonNull Level level, @NonNull Player player, @NonNull BlockPos pos, @NonNull BlockState state, @Nullable BlockEntity blockEntity, @NonNull ItemStack destroyedWith) {

        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TEAM);
        super.createBlockStateDefinition(builder);
    }
}

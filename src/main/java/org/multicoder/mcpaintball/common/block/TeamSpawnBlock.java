package org.multicoder.mcpaintball.common.block;

import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.util.enums.Teams;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

@SuppressWarnings("all")
public class TeamSpawnBlock extends Block {
    public Teams Team;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public TeamSpawnBlock(Teams In) {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
        Team = In;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        try{
            if (!level.isClientSide()) {
                Direction D = state.getValue(FACING);
                if ((player.isCrouching() && player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get().Team == Team) || (player.isCrouching() && player.hasPermissions(Commands.LEVEL_ADMINS))) {
                    D = D.getClockWise();
                    level.setBlockAndUpdate(pos, state.setValue(FACING, D));
                    player.sendSystemMessage(Component.translatable("text.mcpaintball.spawn_facing", D.getName()));
                    return InteractionResult.CONSUME;
                }
                switch (D) {
                    case NORTH -> {
                        pos = pos.north();
                    }
                    case EAST -> {
                        pos = pos.east();
                    }
                    case WEST -> {
                        pos = pos.west();
                    }
                    case SOUTH -> {
                        pos = pos.south();
                    }
                    default -> {
                        pos = pos.above();
                    }
                }
                PaintballPlayer PPlayer = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                if (PPlayer.Team == Team) {
                    ServerPlayer P = (ServerPlayer) player;
                    P.setRespawnPosition(level.dimension(), pos, 0f, true, false);
                    player.sendSystemMessage(Component.translatable("text.mcpaintball.spawn_update"));
                }
            }
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player)
    {
        try{
            if (player.hasPermissions(Commands.LEVEL_ADMINS)) {
                return true;
            } else return player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get().Team == Team;
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> p_49915_) {
        super.createBlockStateDefinition(p_49915_);
        p_49915_.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext p_49820_) {
        BlockState state = super.getStateForPlacement(p_49820_);
        state = state.setValue(FACING, Direction.NORTH);
        return state;
    }
}

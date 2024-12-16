package org.multicoder.mcpaintball.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;

import static net.minecraft.world.InteractionResult.SUCCESS;
import static org.multicoder.mcpaintball.data.MCPaintballWorldData.INSTANCE;
import static org.multicoder.mcpaintball.init.MCPaintballBlocks.*;
import static org.multicoder.mcpaintball.init.MCPaintballItems.*;

@SuppressWarnings("all")
public class PaintballTeamStationBlock extends Block
{
    public static final DirectionProperty FACING = DirectionProperty.create("facing");
    public PaintballTeamStationBlock()
    {
        super(Properties.of().noOcclusion().destroyTime(3f));
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext p_49820_)
    {
        return defaultBlockState().setValue(FACING, p_49820_.getHorizontalDirection());
    }

    @Override
    public InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result)
    {
        if(!level.isClientSide())
        {
            if(INSTANCE.MatchStarted)
            {
                if(MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    if(Team == 0 && state.getBlock().equals(RED_TEAM_STATION.value()))
                    {
                        ServerPlayer SP = (ServerPlayer) player;
                        SP.setRespawnPosition(player.level().dimension(),pos.above(),0f,true,true);
                        player.addItem(new ItemStack(RED_GRENADE.value(),8));
                        player.addItem(new ItemStack(RED_C4.value(),2));
                    }
                    else if(Team == 1 && state.getBlock().equals(GREEN_TEAM_STATION.value()))
                    {
                        ServerPlayer SP = (ServerPlayer) player;
                        SP.setRespawnPosition(player.level().dimension(),pos.above(),0f,true,true);
                        player.addItem(new ItemStack(GREEN_GRENADE.value(), 8));
                        player.addItem(new ItemStack(GREEN_C4.value(), 2));
                    }
                    else if(Team == 2 && state.getBlock().equals(BLUE_TEAM_STATION.value()))
                    {
                        ServerPlayer SP = (ServerPlayer) player;
                        SP.setRespawnPosition(player.level().dimension(),pos.above(),0f,true,true);
                        player.addItem(new ItemStack(BLUE_GRENADE.value(),8));
                        player.addItem(new ItemStack(BLUE_C4.value(),2));
                    }
                }
            }
        }
        return SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(FACING);
        super.createBlockStateDefinition(p_49915_);
    }
}

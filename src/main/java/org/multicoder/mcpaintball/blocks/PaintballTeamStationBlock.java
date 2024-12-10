package org.multicoder.mcpaintball.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.init.MCPaintballBlocks;
import org.multicoder.mcpaintball.init.MCPaintballItems;

@SuppressWarnings("all")
public class PaintballTeamStationBlock extends Block
{
    public VoxelShape makeShape()
    {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 0.25, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.25, 0, 0.125, 0.75, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.875, 0.25, 0.875, 1, 0.75, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.25, 0.875, 0.125, 0.75, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.875, 0.25, 0, 1, 0.75, 0.125), BooleanOp.OR);
        return shape;
    }

    public PaintballTeamStationBlock()
    {
        super(Properties.of().noOcclusion().destroyTime(3f));
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState p_60555_, @NotNull BlockGetter p_60556_, @NotNull BlockPos p_60557_, @NotNull CollisionContext p_60558_)
    {
        return makeShape();
    }
    @Override
    public InteractionResult use(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result)
    {
        if(!level.isClientSide())
        {
            if(MCPaintballWorldData.INSTANCE.MatchStarted)
            {
                if(MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    int Class = MCPaintballTeamsDataHelper.FetchClass(player);
                    if(Team == 0 && state.getBlock().equals(MCPaintballBlocks.RED_TEAM_STATION.value()))
                    {
                        ServerPlayer SP = (ServerPlayer) player;
                        SP.setRespawnPosition(player.level().dimension(),pos.above(),0f,true,true);
                        switch (Class)
                        {
                            case 0 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.RED_GRENADE.value(),8));
                                player.addItem(new ItemStack(MCPaintballBlocks.RED_C4.value(),2));
                            }
                            case 1 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.RED_GRENADE.value(),12));
                                player.addItem(new ItemStack(MCPaintballBlocks.RED_C4.value(),4));
                            }
                            case 2 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.RED_GRENADE.value(),16));
                                player.addItem(new ItemStack(MCPaintballBlocks.RED_C4.value(),6));
                            }
                        }
                    }
                    else if(Team == 1 && state.getBlock().equals(MCPaintballBlocks.GREEN_TEAM_STATION.value()))
                    {
                        ServerPlayer SP = (ServerPlayer) player;
                        SP.setRespawnPosition(player.level().dimension(),pos.above(),0f,true,true);
                        switch (Class) {
                            case 0 -> {
                                player.addItem(new ItemStack(MCPaintballItems.GREEN_GRENADE.value(), 8));
                                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_C4.value(), 2));
                            }
                            case 1 -> {
                                player.addItem(new ItemStack(MCPaintballItems.GREEN_GRENADE.value(), 12));
                                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_C4.value(), 4));
                            }
                            case 2 -> {
                                player.addItem(new ItemStack(MCPaintballItems.GREEN_GRENADE.value(), 16));
                                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_C4.value(), 6));
                            }
                        }
                    }
                    else if(Team == 2 && state.getBlock().equals(MCPaintballBlocks.BLUE_TEAM_STATION.value()))
                    {
                        ServerPlayer SP = (ServerPlayer) player;
                        SP.setRespawnPosition(player.level().dimension(),pos.above(),0f,true,true);
                        switch (Class)
                        {
                            case 0 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.BLUE_GRENADE.value(),8));
                                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_C4.value(),2));
                            }
                            case 1 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.BLUE_GRENADE.value(),12));
                                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_C4.value(),4));
                            }
                            case 2 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.BLUE_GRENADE.value(),16));
                                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_C4.value(),6));
                            }
                        }
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

}

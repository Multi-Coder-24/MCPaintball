package org.multicoder.mcpaintball.common.blocks;


import net.minecraft.core.BlockPos;
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
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

@SuppressWarnings("all")
public class PaintballTeamStationBlock extends Block
{
    public VoxelShape makeShape(){
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
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return makeShape();
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult result)
    {
        if(!level.isClientSide())
        {
            if(MCPaintballWorldData.INSTANCE.MatchStarted)
            {
                if(MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    int Class = MCPaintballTeamsDataHelper.FetchClass(player);
                    if(Team == 1 && state.getBlock().equals(MCPaintballBlocks.RED_TEAM_STATION.value()))
                    {
                        switch (Class)
                        {
                            case 1 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.RED_GRENADE.value(),8));
                                player.addItem(new ItemStack(MCPaintballBlocks.RED_C4.value(),2));
                            }
                            case 2 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.RED_GRENADE.value(),12));
                                player.addItem(new ItemStack(MCPaintballBlocks.RED_C4.value(),4));
                            }
                            case 3 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.RED_GRENADE.value(),16));
                                player.addItem(new ItemStack(MCPaintballBlocks.RED_C4.value(),6));
                            }
                        }
                    }
                    else if(Team == 2 && state.getBlock().equals(MCPaintballBlocks.GREEN_TEAM_STATION.value()))
                    {
                        switch (Class) {
                            case 1 -> {
                                player.addItem(new ItemStack(MCPaintballItems.GREEN_GRENADE.value(), 8));
                                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_C4.value(), 2));
                            }
                            case 2 -> {
                                player.addItem(new ItemStack(MCPaintballItems.GREEN_GRENADE.value(), 12));
                                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_C4.value(), 4));
                            }
                            case 3 -> {
                                player.addItem(new ItemStack(MCPaintballItems.GREEN_GRENADE.value(), 16));
                                player.addItem(new ItemStack(MCPaintballBlocks.GREEN_C4.value(), 6));
                            }
                        }
                    }
                    else if(Team == 3 && state.getBlock().equals(MCPaintballBlocks.BLUE_TEAM_STATION.value()))
                    {
                        switch (Class)
                        {
                            case 1 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.BLUE_GRENADE.value(),8));
                                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_C4.value(),2));
                            }
                            case 2 ->
                            {
                                player.addItem(new ItemStack(MCPaintballItems.BLUE_GRENADE.value(),12));
                                player.addItem(new ItemStack(MCPaintballBlocks.BLUE_C4.value(),4));
                            }
                            case 3 ->
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

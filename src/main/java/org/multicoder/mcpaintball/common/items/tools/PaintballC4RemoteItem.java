package org.multicoder.mcpaintball.common.items.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;
import org.multicoder.mcpaintball.common.utility.NBTHelper;

@SuppressWarnings("all")
public class PaintballC4RemoteItem extends Item
{

    public PaintballC4RemoteItem()
    {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        ItemStack stack = player.getItemInHand(hand);
        CompoundTag RemoteNBT = player.getPersistentData();
        if(!level.isClientSide())
        {
            if(MCPaintballWorldData.INSTANCE.MatchStarted)
            {
                if(MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    if(Team == 1 && stack.getItem().equals(MCPaintballItems.RED_REMOTE.value()))
                    {
                        NBTHelper.C4Det(RemoteNBT,stack,level,player);
                        return InteractionResultHolder.consume(stack);
                    } else if (Team == 2 && stack.getItem().equals(MCPaintballItems.GREEN_REMOTE.value()))
                    {
                        NBTHelper.C4Det(RemoteNBT,stack,level,player);
                        return InteractionResultHolder.consume(stack);
                    } else if (Team == 3 && stack.getItem().equals(MCPaintballItems.BLUE_REMOTE.value()))
                    {
                        NBTHelper.C4Det(RemoteNBT,stack,level,player);
                        return InteractionResultHolder.consume(stack);
                    }
                }
            }
            return InteractionResultHolder.fail(stack);
        }
        return super.use(level, player, hand);
    }

    //  Add/Remove Block
    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Level level = player.level();
        CompoundTag RemoteNBT = player.getPersistentData();
        if(!level.isClientSide()) {
            if (MCPaintballWorldData.INSTANCE.MatchStarted)
            {
                if (MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    if (Team == 1 && stack.getItem().equals(MCPaintballItems.RED_REMOTE.value()))
                    {
                        Block Selected = level.getBlockState(pos).getBlock();
                        NBTHelper.C4SetRem(RemoteNBT,stack,Selected,level,pos,player);
                        return InteractionResult.CONSUME;
                    }
                    else if (Team == 2 && stack.getItem().equals(MCPaintballItems.GREEN_REMOTE.value()))
                    {
                        Block Selected = level.getBlockState(pos).getBlock();
                        NBTHelper.C4SetRem(RemoteNBT,stack,Selected,level,pos,player);
                    }
                    else if (Team == 3 && stack.getItem().equals(MCPaintballItems.BLUE_REMOTE.value()))
                    {
                        Block Selected = level.getBlockState(pos).getBlock();
                        NBTHelper.C4SetRem(RemoteNBT,stack,Selected,level,pos,player);
                    }
                    return InteractionResult.CONSUME;
                }
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.SUCCESS;
    }
}

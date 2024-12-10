package org.multicoder.mcpaintball.items.tools;

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
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.utility.NBTHelper;

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
        if(!level.isClientSide())
        {
            if(MCPaintballWorldData.INSTANCE.MatchStarted)
            {
                if(MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    NBTHelper.C4Det(stack,level,player);
                    return InteractionResultHolder.consume(stack);
                }
            }
            return InteractionResultHolder.fail(stack);
        }
        return InteractionResultHolder.success(stack);
    }

    //  Add/Remove Block
    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Level level = player.level();
        if(!level.isClientSide()) {
            if (MCPaintballWorldData.INSTANCE.MatchStarted)
            {
                if (MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    CompoundTag Data = stack.getOrCreateTag();
                    Block Selected = level.getBlockState(pos).getBlock();
                    NBTHelper.C4SetRem(stack,Selected,level,pos,player);
                    return InteractionResult.CONSUME;
                }
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.SUCCESS;
    }
}

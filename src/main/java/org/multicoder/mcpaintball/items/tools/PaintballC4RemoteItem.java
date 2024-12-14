package org.multicoder.mcpaintball.items.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.utility.NBTHelper;

import static net.minecraft.world.InteractionResult.*;
import static org.multicoder.mcpaintball.data.MCPaintballWorldData.INSTANCE;

@SuppressWarnings("all")
public class PaintballC4RemoteItem extends Item
{

    public PaintballC4RemoteItem()
    {
        super(new Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand)
    {
        ItemStack stack = player.getItemInHand(hand);
        if(!level.isClientSide())
        {
            if(INSTANCE.MatchStarted)
            {
                if(MCPaintballTeamsDataHelper.HasTeam(player))
                {
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
    public @NotNull InteractionResult useOn(UseOnContext context)
    {
        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Level level = player.level();
        if(!level.isClientSide()) {
            if (INSTANCE.MatchStarted)
            {
                if (MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    Block Selected = level.getBlockState(pos).getBlock();
                    NBTHelper.C4SetRem(stack,Selected,level,pos,player);
                    return CONSUME;
                }
                return FAIL;
            }
        }
        return SUCCESS;
    }
}

package org.multicoder.mcpaintball.common.items.tools;

import com.mojang.blaze3d.platform.ScreenManager;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.multicoder.mcpaintball.common.blocks.MCPaintballBlocks;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

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
            CompoundTag Data = stack.getOrCreateTag();
            if(Data.contains("devices"))
            {
                ListTag Devices = Data.getList("devices",Tag.TAG_LONG);
                if(!Devices.isEmpty())
                {
                    if(Screen.hasControlDown())
                    {
                        Devices.forEach(tag ->
                        {
                            LongTag posTag = (LongTag) tag;
                            BlockPos Pos = BlockPos.of(posTag.getAsLong());
                            if(stack.getItem().equals(MCPaintballItems.RED_REMOTE))
                            {
                                if(level.getBlockState(Pos).getBlock().equals(MCPaintballBlocks.RED_C4))
                                {
                                    level.explode(null,Pos.getX(),Pos.getY(),Pos.getZ(),5f, Level.ExplosionInteraction.NONE);
                                    level.setBlockAndUpdate(Pos, Blocks.AIR.defaultBlockState());
                                }
                            } else if (stack.getItem().equals(MCPaintballItems.GREEN_REMOTE))
                            {
                                if(level.getBlockState(Pos).getBlock().equals(MCPaintballBlocks.GREEN_C4))
                                {
                                    level.explode(null,Pos.getX(),Pos.getY(),Pos.getZ(),5f, Level.ExplosionInteraction.NONE);
                                    level.setBlockAndUpdate(Pos, Blocks.AIR.defaultBlockState());
                                }
                            } else if (stack.getItem().equals(MCPaintballItems.BLUE_REMOTE))
                            {
                                if(level.getBlockState(Pos).getBlock().equals(MCPaintballBlocks.BLUE_C4))
                                {
                                    level.explode(null,Pos.getX(),Pos.getY(),Pos.getZ(),5f, Level.ExplosionInteraction.NONE);
                                    level.setBlockAndUpdate(Pos, Blocks.AIR.defaultBlockState());
                                }
                            }
                        });
                        stack.setTag(new CompoundTag());
                        return InteractionResultHolder.consume(stack);
                    }
                }
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        ItemStack stack = context.getItemInHand();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Level level = player.level();
        if(!level.isClientSide())
        {
            Block Selected = level.getBlockState(pos).getBlock();
            CompoundTag Data = stack.getOrCreateTag();
            if(Data.contains("devices", Tag.TAG_LIST))
            {
                ListTag Devices = Data.getList("devices",Tag.TAG_LONG);
                if(stack.getItem().equals(MCPaintballItems.RED_REMOTE) && Selected.equals(MCPaintballBlocks.RED_C4))
                {
                    if(Screen.hasShiftDown())
                    {
                        Devices.add(LongTag.valueOf(pos.asLong()));
                    }
                    else
                    {
                        Devices.remove(LongTag.valueOf(pos.asLong()));
                    }
                } else if (stack.getItem().equals(MCPaintballItems.GREEN_REMOTE) && Selected.equals(MCPaintballBlocks.GREEN_C4))
                {
                    if(Screen.hasShiftDown())
                    {
                        Devices.add(LongTag.valueOf(pos.asLong()));
                    }
                    else
                    {
                        Devices.remove(LongTag.valueOf(pos.asLong()));
                    }
                } else if (stack.getItem().equals(MCPaintballItems.BLUE_REMOTE) && Selected.equals(MCPaintballBlocks.BLUE_C4))
                {
                    if(Screen.hasShiftDown())
                    {
                        Devices.add(LongTag.valueOf(pos.asLong()));
                    }
                    else
                    {
                        Devices.remove(LongTag.valueOf(pos.asLong()));
                    }
                }
                Data.put("devices",Devices);
                stack.setTag(Data);

            }
            else
            {
                ListTag Devices = new ListTag();
                if(stack.getItem().equals(MCPaintballItems.RED_REMOTE) && Selected.equals(MCPaintballBlocks.RED_C4))
                {
                    if(Screen.hasShiftDown())
                    {
                        Devices.add(LongTag.valueOf(pos.asLong()));
                    }
                } else if (stack.getItem().equals(MCPaintballItems.GREEN_REMOTE) && Selected.equals(MCPaintballBlocks.GREEN_C4))
                {
                    if(Screen.hasShiftDown())
                    {
                        Devices.add(LongTag.valueOf(pos.asLong()));
                    }
                } else if (stack.getItem().equals(MCPaintballItems.BLUE_REMOTE) && Selected.equals(MCPaintballBlocks.BLUE_C4))
                {
                    if(Screen.hasShiftDown())
                    {
                        Devices.add(LongTag.valueOf(pos.asLong()));
                    }
                }
                Data.put("devices",Devices);
                stack.setTag(Data);
            }
            return InteractionResult.CONSUME;
        }
        return super.useOn(context);
    }
}

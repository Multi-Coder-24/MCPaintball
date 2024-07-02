package org.multicoder.mcpaintball.common.utility;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.blocks.MCPaintballBlocks;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

import java.util.concurrent.atomic.AtomicBoolean;

public class NBTHelper
{
    public static void C4SetRem(CompoundTag Data, ItemStack stack, Block Selected, Level level, BlockPos pos, Player player)
    {
        if (Data.contains("devices", Tag.TAG_LIST))
        {
            ListTag Devices = Data.getList("devices", Tag.TAG_LONG);
            if (stack.getItem().equals(MCPaintballItems.RED_REMOTE.value()) && Selected.equals(MCPaintballBlocks.RED_C4.value()))
            {
                if (Screen.hasShiftDown())
                {
                    Devices.add(LongTag.valueOf(pos.asLong()));
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
                } else
                {
                    Devices.remove(LongTag.valueOf(pos.asLong()));
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_REMOVED.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
            else if (stack.getItem().equals(MCPaintballItems.GREEN_REMOTE.value()) && Selected.equals(MCPaintballBlocks.GREEN_C4.value()))
            {
                if (Screen.hasShiftDown())
                {
                    Devices.add(LongTag.valueOf(pos.asLong()));
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
                } else
                {
                    Devices.remove(LongTag.valueOf(pos.asLong()));
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_REMOVED.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
            else if (stack.getItem().equals(MCPaintballItems.BLUE_REMOTE.value()) && Selected.equals(MCPaintballBlocks.BLUE_C4.value()))
            {
                if (Screen.hasShiftDown())
                {
                    Devices.add(LongTag.valueOf(pos.asLong()));
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
                } else {
                    Devices.remove(LongTag.valueOf(pos.asLong()));
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_REMOVED.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
            Data.put("devices", Devices);
            stack.setTag(Data);
        }
        else
        {
            ListTag Devices = new ListTag();
            if (stack.getItem().equals(MCPaintballItems.RED_REMOTE.value()) && Selected.equals(MCPaintballBlocks.RED_C4.value()))
            {
                if (Screen.hasShiftDown())
                {
                    Devices.add(LongTag.valueOf(pos.asLong()));
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
            else if (stack.getItem().equals(MCPaintballItems.GREEN_REMOTE.value()) && Selected.equals(MCPaintballBlocks.GREEN_C4.value()))
            {
                if (Screen.hasShiftDown())
                {
                    Devices.add(LongTag.valueOf(pos.asLong()));
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
            else if (stack.getItem().equals(MCPaintballItems.BLUE_REMOTE.value()) && Selected.equals(MCPaintballBlocks.BLUE_C4.value()))
            {
                if (Screen.hasShiftDown())
                {
                    Devices.add(LongTag.valueOf(pos.asLong()));
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
            Data.put("devices", Devices);
            stack.setTag(Data);
        }
    }
    public static void C4Det(CompoundTag Data, ItemStack stack, Level level, Player player)
    {
        AtomicBoolean Trigger = new AtomicBoolean(false);
        if(Data.contains("devices"))
        {
            ListTag Devices = Data.getList("devices", Tag.TAG_LONG);
            if (!Devices.isEmpty()) {
                if (Screen.hasControlDown()) {
                    Devices.forEach(tag ->
                    {
                        LongTag posTag = (LongTag) tag;
                        BlockPos Pos = BlockPos.of(posTag.getAsLong());
                        if (stack.getItem().equals(MCPaintballItems.RED_REMOTE.value())) {
                            if (level.getBlockState(Pos).getBlock().equals(MCPaintballBlocks.RED_C4.value())) {
                                level.explode(null, Pos.getX(), Pos.getY(), Pos.getZ(), 5f, Level.ExplosionInteraction.NONE);
                                level.setBlockAndUpdate(Pos, Blocks.AIR.defaultBlockState());
                                Trigger.set(true);
                            }
                        } else if (stack.getItem().equals(MCPaintballItems.GREEN_REMOTE.value())) {
                            if (level.getBlockState(Pos).getBlock().equals(MCPaintballBlocks.GREEN_C4.value())) {
                                level.explode(null, Pos.getX(), Pos.getY(), Pos.getZ(), 5f, Level.ExplosionInteraction.NONE);
                                level.setBlockAndUpdate(Pos, Blocks.AIR.defaultBlockState());
                                Trigger.set(true);
                            }
                        } else if (stack.getItem().equals(MCPaintballItems.BLUE_REMOTE.value())) {
                            if (level.getBlockState(Pos).getBlock().equals(MCPaintballBlocks.BLUE_C4.value())) {
                                level.explode(null, Pos.getX(), Pos.getY(), Pos.getZ(), 5f, Level.ExplosionInteraction.NONE);
                                level.setBlockAndUpdate(Pos, Blocks.AIR.defaultBlockState());
                                Trigger.set(true);
                            }
                        }
                    });
                    stack.setTag(new CompoundTag());
                    if (Trigger.get()) {
                        level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_EXPLODE.get(), SoundSource.PLAYERS, 1f, 1f);
                    }
                }
            }
        }
    }
}

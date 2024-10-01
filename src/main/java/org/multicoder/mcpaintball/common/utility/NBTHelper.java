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
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.init.MCPaintballSounds;
import org.multicoder.mcpaintball.common.blockentities.SoloC4PaintballBlockEntity;
import org.multicoder.mcpaintball.common.init.MCPaintballBlocks;
import org.multicoder.mcpaintball.common.init.MCPaintballItems;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings("all")
public class NBTHelper
{
    public static void C4SetRem(ItemStack stack, Block Selected, Level level, BlockPos pos, Player player)
    {
        CompoundTag StackTag = stack.getOrCreateTag();
        ListTag Devices = StackTag.contains("devices") ? StackTag.getList("devices",Tag.TAG_LONG) : new ListTag();
        if(stack.getItem().equals(MCPaintballItems.RED_REMOTE.value()) && Selected.equals(MCPaintballBlocks.RED_C4.value()))
        {
            if(player.isShiftKeyDown())
            {
                Devices.add(LongTag.valueOf(pos.asLong()));
                level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_ADDED.get(),SoundSource.PLAYERS);
            }
            else
            {
                Devices.remove(LongTag.valueOf(pos.asLong()));
                level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_REMOVED.get(),SoundSource.PLAYERS);
            }
            StackTag.put("devices",Devices);
            stack.setTag(StackTag);
            return;
        }
        if(stack.getItem().equals(MCPaintballItems.GREEN_REMOTE.value()) && Selected.equals(MCPaintballBlocks.GREEN_C4.value()))
        {
            if(player.isShiftKeyDown())
            {
                Devices.add(LongTag.valueOf(pos.asLong()));
                level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_ADDED.get(),SoundSource.PLAYERS);
            }
            else
            {
                Devices.remove(LongTag.valueOf(pos.asLong()));
                level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_REMOVED.get(),SoundSource.PLAYERS);
            }
            StackTag.put("devices",Devices);
            stack.setTag(StackTag);
            return;
        }
        if(stack.getItem().equals(MCPaintballItems.BLUE_REMOTE.value()) && Selected.equals(MCPaintballBlocks.BLUE_C4.value()))
        {
            if(player.isShiftKeyDown())
            {
                Devices.add(LongTag.valueOf(pos.asLong()));
                level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_ADDED.get(),SoundSource.PLAYERS);
            }
            else
            {
                Devices.remove(LongTag.valueOf(pos.asLong()));
                level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_REMOVED.get(),SoundSource.PLAYERS);
            }
            StackTag.put("devices",Devices);
            stack.setTag(StackTag);
            return;
        }
        if(stack.getItem().equals(MCPaintballItems.SOLO_REMOTE.value()) && Selected.equals(MCPaintballBlocks.SOLO_C4.value()))
        {
            if(((SoloC4PaintballBlockEntity)level.getBlockEntity(pos)).IsSamePlayer(player))
            {
                if(player.isShiftKeyDown())
                {
                    Devices.add(LongTag.valueOf(pos.asLong()));
                    level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_ADDED.get(),SoundSource.PLAYERS);
                }
                else
                {
                    Devices.remove(LongTag.valueOf(pos.asLong()));
                    level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_REMOVED.get(),SoundSource.PLAYERS);
                }
                StackTag.put("devices",Devices);
                stack.setTag(StackTag);
                return;
            }
            return;
        }
    }
    public static void C4Det(ItemStack stack, Level level, Player player) {
        CompoundTag StackTag = stack.getOrCreateTag();
        ListTag Devices = StackTag.contains("devices") ? StackTag.getList("devices", Tag.TAG_LONG) : new ListTag();
        if (!Devices.isEmpty()) {
            if (player.isShiftKeyDown()) {
                AtomicBoolean Trigger = new AtomicBoolean(false);
                Devices.forEach(position ->
                {
                    BlockPos blockPosition = BlockPos.of(((LongTag) position).getAsLong());
                    if (stack.getItem().equals(MCPaintballItems.RED_REMOTE.value()) && level.getBlockState(blockPosition).getBlock().equals(MCPaintballBlocks.RED_C4.value())) {
                        Trigger.set(true);
                        level.explode(null, blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), 5f, Level.ExplosionInteraction.NONE);
                        level.setBlockAndUpdate(blockPosition, Blocks.AIR.defaultBlockState());
                    }
                    if (stack.getItem().equals(MCPaintballItems.GREEN_REMOTE.value()) && level.getBlockState(blockPosition).getBlock().equals(MCPaintballBlocks.GREEN_C4.value())) {
                        Trigger.set(true);
                        level.explode(null, blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), 5f, Level.ExplosionInteraction.NONE);
                        level.setBlockAndUpdate(blockPosition, Blocks.AIR.defaultBlockState());
                    }
                    if (stack.getItem().equals(MCPaintballItems.BLUE_REMOTE.value()) && level.getBlockState(blockPosition).getBlock().equals(MCPaintballBlocks.BLUE_C4.value())) {
                        Trigger.set(true);
                        level.explode(null, blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), 5f, Level.ExplosionInteraction.NONE);
                        level.setBlockAndUpdate(blockPosition, Blocks.AIR.defaultBlockState());
                    }
                    if (stack.getItem().equals(MCPaintballItems.SOLO_REMOTE.value()) && level.getBlockState(blockPosition).getBlock().equals(MCPaintballBlocks.SOLO_C4.value())) {
                        if (((SoloC4PaintballBlockEntity) level.getBlockEntity(blockPosition)).IsSamePlayer(player)) {
                            Trigger.set(true);
                            level.explode(null, blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), 5f, Level.ExplosionInteraction.NONE);
                            level.setBlockAndUpdate(blockPosition, Blocks.AIR.defaultBlockState());
                        }
                    }
                });
                if (Trigger.get())
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_EXPLODE.get(), SoundSource.PLAYERS, 1f, 1f);
                stack.setTag(new CompoundTag());
            }
        }
    }
}

package org.multicoder.mcpaintball.utility;

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
import org.multicoder.mcpaintball.init.MCPaintballSounds;
import org.multicoder.mcpaintball.init.MCPaintballBlocks;
import org.multicoder.mcpaintball.init.MCPaintballItems;

import java.util.concurrent.atomic.AtomicBoolean;


public class NBTHelper
{
    public static void C4SetRem(ItemStack stack, Block Selected, Level level, BlockPos pos, Player player)
    {
        CompoundTag StackTag = stack.getOrCreateTag();
        ListTag Devices = StackTag.contains("devices") ? StackTag.getList("devices",Tag.TAG_LONG) : new ListTag();
        if(stack.getItem().equals(MCPaintballItems.RED_REMOTE.value()) && Selected.equals(MCPaintballBlocks.RED_C4.value()))
        {
            handleRemote(stack, level, pos, player, StackTag, Devices);
            return;
        }
        if(stack.getItem().equals(MCPaintballItems.GREEN_REMOTE.value()) && Selected.equals(MCPaintballBlocks.GREEN_C4.value()))
        {
            handleRemote(stack, level, pos, player, StackTag, Devices);
        }
        if(stack.getItem().equals(MCPaintballItems.BLUE_REMOTE.value()) && Selected.equals(MCPaintballBlocks.BLUE_C4.value()))
        {
            handleRemote(stack, level, pos, player, StackTag, Devices);
        }
    }

    private static void handleRemote(ItemStack stack, Level level, BlockPos pos, Player player, CompoundTag stackTag, ListTag devices) {
        if(player.isShiftKeyDown())
        {
            devices.add(LongTag.valueOf(pos.asLong()));
            level.playSound(null,player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS);
        }
        else
        {
            devices.remove(LongTag.valueOf(pos.asLong()));
            level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_REMOVED.get(),SoundSource.PLAYERS);
        }
        stackTag.put("devices", devices);
        stack.setTag(stackTag);
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
                });
                if (Trigger.get())
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_EXPLODE.get(), SoundSource.PLAYERS, 1f, 1f);
                stack.setTag(new CompoundTag());
            }
        }
    }
}

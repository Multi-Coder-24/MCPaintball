package org.multicoder.mcpaintball.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static net.minecraft.nbt.Tag.TAG_LONG;
import static net.minecraft.sounds.SoundSource.PLAYERS;
import static net.minecraft.world.level.Level.ExplosionInteraction.NONE;
import static net.minecraft.world.level.block.Blocks.AIR;
import static org.multicoder.mcpaintball.init.MCPaintballItems.*;
import static org.multicoder.mcpaintball.init.MCPaintballBlocks.*;
import static org.multicoder.mcpaintball.init.MCPaintballSounds.*;


public class NBTHelper
{
    public static void C4SetRem(ItemStack stack, Block Selected, Level level, BlockPos pos, Player player)
    {
        CompoundTag StackTag = stack.getOrCreateTag();
        ListTag Devices = StackTag.contains("devices") ? StackTag.getList("devices",TAG_LONG) : new ListTag();
        if(stack.getItem().equals(RED_REMOTE.value()) && Selected.equals(RED_C4.value()))
        {
            handleRemote(stack, level, pos, player, StackTag, Devices);
            return;
        }
        if(stack.getItem().equals(GREEN_REMOTE.value()) && Selected.equals(GREEN_C4.value()))
        {
            handleRemote(stack, level, pos, player, StackTag, Devices);
        }
        if(stack.getItem().equals(BLUE_REMOTE.value()) && Selected.equals(BLUE_C4.value()))
        {
            handleRemote(stack, level, pos, player, StackTag, Devices);
        }
    }

    private static void handleRemote(ItemStack stack, Level level, BlockPos pos, Player player, CompoundTag stackTag, ListTag devices) {
        if(player.isShiftKeyDown())
        {
            devices.add(LongTag.valueOf(pos.asLong()));
            level.playSound(null,player.blockPosition(), C4_ADDED.get(), PLAYERS);
        }
        else
        {
            devices.remove(LongTag.valueOf(pos.asLong()));
            level.playSound(null,player.blockPosition(),C4_REMOVED.get(), PLAYERS);
        }
        stackTag.put("devices", devices);
        stack.setTag(stackTag);
    }

    public static void C4Det(ItemStack stack, Level level, Player player) {
        CompoundTag StackTag = stack.getOrCreateTag();
        ListTag Devices = StackTag.contains("devices") ? StackTag.getList("devices", TAG_LONG) : new ListTag();
        if (!Devices.isEmpty())
        {
            if (player.isShiftKeyDown())
            {
                AtomicBoolean Trigger = new AtomicBoolean(false);
                Devices.forEach(position ->
                {
                    BlockPos blockPosition = BlockPos.of(((LongTag) position).getAsLong());
                    if (stack.getItem().equals(RED_REMOTE.value()) && level.getBlockState(blockPosition).getBlock().equals(RED_C4.value())) {
                        Trigger.set(true);
                        level.explode(null, blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), 5f, NONE);
                        level.setBlockAndUpdate(blockPosition, AIR.defaultBlockState());
                    }
                    if (stack.getItem().equals(GREEN_REMOTE.value()) && level.getBlockState(blockPosition).getBlock().equals(GREEN_C4.value())) {
                        Trigger.set(true);
                        level.explode(null, blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), 5f, NONE);
                        level.setBlockAndUpdate(blockPosition, AIR.defaultBlockState());
                    }
                    if (stack.getItem().equals(BLUE_REMOTE.value()) && level.getBlockState(blockPosition).getBlock().equals(BLUE_C4.value())) {
                        Trigger.set(true);
                        level.explode(null, blockPosition.getX(), blockPosition.getY(), blockPosition.getZ(), 5f, NONE);
                        level.setBlockAndUpdate(blockPosition, AIR.defaultBlockState());
                    }
                });
                if (Trigger.get()) level.playSound(null, player.blockPosition(), C4_EXPLODE.get(), PLAYERS, 1f, 1f);
                stack.setTag(new CompoundTag());
            }
        }
    }
}

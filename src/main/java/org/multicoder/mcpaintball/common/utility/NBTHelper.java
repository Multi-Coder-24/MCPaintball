package org.multicoder.mcpaintball.common.utility;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.blockentities.SoloC4PaintballBlockEntity;
import org.multicoder.mcpaintball.common.blocks.MCPaintballBlocks;
import org.multicoder.mcpaintball.common.data.containers.C4LocationData;
import org.multicoder.mcpaintball.common.data.containers.MCPaintballDataContainers;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings("all")
public class NBTHelper {
    public static void C4SetRem(ItemStack stack, Block Selected, Level level, BlockPos pos, Player player) {
        C4LocationData DataComponent = stack.get(MCPaintballDataContainers.C4_REMOTE);
        if (stack.getItem().equals(MCPaintballItems.RED_REMOTE.value()) && Selected.equals(MCPaintballBlocks.RED_C4.value())) {
            if (Screen.hasShiftDown()) {
                DataComponent.Positions().add(pos.asLong());
                level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
            } else {
                DataComponent.Positions().remove(pos.asLong());
                level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_REMOVED.get(), SoundSource.PLAYERS, 1f, 1f);
            }
        } else if (stack.getItem().equals(MCPaintballItems.GREEN_REMOTE.value()) && Selected.equals(MCPaintballBlocks.GREEN_C4.value())) {
            if (Screen.hasShiftDown()) {
                DataComponent.Positions().add(pos.asLong());
                level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
            } else {
                DataComponent.Positions().remove(pos.asLong());
                level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_REMOVED.get(), SoundSource.PLAYERS, 1f, 1f);
            }
        } else if (stack.getItem().equals(MCPaintballItems.BLUE_REMOTE.value()) && Selected.equals(MCPaintballBlocks.BLUE_C4.value())) {
            if (Screen.hasShiftDown()) {
                DataComponent.Positions().add(pos.asLong());
                level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
            } else {
                DataComponent.Positions().remove(pos.asLong());
                level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_REMOVED.get(), SoundSource.PLAYERS, 1f, 1f);
            }
        } else if (stack.getItem().equals(MCPaintballItems.SOLO_REMOTE.value()) && Selected.equals(MCPaintballBlocks.SOLO_C4.value())) {
            SoloC4PaintballBlockEntity E = (SoloC4PaintballBlockEntity) level.getBlockEntity(pos);
            if (E.IsSamePlayer(player)) {
                if (Screen.hasShiftDown()) {
                    DataComponent.Positions().add(pos.asLong());
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS, 1f, 1f);
                } else {
                    DataComponent.Positions().remove(pos.asLong());
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_REMOVED.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
        }
        stack.set(MCPaintballDataContainers.C4_REMOTE, DataComponent);
    }

    public static void C4Det(ItemStack stack, Level level, Player player) {
        AtomicBoolean Trigger = new AtomicBoolean(false);
        C4LocationData DataComponent = stack.get(MCPaintballDataContainers.C4_REMOTE);
        if (!DataComponent.Positions().isEmpty()) {
            if (Screen.hasControlDown()) {
                DataComponent.Positions().forEach(pos ->
                {
                    BlockPos Pos = BlockPos.of(pos);
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
                    } else if (stack.getItem().equals(MCPaintballItems.SOLO_REMOTE.value())) {
                        if (level.getBlockState(Pos).getBlock().equals(MCPaintballBlocks.SOLO_C4.value())) {
                            SoloC4PaintballBlockEntity E = (SoloC4PaintballBlockEntity) level.getBlockEntity(Pos);
                            if (E.IsSamePlayer(player)) {
                                level.explode(null, Pos.getX(), Pos.getY(), Pos.getZ(), 5f, Level.ExplosionInteraction.NONE);
                                level.setBlockAndUpdate(Pos, Blocks.AIR.defaultBlockState());
                                Trigger.set(true);
                            }
                        }
                    }
                });
                DataComponent.Positions().clear();
                stack.set(MCPaintballDataContainers.C4_REMOTE, DataComponent);
                if (Trigger.get()) {
                    level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_EXPLODE.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
        }
    }
}

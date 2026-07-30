package org.multicoder.mcpaintball.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class FlagBlock extends Block{

    public FlagBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void playerDestroy(Level level, @NonNull Player player, @NonNull BlockPos pos, @NonNull BlockState state, @Nullable BlockEntity blockEntity, @NonNull ItemStack destroyedWith) {
        if(!level.isClientSide()){
            ServerLevel serverLevel = (ServerLevel) level;
            if(state.getBlock() == MCPaintballBlocks.RED_FLAG){
                ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 1).findFirst().orElse((ServerPlayer) player);
                team.sendSystemMessage(Component.translatable("text.mcpaintball.flag_destroyed",Component.literal(pos.getX() + " " + pos.getY() + " " + pos.getZ())));
            }if(state.getBlock() == MCPaintballBlocks.GREEN_FLAG){
                ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 2).findFirst().orElse((ServerPlayer) player);
                team.sendSystemMessage(Component.translatable("text.mcpaintball.flag_destroyed",Component.literal(pos.getX() + " " + pos.getY() + " " + pos.getZ())));
            }if(state.getBlock() == MCPaintballBlocks.BLUE_FLAG){
                ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 3).findFirst().orElse((ServerPlayer) player);
                team.sendSystemMessage(Component.translatable("text.mcpaintball.flag_destroyed",Component.literal(pos.getX() + " " + pos.getY() + " " + pos.getZ())));
            }if(state.getBlock() == MCPaintballBlocks.YELLOW_FLAG){
                ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 4).findFirst().orElse((ServerPlayer) player);
                team.sendSystemMessage(Component.translatable("text.mcpaintball.flag_destroyed",Component.literal(pos.getX() + " " + pos.getY() + " " + pos.getZ())));
            }if(state.getBlock() == MCPaintballBlocks.PINK_FLAG){
                ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 5).findFirst().orElse((ServerPlayer) player);
                team.sendSystemMessage(Component.translatable("text.mcpaintball.flag_destroyed",Component.literal(pos.getX() + " " + pos.getY() + " " + pos.getZ())));
            }if(state.getBlock() == MCPaintballBlocks.ORANGE_FLAG){
                ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 6).findFirst().orElse((ServerPlayer) player);
                team.sendSystemMessage(Component.translatable("text.mcpaintball.flag_destroyed",Component.literal(pos.getX() + " " + pos.getY() + " " + pos.getZ())));
            }
        }
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }

    @Override
    protected @NonNull InteractionResult useItemOn(@NonNull ItemStack itemStack, @NonNull BlockState state, Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull InteractionHand hand, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                ServerLevel serverLevel = (ServerLevel) level;
                if(state.getBlock() == MCPaintballBlocks.RED_FLAG && itemStack.getItem() != MCPaintballBlocks.RED_FLAG.asItem()){
                    MCPaintballGameEvents.INSTANCE.RedPoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    if(itemStack.getItem() == MCPaintballBlocks.RED_FLAG.asItem()){
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 1).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.RED_FLAG.asItem()));
                    } else if (itemStack.getItem() == MCPaintballBlocks.GREEN_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 2).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.GREEN_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.BLUE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 3).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.BLUE_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.YELLOW_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 4).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.YELLOW_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.PINK_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 5).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.PINK_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.ORANGE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 6).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.ORANGE_FLAG.asItem()));
                    }
                }else if(state.getBlock() == MCPaintballBlocks.GREEN_FLAG && itemStack.getItem() != MCPaintballBlocks.GREEN_FLAG.asItem()){
                    MCPaintballGameEvents.INSTANCE.GreenPoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    if(itemStack.getItem() == MCPaintballBlocks.RED_FLAG.asItem()){
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 1).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.RED_FLAG.asItem()));
                    } else if (itemStack.getItem() == MCPaintballBlocks.GREEN_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 2).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.GREEN_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.BLUE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 3).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.BLUE_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.YELLOW_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 4).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.YELLOW_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.PINK_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 5).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.PINK_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.ORANGE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 6).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.ORANGE_FLAG.asItem()));
                    }
                }else if(state.getBlock() == MCPaintballBlocks.BLUE_FLAG && itemStack.getItem() != MCPaintballBlocks.BLUE_FLAG.asItem()){
                    MCPaintballGameEvents.INSTANCE.BluePoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    if(itemStack.getItem() == MCPaintballBlocks.RED_FLAG.asItem()){
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 1).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.RED_FLAG.asItem()));
                    } else if (itemStack.getItem() == MCPaintballBlocks.GREEN_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 2).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.GREEN_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.BLUE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 3).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.BLUE_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.YELLOW_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 4).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.YELLOW_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.PINK_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 5).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.PINK_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.ORANGE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 6).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.ORANGE_FLAG.asItem()));
                    }
                }else if(state.getBlock() == MCPaintballBlocks.YELLOW_FLAG && itemStack.getItem() != MCPaintballBlocks.YELLOW_FLAG.asItem()){
                    MCPaintballGameEvents.INSTANCE.YellowPoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    if(itemStack.getItem() == MCPaintballBlocks.RED_FLAG.asItem()){
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 1).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.RED_FLAG.asItem()));
                    } else if (itemStack.getItem() == MCPaintballBlocks.GREEN_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 2).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.GREEN_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.BLUE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 3).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.BLUE_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.YELLOW_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 4).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.YELLOW_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.PINK_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 5).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.PINK_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.ORANGE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 6).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.ORANGE_FLAG.asItem()));
                    }
                }else if(state.getBlock() == MCPaintballBlocks.PINK_FLAG && itemStack.getItem() != MCPaintballBlocks.PINK_FLAG.asItem()){
                    MCPaintballGameEvents.INSTANCE.PinkPoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    if(itemStack.getItem() == MCPaintballBlocks.RED_FLAG.asItem()){
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 1).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.RED_FLAG.asItem()));
                    } else if (itemStack.getItem() == MCPaintballBlocks.GREEN_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 2).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.GREEN_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.BLUE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 3).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.BLUE_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.YELLOW_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 4).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.YELLOW_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.PINK_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 5).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.PINK_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.ORANGE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 6).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.ORANGE_FLAG.asItem()));
                    }
                }else if(state.getBlock() == MCPaintballBlocks.ORANGE_FLAG && itemStack.getItem() != MCPaintballBlocks.ORANGE_FLAG.asItem()){
                    MCPaintballGameEvents.INSTANCE.OrangePoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    if(itemStack.getItem() == MCPaintballBlocks.RED_FLAG.asItem()){
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 1).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.RED_FLAG.asItem()));
                    } else if (itemStack.getItem() == MCPaintballBlocks.GREEN_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 2).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.GREEN_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.BLUE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 3).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.BLUE_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.YELLOW_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 4).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.YELLOW_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.PINK_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 5).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.PINK_FLAG.asItem()));
                    }else if (itemStack.getItem() == MCPaintballBlocks.ORANGE_FLAG.asItem()) {
                        ServerPlayer team = serverLevel.getServer().getPlayerList().getPlayers().stream().filter(x -> Objects.requireNonNull(x.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team == 6).findFirst().orElse((ServerPlayer) player);
                        team.addItem(new ItemStack(MCPaintballBlocks.ORANGE_FLAG.asItem()));
                    }
                }
            }
        }
        return super.useItemOn(itemStack, state, level, pos, player, hand, hitResult);
    }
}

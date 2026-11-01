package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.util.PlayManager;

public class ShotgunItem extends Item {

    public ShotgunItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            ServerLevel serverLevel = (ServerLevel) level;
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if(PlayManager.IsValid(serverLevel.getServer(), serverPlayer)){
                ItemStack weaponItemStack = serverPlayer.getItemInHand(hand);
                PlayManager.HandlePaintball(serverPlayer,serverLevel,-16f,3f,0.1f,weaponItemStack);
                PlayManager.HandlePaintball(serverPlayer,serverLevel,0f,3f,0.1f,weaponItemStack);
                PlayManager.HandlePaintball(serverPlayer,serverLevel,16f,3f,0.1f,weaponItemStack);
                serverLevel.playSound(null,serverPlayer, MCPaintballSounds.SHOT, SoundSource.PLAYERS,1f,1f);
                serverPlayer.getCooldowns().addCooldown(weaponItemStack,40);
            }
        }
        return super.use(level, player, hand);
    }
}

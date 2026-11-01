package org.multicoder.mcpaintball.item.weapon.grenades;

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
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.PaintGrenadeEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.PlayManager;

import java.util.Objects;

public class PaintGrenadeItem extends Item {

    public PaintGrenadeItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            ServerLevel serverLevel = (ServerLevel) level;
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if(PlayManager.IsValid(serverLevel.getServer(),serverPlayer)){
                ItemStack heldStack = serverPlayer.getItemInHand(hand);
                if(PlayManager.HandlePaintGrenade(serverPlayer,serverLevel,heldStack)){
                    heldStack.shrink(1);
                    serverPlayer.getCooldowns().addCooldown(heldStack,20);
                }
            }
        }
        return super.use(level, player, hand);
    }
}

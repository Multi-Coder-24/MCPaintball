package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.PaintballEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class SniperRifleItem extends Item {

    public SniperRifleItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.tournamentStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                EntityType<PaintballEntity> paintballType = data.getFromTeam();
                PaintballEntity paintball = new PaintballEntity(paintballType,player,level,player.getItemInHand(hand));
                Objects.requireNonNull(paintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,8.0F,0.1F);
                level.addFreshEntity(paintball);
                player.getCooldowns().addCooldown(player.getItemInHand(hand),60);
                level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT, SoundSource.PLAYERS,1f,1f);
                return InteractionResult.CONSUME;
            }
            else {
                player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_use"));
            }
        }
        return super.use(level, player, hand);
    }
}

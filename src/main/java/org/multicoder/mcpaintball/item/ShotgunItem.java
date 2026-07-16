package org.multicoder.mcpaintball.item;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.BluePaintballEntity;
import org.multicoder.mcpaintball.entity.GreenPaintballEntity;
import org.multicoder.mcpaintball.entity.RedPaintballEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class ShotgunItem extends Item {

    public ShotgunItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                boolean Fired = false;
                switch (data.Team){
                    case 1:
                        RedPaintballEntity redPaintball1 = new RedPaintballEntity(player,level,player.getItemInHand(hand));
                        RedPaintballEntity redPaintball2 = new RedPaintballEntity(player,level,player.getItemInHand(hand));
                        RedPaintballEntity redPaintball3 = new RedPaintballEntity(player,level,player.getItemInHand(hand));
                        Objects.requireNonNull(redPaintball1).shootFromRotation(player,player.getXRot(),player.getYRot() - 3f,0.0F,4.0F,0.4F);
                        Objects.requireNonNull(redPaintball2).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,4.0F,0.4F);
                        Objects.requireNonNull(redPaintball3).shootFromRotation(player,player.getXRot(),player.getYRot() + 3f,0.0F,4.0F,0.4F);
                        level.addFreshEntity(redPaintball1);
                        level.addFreshEntity(redPaintball2);
                        level.addFreshEntity(redPaintball3);
                        Fired = true;
                        break;
                    case 2:
                        GreenPaintballEntity greenPaintball1 = new GreenPaintballEntity(player,level,player.getItemInHand(hand));
                        GreenPaintballEntity greenPaintball2 = new GreenPaintballEntity(player,level,player.getItemInHand(hand));
                        GreenPaintballEntity greenPaintball3 = new GreenPaintballEntity(player,level,player.getItemInHand(hand));
                        Objects.requireNonNull(greenPaintball1).shootFromRotation(player,player.getXRot(),player.getYRot() - 3f,0.0F,4.0F,0.4F);
                        Objects.requireNonNull(greenPaintball2).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,4.0F,0.4F);
                        Objects.requireNonNull(greenPaintball3).shootFromRotation(player,player.getXRot(),player.getYRot() + 3f,0.0F,4.0F,0.4F);
                        level.addFreshEntity(greenPaintball1);
                        level.addFreshEntity(greenPaintball2);
                        level.addFreshEntity(greenPaintball3);
                        Fired = true;
                        break;
                    case 3:
                        BluePaintballEntity bluePaintball1 = new BluePaintballEntity(player,level,player.getItemInHand(hand));
                        BluePaintballEntity bluePaintball2 = new BluePaintballEntity(player,level,player.getItemInHand(hand));
                        BluePaintballEntity bluePaintball3 = new BluePaintballEntity(player,level,player.getItemInHand(hand));
                        Objects.requireNonNull(bluePaintball1).shootFromRotation(player,player.getXRot(),player.getYRot() - 3f,0.0F,4.0F,0.4F);
                        Objects.requireNonNull(bluePaintball2).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,4.0F,0.4F);
                        Objects.requireNonNull(bluePaintball3).shootFromRotation(player,player.getXRot(),player.getYRot() + 3f,0.0F,4.0F,0.4F);
                        level.addFreshEntity(bluePaintball1);
                        level.addFreshEntity(bluePaintball2);
                        level.addFreshEntity(bluePaintball3);
                        Fired = true;
                        break;
                }
                if(Fired){
                    player.getCooldowns().addCooldown(player.getItemInHand(hand),40);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT.get(), SoundSource.PLAYERS,1f,1f);
                    return InteractionResult.CONSUME;
                }
            }
            else {
                player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_use"));
            }
        }
        return super.use(level, player, hand);
    }
}

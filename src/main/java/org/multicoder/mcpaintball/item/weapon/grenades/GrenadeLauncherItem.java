package org.multicoder.mcpaintball.item.weapon.grenades;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.*;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class GrenadeLauncherItem extends Item {

    public GrenadeLauncherItem(Properties properties) {super(properties);}

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                boolean Fired = false;
                switch (data.Team){
                    case 1:
                        RedPaintGrenadeEntity redPaintGrenade = new RedPaintGrenadeEntity(MCPaintballEntities.RED_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                        Objects.requireNonNull(redPaintGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(redPaintGrenade);
                        Fired = true;
                        break;
                    case 2:
                        GreenPaintGrenadeEntity greenPaintGrenade = new GreenPaintGrenadeEntity(MCPaintballEntities.GREEN_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                        Objects.requireNonNull(greenPaintGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(greenPaintGrenade);
                        Fired = true;
                        break;
                    case 3:
                        BluePaintGrenadeEntity bluePaintGrenade = new BluePaintGrenadeEntity(MCPaintballEntities.BLUE_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                        Objects.requireNonNull(bluePaintGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(bluePaintGrenade);
                        Fired = true;
                        break;
                }
                if(Fired){
                    player.getCooldowns().addCooldown(player.getItemInHand(hand),80);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT, SoundSource.PLAYERS,1f,1f);
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

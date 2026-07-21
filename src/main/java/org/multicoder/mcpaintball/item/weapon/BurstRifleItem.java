package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.BluePaintballEntity;
import org.multicoder.mcpaintball.entity.GreenPaintballEntity;
import org.multicoder.mcpaintball.entity.RedPaintballEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class BurstRifleItem extends Item {

    public BurstRifleItem(Properties properties) {super(properties);}

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                boolean Fired = false;
                switch (data.Team){
                    case 1:
                        Thread T1 = new Thread(() -> {
                            try {
                                for(int i = 0; i < 3; i++){
                                    RedPaintballEntity redPaintball = new RedPaintballEntity(player,level,player.getItemInHand(hand));
                                    Objects.requireNonNull(redPaintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                                    level.addFreshEntity(redPaintball);
                                    level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT.get(), SoundSource.PLAYERS,1f,1f);
                                    Thread.sleep(100);
                                }
                            } catch (Exception e) {
                                MCPaintball.LOGGER.error("Exception Using Burst Rifle",e);
                            }
                        });
                        T1.start();
                        Fired = true;
                        break;
                    case 2:
                        Thread T2 = new Thread(() -> {
                            try {
                                for(int i = 0; i < 3; i++){
                                    GreenPaintballEntity greenPaintball = new GreenPaintballEntity(player,level,player.getItemInHand(hand));
                                    Objects.requireNonNull(greenPaintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                                    level.addFreshEntity(greenPaintball);
                                    level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT.get(), SoundSource.PLAYERS,1f,1f);
                                    Thread.sleep(100);
                                }
                            } catch (Exception e) {
                                MCPaintball.LOGGER.error("Exception Using Burst Rifle",e);
                            }
                        });
                        T2.start();
                        Fired = true;
                        break;
                    case 3:
                        Thread T3 = new Thread(() -> {
                            try {
                                for(int i = 0; i < 3; i++){
                                    BluePaintballEntity bluePaintball = new BluePaintballEntity(player,level,player.getItemInHand(hand));
                                    Objects.requireNonNull(bluePaintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                                    level.addFreshEntity(bluePaintball);
                                    level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT.get(), SoundSource.PLAYERS,1f,1f);
                                    Thread.sleep(100);
                                }
                            } catch (Exception e) {
                                MCPaintball.LOGGER.error("Exception Using Burst Rifle",e);
                            }
                        });
                        T3.start();
                        Fired = true;
                        break;
                }
                if(Fired){
                    player.getCooldowns().addCooldown(player.getItemInHand(hand),60);
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

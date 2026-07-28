package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.PaintballEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class BurstRifleItem extends Item {

    public BurstRifleItem(Properties properties) {super(properties);}

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                if(data.Team != 0){
                    EntityType<? extends AbstractArrow> type = switch (data.Team){
                        case 1 -> MCPaintballEntities.RED_PAINTBALL.get();
                        case 2 -> MCPaintballEntities.GREEN_PAINTBALL.get();
                        case 3 -> MCPaintballEntities.BLUE_PAINTBALL.get();
                        case 4 -> MCPaintballEntities.YELLOW_PAINTBALL.get();
                        default -> throw new IllegalStateException("Unexpected value: " + data.Team);
                    };
                    Thread T1 = new Thread(() -> {
                        try {
                            for(int i = 0; i < 3; i++){
                                PaintballEntity paintball = new PaintballEntity(type,player,level,player.getItemInHand(hand));
                                Objects.requireNonNull(paintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                                level.addFreshEntity(paintball);
                                level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT.get(), SoundSource.PLAYERS,1f,1f);
                                Thread.sleep(100);
                            }
                        } catch (Exception e) {
                            MCPaintball.LOGGER.error("Exception Using Burst Rifle",e);
                        }
                    });
                    T1.start();
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

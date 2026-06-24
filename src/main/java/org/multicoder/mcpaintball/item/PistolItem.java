package org.multicoder.mcpaintball.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.BluePaintballEntity;
import org.multicoder.mcpaintball.entity.GreenPaintballEntity;
import org.multicoder.mcpaintball.entity.RedPaintballEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class PistolItem extends Item {

    public PistolItem(Properties properties) {super(properties);}

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                boolean Fired = false;
                switch (data.Team){
                    case 1:
                        RedPaintballEntity redPaintball = new RedPaintballEntity(player,level,player.getItemInHand(hand));
                        Objects.requireNonNull(redPaintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(redPaintball);
                        Fired = true;
                        break;
                    case 2:
                        GreenPaintballEntity greenPaintball = new GreenPaintballEntity(player,level,player.getItemInHand(hand));
                        Objects.requireNonNull(greenPaintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(greenPaintball);
                        Fired = true;
                        break;
                    case 3:
                        BluePaintballEntity bluePaintball = new BluePaintballEntity(player,level,player.getItemInHand(hand));
                        Objects.requireNonNull(bluePaintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(bluePaintball);
                        Fired = true;
                        break;
                }
                if(Fired){
                    player.getCooldowns().addCooldown(player.getItemInHand(hand),30);
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

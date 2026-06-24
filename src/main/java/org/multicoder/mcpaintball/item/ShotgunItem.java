package org.multicoder.mcpaintball.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.BluePaintballEntity;
import org.multicoder.mcpaintball.entity.GreenPaintballEntity;
import org.multicoder.mcpaintball.entity.RedPaintballEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

public class ShotgunItem extends Item {

    public ShotgunItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                boolean Fired = false;
                switch (data.Team){
                    case 1:
                        RedPaintballEntity redPaintball1 = new RedPaintballEntity(MCPaintballEntities.RED_PAINTBALL,level);
                        RedPaintballEntity redPaintball2 = new RedPaintballEntity(MCPaintballEntities.RED_PAINTBALL,level);
                        RedPaintballEntity redPaintball3 = new RedPaintballEntity(MCPaintballEntities.RED_PAINTBALL,level);
                        redPaintball1.shootFromRotation(player,player.getXRot(),player.getYRot() - 3f,0.0F,4.0F,0.4F);
                        redPaintball2.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,4.0F,0.4F);
                        redPaintball3.shootFromRotation(player,player.getXRot(),player.getYRot() + 3f,0.0F,4.0F,0.4F);
                        level.addFreshEntity(redPaintball1);
                        level.addFreshEntity(redPaintball2);
                        level.addFreshEntity(redPaintball3);
                        Fired = true;
                        break;
                    case 2:
                        GreenPaintballEntity greenPaintball1 = new GreenPaintballEntity(MCPaintballEntities.GREEN_PAINTBALL,level);
                        GreenPaintballEntity greenPaintball2 = new GreenPaintballEntity(MCPaintballEntities.GREEN_PAINTBALL,level);
                        GreenPaintballEntity greenPaintball3 = new GreenPaintballEntity(MCPaintballEntities.GREEN_PAINTBALL,level);
                        greenPaintball1.shootFromRotation(player,player.getXRot(),player.getYRot() - 3f,0.0F,4.0F,0.4F);
                        greenPaintball2.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,4.0F,0.4F);
                        greenPaintball3.shootFromRotation(player,player.getXRot(),player.getYRot() + 3f,0.0F,4.0F,0.4F);
                        level.addFreshEntity(greenPaintball1);
                        level.addFreshEntity(greenPaintball2);
                        level.addFreshEntity(greenPaintball3);
                        Fired = true;
                        break;
                    case 3:
                        BluePaintballEntity bluePaintball1 = new BluePaintballEntity(MCPaintballEntities.BLUE_PAINTBALL,level);
                        BluePaintballEntity bluePaintball2 = new BluePaintballEntity(MCPaintballEntities.BLUE_PAINTBALL,level);
                        BluePaintballEntity bluePaintball3 = new BluePaintballEntity(MCPaintballEntities.BLUE_PAINTBALL,level);
                        bluePaintball1.shootFromRotation(player,player.getXRot(),player.getYRot() - 3f,0.0F,4.0F,0.4F);
                        bluePaintball2.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,4.0F,0.4F);
                        bluePaintball3.shootFromRotation(player,player.getXRot(),player.getYRot() + 3f,0.0F,4.0F,0.4F);
                        level.addFreshEntity(bluePaintball1);
                        level.addFreshEntity(bluePaintball2);
                        level.addFreshEntity(bluePaintball3);
                        Fired = true;
                        break;
                }
                if(Fired){
                    player.getCooldowns().addCooldown(player.getItemInHand(hand),40);
                    return InteractionResult.CONSUME;
                }
            }
        }
        return super.use(level, player, hand);
    }
}

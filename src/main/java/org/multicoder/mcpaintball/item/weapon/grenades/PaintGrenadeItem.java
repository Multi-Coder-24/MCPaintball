package org.multicoder.mcpaintball.item.weapon.grenades;

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

import java.util.Objects;

public class PaintGrenadeItem extends Item {

    public PaintGrenadeItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.tournamentStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                ItemStack held =  player.getItemInHand(hand);
                PaintGrenadeEntity entity;
                MCPaintballPlayerData data = Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER));
                if(held.getItem() == MCPaintballItems.RED_PAINT_GRENADE && data.team == 1){
                    entity = new PaintGrenadeEntity(MCPaintballEntities.RED_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                }else if(held.getItem() == MCPaintballItems.GREEN_PAINT_GRENADE && data.team == 2){
                    entity = new PaintGrenadeEntity(MCPaintballEntities.GREEN_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                }else if(held.getItem() == MCPaintballItems.BLUE_PAINT_GRENADE && data.team == 3){
                    entity = new PaintGrenadeEntity(MCPaintballEntities.BLUE_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                }else if(held.getItem() == MCPaintballItems.YELLOW_PAINT_GRENADE && data.team == 4){
                    entity = new PaintGrenadeEntity(MCPaintballEntities.YELLOW_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                }else if(held.getItem() == MCPaintballItems.PINK_PAINT_GRENADE && data.team == 5){
                    entity = new PaintGrenadeEntity(MCPaintballEntities.PINK_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                }else if(held.getItem() == MCPaintballItems.ORANGE_PAINT_GRENADE && data.team == 6){
                    entity = new PaintGrenadeEntity(MCPaintballEntities.ORANGE_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                }else {return InteractionResult.FAIL;}
                entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE, SoundSource.PLAYERS,1f,1f);
                level.addFreshEntity(entity);
                held.shrink(1);
                player.getCooldowns().addCooldown(held,20);
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(level, player, hand);
    }
}

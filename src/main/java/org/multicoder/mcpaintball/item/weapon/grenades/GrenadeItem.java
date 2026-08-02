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
import org.multicoder.mcpaintball.entity.*;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class GrenadeItem extends Item {

    public GrenadeItem(Properties properties) {
        super(properties.stacksTo(16));
    }

    @Override
    public @NonNull InteractionResult use(Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                ItemStack held = player.getItemInHand(hand);
                if(held.getItem() == MCPaintballItems.RED_PAINT_GRENADE.asItem()){
                    if(Objects.requireNonNull(data).Team == 1){
                        PaintGrenadeEntity entity = new PaintGrenadeEntity(MCPaintballEntities.RED_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                        entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                        level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                        level.addFreshEntity(entity);
                        held.shrink(1);
                    }
                } else if(held.getItem() == MCPaintballItems.GREEN_PAINT_GRENADE.asItem()){
                    if(Objects.requireNonNull(data).Team == 2){
                        PaintGrenadeEntity entity = new PaintGrenadeEntity(MCPaintballEntities.GREEN_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                        entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                        level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                        level.addFreshEntity(entity);
                        held.shrink(1);
                    }
                } else if(held.getItem() == MCPaintballItems.BLUE_PAINT_GRENADE.asItem()){
                    if(Objects.requireNonNull(data).Team == 3){
                        PaintGrenadeEntity entity = new PaintGrenadeEntity(MCPaintballEntities.BLUE_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                        entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                        level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                        level.addFreshEntity(entity);
                        held.shrink(1);
                    }
                } else if(held.getItem() == MCPaintballItems.YELLOW_PAINT_GRENADE.asItem()){
                    if(Objects.requireNonNull(data).Team == 4){
                        PaintGrenadeEntity entity = new PaintGrenadeEntity(MCPaintballEntities.YELLOW_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                        entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                        level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                        level.addFreshEntity(entity);
                        held.shrink(1);
                    }
                } else if(held.getItem() == MCPaintballItems.PINK_PAINT_GRENADE.asItem()){
                    if(Objects.requireNonNull(data).Team == 5){
                        PaintGrenadeEntity entity = new PaintGrenadeEntity(MCPaintballEntities.PINK_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                        entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                        level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                        level.addFreshEntity(entity);
                        held.shrink(1);
                    }
                } else if(held.getItem() == MCPaintballItems.ORANGE_PAINT_GRENADE.asItem()){
                    if(Objects.requireNonNull(data).Team == 6){
                        PaintGrenadeEntity entity = new PaintGrenadeEntity(MCPaintballEntities.ORANGE_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                        entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                        level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                        level.addFreshEntity(entity);
                        held.shrink(1);
                    }
                } else if(held.getItem() == MCPaintballItems.SMOKE_GRENADE.asItem()){
                    SmokeGrenadeEntity entity = new SmokeGrenadeEntity(MCPaintballEntities.SMOKE_GRENADE.get(),player,level,player.getItemInHand(hand));
                    entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                    level.addFreshEntity(entity);
                    held.shrink(1);
                } else if(held.getItem() == MCPaintballItems.EMP_GRENADE.asItem()){
                    EMPGrenadeEntity entity = new EMPGrenadeEntity(MCPaintballEntities.EMP_GRENADE.get(),player,level,player.getItemInHand(hand));
                    entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                    level.addFreshEntity(entity);
                    held.shrink(1);
                } else if(held.getItem() == MCPaintballItems.SIGHT_GRENADE.asItem()){
                    SightGrenadeEntity entity = new SightGrenadeEntity(MCPaintballEntities.SIGHT_GRENADE.get(),player,level,player.getItemInHand(hand));
                    entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                    level.addFreshEntity(entity);
                    held.shrink(1);
                }
            }
        }
        return super.use(level, player, hand);
    }
}

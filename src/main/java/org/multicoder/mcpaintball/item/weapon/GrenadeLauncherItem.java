package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballGrenadeLauncherSetting;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.*;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class GrenadeLauncherItem extends Item {

    public GrenadeLauncherItem(Properties properties) {
        super(properties.component(MCPaintballDataComponents.SETTING.get(),new MCPaintballGrenadeLauncherSetting(1)).stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                ItemStack itemStack = player.getItemInHand(hand);
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                if(data.Team != 0){
                    boolean Fired = false;
                    int Setting = Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.SETTING)).Setting();
                    if(Setting == 1){
                        EntityType<? extends ThrowableItemProjectile> type = switch (data.Team) {
                            case 1 -> MCPaintballEntities.RED_PAINT_GRENADE.get();
                            case 2 -> MCPaintballEntities.GREEN_PAINT_GRENADE.get();
                            case 3 -> MCPaintballEntities.BLUE_PAINT_GRENADE.get();
                            case 4 -> MCPaintballEntities.YELLOW_PAINT_GRENADE.get();
                            case 5 -> MCPaintballEntities.PINK_PAINT_GRENADE.get();
                            case 6 -> MCPaintballEntities.ORANGE_PAINT_GRENADE.get();
                            default -> throw new IllegalStateException("Unexpected value: " + data.Team);
                        };
                        PaintGrenadeEntity paintball = new PaintGrenadeEntity(type,player,level,itemStack);
                        Objects.requireNonNull(paintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(paintball);
                        Fired = true;
                    }else if(Setting == 2){
                        SmokeGrenadeEntity smokeGrenade = new SmokeGrenadeEntity(MCPaintballEntities.SMOKE_GRENADE.get(),player,level,itemStack);
                        Objects.requireNonNull(smokeGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(smokeGrenade);
                        Fired = true;

                    }else if(Setting == 3){
                        EMPGrenadeEntity empGrenade = new EMPGrenadeEntity(MCPaintballEntities.EMP_GRENADE.get(),player,level,itemStack);
                        Objects.requireNonNull(empGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(empGrenade);
                        Fired = true;

                    }else if(Setting == 4){
                        SightGrenadeEntity sightGrenade = new SightGrenadeEntity(MCPaintballEntities.SIGHT_GRENADE.get(),player,level,itemStack);
                        Objects.requireNonNull(sightGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                        level.addFreshEntity(sightGrenade);
                        Fired = true;
                    }
                    if(Fired){
                        player.getCooldowns().addCooldown(player.getItemInHand(hand),80);
                        level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT.get(), SoundSource.PLAYERS,1f,1f);
                        return InteractionResult.CONSUME;
                    }
                }
            }
            else {
                player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_use"));
            }
        }
        return super.use(level, player, hand);
    }
}

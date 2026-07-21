package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import org.multicoder.mcpaintball.entity.BluePaintGrenadeEntity;
import org.multicoder.mcpaintball.entity.GreenPaintGrenadeEntity;
import org.multicoder.mcpaintball.entity.RedPaintGrenadeEntity;
import org.multicoder.mcpaintball.entity.SmokeGrenadeEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class GrenadeLauncherItem extends Item {

    public GrenadeLauncherItem(Properties properties) {
        super(properties.component(MCPaintballDataComponents.SETTING.get(),new MCPaintballGrenadeLauncherSetting(1)));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                ItemStack itemStack = player.getItemInHand(hand);
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                boolean Fired = false;
                switch (data.Team){
                    case 1:
                        if(Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.SETTING)).Setting() == 1){
                            RedPaintGrenadeEntity redPaintGrenade = new RedPaintGrenadeEntity(MCPaintballEntities.RED_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(redPaintGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(redPaintGrenade);
                            Fired = true;
                        }else if(Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.SETTING)).Setting() == 2){
                            SmokeGrenadeEntity smokeGrenade = new SmokeGrenadeEntity(MCPaintballEntities.SMOKE_GRENADE.get(),player,level,itemStack);
                            Objects.requireNonNull(smokeGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(smokeGrenade);
                            Fired = true;
                        }
                        break;
                    case 2:
                        if(Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.SETTING)).Setting() == 1){
                            GreenPaintGrenadeEntity greenPaintGrenade = new GreenPaintGrenadeEntity(MCPaintballEntities.GREEN_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(greenPaintGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(greenPaintGrenade);
                            Fired = true;
                        }else if(Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.SETTING)).Setting() == 2){
                            SmokeGrenadeEntity smokeGrenade = new SmokeGrenadeEntity(MCPaintballEntities.SMOKE_GRENADE.get(),player,level,itemStack);
                            Objects.requireNonNull(smokeGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(smokeGrenade);
                            Fired = true;
                        }
                        break;
                    case 3:
                        if(Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.SETTING)).Setting() == 1){
                            BluePaintGrenadeEntity bluePaintGrenade = new BluePaintGrenadeEntity(MCPaintballEntities.BLUE_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(bluePaintGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(bluePaintGrenade);
                            Fired = true;
                        }else if(Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.SETTING)).Setting() == 2){
                            SmokeGrenadeEntity smokeGrenade = new SmokeGrenadeEntity(MCPaintballEntities.SMOKE_GRENADE.get(),player,level,itemStack);
                            Objects.requireNonNull(smokeGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(smokeGrenade);
                            Fired = true;
                        }
                        break;
                }
                if(Fired){
                    player.getCooldowns().addCooldown(player.getItemInHand(hand),80);
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

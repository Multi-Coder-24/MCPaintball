package org.multicoder.mcpaintball.item.weapon.grenades;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
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

    public GrenadeLauncherItem() {
        super(new Properties().component(MCPaintballDataComponents.SETTING,new MCPaintballGrenadeLauncherSetting(1)).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"weapon/grenade_launcher"))).stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            ItemStack itemStack = player.getItemInHand(hand);
            int Setting = Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.SETTING)).Setting();
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                boolean Fired = false;
                switch (data.Team){
                    case 1:
                        if(Setting == 1){
                            RedPaintGrenadeEntity redPaintGrenade = new RedPaintGrenadeEntity(MCPaintballEntities.RED_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(redPaintGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(redPaintGrenade);
                            Fired = true;
                        }else if(Setting == 2){
                            SmokeGrenadeEntity smokeGrenade = new SmokeGrenadeEntity(MCPaintballEntities.SMOKE_GRENADE,player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(smokeGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(smokeGrenade);
                            Fired = true;
                        }
                        break;
                    case 2:
                        if(Setting == 1){
                            GreenPaintGrenadeEntity greenPaintGrenade = new GreenPaintGrenadeEntity(MCPaintballEntities.GREEN_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(greenPaintGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(greenPaintGrenade);
                            Fired = true;
                        }else if(Setting == 2){
                            SmokeGrenadeEntity smokeGrenade = new SmokeGrenadeEntity(MCPaintballEntities.SMOKE_GRENADE,player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(smokeGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(smokeGrenade);
                            Fired = true;
                        }
                        break;
                    case 3:
                        if(Setting == 1){
                            BluePaintGrenadeEntity bluePaintGrenade = new BluePaintGrenadeEntity(MCPaintballEntities.BLUE_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(bluePaintGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(bluePaintGrenade);
                            Fired = true;
                        }else if(Setting == 2){
                            SmokeGrenadeEntity smokeGrenade = new SmokeGrenadeEntity(MCPaintballEntities.SMOKE_GRENADE,player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(smokeGrenade).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(smokeGrenade);
                            Fired = true;
                        }
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

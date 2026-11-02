package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballGrenadeLauncherSetting;
import org.multicoder.mcpaintball.entity.EMPGrenadeEntity;
import org.multicoder.mcpaintball.entity.PaintGrenadeEntity;
import org.multicoder.mcpaintball.entity.SightGrenadeEntity;
import org.multicoder.mcpaintball.entity.SmokeGrenadeEntity;
import org.multicoder.mcpaintball.util.PlayManager;

import java.util.Objects;

public class  GrenadeLauncherItem extends Item {

    public GrenadeLauncherItem(Properties properties) {
        super(properties.component(MCPaintballDataComponents.SETTING,new MCPaintballGrenadeLauncherSetting(1)).stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            ServerLevel serverLevel = (ServerLevel) level;
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if(PlayManager.IsValid(serverLevel.getServer(),serverPlayer)){
                ItemStack heldStack = serverPlayer.getItemInHand(hand);
                MCPaintballGrenadeLauncherSetting setting = heldStack.get(MCPaintballDataComponents.SETTING);
                switch (Objects.requireNonNull(setting).setting()){
                    case 1:
                        if(PlayManager.HandlePaintGrenade(serverPlayer,serverLevel,heldStack)){
                            serverLevel.playSound(null,serverPlayer.blockPosition(), MCPaintballSounds.GRENADE, SoundSource.PLAYERS,1f,1f);
                            serverPlayer.getCooldowns().addCooldown(heldStack,80);
                        }
                        break;
                    case 2:
                        SmokeGrenadeEntity smokeGrenade = new SmokeGrenadeEntity(MCPaintballEntities.SMOKE_GRENADE,serverPlayer,serverLevel,heldStack);
                        smokeGrenade.shootFromRotation(serverPlayer,serverPlayer.getXRot(),serverPlayer.getYRot(),0f,3f,0.1f);
                        serverLevel.addFreshEntity(smokeGrenade);
                        serverLevel.playSound(null,serverPlayer.blockPosition(), MCPaintballSounds.GRENADE, SoundSource.PLAYERS,1f,1f);
                        serverPlayer.getCooldowns().addCooldown(heldStack,80);
                        break;
                    case 3:
                        EMPGrenadeEntity empGrenade = new EMPGrenadeEntity(MCPaintballEntities.EMP_GRENADE,serverPlayer,serverLevel,heldStack);
                        empGrenade.shootFromRotation(serverPlayer,serverPlayer.getXRot(),serverPlayer.getYRot(),0f,3f,0.1f);
                        serverLevel.addFreshEntity(empGrenade);
                        serverLevel.playSound(null,serverPlayer.blockPosition(), MCPaintballSounds.GRENADE, SoundSource.PLAYERS,1f,1f);
                        serverPlayer.getCooldowns().addCooldown(heldStack,80);
                        break;
                    case 4:
                        SightGrenadeEntity sightGrenade = new SightGrenadeEntity(MCPaintballEntities.SIGHT_GRENADE,serverPlayer,serverLevel,heldStack);
                        sightGrenade.shootFromRotation(serverPlayer,serverPlayer.getXRot(),serverPlayer.getYRot(),0f,3f,0.1f);
                        serverLevel.addFreshEntity(sightGrenade);
                        serverLevel.playSound(null,serverPlayer.blockPosition(), MCPaintballSounds.GRENADE, SoundSource.PLAYERS,1f,1f);
                        serverPlayer.getCooldowns().addCooldown(heldStack,80);
                        break;
                }
            }
        }
        return super.use(level, player, hand);
    }
}

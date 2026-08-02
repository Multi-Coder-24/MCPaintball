package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.PaintballEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class BurstRifleItem extends Item {

    public BurstRifleItem() {
        super(new Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"weapon/burst_rifle"))).stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.matchStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                EntityType<PaintballEntity> paintballType = data.getFromTeam();
                Thread thread = new Thread(() -> {
                    try {
                        for(int i = 0; i < 3; i++){
                            PaintballEntity paintball = new PaintballEntity(paintballType,player,level,player.getItemInHand(hand));
                            Objects.requireNonNull(paintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.1F);
                            level.addFreshEntity(paintball);
                            level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT, SoundSource.PLAYERS,1f,1f);
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        MCPaintball.LOGGER.error("Exception Using Burst Rifle",e);
                    }
                });
                thread.start();
                player.getCooldowns().addCooldown(player.getItemInHand(hand),60);
                return InteractionResult.CONSUME;
            }
            else {
                player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_use"));
            }
        }
        return super.use(level, player, hand);
    }
}

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

public class RifleItem extends Item {

    public RifleItem() {
        super(new Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"weapon/assault_rifle"))).stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()) {
            if (MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted) {
                MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                EntityType<? extends AbstractArrow> type = switch (data.Team){
                    case 1 -> MCPaintballEntities.RED_PAINTBALL;
                    case 2 -> MCPaintballEntities.BLUE_PAINTBALL;
                    case 3 -> MCPaintballEntities.GREEN_PAINTBALL;
                    case 4 -> MCPaintballEntities.YELLOW_PAINTBALL;
                    default -> throw new IllegalStateException("Unexpected value: " + data.Team);
                };
                PaintballEntity paintball = new PaintballEntity(type,player,level,player.getItemInHand(hand));
                Objects.requireNonNull(paintball).shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,0.1F);
                level.addFreshEntity(paintball);
                player.getCooldowns().addCooldown(player.getItemInHand(hand), 20);
                level.playSound(null,player.blockPosition(), MCPaintballSounds.SHOT, SoundSource.PLAYERS,1f,1f);
                return InteractionResult.CONSUME;
            }
            else {
                player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_use"));
            }
        }
        return super.use(level, player, hand);
    }
}

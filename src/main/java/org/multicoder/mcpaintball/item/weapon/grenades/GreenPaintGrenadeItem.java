package org.multicoder.mcpaintball.item.weapon.grenades;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.GreenPaintGrenadeEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class GreenPaintGrenadeItem extends Item {

    public GreenPaintGrenadeItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                if(Objects.requireNonNull(data).Team == 2){
                    GreenPaintGrenadeEntity entity = new GreenPaintGrenadeEntity(MCPaintballEntities.GREEN_PAINT_GRENADE.get(),player,level,player.getItemInHand(hand));
                    entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                    level.addFreshEntity(entity);
                }
            }
        }
        return super.use(level, player, hand);
    }
}

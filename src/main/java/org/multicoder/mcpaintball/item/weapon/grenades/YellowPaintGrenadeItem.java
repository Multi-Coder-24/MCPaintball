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
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.entity.YellowPaintGrenadeEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class YellowPaintGrenadeItem extends Item {

    public YellowPaintGrenadeItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                ItemStack held =  player.getItemInHand(hand);
                MCPaintballPlayerData data = player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                if(Objects.requireNonNull(data).Team == 4){
                    YellowPaintGrenadeEntity entity = new YellowPaintGrenadeEntity(MCPaintballEntities.YELLOW_PAINT_GRENADE,player,level,player.getItemInHand(hand));
                    entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE, SoundSource.PLAYERS,1f,1f);
                    level.addFreshEntity(entity);
                    held.shrink(1);
                }
            }
        }
        return super.use(level, player, hand);
    }
}

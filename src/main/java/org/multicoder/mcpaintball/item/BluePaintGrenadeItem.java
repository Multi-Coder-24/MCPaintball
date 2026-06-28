package org.multicoder.mcpaintball.item;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.entity.BluePaintGrenadeEntity;

public class BluePaintGrenadeItem extends Item {

    public BluePaintGrenadeItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        BluePaintGrenadeEntity entity = new BluePaintGrenadeEntity(MCPaintballEntities.BLUE_PAINT_GRENADE,player,level,player.getItemInHand(hand));
        entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
        level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE, SoundSource.PLAYERS,1f,1f);
        level.addFreshEntity(entity);
        return super.use(level, player, hand);
    }
}

package org.multicoder.mcpaintball.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.entity.RedPaintGrenadeEntity;

public class RedPaintGrenadeItem extends Item {

    public RedPaintGrenadeItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()){
            RedPaintGrenadeEntity entity = new RedPaintGrenadeEntity(MCPaintballEntities.RED_PAINT_GRENADE,player,level,player.getItemInHand(hand));
            entity.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,5.0F,1.0F);
            level.addFreshEntity(entity);
        }
        return InteractionResult.CONSUME;
    }
}

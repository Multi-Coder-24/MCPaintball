package org.multicoder.mcpaintball.item.weapon.grenades;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.entity.EMPGrenadeEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

public class EMPGrenadeItem extends Item {

    public EMPGrenadeItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        if(!level.isClientSide()) {
        }
        return super.use(level, player, hand);
    }
}

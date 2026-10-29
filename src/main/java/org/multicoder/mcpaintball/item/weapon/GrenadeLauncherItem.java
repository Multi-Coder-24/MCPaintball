package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
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
import org.multicoder.mcpaintball.entity.EMPGrenadeEntity;
import org.multicoder.mcpaintball.entity.PaintGrenadeEntity;
import org.multicoder.mcpaintball.entity.SightGrenadeEntity;
import org.multicoder.mcpaintball.entity.SmokeGrenadeEntity;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class  GrenadeLauncherItem extends Item {

    public GrenadeLauncherItem(Properties properties) {
        super(properties.component(MCPaintballDataComponents.SETTING,new MCPaintballGrenadeLauncherSetting(1)).stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        //if(!level.isClientSide()){}
        return super.use(level, player, hand);
    }
}

package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.*;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.PlayManager;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class PaintGrenadeEntity extends ThrowableItemProjectile {
    public PaintGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, Level level) {
        super(type, level);
    }

    public PaintGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, LivingEntity owner, Level level, ItemStack itemStack) {
        super(type, owner, level, itemStack);
    }

    @Override
    protected @NonNull Item getDefaultItem() {
        return MCPaintballItems.BLUE_PAINT_GRENADE;
    }

    @Override
    protected void onHit(@NonNull HitResult hitResult) {
        super.onHit(hitResult);
        if(!this.level().isClientSide()){
            BlockPos pos = this.blockPosition();
            ServerLevel serverLevel = (ServerLevel) this.level();
            ServerPlayer serverPlayer = (ServerPlayer) this.getOwner();
            PlayManager.HandlePaintGrenadeHit(serverLevel,(EntityType<PaintGrenadeEntity>) this.getType(),pos,serverPlayer);
        }
        this.discard();
    }
}

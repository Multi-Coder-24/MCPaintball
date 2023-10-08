package org.multicoder.mcpaintball.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.config.MCPaintballConfig;
import org.multicoder.mcpaintball.common.init.iteminit;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("all")
public class PaintballGrenade extends ThrowableItemProjectile {
    public PaintballGrenade(EntityType<?> pEntityType, Level pLevel) {
        super((EntityType<? extends ThrowableItemProjectile>) pEntityType, pLevel);
    }

    public PaintballGrenade(EntityType<? extends ThrowableItemProjectile> pEntityType, LivingEntity pShooter, Level pLevel) {
        super(pEntityType, pShooter, pLevel);
    }


    @Override
    protected void onHit(HitResult pResult) {
        if (Objects.nonNull(this.getOwner())) {
            if (!this.level().isClientSide()) {
                if (getOwner() instanceof ServerPlayer) {
                    ServerPlayer Thrower = (ServerPlayer) getOwner();
                    PaintballPlayer PPlayer = Thrower.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                    BlockPos pos = new BlockPos(((int) pResult.getLocation().x), ((int) pResult.getLocation().y), ((int) pResult.getLocation().z));
                    Explosion ex;
                    if (MCPaintballConfig.EXPLODE_BLOCKS.get()) {
                        ex = this.level().explode(this, pos.getX(), pos.getY(), pos.getZ(), 3, Level.ExplosionInteraction.TNT);
                    } else {
                        ex = this.level().explode(this, pos.getX(), pos.getY(), pos.getZ(), 3, Level.ExplosionInteraction.NONE);
                    }
                    AtomicInteger Points = new AtomicInteger(0);
                    ex.getHitPlayers().keySet().forEach(player ->
                    {
                        if (!Objects.equals(PPlayer.Team, player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get().Team)) {
                            Points.getAndIncrement();
                        }
                    });
                    PPlayer.Points += Points.get();
                    this.kill();
                    this.discard();
                }
            }
        }
    }

    @Override
    protected Item getDefaultItem() {
        return iteminit.PAINTBALL_GRENADE.get();
    }
}

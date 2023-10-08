package org.multicoder.mcpaintball.common.entity;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.config.MCPaintballConfig;
import org.multicoder.mcpaintball.common.util.enums.Teams;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("all")
public class HeavyPaintballEntity extends AbstractArrow {
    public HeavyPaintballEntity(EntityType<?> pEntityType, Level pLevel) {
        super((EntityType<? extends AbstractArrow>) pEntityType, pLevel);
    }

    public HeavyPaintballEntity(EntityType<? extends AbstractArrow> pEntityType, LivingEntity pShooter, Level pLevel) {
        super(pEntityType, pShooter, pLevel);
    }


    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onHit(HitResult pResult) {
        if (Objects.nonNull(this.getOwner())) {
            if (!this.level().isClientSide()) {
                Vec3 Vector = pResult.getLocation();
                ServerPlayer Player = (ServerPlayer) getOwner();
                PaintballPlayer PPlayer = Player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                Teams Shooter = PPlayer.Team;
                Explosion explosion;
                if (MCPaintballConfig.EXPLODE_BLOCKS.get()) {
                    explosion = this.level().explode(null, Vector.x, Vector.y, Vector.z, 2f, Level.ExplosionInteraction.TNT);
                } else {
                    explosion = this.level().explode(null, Vector.x, Vector.y, Vector.z, 2f, Level.ExplosionInteraction.NONE);
                }
                AtomicInteger Points = new AtomicInteger();
                explosion.getHitPlayers().keySet().forEach(player ->
                {
                    if (!Objects.equals(Shooter, player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get().Team)) {
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

package org.multicoder.mcpaintball.common.entity.throwable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.entity.paintball.PaintballEntity;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

import java.rmi.AccessException;

public class GrenadeEntity extends ThrowableItemProjectile {

    public GrenadeEntity(EntityType<?> p_37442_, Level p_37443_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37442_, p_37443_);
    }

    public GrenadeEntity(EntityType<?> p_37438_, LivingEntity p_37439_, Level p_37440_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37438_, p_37439_, p_37440_);
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!level().isClientSide()) {
            ServerPlayer Owner = (ServerPlayer) getOwner();
            BlockPos Position = result.getBlockPos();
            Explosion E = level().explode(this, Position.getX(), Position.getY(), Position.getZ(), 5f, Level.ExplosionInteraction.MOB);
            E.getHitPlayers().keySet().forEach(player ->
            {
                PaintballPlayer OwnerData = Owner.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                PaintballPlayer TargetData = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                try {
                    if (OwnerData.GetTeam(GrenadeEntity.class).ordinal() != TargetData.GetTeam(GrenadeEntity.class).ordinal()) {
                        try {
                            MCPaintballWorldData.INSTANCE.IncrementByName(OwnerData.getName(GrenadeEntity.class), OwnerData.GetTeam(GrenadeEntity.class).ordinal(), GrenadeEntity.class);
                        } catch (AccessException e) {}
                    }
                } catch (AccessException e) {}
            });
            this.kill();
            this.discard();
        }
        super.onHitBlock(result);
    }

    @Override
    protected Item getDefaultItem() {
        return MCPaintballItems.GRENADE.get();
    }
}

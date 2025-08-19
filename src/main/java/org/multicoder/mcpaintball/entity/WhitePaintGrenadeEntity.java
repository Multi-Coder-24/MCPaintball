package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.init.MCPaintballExplosives;
import org.multicoder.mcpaintball.init.MCPaintballUtilities;
@SuppressWarnings("all")
public class WhitePaintGrenadeEntity extends ThrowableItemProjectile implements ItemSupplier {

    public WhitePaintGrenadeEntity(EntityType<?> entityEntityType, Level level) {
        super((EntityType<? extends ThrowableItemProjectile>) entityEntityType, level);
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        Level level = level();
        BlockPos pos = result.getBlockPos();
        Explosion explosion = level.explode(this,pos.getX(),pos.getY(),pos.getZ(),2F, Level.ExplosionInteraction.NONE);
        this.discard();
    }

    public WhitePaintGrenadeEntity(LivingEntity shooter, Level level) {
        super((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.WHITE_PAINT_GRENADE.get(), shooter, level);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return MCPaintballUtilities.WHITE_PAINT_GRENADE.get();
    }
}

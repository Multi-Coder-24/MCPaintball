package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballItems;

public class SightGrenadeEntity extends ThrowableItemProjectile {
    public SightGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, Level level) {
        super(type, level);
    }

    public SightGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, LivingEntity owner, Level level, ItemStack itemStack) {
        super(type, owner, level, itemStack);
    }

    @Override
    protected @NonNull Item getDefaultItem() {
        return MCPaintballItems.SMOKE_GRENADE;
    }

    @Override
    protected void onHit(@NonNull HitResult hitResult) {
        super.onHit(hitResult);
            if(!this.level().isClientSide()){
                ServerLevel level = (ServerLevel) this.level();
                BlockPos current = this.blockPosition();
                AABB box = AABB.encapsulatingFullBlocks(current.offset(-5,-2,-5),current.offset(5,2,5));
                level.getEntities(null,box).forEach(entity -> {
                    if(entity instanceof ServerPlayer player){
                        if(player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER).Team != 0){
                            MobEffectInstance blind = new MobEffectInstance(MobEffects.BLINDNESS,40);
                            MobEffectInstance dark = new MobEffectInstance(MobEffects.DARKNESS,40);
                            player.addEffect(dark);
                            player.addEffect(blind);
                        }
                    }
                });
            }
        this.discard();
    }
}

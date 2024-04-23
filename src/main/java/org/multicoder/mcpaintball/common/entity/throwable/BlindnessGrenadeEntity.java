package org.multicoder.mcpaintball.common.entity.throwable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

import java.util.List;

public class BlindnessGrenadeEntity extends ThrowableItemProjectile {


    public BlindnessGrenadeEntity(EntityType<?> p_37442_, Level p_37443_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37442_, p_37443_);
    }

    public BlindnessGrenadeEntity(EntityType<?> p_37438_, LivingEntity p_37439_, Level p_37440_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37438_, p_37439_, p_37440_);
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        BlockPos Position = result.getBlockPos();
        Level level = level();
        Cow C = new Cow(EntityType.COW, level);
        C.setPos(Position.getX(), Position.getY(), Position.getZ());
        level.addFreshEntity(C);
        AABB BB = new AABB(Position.offset(-5, -5, -5), Position.offset(5, 5, 5));
        List<Player> Players = level.getNearbyPlayers(TargetingConditions.DEFAULT, C, BB);
        C.discard();
        Players.forEach(player -> player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80)));
        level.playSound(null, Position, SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1f, 1f);
        this.kill();
        this.discard();
        super.onHitBlock(result);
    }

    @Override
    protected Item getDefaultItem() {
        return MCPaintballItems.BLIND_GRENADE.get();
    }
}

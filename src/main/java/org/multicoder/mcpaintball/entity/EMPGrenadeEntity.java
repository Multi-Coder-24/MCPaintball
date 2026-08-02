package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
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
import org.multicoder.mcpaintball.core.MCPaintballSounds;

public class EMPGrenadeEntity extends ThrowableItemProjectile {
    public EMPGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, Level level) {
        super(type, level);
    }

    public EMPGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, LivingEntity owner, Level level, ItemStack itemStack) {
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
                BlockPos.betweenClosed(box).forEach(pos -> level.sendParticles(ParticleTypes.ELECTRIC_SPARK,true, true,pos.getX(), pos.getY(), pos.getZ(),10,1.0,1.0,1.0,0.001));
                level.getEntities(null,box).forEach(entity -> {
                    if(entity instanceof ServerPlayer player){
                        if(player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER).team != 0){
                            level.playSound(null,player.blockPosition(), MCPaintballSounds.SPARK, SoundSource.PLAYERS,1f,1f);
                            player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER),120);
                            player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.PISTOL),120);
                            player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.SHOTGUN),120);
                            player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.BURST_RIFLE),120);
                            player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.ASSAULT_RIFLE),120);
                            player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.SNIPER_RIFLE),120);
                        }
                    }
                });
            }
        this.discard();
    }
}

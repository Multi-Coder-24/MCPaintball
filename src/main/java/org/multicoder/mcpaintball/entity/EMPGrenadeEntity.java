package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.util.PlayManager;

public class EMPGrenadeEntity extends ThrowableItemProjectile {
    public EMPGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, Level level) {
        super(type, level);
    }

    public EMPGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, LivingEntity owner, Level level, ItemStack itemStack) {
        super(type, owner, level, itemStack);
    }

    @Override
    protected @NonNull Item getDefaultItem() {
        return MCPaintballItems.EMP_GRENADE;
    }

    @Override
    protected void onHit(@NonNull HitResult hitResult) {
        super.onHit(hitResult);
            if(!this.level().isClientSide()){
                ServerLevel serverLevel = (ServerLevel) this.level();
                ServerPlayer serverPlayer = (ServerPlayer) this.getOwner();
                if(PlayManager.IsValid(serverLevel.getServer(), serverPlayer)){
                    BlockPos current = this.blockPosition();
                    AABB box = AABB.encapsulatingFullBlocks(current.offset(-5,-2,-5),current.offset(5,2,5));
                    BlockPos.betweenClosed(box).forEach(pos -> serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK,true, true,pos.getX(), pos.getY(), pos.getZ(),10,1.0,1.0,1.0,0.001));
                    serverLevel.playSound(null,current,MCPaintballSounds.SPARK,SoundSource.PLAYERS,1f,1f);
                    serverLevel.getEntities(null,box).forEach(entity -> {
                        if(entity instanceof Player player){
                            if(PlayManager.IsValid(serverLevel.getServer(), (ServerPlayer) entity)){
                                player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.PISTOL),120);
                                player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.ASSAULT_RIFLE),120);
                                player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.SNIPER_RIFLE),120);
                                player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.SHOTGUN),120);
                                player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.BURST_RIFLE),120);
                                player.getCooldowns().addCooldown(new ItemStack(MCPaintballItems.GRENADE_LAUNCHER),120);
                            }
                        }
                    });
                }
            }
        this.discard();
    }
}

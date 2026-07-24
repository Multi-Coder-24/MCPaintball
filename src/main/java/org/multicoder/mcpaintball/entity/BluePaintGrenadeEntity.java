package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
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
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.core.MCPaintballParticles;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.DebugHelper;

import java.util.Objects;

public class BluePaintGrenadeEntity extends ThrowableItemProjectile {
    public BluePaintGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, Level level) {
        super(type, level);
    }

    public BluePaintGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, LivingEntity owner, Level level, ItemStack itemStack) {
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
                ServerLevel level = (ServerLevel) this.level();
                BlockPos current = this.blockPosition();
                AABB box = AABB.encapsulatingFullBlocks(current.offset(-5,-2,-5),current.offset(5,2,5));
                BlockPos.betweenClosed(box).forEach(pos -> level.sendParticles(MCPaintballParticles.BLUE_PAINT,true, true,pos.getX(), pos.getY(), pos.getZ(),5,0.2,0.2,0.2,0.01));
                level.getEntities(this,box).forEach(entity -> {
                    if(entity instanceof Player player){
                        MCPaintballPlayerData targetData = player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                        if((Objects.requireNonNull(targetData).Team != 0 && Objects.requireNonNull(targetData).Team != 3)){
                            level().playSound(null, Objects.requireNonNull(this.getOwner()).blockPosition(), MCPaintballSounds.HIT, SoundSource.PLAYERS,1f,1f);
                            MCPaintballGameEvents.INSTANCE.BluePoints++;
                            MCPaintballGameEvents.INSTANCE.setDirty(true);
                            ServerPlayer serverPlayer = (ServerPlayer) player;
                            BlockPos pos = Objects.requireNonNull(serverPlayer.getRespawnConfig()).respawnData().pos();
                            serverPlayer.teleportTo(pos.getX(),pos.getY(),pos.getZ());
                        }
                    }else if(MCPaintball.DEBUG){
                        DebugHelper.HandleGrenadeDebug(entity,level(),3,(Player) this.getOwner());
                    }
                });
            }
        this.discard();
    }
}

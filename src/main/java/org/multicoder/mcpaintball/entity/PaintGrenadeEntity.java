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
import org.multicoder.mcpaintball.core.*;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.DebugHelper;

import java.util.Objects;

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
                ServerLevel level = (ServerLevel) this.level();
                BlockPos current = this.blockPosition();
                AABB box = AABB.encapsulatingFullBlocks(current.offset(-5,-2,-5),current.offset(5,2,5));
                int Checker;
                EntityType<?> type = getType();
                if(type == MCPaintballEntities.RED_PAINT_GRENADE){
                    BlockPos.betweenClosed(box).forEach(pos -> level.sendParticles(MCPaintballParticles.RED_PAINT,true, true,pos.getX(), pos.getY(), pos.getZ(),5,0.2,0.2,0.2,0.01));
                    Checker = 1;
                }else if(type == MCPaintballEntities.GREEN_PAINT_GRENADE){
                    BlockPos.betweenClosed(box).forEach(pos -> level.sendParticles(MCPaintballParticles.GREEN_PAINT,true, true,pos.getX(), pos.getY(), pos.getZ(),5,0.2,0.2,0.2,0.01));
                    Checker = 2;
                }else if(type == MCPaintballEntities.BLUE_PAINT_GRENADE){
                    BlockPos.betweenClosed(box).forEach(pos -> level.sendParticles(MCPaintballParticles.BLUE_PAINT,true, true,pos.getX(), pos.getY(), pos.getZ(),5,0.2,0.2,0.2,0.01));
                    Checker = 3;
                }else if(type == MCPaintballEntities.YELLOW_PAINT_GRENADE){
                    BlockPos.betweenClosed(box).forEach(pos -> level.sendParticles(MCPaintballParticles.YELLOW_PAINT,true, true,pos.getX(), pos.getY(), pos.getZ(),5,0.2,0.2,0.2,0.01));
                    Checker = 4;
                }else if(type == MCPaintballEntities.PINK_PAINT_GRENADE){
                    BlockPos.betweenClosed(box).forEach(pos -> level.sendParticles(MCPaintballParticles.PINK_PAINT,true, true,pos.getX(), pos.getY(), pos.getZ(),5,0.2,0.2,0.2,0.01));
                    Checker = 5;
                }else if(type == MCPaintballEntities.ORANGE_PAINT_GRENADE){
                    BlockPos.betweenClosed(box).forEach(pos -> level.sendParticles(MCPaintballParticles.ORANGE_PAINT,true, true,pos.getX(), pos.getY(), pos.getZ(),5,0.2,0.2,0.2,0.01));
                    Checker = 6;
                } else {
                    Checker = 0;
                }
                level.getEntities(this,box).forEach(entity -> {
                    if(entity instanceof Player player){
                        MCPaintballPlayerData targetData = player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                        if((Objects.requireNonNull(targetData).Team != 0 && Objects.requireNonNull(targetData).Team != Checker)){
                            level().playSound(null, Objects.requireNonNull(this.getOwner()).blockPosition(), MCPaintballSounds.HIT, SoundSource.PLAYERS,1f,1f);
                            MCPaintballGameEvents.INSTANCE.incrementByChecker(Checker);
                            ServerPlayer serverPlayer = (ServerPlayer) player;
                            BlockPos pos = Objects.requireNonNull(serverPlayer.getRespawnConfig()).respawnData().pos();
                            serverPlayer.teleportTo(pos.getX(),pos.getY(),pos.getZ());
                        }
                    }else if(MCPaintball.DEBUG){
                        DebugHelper.HandleGrenadeDebug(entity,level(),Checker,(Player) this.getOwner());
                    }
                });
            }
        this.discard();
    }
}

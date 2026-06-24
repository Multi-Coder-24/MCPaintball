package org.multicoder.mcpaintball.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.core.MCPaintballParticles;

public class RedPaintGrenadeEntity extends ThrowableItemProjectile {
    public RedPaintGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, Level level) {
        super(type, level);
    }

    public RedPaintGrenadeEntity(EntityType<? extends ThrowableItemProjectile> type, LivingEntity owner, Level level, ItemStack itemStack) {
        super(type, owner, level, itemStack);
    }

    @Override
    protected @NonNull Item getDefaultItem() {
        return MCPaintballItems.RED_PAINT_GRENADE;
    }

    @Override
    protected void onHit(@NonNull HitResult hitResult) {
        super.onHit(hitResult);
        if(!this.level().isClientSide()){
            ServerLevel level = (ServerLevel) this.level();
            BlockPos current = this.blockPosition();
            AABB box = AABB.encapsulatingFullBlocks(current.offset(-5,-2,-5),current.offset(5,2,5));
            BlockPos.betweenClosed(box).forEach(pos -> level.sendParticles(MCPaintballParticles.RED_PAINT,true,true,pos.getX(),pos.getY(),pos.getZ(),5,0.2,0.2,0.2,0.01));
            level.getEntities(this,box).forEach(entity -> {
                if(entity instanceof Player player){
                    player.sendSystemMessage(Component.literal("Hit By Grenade!"));
                }
            });
        }
        this.discard();
    }
}

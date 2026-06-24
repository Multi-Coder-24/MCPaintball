package org.multicoder.mcpaintball.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.core.MCPaintballEntities;

public class GreenPaintballEntity extends AbstractArrow {
    public GreenPaintballEntity(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public GreenPaintballEntity(Player mob, Level level, @Nullable ItemStack firedFromWeapon) {
        super(MCPaintballEntities.GREEN_PAINTBALL, mob, level, new ItemStack(Items.ARROW), firedFromWeapon);
    }

    @Override
    protected @NonNull ItemStack getDefaultPickupItem() {
        return new ItemStack(Items.ARROW);
    }

    @Override
    protected boolean tryPickup(@NonNull Player player) {return false;}

    @Override
    public void tick() {
        super.tick();
        if(this.isInGround() && this.inGroundTime >= 80){
            this.discard();
        }
    }
    @Override
    protected void onHitEntity(@NonNull EntityHitResult ignored) {
        super.discard();
    }
}

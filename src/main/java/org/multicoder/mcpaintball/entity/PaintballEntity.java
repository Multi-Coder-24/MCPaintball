package org.multicoder.mcpaintball.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.util.PlayManager;

public class PaintballEntity extends AbstractArrow {
    public PaintballEntity(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public PaintballEntity(EntityType<? extends AbstractArrow> type,Player mob, Level level, @Nullable ItemStack firedFromWeapon) {
        super(type, mob, level, new ItemStack(Items.ARROW), firedFromWeapon);
    }

    @Override
    public @NonNull ItemStack getDefaultPickupItem() {
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
    protected @NonNull SoundEvent getDefaultHitGroundSoundEvent() {
        return MCPaintballSounds.SPLAT;
    }

    @Override
    protected void onHitEntity(@NonNull EntityHitResult result) {
        if(!level().isClientSide()){
            ServerPlayer shooter = (ServerPlayer) this.getOwner();
            ServerLevel serverLevel = (ServerLevel) this.level();
            if(PlayManager.IsValid(serverLevel.getServer(), shooter)){
                if(result.getEntity() instanceof Player){
                    PlayManager.HandlePaintballPlayerHit((ServerPlayer) result.getEntity(),shooter,serverLevel);
                }
            }
        }
        super.discard();
    }
}

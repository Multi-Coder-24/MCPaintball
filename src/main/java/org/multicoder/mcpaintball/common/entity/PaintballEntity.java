package org.multicoder.mcpaintball.common.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.config.MCPaintballConfig;
import org.multicoder.mcpaintball.common.init.soundinit;

import java.util.Objects;

@SuppressWarnings("all")
public class PaintballEntity extends AbstractArrow {

    public PaintballEntity(EntityType<? extends AbstractArrow> pEntityType, LivingEntity pShooter, Level pLevel) {
        super(pEntityType, pShooter, pLevel);
    }

    public PaintballEntity(EntityType<?> pEntityType, Level pLevel) {
        super((EntityType<? extends AbstractArrow>) pEntityType, pLevel);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (Objects.nonNull(this.getOwner())) {
            if (!this.level().isClientSide()) {
                if (pResult.getEntity() instanceof Player) {
                    Player Target = (Player) pResult.getEntity();
                    Player Shooter = (Player) this.getOwner();
                    PaintballPlayer TargetData = Target.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                    PaintballPlayer ShooterData = Shooter.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                    if (!Objects.equals(TargetData.Team, ShooterData.Team)) {
                        ShooterData.Points += 1;
                        Target.hurt(this.level().damageSources().arrow(this, Shooter), 2.5f);
                        this.level().playSound(null, Target.blockPosition(), soundinit.DING.get(), SoundSource.PLAYERS, 1f, 1f);
                        this.kill();
                        this.discard();
                    }
                    if (Objects.equals(TargetData.Team, ShooterData.Team) && !MCPaintballConfig.FRIENDLY_FIRE.get()) {
                        Target.hurt(this.level().damageSources().arrow(this, Shooter), 2.5f);
                        this.kill();
                        this.discard();
                    }
                }
            }
        }
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return soundinit.SPLAT.get();
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround) {
            if (this.inGroundTime > 60) {
                this.kill();
                this.discard();
            }
        }
    }
}

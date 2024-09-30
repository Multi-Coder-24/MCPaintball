package org.multicoder.mcpaintball.common.entity.paintball;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.utility.enums.PaintballTeam;

import java.util.Objects;

@SuppressWarnings("all")
public class PaintballEntity extends AbstractArrow {
    public PaintballEntity(EntityType<?> entityType, Level level) {
        super((EntityType<? extends AbstractArrow>) entityType, level, ItemStack.EMPTY);
    }

    public PaintballEntity(EntityType<?> entityType, LivingEntity shooter, Level level) {
        super((EntityType<? extends AbstractArrow>) entityType, shooter, level, ItemStack.EMPTY);
    }


    @Override
    protected void onHitEntity(EntityHitResult hitResult)
    {
        if (!level().isClientSide())
        {
            if (MCPaintballWorldData.INSTANCE.MatchStarted)
            {
                float Damage = (MCPaintballWorldData.INSTANCE.GAME_TYPE == 3) ? 2f : 0f;
                PaintballTeam Team = PaintballTeam.getFromEntityType(getTypeName().getString().toLowerCase());
                if (hitResult.getEntity() instanceof Player player && Objects.nonNull(Team))
                {
                    if (MCPaintballTeamsDataHelper.HasTeam(player)) {
                        PaintballTeam TargetTeam = PaintballTeam.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                        Player shooter = (Player) getOwner();
                        if (!Objects.equals(Team, TargetTeam)) {
                            player.hurt(level().damageSources().arrow(this, shooter), Damage);
                            MCPaintballTeamsDataHelper.AddPoint(shooter);
                        }
                    }
                }
            }
        }
        this.kill();
        this.discard();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGroundTime == 100) {
            this.kill();
            this.discard();
        }
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return MCPaintballSounds.SPLAT.get();
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}

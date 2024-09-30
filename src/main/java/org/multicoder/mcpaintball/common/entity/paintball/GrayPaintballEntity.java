package org.multicoder.mcpaintball.common.entity.paintball;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;

@SuppressWarnings("all")
public class GrayPaintballEntity extends AbstractArrow {
    public GrayPaintballEntity(EntityType<?> entityType, Level level) {
        super((EntityType<? extends AbstractArrow>) entityType, level, ItemStack.EMPTY);
    }

    public GrayPaintballEntity(EntityType<?> entityType, LivingEntity shooter, Level level) {
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
                if (hitResult.getEntity() instanceof Player player)
                {
                    if (MCPaintballTeamsDataHelper.HasTeam(player))
                    {
                        Player shooter = (Player) getOwner();
                        player.hurt(level().damageSources().arrow(this,shooter),Damage);
                        MCPaintballTeamsDataHelper.AddPoint(shooter);
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

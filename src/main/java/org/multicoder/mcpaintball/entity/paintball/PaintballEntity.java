package org.multicoder.mcpaintball.entity.paintball;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.*;
import org.multicoder.mcpaintball.init.MCPaintballSounds;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import java.util.Objects;

import static org.multicoder.mcpaintball.init.MCPaintballSounds.HIT;
import static org.multicoder.mcpaintball.data.MCPaintballWorldData.INSTANCE;

@SuppressWarnings("all")
public class PaintballEntity extends AbstractArrow {
    public PaintballEntity(EntityType<?> entityType, Level level) {
        super((EntityType<? extends AbstractArrow>) entityType, level, ItemStack.EMPTY);
    }

    public PaintballEntity(EntityType<?> entityType, LivingEntity shooter, Level level) {
        super((EntityType<? extends AbstractArrow>) entityType, shooter, level, ItemStack.EMPTY);
    }
    @Override
    protected void onHitEntity(@NotNull EntityHitResult hitResult)
    {
        if (!level().isClientSide())
        {
            if (INSTANCE.MatchStarted)
            {
                PaintballTeam Team = PaintballTeam.getFromEntityType(getTypeName().getString().toLowerCase());
                if (hitResult.getEntity() instanceof Player player && Objects.nonNull(Team))
                {
                    if (MCPaintballTeamsDataHelper.HasTeam(player))
                    {
                        PaintballTeam TargetTeam = PaintballTeam.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                        Player shooter = (Player) getOwner();
                        if (!Objects.equals(Team, TargetTeam))
                        {
                            shooter.playSound(HIT.get(),1f,1f);
                            MCPaintballWorldData.incrementByIndex(Team.ordinal());
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
    protected void onHitBlock(BlockHitResult p_36755_)
    {
        BlockPos pos = p_36755_.getBlockPos();
        level().playSound(this,pos,MCPaintballSounds.SPLAT.get(), SoundSource.PLAYERS,1f,1f);
        super.onHitBlock(p_36755_);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGroundTime == 100) {
            this.discard();
        }
    }

    @Override
    protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
        return MCPaintballSounds.SPLAT.get();
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
}

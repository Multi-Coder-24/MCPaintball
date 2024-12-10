package org.multicoder.mcpaintball.entity.paintball;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.init.MCPaintballSounds;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import java.util.Objects;

@SuppressWarnings("all")
public class PaintballEntity extends AbstractArrow {
    public PaintballEntity(EntityType<?> entityType, Level level) {
        super((EntityType<? extends AbstractArrow>) entityType, level, ItemStack.EMPTY);
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult hitResult)
    {
        if (!level().isClientSide())
        {
            if (MCPaintballWorldData.INSTANCE.MatchStarted)
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
                            shooter.playSound(MCPaintballSounds.HIT.get(),1f,1f);
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
    public void tick() {
        super.tick();
        if (this.inGroundTime == 100) {
            this.kill();
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

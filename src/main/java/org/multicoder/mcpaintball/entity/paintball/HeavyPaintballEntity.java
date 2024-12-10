package org.multicoder.mcpaintball.entity.paintball;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.init.MCPaintballSounds;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import java.util.Objects;

@SuppressWarnings("all")
public class HeavyPaintballEntity extends AbstractArrow
{
    public HeavyPaintballEntity(EntityType<?> p_36721_, Level p_36722_) {
        super((EntityType<? extends AbstractArrow>) p_36721_, p_36722_, ItemStack.EMPTY);
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult hitResult)
    {
        if (MCPaintballWorldData.INSTANCE.MatchStarted)
        {
            BlockPos Position = hitResult.getBlockPos();
            Explosion E = level().explode(this, Position.getX(), Position.getY(), Position.getZ(), 2f,Level.ExplosionInteraction.NONE);
            String TypeName = getTypeName().getString().toLowerCase();
            PaintballTeam Team = PaintballTeam.getFromEntityType(getTypeName().getString().toLowerCase());
            E.getHitPlayers().keySet().forEach(player ->
            {
                if (MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    PaintballTeam TargetTeam = PaintballTeam.values()[MCPaintballTeamsDataHelper.FetchTeam(player)];
                    if (!Objects.equals(Team,TargetTeam))
                    {
                        MCPaintballWorldData.incrementByIndex(Team.ordinal());
                    }
                }
            });
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

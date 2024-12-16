package org.multicoder.mcpaintball.entity.grenade;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.*;
import java.util.Objects;

import static net.minecraft.world.level.Level.ExplosionInteraction.NONE;
import static org.multicoder.mcpaintball.data.MCPaintballWorldData.INSTANCE;
import static org.multicoder.mcpaintball.init.MCPaintballItems.GREEN_GRENADE;
import static org.multicoder.mcpaintball.utility.enums.PaintballTeam.GREEN;

@SuppressWarnings("all")
public class GreenPaintballGrenadeEntity extends ThrowableItemProjectile implements ItemSupplier {

    public GreenPaintballGrenadeEntity(EntityType<?> p_37442_, Level p_37443_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37442_, p_37443_);
    }

    public GreenPaintballGrenadeEntity(EntityType<?> p_37442_, LivingEntity shooter, Level p_37443_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37442_,shooter, p_37443_);
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult hitResult)
    {
        if (INSTANCE.MatchStarted)
        {
            BlockPos Position = hitResult.getBlockPos();
            Explosion E = level().explode(this, Position.getX(), Position.getY(), Position.getZ(), 2f,NONE);
            E.getHitPlayers().keySet().forEach(player ->
            {
                if (MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    if (!Objects.equals(Team, GREEN.ordinal()))
                    {
                        MCPaintballWorldData.incrementByIndex(GREEN.ordinal());
                    }
                }
            });
        }
        this.kill();
        this.discard();
    }

    @Override
    protected @NotNull Item getDefaultItem()
    {
        return GREEN_GRENADE.get();
    }
}

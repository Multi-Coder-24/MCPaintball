package org.multicoder.mcpaintball.entity.grenade;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.init.MCPaintballItems;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import java.util.Objects;

@SuppressWarnings("all")
public class BluePaintballGrenadeEntity extends ThrowableItemProjectile implements ItemSupplier {

    public BluePaintballGrenadeEntity(EntityType<?> p_37442_, Level p_37443_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37442_, p_37443_);
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult hitResult)
    {
        if (MCPaintballWorldData.INSTANCE.MatchStarted)
        {
            BlockPos Position = hitResult.getBlockPos();
            Explosion E = level().explode(this, Position.getX(), Position.getY(), Position.getZ(), 2f,Level.ExplosionInteraction.NONE);
            E.getHitPlayers().keySet().forEach(player ->
            {
                if (MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    if (!Objects.equals(Team, PaintballTeam.BLUE.ordinal()))
                    {
                        MCPaintballWorldData.incrementByIndex(PaintballTeam.BLUE.ordinal());
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
        return MCPaintballItems.BLUE_GRENADE.get();
    }
}

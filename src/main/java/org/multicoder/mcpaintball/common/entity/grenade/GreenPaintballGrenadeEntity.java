package org.multicoder.mcpaintball.common.entity.grenade;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;
import org.multicoder.mcpaintball.common.utility.enums.PaintballTeam;

import java.util.Objects;

@SuppressWarnings("all")
public class GreenPaintballGrenadeEntity extends ThrowableItemProjectile implements ItemSupplier {

    public GreenPaintballGrenadeEntity(EntityType<?> p_37442_, Level p_37443_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37442_, p_37443_);
    }

    public GreenPaintballGrenadeEntity(EntityType<?> p_37438_, LivingEntity p_37439_, Level p_37440_) {
        super((EntityType<? extends ThrowableItemProjectile>) p_37438_, p_37439_, p_37440_);
    }

    @Override
    protected void onHitBlock(BlockHitResult p_37258_)
    {
        if (MCPaintballWorldData.INSTANCE.MatchStarted)
        {
            BlockPos Position = p_37258_.getBlockPos();
            Level.ExplosionInteraction Interaction = (MCPaintballWorldData.INSTANCE.GAME_TYPE == 2) ? Level.ExplosionInteraction.TNT : Level.ExplosionInteraction.NONE;
            Explosion E = level().explode(this, Position.getX(), Position.getY(), Position.getZ(), 2f,Interaction);
            E.getHitPlayers().keySet().forEach(player ->
            {
                if (MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    if (!Objects.equals(Team, PaintballTeam.GREEN.ordinal()))
                    {
                        MCPaintballWorldData.incrementByOrdinal(PaintballTeam.GREEN.ordinal());
                    }
                }
            });
        }
        this.kill();
        this.discard();
    }

    @Override
    protected Item getDefaultItem()
    {
        return MCPaintballItems.GREEN_GRENADE.get();
    }
}

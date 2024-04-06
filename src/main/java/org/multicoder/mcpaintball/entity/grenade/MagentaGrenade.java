package org.multicoder.mcpaintball.entity.grenade;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.init.entityinit;
import org.multicoder.mcpaintball.init.iteminit;
import org.multicoder.mcpaintball.network.Networking;
import org.multicoder.mcpaintball.network.packets.TeamPointS2CPacket;
import org.multicoder.mcpaintball.util.MCPaintballUtilities;

import java.util.concurrent.atomic.AtomicInteger;

public class MagentaGrenade extends ThrowableItemProjectile
{

    public MagentaGrenade(double pX, double pY, double pZ, Level pLevel)
    {
        super((EntityType<? extends ThrowableItemProjectile>) entityinit.MAGENTA_GRENADE.get(), pX, pY, pZ, pLevel);
    }

    public MagentaGrenade(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel)
    {
        super(pEntityType, pLevel);
    }

    public MagentaGrenade(LivingEntity pShooter, Level pLevel)
    {
        super((EntityType<? extends ThrowableItemProjectile>) entityinit.MAGENTA_GRENADE.get(), pShooter, pLevel);
    }


    @Override
    protected void onHit(HitResult pResult)
    {
        if(!level.isClientSide())
        {
            if(getOwner() instanceof ServerPlayer)
            {
                int X = (int) pResult.getLocation().x;
                int Y = (int) pResult.getLocation().y;
                int Z = (int) pResult.getLocation().z;
                ServerPlayer Thrower = (ServerPlayer) getOwner();
                BlockPos pos = new BlockPos(X,Y,Z);
                Explosion ex = getLevel().explode(this,pos.getX(),pos.getY(),pos.getZ(),3, Explosion.BlockInteraction.DESTROY);
                AtomicInteger Points = new AtomicInteger(0);
                MCPaintballUtilities.LevelUtils.GetPointsFromExplosion(Points,ex,Thrower);
                Thrower.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
                {
                    cap.AddPoints(Points.get());
                    Networking.sendToPlayer(new TeamPointS2CPacket(cap.GetPoints()),Thrower);
                });
            }

        }
    }

    @Override
    protected Item getDefaultItem()
    {
        return iteminit.PAINTBALL_GRENADE.get();
    }
}

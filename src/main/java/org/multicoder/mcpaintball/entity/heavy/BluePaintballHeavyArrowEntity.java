package org.multicoder.mcpaintball.entity.heavy;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.init.entityinit;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.network.Networking;
import org.multicoder.mcpaintball.network.packets.TeamPointS2CPacket;
import org.multicoder.mcpaintball.util.MCPaintballUtilities;

import java.util.concurrent.atomic.AtomicInteger;

public class BluePaintballHeavyArrowEntity extends AbstractArrow
{

    public BluePaintballHeavyArrowEntity(EntityType<? extends Entity> p_36858_, Level p_36859_) {super((EntityType<? extends AbstractArrow>) p_36858_, p_36859_);}

    public BluePaintballHeavyArrowEntity(Level p_36861_, double p_36862_, double p_36863_, double p_36864_) {super((EntityType<? extends AbstractArrow>) entityinit.BLUE_PAINTBALL_HEAVY.get(), p_36862_, p_36863_, p_36864_,p_36861_);}

    public BluePaintballHeavyArrowEntity(Level p_36866_, LivingEntity p_36867_) {super((EntityType<? extends AbstractArrow>) entityinit.BLUE_PAINTBALL_HEAVY.get(), p_36867_,p_36866_);}

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {return soundinit.SPLAT.get();}

    @Override
    protected ItemStack getPickupItem() {return ItemStack.EMPTY;}



    @Override
    protected void onHit(HitResult pResult)
    {
        if(!getLevel().isClientSide())
        {
            Vec3 Vector = pResult.getLocation();
            ServerPlayer Shooter = (ServerPlayer) getOwner();
            Explosion explosion = getLevel().explode(null,Vector.x,Vector.y,Vector.z,2f, Explosion.BlockInteraction.DESTROY);
            AtomicInteger Points = new AtomicInteger();
            MCPaintballUtilities.LevelUtils.GetPointsFromExplosion(Points,explosion,Shooter);
            Shooter.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
            {
                cap.AddPoints(Points.get());
                Networking.sendToPlayer(new TeamPointS2CPacket(cap.GetPoints()),Shooter);
            });
            this.kill();
            this.discard();
        }
    }
}

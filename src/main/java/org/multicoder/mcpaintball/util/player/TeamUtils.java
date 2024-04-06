package org.multicoder.mcpaintball.util.player;

import net.minecraft.server.level.ServerPlayer;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;

import java.util.concurrent.atomic.AtomicInteger;

public class TeamUtils
{
    public static boolean IsSameTeam(ServerPlayer Shooter, ServerPlayer Target)
    {
        if(Shooter.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).isPresent() && Target.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).isPresent())
        {
            AtomicInteger ShooterTeam = new AtomicInteger();
            AtomicInteger TargetTeam = new AtomicInteger();
            Shooter.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap -> { ShooterTeam.set(cap.GetTeam());});
            Target.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap -> {TargetTeam.set(cap.GetTeam());});
            return ShooterTeam.get() == TargetTeam.get();
        }
        return false;
    }
    public static boolean HasTeam(ServerPlayer Shooter, ServerPlayer Target)
    {
        boolean ShooterTeam = Shooter.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).isPresent();
        boolean TargetTeam = Target.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).isPresent();
        if(ShooterTeam && TargetTeam)
        {
            return true;
        }
        return false;
    }
}

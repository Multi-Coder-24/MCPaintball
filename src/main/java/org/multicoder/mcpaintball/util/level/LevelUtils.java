package org.multicoder.mcpaintball.util.level;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Explosion;
import org.multicoder.mcpaintball.util.player.TeamUtils;

import java.util.concurrent.atomic.AtomicInteger;

public class LevelUtils
{
    public static AtomicInteger GetPointsFromExplosion(AtomicInteger initial, Explosion explosion, ServerPlayer shooter)
    {
        explosion.getHitPlayers().forEach((player,vec) -> {
            ServerPlayer Hit = (ServerPlayer) player;
            if(TeamUtils.IsSameTeam(shooter,Hit))
            {
                if(!TeamUtils.IsSameTeam(shooter,Hit))
                {
                    initial.incrementAndGet();
                }
            }
        });
        return initial;
    }
}

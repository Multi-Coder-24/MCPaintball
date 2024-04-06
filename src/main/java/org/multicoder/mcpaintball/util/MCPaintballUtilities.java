package org.multicoder.mcpaintball.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.util.player.TeamUtils;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MCPaintballUtilities
{
    public static class LevelUtils
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
    public static class ClassUtils
    {
        public static boolean IsStandardClass(ServerPlayer Player)
        {
            AtomicBoolean ToReturn = new AtomicBoolean(false);
            Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
            {
                KitType Type = KitType.GetType(cap.GetClass());
                if(Type.equals(KitType.STANDARD))
                {
                    ToReturn.set(true);
                }
            });
            return ToReturn.get();
        }
        public static boolean IsMedicalClass(ServerPlayer Player)
        {
            AtomicBoolean ToReturn = new AtomicBoolean(false);
            Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
            {
                KitType Type = KitType.GetType(cap.GetClass());
                if(Type.equals(KitType.MEDICAL))
                {
                    ToReturn.set(true);
                }
            });
            return ToReturn.get();
        }
        public static boolean IsHeavyClass(ServerPlayer Player)
        {
            AtomicBoolean ToReturn = new AtomicBoolean(false);
            Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
            {
                KitType Type = KitType.GetType(cap.GetClass());
                if(Type.equals(KitType.HEAVY))
                {
                    ToReturn.set(true);
                }
            });
            return ToReturn.get();
        }
        public static boolean IsTraineeClass(ServerPlayer Player)
        {
            AtomicBoolean ToReturn = new AtomicBoolean(false);
            Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
            {
                KitType Type = KitType.GetType(cap.GetClass());
                if(Type.equals(KitType.TRAINEE))
                {
                    ToReturn.set(true);
                }
            });
            return ToReturn.get();
        }
    }

    public static class Keybindings
    {
        public static final String CATEGORY = "key.category.mcpaintball.weapons";
        public static final String REGISTRY_NAME = "key.mcpaintball.reload";

        public static final KeyMapping RELOAD = new KeyMapping(REGISTRY_NAME, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R,CATEGORY);

    }
}

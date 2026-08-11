package org.multicoder.mcpaintball.util;

import net.minecraft.server.MinecraftServer;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;

import java.util.concurrent.atomic.AtomicBoolean;

public class RoleCheck {
    public static boolean checkCaptainRole(MinecraftServer server){
        AtomicBoolean rv =  new AtomicBoolean(false);
        server.getPlayerList().getPlayers().forEach(player -> {
            MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            if(data.team != 0){
                if(data.role == 1){
                    rv.set(true);
                }
            }
        });
        return rv.get();
    }
}

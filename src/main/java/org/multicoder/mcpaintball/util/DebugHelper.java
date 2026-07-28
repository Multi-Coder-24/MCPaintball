package org.multicoder.mcpaintball.util;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballSounds;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

public class DebugHelper {
    public static void HandleDebug(EntityHitResult result,Level level, Player owner){
        if(result.getEntity() instanceof Cow){
            level.playSound(null,owner.blockPosition(), MCPaintballSounds.HIT.get(), SoundSource.PLAYERS,1f,1f);
            MCPaintballPlayerData data = owner.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            switch (data.Team){
                 case 1 -> {
                     MCPaintballGameEvents.INSTANCE.RedPoints++;
                     MCPaintballGameEvents.INSTANCE.setDirty(true);
                 }
                 case 2->{
                     MCPaintballGameEvents.INSTANCE.GreenPoints++;
                     MCPaintballGameEvents.INSTANCE.setDirty(true);
                 }
                 case 3->{
                     MCPaintballGameEvents.INSTANCE.BluePoints++;
                     MCPaintballGameEvents.INSTANCE.setDirty(true);
                 }case  4->{
                     MCPaintballGameEvents.INSTANCE.YellowPoints++;
                     MCPaintballGameEvents.INSTANCE.setDirty(true);
                 }
            }
        }
    }
    public static void HandleGrenadeDebug(Entity result, Level level, int Team, Player owner){
        if(result instanceof Cow){
            level.playSound(null,owner.blockPosition(), MCPaintballSounds.HIT.get(), SoundSource.PLAYERS,1f,1f);
            switch (Team){
                case 1 -> {
                    MCPaintballGameEvents.INSTANCE.RedPoints++;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                }
                case 2->{
                    MCPaintballGameEvents.INSTANCE.GreenPoints++;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                }
                case 3->{
                    MCPaintballGameEvents.INSTANCE.BluePoints++;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                }case 4->{
                    MCPaintballGameEvents.INSTANCE.YellowPoints++;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                }
            }
        }
    }
}

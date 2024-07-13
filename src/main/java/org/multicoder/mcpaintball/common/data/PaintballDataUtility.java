package org.multicoder.mcpaintball.common.data;

import net.minecraft.world.entity.EntityType;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;

public class PaintballDataUtility {
    public enum Team
    {
        NONE,
        RED,
        GREEN,
        BLUE,
        SOLO;

        public EntityType<?> getPaintball() {
            switch (this) {
                case RED -> {
                    return MCPaintballEntities.RED_PAINTBALL.get();
                }
                case GREEN -> {
                    return MCPaintballEntities.GREEN_PAINTBALL.get();
                }
                case BLUE -> {
                    return MCPaintballEntities.BLUE_PAINTBALL.get();
                }case SOLO -> {
                    return MCPaintballEntities.SOLO_PAINTBALL.get();
                }
            }
            return null;
        }

        public EntityType<?> getGrenade() {
            switch (this) {
                case RED -> {
                    return MCPaintballEntities.RED_GRENADE.get();
                }
                case GREEN -> {
                    return MCPaintballEntities.GREEN_GRENADE.get();
                }
                case BLUE -> {
                    return MCPaintballEntities.BLUE_GRENADE.get();
                }case SOLO -> {
                    return MCPaintballEntities.SOLO_GRENADE.get();
                }
            }
            return null;
        }

        public EntityType<?> getHeavyPaintball() {
            switch (this) {
                case RED -> {
                    return MCPaintballEntities.RED_HEAVY_PAINTBALL.get();
                }
                case GREEN -> {
                    return MCPaintballEntities.GREEN_HEAVY_PAINTBALL.get();
                }
                case BLUE -> {
                    return MCPaintballEntities.BLUE_HEAVY_PAINTBALL.get();
                }case SOLO -> {
                    return MCPaintballEntities.SOLO_HEAVY_PAINTBALL.get();
                }
            }
            return null;
        }
    }

    public enum Class
    {
        NONE,
        STANDARD,
        HEAVY,
        SHOTGUNNER,
        SOLO
    }
    public enum GameType
    {
        TEAM,
        SOLO,
        TEAM_DEATH,
        SOLO_DEATH
    }
}

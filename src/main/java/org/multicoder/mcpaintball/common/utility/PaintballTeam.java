package org.multicoder.mcpaintball.common.utility;

import net.minecraft.world.entity.EntityType;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;

import java.rmi.AccessException;

public enum PaintballTeam {
    RED,
    GREEN,
    BLUE,
    CYAN,
    MAGENTA,
    YELLOW,
    LIME,
    LIGHT_BLUE,
    PINK,
    PURPLE;

    public EntityType<?> getPaintball(Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            switch (this) {
                case RED -> {
                    return MCPaintballEntities.RED_PAINTBALL.get();
                }
                case GREEN -> {
                    return MCPaintballEntities.GREEN_PAINTBALL.get();
                }
                case BLUE -> {
                    return MCPaintballEntities.BLUE_PAINTBALL.get();
                }
                case CYAN -> {
                    return MCPaintballEntities.CYAN_PAINTBALL.get();
                }
                case MAGENTA -> {
                    return MCPaintballEntities.MAGENTA_PAINTBALL.get();
                }
                case YELLOW -> {
                    return MCPaintballEntities.YELLOW_PAINTBALL.get();
                }
                case LIME -> {
                    return MCPaintballEntities.LIME_PAINTBALL.get();
                }
                case LIGHT_BLUE -> {
                    return MCPaintballEntities.LIGHT_BLUE_PAINTBALL.get();
                }
                case PINK -> {
                    return MCPaintballEntities.PINK_PAINTBALL.get();
                }
                case PURPLE -> {
                    return MCPaintballEntities.PURPLE_PAINTBALL.get();
                }
            }
            return null;
        }
        else {
            throw new AccessException("Cannot Access This Class");
        }
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
            }
            case CYAN -> {
                return MCPaintballEntities.CYAN_HEAVY_PAINTBALL.get();
            }
            case MAGENTA -> {
                return MCPaintballEntities.MAGENTA_HEAVY_PAINTBALL.get();
            }
            case YELLOW -> {
                return MCPaintballEntities.YELLOW_HEAVY_PAINTBALL.get();
            }
            case LIME -> {
                return MCPaintballEntities.LIME_HEAVY_PAINTBALL.get();
            }
            case LIGHT_BLUE -> {
                return MCPaintballEntities.LIGHT_BLUE_HEAVY_PAINTBALL.get();
            }
            case PINK -> {
                return MCPaintballEntities.PINK_HEAVY_PAINTBALL.get();
            }
            case PURPLE -> {
                return MCPaintballEntities.PURPLE_HEAVY_PAINTBALL.get();
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
            }
            case CYAN -> {
                return MCPaintballEntities.CYAN_GRENADE.get();
            }
            case MAGENTA -> {
                return MCPaintballEntities.MAGENTA_GRENADE.get();
            }
            case YELLOW -> {
                return MCPaintballEntities.YELLOW_GRENADE.get();
            }
            case LIME -> {
                return MCPaintballEntities.LIME_GRENADE.get();
            }
            case LIGHT_BLUE -> {
                return MCPaintballEntities.LIGHT_BLUE_GRENADE.get();
            }
            case PINK -> {
                return MCPaintballEntities.PINK_GRENADE.get();
            }
            case PURPLE -> {
                return MCPaintballEntities.PURPLE_GRENADE.get();
            }
        }
        return null;
    }

    public String GetTKey() {
        return "team." + this.name().toLowerCase();
    }
}

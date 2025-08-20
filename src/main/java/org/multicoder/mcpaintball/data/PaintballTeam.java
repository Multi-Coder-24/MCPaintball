package org.multicoder.mcpaintball.data;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import org.multicoder.mcpaintball.init.MCPaintballEntities;

@SuppressWarnings("unused")
public enum PaintballTeam
{
    NONE,
    RED,
    GREEN,
    BLUE,
    CYAN,
    MAGENTA,
    YELLOW,
    LIME,
    LIGHT_BLUE,
    PINK,
    WHITE;

    public static EntityType<?> getEntityType(PaintballTeam team){
        switch(team){
            case RED:
                return MCPaintballEntities.RED_PAINTBALL.get();
            case GREEN:
                return MCPaintballEntities.GREEN_PAINTBALL.get();
            case BLUE:
                return MCPaintballEntities.BLUE_PAINTBALL.get();
            case CYAN:
                return MCPaintballEntities.CYAN_PAINTBALL.get();
            case MAGENTA:
                return MCPaintballEntities.MAGENTA_PAINTBALL.get();
            case YELLOW:
                return MCPaintballEntities.YELLOW_PAINTBALL.get();
            case LIME:
                return MCPaintballEntities.LIME_PAINTBALL.get();
            case LIGHT_BLUE:
                return MCPaintballEntities.LIGHT_BLUE_PAINTBALL.get();
            case PINK:
                return MCPaintballEntities.PINK_PAINTBALL.get();
            case WHITE:
                return MCPaintballEntities.WHITE_PAINTBALL.get();
        }
        return MCPaintballEntities.WHITE_PAINTBALL.get();
    }
    public static PaintballTeam fromEntitytType(AbstractArrow entity)
    {
        if(entity.getType() == MCPaintballEntities.RED_PAINTBALL.get()){
            return PaintballTeam.RED;
        }
        if(entity.getType() == MCPaintballEntities.GREEN_PAINTBALL.get()){
            return PaintballTeam.GREEN;
        }
        if(entity.getType() == MCPaintballEntities.BLUE_PAINTBALL.get()){
            return PaintballTeam.BLUE;
        }
        if(entity.getType() == MCPaintballEntities.CYAN_PAINTBALL.get()){
            return PaintballTeam.CYAN;
        }
        if(entity.getType() == MCPaintballEntities.MAGENTA_PAINTBALL.get()){
            return PaintballTeam.MAGENTA;
        }
        if(entity.getType() == MCPaintballEntities.YELLOW_PAINTBALL.get()){
            return PaintballTeam.YELLOW;
        }
        if(entity.getType() == MCPaintballEntities.LIME_PAINTBALL.get()){
            return PaintballTeam.LIME;
        }
        if(entity.getType() == MCPaintballEntities.LIGHT_BLUE_PAINTBALL.get()){
            return PaintballTeam.LIGHT_BLUE;
        }
        if(entity.getType() == MCPaintballEntities.PINK_PAINTBALL.get()){
            return PaintballTeam.PINK;
        }
        if(entity.getType() == MCPaintballEntities.WHITE_PAINTBALL.get()){
            return PaintballTeam.WHITE;
        }
        return NONE;
    }
}

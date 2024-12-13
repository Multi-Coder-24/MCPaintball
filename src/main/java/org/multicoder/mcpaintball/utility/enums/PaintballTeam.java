package org.multicoder.mcpaintball.utility.enums;

import net.minecraft.world.entity.EntityType;
import org.multicoder.mcpaintball.init.MCPaintballEntities;

import java.util.Objects;

public enum PaintballTeam
{
    RED,
    GREEN,
    BLUE;

   public static PaintballTeam getFromEntityType(String TypeName){
        if(Objects.equals(TypeName,"red paintball")){
            return RED;
        }
        if(Objects.equals(TypeName,"green paintball")){
            return GREEN;
        }
        if(Objects.equals(TypeName,"blue paintball")){
           return BLUE;
        }
        return null;
   }
    public static String getFromOrdinal(int Ordinal)
    {
        PaintballTeam Team = PaintballTeam.values()[Ordinal];
        switch (Team) {
            case RED -> {
                return "Red";
            }
            case BLUE -> {
                return "Blue";
            }
            case GREEN -> {
                return "Green";
            }
        }
        return "Error";
    }
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
        }
        return null;
    }
}

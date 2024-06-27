package org.multicoder.mcpaintball.common.utility;

import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.EntityType;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;

public enum PaintballTeam
{
    RED,
    GREEN,
    BLUE;

    public ChatFormatting getDisplayColor()
    {
        switch(this)
        {
            case RED ->{return ChatFormatting.DARK_RED;}
            case GREEN ->{return ChatFormatting.DARK_GREEN;}
            case BLUE ->{return ChatFormatting.DARK_BLUE;}
        }
        return ChatFormatting.BLACK;
    }
    public EntityType<?> getPaintball(){
        switch (this){
            case RED -> {return MCPaintballEntities.RED_PAINTBALL.get();}
            case GREEN -> {return MCPaintballEntities.GREEN_PAINTBALL.get();}
            case BLUE -> {return MCPaintballEntities.BLUE_PAINTBALL.get();}
        }
        return null;
    }
    public EntityType<?> getHeavyPaintball(){
        switch (this){
            case RED -> {return MCPaintballEntities.RED_HEAVY_PAINTBALL.get();}
            case GREEN -> {return MCPaintballEntities.GREEN_HEAVY_PAINTBALL.get();}
            case BLUE -> {return MCPaintballEntities.BLUE_HEAVY_PAINTBALL.get();}
        }
        return null;
    }
    public String getPaintballTranslation(){
        switch (this){
            case RED -> {return "mcpaintball:red_paintball";}
            case GREEN -> {return "mcpaintball:green_paintball";}
            case BLUE -> {return "mcpaintball:blue_paintball";}
            case CYAN -> {return "mcpaintball:cyan_paintball";}
        }
        return null;
    }
}

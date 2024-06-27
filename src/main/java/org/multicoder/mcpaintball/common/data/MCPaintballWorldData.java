package org.multicoder.mcpaintball.common.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

public class MCPaintballWorldData extends SavedData
{
    public static final String SAVE_NAME = "mcpaintball";

    public static MCPaintballWorldData INSTANCE;
    public int RED_POINTS;
    public int GREEN_POINTS;
    public int BLUE_POINTS;
    public boolean MatchStarted;
    public boolean GameStarted;

    public static void IncrementByTranslationKey(String Key)
    {
        if(Key.contains("red")){
            INSTANCE.RED_POINTS++;
        } else if (Key.contains("green")) {
            INSTANCE.GREEN_POINTS++;
        } else if (Key.contains("blue")) {
            INSTANCE.BLUE_POINTS++;
        }
    }
    public static MCPaintballWorldData create()
    {
        MCPaintballWorldData data =  new MCPaintballWorldData();
        data.BLUE_POINTS = 0;
        data.GREEN_POINTS = 0;
        data.RED_POINTS = 0;
        data.MatchStarted = false;
        data.GameStarted = false;
        return data;
    }
    public static MCPaintballWorldData load(CompoundTag nbt)
    {
        MCPaintballWorldData data = new MCPaintballWorldData();
        data.RED_POINTS = nbt.getInt("red");
        data.BLUE_POINTS = nbt.getInt("blue");
        data.GREEN_POINTS = nbt.getInt("green");
        data.MatchStarted = nbt.getBoolean("match");
        data.GameStarted = nbt.getBoolean("game");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag)
    {
        tag.putInt("red",RED_POINTS);
        tag.putInt("green",GREEN_POINTS);
        tag.putInt("blue",BLUE_POINTS);
        tag.putBoolean("match",MatchStarted);
        tag.putBoolean("game",GameStarted);
        return tag;
    }
}

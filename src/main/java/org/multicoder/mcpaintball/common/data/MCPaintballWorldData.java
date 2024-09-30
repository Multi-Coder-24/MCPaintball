package org.multicoder.mcpaintball.common.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;


public class MCPaintballWorldData extends SavedData
{
    public static final String SAVE_NAME = "mcpaintball";

    public static MCPaintballWorldData INSTANCE;
    public int RED_POINTS;
    public int GREEN_POINTS;
    public int BLUE_POINTS;
    public int NULL_POINTS;
    public int GAME_TYPE;
    public boolean MatchStarted;
    public boolean GameStarted;
    public static void incrementByOrdinal(int Ordinal)
    {
        switch (Ordinal)
        {
            case 0 -> {
                INSTANCE.RED_POINTS++;
                INSTANCE.setDirty();
            }
            case 1 ->{
                INSTANCE.GREEN_POINTS++;
                INSTANCE.setDirty();
            }
            case 2 -> {
                INSTANCE.BLUE_POINTS++;
                INSTANCE.setDirty();
            }
        }
    }
    public static MCPaintballWorldData create()
    {
        MCPaintballWorldData data = new MCPaintballWorldData();
        data.BLUE_POINTS = 0;
        data.GREEN_POINTS = 0;
        data.RED_POINTS = 0;
        data.NULL_POINTS = -1;
        data.GAME_TYPE = 0;
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
        data.NULL_POINTS = nbt.getInt("null_points");
        data.MatchStarted = nbt.getBoolean("match");
        data.GAME_TYPE = nbt.getInt("type");
        data.GameStarted = nbt.getBoolean("game");
        return data;
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag tag)
    {
        tag.putInt("red",RED_POINTS);
        tag.putInt("green",GREEN_POINTS);
        tag.putInt("blue",BLUE_POINTS);
        tag.putInt("null_points",-1);
        tag.putInt("type",GAME_TYPE);
        tag.putBoolean("match",MatchStarted);
        tag.putBoolean("game",GameStarted);
        return tag;
    }
}

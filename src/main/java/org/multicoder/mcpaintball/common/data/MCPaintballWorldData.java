package org.multicoder.mcpaintball.common.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import org.multicoder.mcpaintball.MCPaintball;


@SuppressWarnings("all")
public class MCPaintballWorldData extends SavedData
{
    public static final String SAVE_NAME = "mcpaintball";

    public static MCPaintballWorldData INSTANCE;
    public int RED_POINTS;
    public int GREEN_POINTS;
    public int BLUE_POINTS;
    public int NULL_POINTS;
    public boolean MatchStarted;
    public boolean GameStarted;

    public static void IncrementByTranslationKey(String Key)
    {
        if(Key.contains("red"))
        {
            INSTANCE.RED_POINTS += 1;
            INSTANCE.setDirty();
        } else if (Key.contains("green"))
        {
            INSTANCE.GREEN_POINTS += 1;
            INSTANCE.setDirty();
        } else if (Key.contains("blue"))
        {
            INSTANCE.BLUE_POINTS += 1;
            INSTANCE.setDirty();
        }
        INSTANCE.setDirty();
    }
    public static MCPaintballWorldData create()
    {
        MCPaintball.LOG.info("New World Data");
        MCPaintballWorldData data = new MCPaintballWorldData();
        data.BLUE_POINTS = 0;
        data.GREEN_POINTS = 0;
        data.RED_POINTS = 0;
        data.NULL_POINTS = -1;
        data.MatchStarted = false;
        data.GameStarted = false;
        return data;
    }
    public static MCPaintballWorldData load(CompoundTag nbt, HolderLookup.Provider p_323640_)
    {
        MCPaintballWorldData data = new MCPaintballWorldData();
        data.RED_POINTS = nbt.getInt("red");
        data.BLUE_POINTS = nbt.getInt("blue");
        data.GREEN_POINTS = nbt.getInt("green");
        data.NULL_POINTS = nbt.getInt("null_points");
        data.MatchStarted = nbt.getBoolean("match");
        data.GameStarted = nbt.getBoolean("game");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider p_323640_)
    {
        tag.putInt("red",RED_POINTS);
        tag.putInt("green",GREEN_POINTS);
        tag.putInt("blue",BLUE_POINTS);
        tag.putInt("null_points",-1);
        tag.putBoolean("match",MatchStarted);
        tag.putBoolean("game",GameStarted);
        return tag;
    }
}

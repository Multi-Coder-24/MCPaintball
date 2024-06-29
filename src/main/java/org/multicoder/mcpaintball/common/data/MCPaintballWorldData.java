package org.multicoder.mcpaintball.common.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import org.multicoder.mcpaintball.MCPaintball;

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
        MCPaintballWorldData data = new MCPaintballWorldData();
        data.BLUE_POINTS = 0;
        data.GREEN_POINTS = 0;
        data.RED_POINTS = 0;
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
        data.MatchStarted = nbt.getBoolean("match");
        data.GameStarted = nbt.getBoolean("game");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag p_77763_, HolderLookup.Provider p_323640_) {
        p_77763_.putInt("red",RED_POINTS);
        p_77763_.putInt("green",GREEN_POINTS);
        p_77763_.putInt("blue",BLUE_POINTS);
        p_77763_.putBoolean("match",MatchStarted);
        p_77763_.putBoolean("game",GameStarted);
        return p_77763_;
    }
}

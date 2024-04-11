package org.multicoder.mcpaintball.common.data;

import net.minecraft.nbt.CompoundTag;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballMatch
{
    public String Name;
    public boolean Started;
    public int RED;
    public int GREEN;
    public int BLUE;
    public int CYAN;
    public int MAGENTA;
    public int YELLOW;
    public int LIME;
    public int LIGHT_BLUE;
    public int PINK;
    public int PURPLE;

    public MCPaintballMatch(String name){
        Name = name;
        RED = 0;
        GREEN = 0;
        BLUE = 0;
        CYAN = 0;
        MAGENTA = 0;
        YELLOW = 0;
        LIME = 0;
        LIGHT_BLUE = 0;
        PINK = 0;
        PURPLE = 0;
        Started = false;
    }

    public MCPaintballMatch(CompoundTag nbt)
    {
        Name = nbt.getString("name");
        Started = nbt.getBoolean("started");
        RED = nbt.getInt("red");
        GREEN = nbt.getInt("green");
        BLUE = nbt.getInt("blue");
        CYAN = nbt.getInt("cyan");
        MAGENTA = nbt.getInt("magenta");
        YELLOW = nbt.getInt("yellow");
        LIME = nbt.getInt("lime");
        LIGHT_BLUE = nbt.getInt("light_blue");
        PINK = nbt.getInt("pink");
        PURPLE = nbt.getInt("purple");
    }

    public CompoundTag Serialize()
    {
        CompoundTag nbt = new CompoundTag();
        nbt.putString("name",Name);
        nbt.putInt("red",RED);
        nbt.putInt("green",GREEN);
        nbt.putInt("blue",BLUE);
        nbt.putInt("cyan",CYAN);
        nbt.putInt("magenta",MAGENTA);
        nbt.putInt("yellow",YELLOW);
        nbt.putInt("lime",LIME);
        nbt.putInt("light_blue",LIGHT_BLUE);
        nbt.putInt("pink",PINK);
        nbt.putInt("purple",PURPLE);
        nbt.putBoolean("started",Started);
        return nbt;
    }

    public void IncrementByOrdinal(int Index)
    {
        switch (Index)
        {
            case 0 -> RED++;
            case 1 -> GREEN++;
            case 2 -> BLUE++;
            case 3 -> CYAN++;
            case 4 -> MAGENTA++;
            case 5 -> YELLOW++;
            case 6 -> LIME++;
            case 7 -> LIGHT_BLUE++;
            case 8 -> PINK++;
            case 9 -> PURPLE++;
        }
    }
}

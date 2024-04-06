package org.multicoder.mcpaintball.common.data;

import net.minecraft.nbt.CompoundTag;

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
        nbt.putInt("green",RED);
        nbt.putInt("blue",RED);
        nbt.putInt("cyan",RED);
        nbt.putInt("magenta",RED);
        nbt.putInt("yellow",RED);
        nbt.putInt("lime",RED);
        nbt.putInt("light_blue",RED);
        nbt.putInt("pink",RED);
        nbt.putInt("purple",RED);
        nbt.putBoolean("started",Started);
        return nbt;
    }

    public void IncrementByTranslationKey(String Key)
    {
        if(Key.contains("red")){
            RED++;
        } else if (Key.contains("green")) {
            GREEN++;
        } else if (Key.contains("blue")) {
            BLUE++;
        } else if (Key.contains("cyan")) {
            CYAN++;
        } else if (Key.contains("magenta")) {
            MAGENTA++;
        } else if (Key.contains("yellow")) {
            YELLOW++;
        } else if (Key.contains("lime")) {
            LIME++;
        } else if (Key.contains("light_blue")) {
            LIGHT_BLUE++;
        } else if (Key.contains("pink")) {
            PINK++;
        } else if (Key.contains("purple")) {
            PURPLE++;
        }
    }
}

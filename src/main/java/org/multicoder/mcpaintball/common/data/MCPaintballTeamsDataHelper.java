package org.multicoder.mcpaintball.common.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

@SuppressWarnings("all")
public class MCPaintballTeamsDataHelper
{
    public static void SetIfAbsent(Player player)
    {
        if(!player.getPersistentData().contains("mcpaintball.team"))
        {
            CompoundTag Default = new CompoundTag();
            Default.putInt("team", 0);
            Default.putInt("class", 0);
            Default.putInt("points", 0);
            Default.putBoolean("active",false);
            player.getPersistentData().put("mcpaintball.team", Default);
        }
    }
    public static int FetchPoints(Player player)
    {
        return player.getPersistentData().getCompound("mcpaintball.team").getInt("points");
    }
    public static void ResetAll(Player player)
    {
        CompoundTag Data = player.getPersistentData().getCompound("mcpaintball.team");
        Data.putInt("team", 0);
        Data.putInt("class", 0);
        Data.putInt("points", 0);
        Data.putBoolean("active",false);
        player.getPersistentData().put("mcpaintball.team", Data);
    }
    public static boolean HasTeam(Player player)
    {
        if(player.getPersistentData().contains("mcpaintball.team"))
        {
            if(player.getPersistentData().getCompound("mcpaintball.team").getBoolean("active")){
                return player.getPersistentData().getCompound("mcpaintball.team").getInt("team") >= 1;
            }
        }
        return false;
    }
    public static void AddPoint(Player player)
    {
        CompoundTag Data = player.getPersistentData().getCompound("mcpaintball.team");
        int Cached = Data.getInt("points");
        Cached += 1;
        Data.putInt("points",Cached);
        player.getPersistentData().put("mcpaintball.team", Data);
    }
    public static int FetchTeam(Player player)
    {
        return player.getPersistentData().getCompound("mcpaintball.team").getInt("team");
    }
    public static int FetchClass(Player player){
        return player.getPersistentData().getCompound("mcpaintball.team").getInt("class");
    }
    public static void UpdateTeam(int Team,Player player)
    {
        CompoundTag Data = player.getPersistentData().getCompound("mcpaintball.team");
        Data.putInt("team",Team);
        Data.putBoolean("active",true);
        player.getPersistentData().put("mcpaintball.team",Data);
    }
    public static void UpdateClass(int Class,Player player)
    {
        CompoundTag Data = player.getPersistentData().getCompound("mcpaintball.team");
        Data.putInt("class",Class);
        Data.putBoolean("active",true);
        player.getPersistentData().put("mcpaintball.team",Data);
    }
}

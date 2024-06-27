package org.multicoder.mcpaintball.common.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class MCPaintballTeamsDataHelper
{
    public static void SetIfAbsent(Player player)
    {
        if(!player.getPersistentData().contains("mcpaintball.team"))
        {
            CompoundTag Default = new CompoundTag();
            Default.putInt("team",-1);
            Default.putInt("class",-1);
            player.getPersistentData().put("mcpaintball.team",Default);
        }
    }
    public static void ResetAll(Player player)
    {
        CompoundTag Data = player.getPersistentData().getCompound("mcpaintball.team");
        Data.putInt("team",-1);
        Data.putInt("class",-1);
        player.getPersistentData().put("mcpaintball.team",Data);
    }
    public static boolean HasTeam(Player player)
    {
        if(player.getPersistentData().contains("mcpaintball.team"))
        {
            return player.getPersistentData().getCompound("mcpaintball.team").getInt("team") > 0;
        }
        return false;
    }
    public static boolean HasClass(Player player)
    {
        if(player.getPersistentData().contains("mcpaintball.team"))
        {
            return player.getPersistentData().getCompound("mcpaintball.team").getInt("class") > 0;
        }
        return false;
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
        player.getPersistentData().put("mcpaintball.team",Data);
    }
    public static void UpdateClass(int Class,Player player)
    {
        CompoundTag Data = player.getPersistentData().getCompound("mcpaintball.team");
        Data.putInt("class",Class);
        player.getPersistentData().put("mcpaintball.team",Data);
    }
}
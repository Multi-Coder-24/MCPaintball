package org.multicoder.mcpaintball.capability;

import net.minecraft.nbt.CompoundTag;

public class PlayerTeamCapability
{
    private int Team;
    private int Points;
    public static final String Version = "1.0.0";

    private String Class;

    public int GetTeam(){
        return Team;
    }
    public String getVersion(){return Version;}
    public void SetTeam(int t)
    {
        Team = t;
    }
    public void ResetTeam(){Team = 0;}

    public int GetPoints(){
        return Points;
    }
    public void SetPoints(int P){
        Points = P;
    }
    public void ResetPoints(){
        Points = 0;
    }
    public void IncPoints()
    {
        Points += 1;
    }
    public void DecPoints(){Points -= 1;}
    public void AddPoints(int p){Points += p;}

    public void SetClass(String Selected){Class = Selected;}
    public String GetClass(){return Class;}
    public void ResetClass(){Class = "None";}

    public void ResetAll()
    {
        Team = 0;
        Points = 0;
        Class = "None";
    }
    public void CopyFrom(PlayerTeamCapability source)
    {
        this.Team = source.GetTeam();
        this.Points = source.GetPoints();
        this.Class = source.GetClass();
    }

    public void saveNBT(CompoundTag tag)
    {
        tag.putInt("Team",Team);
        tag.putInt("Points",Points);
        tag.putString("Class",Class);
        tag.putString("Version",Version);
    }

    public void readNBT(CompoundTag tag)
    {
        this.SetTeam(tag.getInt("Team"));
        this.SetPoints(tag.getInt("Points"));
        this.SetClass(tag.getString("Class"));
    }
}

package org.multicoder.mcpaintball.common.capability;

import net.minecraft.nbt.CompoundTag;
import org.multicoder.mcpaintball.common.util.enums.KitType;
import org.multicoder.mcpaintball.common.util.enums.Teams;

@SuppressWarnings("all")
public class PaintballPlayer {
    public int Points;
    public Teams Team;
    public KitType ClassType;
    public String LoadoutCode;

    public void reset() {
        Points = 0;
        Team = Teams.NONE;
        ClassType = KitType.NONE;
        LoadoutCode = String.valueOf(0) + String.valueOf(0);
    }

    public void SetPoints(int P) {
        Points = P;
    }

    public int GetPoints() {
        return Points;
    }

    public void SetTeam(Teams T) {
        Team = T;
        UpdateLoadoutCode();
    }

    public Teams GetTeam() {
        return Team;
    }

    public void SetClass(KitType T) {
        ClassType = T;
        UpdateLoadoutCode();
    }

    public KitType GetClass() {
        return ClassType;
    }

    public String GetCode() {
        return LoadoutCode;
    }

    private void UpdateLoadoutCode() {
        LoadoutCode = String.valueOf(Team.ordinal()) + String.valueOf(ClassType.ordinal());
    }

    public void copyFrom(PaintballPlayer player) {
        Points = player.Points;
        Team = player.Team;
        ClassType = player.ClassType;
    }

    public void saveNBT(CompoundTag nbt) {
        nbt.putInt("points", Points);
        nbt.putInt("team", Team.ordinal());
        nbt.putInt("class", ClassType.ordinal());
        nbt.putString("loadout_code", LoadoutCode);
    }

    public void readNBT(CompoundTag nbt) {
        Points = nbt.getInt("points");
        Team = Teams.getTeam(nbt.getInt("team"));
        ClassType = KitType.GetType(nbt.getInt("class"));
        LoadoutCode = nbt.getString("loadout_code");
    }
}

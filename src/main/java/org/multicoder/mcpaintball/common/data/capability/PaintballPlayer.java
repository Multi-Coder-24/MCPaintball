package org.multicoder.mcpaintball.common.data.capability;

import net.minecraft.nbt.CompoundTag;
import org.multicoder.mcpaintball.common.utility.PaintballClass;
import org.multicoder.mcpaintball.common.utility.PaintballTeam;

public class PaintballPlayer {
    private PaintballClass Type = PaintballClass.STANDARD;
    private PaintballTeam Team = PaintballTeam.RED;
    private String Name = "";

    public void SetType(PaintballClass type) {
        Type = type;
    }

    public void SetTeam(PaintballTeam team) {
        Team = team;
    }

    public void SetName(String name) {
        Name = name;
    }

    public PaintballClass GetType() {
        return Type;
    }

    public PaintballTeam GetTeam() {
        return Team;
    }

    public String getName() {
        return Name;
    }


    public void CopyFrom(PaintballPlayer player) {
        this.Team = player.Team;
        this.Type = player.Type;
        this.Name = player.Name;
    }

    public void SaveNBT(CompoundTag tag) {
        tag.putInt("team", Team.ordinal());
        tag.putInt("type", Type.ordinal());
        tag.putString("name", Name);
    }

    public void LoadNBT(CompoundTag tag) {
        Team = PaintballTeam.values()[tag.getInt("team")];
        Type = PaintballClass.values()[tag.getInt("type")];
        Name = tag.getString("name");
    }
}

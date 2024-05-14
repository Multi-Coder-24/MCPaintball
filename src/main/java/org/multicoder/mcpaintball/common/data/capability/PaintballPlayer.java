package org.multicoder.mcpaintball.common.data.capability;

import net.minecraft.nbt.CompoundTag;
import org.multicoder.mcpaintball.common.utility.PaintballClass;
import org.multicoder.mcpaintball.common.utility.PaintballTeam;

import java.rmi.AccessException;

public class PaintballPlayer {
    private PaintballClass Type = PaintballClass.STANDARD;
    private PaintballTeam Team = PaintballTeam.RED;
    private String Name = "";

    public void SetType(PaintballClass type,Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            Type = type;
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }

    public void SetTeam(PaintballTeam team,Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            Team = team;
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }

    }

    public void SetName(String name,Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            Name = name;
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }

    public PaintballClass GetType(Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            return Type;
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }

    public PaintballTeam GetTeam(Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            return Team;
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }

    public String getName(Class<?> Invoker) throws AccessException {
        if(Invoker.getPackageName().startsWith("org.multicoder")){
            return Name;
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
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

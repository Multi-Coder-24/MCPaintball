package org.multicoder.mcpaintball.data.attachments;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

public class PlayerTeamDataAttachment implements INBTSerializable<CompoundTag>
{
    public int Team;
    public int Class;
    public int Points;
    public PlayerTeamDataAttachment(){
        Team = 0;
        Class = 0;
        Points = 0;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.@NotNull Provider provider)
    {
        CompoundTag tag = new CompoundTag();
        tag.putInt("Team", Team);
        tag.putInt("Class", Class);
        tag.putInt("Points", Points);
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.@NotNull Provider provider, CompoundTag compoundTag)
    {
        this.Team = compoundTag.getInt("Team");
        this.Class = compoundTag.getInt("Class");
        this.Points = compoundTag.getInt("Points");
    }
}

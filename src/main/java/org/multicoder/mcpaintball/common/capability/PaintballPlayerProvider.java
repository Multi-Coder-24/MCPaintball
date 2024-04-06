package org.multicoder.mcpaintball.common.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.common.util.enums.KitType;
import org.multicoder.mcpaintball.common.util.enums.Teams;

@SuppressWarnings("all")
public class PaintballPlayerProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PaintballPlayer> CAPABILITY = CapabilityManager.get(new CapabilityToken<PaintballPlayer>() {
    });
    public PaintballPlayer TEAM = null;
    public LazyOptional<PaintballPlayer> optional = LazyOptional.of(this::CreateCapabiliy);

    private PaintballPlayer CreateCapabiliy() {
        if (this.TEAM == null) {
            this.TEAM = new PaintballPlayer();
            this.TEAM.Points = 0;
            this.TEAM.ClassType = KitType.NONE;
            this.TEAM.Team = Teams.NONE;
            this.TEAM.LoadoutCode = "00";
        }
        return this.TEAM;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CAPABILITY) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        this.CreateCapabiliy().saveNBT(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.CreateCapabiliy().readNBT(nbt);
    }
}

package org.multicoder.mcpaintball.common.data.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.capabilities.CapabilityManager;
import net.neoforged.neoforge.common.capabilities.CapabilityToken;
import net.neoforged.neoforge.common.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PaintballPlayerProvider implements ICapabilityProvider, INBTSerializable<CompoundTag>
{
    public static Capability<PaintballPlayer> CAPABILITY = CapabilityManager.get(new CapabilityToken<PaintballPlayer>() {});

    private PaintballPlayer playerData = null;
    private final LazyOptional<PaintballPlayer> optional = LazyOptional.of(this::createPaintballPlayer);

    private PaintballPlayer createPaintballPlayer()
    {
        if(this.playerData == null) {
            this.playerData = new PaintballPlayer();
        }
        return this.playerData;
    }
    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag tag = new CompoundTag();
        createPaintballPlayer().SaveNBT(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag)
    {
        createPaintballPlayer().LoadNBT(tag);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction direction)
    {
        if(capability == CAPABILITY){
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if(cap == CAPABILITY){
            return optional.cast();
        }
        return LazyOptional.empty();
    }
}

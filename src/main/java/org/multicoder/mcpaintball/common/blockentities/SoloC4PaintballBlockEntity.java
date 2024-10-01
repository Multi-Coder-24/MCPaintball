package org.multicoder.mcpaintball.common.blockentities;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.multicoder.mcpaintball.common.init.MCPaintballBlockEntities;

import java.util.UUID;

@SuppressWarnings("all")
public class SoloC4PaintballBlockEntity extends BlockEntity
{
    protected static UUID Placer = Util.NIL_UUID;

    public SoloC4PaintballBlockEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(MCPaintballBlockEntities.SOLO_C4.get(), p_155229_, p_155230_);
    }

    public void PlacedBy(Player player)
    {
        Placer = player.getUUID();
    }
    public boolean IsSamePlayer(Player player)
    {
        return Placer.equals(player.getUUID());
    }

    @Override
    public void load(CompoundTag compoundTag)
    {
        super.load(compoundTag);
        Placer = compoundTag.getUUID("placer");
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag)
    {
        super.saveAdditional(compoundTag);
        compoundTag.putUUID("placer",Placer);
    }

}

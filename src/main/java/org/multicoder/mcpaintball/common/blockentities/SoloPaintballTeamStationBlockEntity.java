package org.multicoder.mcpaintball.common.blockentities;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

@SuppressWarnings("all")
public class SoloPaintballTeamStationBlockEntity extends BlockEntity
{
    protected static UUID Placer = Util.NIL_UUID;
    public SoloPaintballTeamStationBlockEntity(BlockPos p_155229_, BlockState p_155230_)
    {
        super(MCPaintballBlockEntities.SOLO_STATION.get(), p_155229_, p_155230_);
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
    protected void saveAdditional(CompoundTag p_187471_, HolderLookup.Provider p_323635_)
    {
        super.saveAdditional(p_187471_, p_323635_);
        p_187471_.putUUID("placer",Placer);
    }

    @Override
    protected void loadAdditional(CompoundTag p_338466_, HolderLookup.Provider p_338445_)
    {
        super.loadAdditional(p_338466_, p_338445_);
        Placer = p_338466_.getUUID("placer");
    }
}

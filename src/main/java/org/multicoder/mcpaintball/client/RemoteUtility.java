package org.multicoder.mcpaintball.client;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.init.soundinit;
import org.multicoder.mcpaintball.common.util.enums.Teams;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class RemoteUtility {
    public static boolean HandleRemote(Level level, Player player, ItemStack stack, Teams Team, BlockState state, BlockPos pos)
    {
        try{
            CompoundTag nbt = stack.getOrCreateTag();
            if (nbt.contains("targets")) {
                ListTag LT = nbt.getList("targets", Tag.TAG_COMPOUND);
                CompoundTag tag = new CompoundTag();
                tag.putInt("X", pos.getX());
                tag.putInt("Y", pos.getY());
                tag.putInt("Z", pos.getZ());
                if (Team.GetExplosive() == state.getBlock()) {
                    if (LT.contains(tag)) {
                        LT.remove(tag);
                        level.playSound(null, player.blockPosition(), soundinit.REM.get(), SoundSource.PLAYERS, 1f, 1f);
                    } else {
                        level.playSound(null, player.blockPosition(), soundinit.SET.get(), SoundSource.PLAYERS, 1f, 1f);
                        LT.add(tag);
                    }
                }
            } else {
                ListTag LT = new ListTag();
                if (Team.GetExplosive() == state.getBlock()) {
                    CompoundTag tag = new CompoundTag();
                    tag.putInt("X", pos.getX());
                    tag.putInt("Y", pos.getY());
                    tag.putInt("Z", pos.getZ());
                    LT.add(tag);
                    nbt.put("targets", LT);
                    level.playSound(null, player.blockPosition(), soundinit.SET.get(), SoundSource.PLAYERS, 1f, 1f);
                }
            }
            return true;
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
        return false;
    }

    public static List<BlockPos> HandleDetonation(Level level, ItemStack stack, Teams Team)
    {
        try{
            CompoundTag nbt = stack.getOrCreateTag();
            if (nbt.contains("targets")) {
                ListTag LT = nbt.getList("targets", Tag.TAG_COMPOUND);
                List<BlockPos> Positions = new ArrayList<>();
                List<BlockPos> Valid = new ArrayList<>();
                LT.forEach(tag -> {
                    CompoundTag loc = (CompoundTag) tag;
                    BlockPos Position = new BlockPos(loc.getInt("X"), loc.getInt("Y"), loc.getInt("Z"));
                    Positions.add(Position);
                });
                Positions.forEach(pos ->
                {
                    if (Team.GetExplosive() == level.getBlockState(pos).getBlock()) {
                        Valid.add(pos);
                    }
                });
                return Valid;
            }
            return null;
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
        return null;
    }
}

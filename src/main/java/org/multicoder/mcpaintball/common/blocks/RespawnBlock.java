package org.multicoder.mcpaintball.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.apache.logging.log4j.MarkerManager;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayerProvider;

import java.rmi.AccessException;

public class RespawnBlock extends Block
{
    public RespawnBlock()
    {
        super(BlockBehaviour.Properties.copy(Blocks.REINFORCED_DEEPSLATE).noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        if(!level.isClientSide())
        {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            PaintballPlayer Cap = serverPlayer.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
            try {
                if(MCPaintballWorldData.INSTANCE.StartedByName(Cap.getName(RespawnBlock.class), RespawnBlock.class))
                {
                    Block Ref = null;
                    switch (Cap.GetTeam(RespawnBlock.class))
                    {
                        case RED -> Ref = MCPaintballBlocks.RED_RESPAWN.get();
                        case BLUE -> Ref = MCPaintballBlocks.BLUE_RESPAWN.get();
                        case GREEN -> Ref = MCPaintballBlocks.GREEN_RESPAWN.get();
                        case CYAN -> Ref = MCPaintballBlocks.CYAN_RESPAWN.get();
                        case MAGENTA -> Ref = MCPaintballBlocks.MAGENTA_RESPAWN.get();
                        case YELLOW -> Ref = MCPaintballBlocks.YELLOW_RESPAWN.get();
                        case LIME -> Ref = MCPaintballBlocks.LIME_RESPAWN.get();
                        case LIGHT_BLUE -> Ref = MCPaintballBlocks.LIGHT_BLUE_RESPAWN.get();
                        case PINK -> Ref = MCPaintballBlocks.PINK_RESPAWN.get();
                        case PURPLE -> Ref = MCPaintballBlocks.PURPLE_RESPAWN.get();
                    }
                    if(state.getBlock() == Ref)
                    {
                        serverPlayer.setRespawnPosition(level.dimension(),pos.above(),0f,true,false);
                    }
                }
            } catch (AccessException e)
            {
                MCPaintball.SECURITY_LOG.fatal(MarkerManager.getMarker("MCPaintball"),"An attempt Was made to access an anti-cheat protected class");
            }
        }
        return super.use(state, level, pos, player, hand, result);
    }
}

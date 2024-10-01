package org.multicoder.mcpaintball.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;

@SuppressWarnings("all")
public class FlagBlock extends Block
{
    public static final IntegerProperty TEAM = IntegerProperty.create("team",0,3);
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");
    public FlagBlock()
    {
        super(Properties.of());
        registerDefaultState(defaultBlockState().setValue(TEAM,3).setValue(LOCKED,false));
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source)
    {
        level.setBlockAndUpdate(pos,state.setValue(LOCKED,false));
        super.tick(state, level, pos, source);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result)
    {
        if(!player.level().isClientSide())
        {
            if(MCPaintballWorldData.INSTANCE.MatchStarted)
            {
                if(MCPaintballWorldData.INSTANCE.GAME_TYPE == 0 || MCPaintballWorldData.INSTANCE.GAME_TYPE == 2)
                {
                    if(MCPaintballTeamsDataHelper.HasTeam(player))
                    {
                        int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                        if(!state.getValue(TEAM).equals(Team))
                        {
                            level.setBlockAndUpdate(pos,state.setValue(TEAM,MCPaintballTeamsDataHelper.FetchTeam(player)).setValue(LOCKED,true));
                            level.scheduleTick(pos,this,100);
                            MCPaintballWorldData.incrementByOrdinal(MCPaintballTeamsDataHelper.FetchTeam(player));
                            MCPaintballWorldData.INSTANCE.setDirty();
                        }
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(TEAM);
        builder.add(LOCKED);
        super.createBlockStateDefinition(builder);
    }
}

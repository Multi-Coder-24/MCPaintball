package org.multicoder.mcpaintball.blocks;

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
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.data.MCPaintballWorldData;

import static net.minecraft.world.InteractionResult.SUCCESS;
import static org.multicoder.mcpaintball.data.MCPaintballWorldData.INSTANCE;

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
    public void tick(BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source)
    {
        level.setBlockAndUpdate(pos,state.setValue(LOCKED,false));
        super.tick(state, level, pos, source);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result)
    {
        if(!player.level().isClientSide())
        {
            if(INSTANCE.MatchStarted)
            {
                if(MCPaintballTeamsDataHelper.HasTeam(player))
                {
                    int Team = MCPaintballTeamsDataHelper.FetchTeam(player);
                    if(!state.getValue(TEAM).equals(Team))
                    {
                        level.setBlockAndUpdate(pos,state.setValue(TEAM,MCPaintballTeamsDataHelper.FetchTeam(player)).setValue(LOCKED,true));
                        level.scheduleTick(pos,this,100);
                        MCPaintballWorldData.incrementByIndex(MCPaintballTeamsDataHelper.FetchTeam(player));
                        INSTANCE.setDirty();
                    }
                }
            }
        }
        return SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(TEAM);
        builder.add(LOCKED);
        super.createBlockStateDefinition(builder);
    }
}

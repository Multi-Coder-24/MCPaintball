package org.multicoder.mcpaintball.block.doors;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class TeamedDoor extends DoorBlock {
    public BlockSetType type = BlockSetType.IRON;
    public TeamedDoor(Properties properties) {
        super(BlockSetType.IRON, properties);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, final @NonNull Level level, final @NonNull BlockPos pos, final @NonNull Player player, final @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.matchStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                MCPaintballPlayerData data = Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER));
                if(data.team != 0){
                    if(state.getBlock() == MCPaintballBlocks.RED_DOOR && data.team == 1){
                        state = state.cycle(OPEN);
                        level.setBlock(pos, state, 10);
                    }else  if(state.getBlock() == MCPaintballBlocks.GREEN_DOOR && data.team == 2){
                        state = state.cycle(OPEN);
                        level.setBlock(pos, state, 10);
                    }else if(state.getBlock() == MCPaintballBlocks.BLUE_DOOR && data.team == 3){
                        state = state.cycle(OPEN);
                        level.setBlock(pos, state, 10);
                    }else if(state.getBlock() == MCPaintballBlocks.YELLOW_DOOR && data.team == 4){
                        state = state.cycle(OPEN);
                        level.setBlock(pos, state, 10);
                    }else if(state.getBlock() == MCPaintballBlocks.PINK_DOOR && data.team == 5){
                        state = state.cycle(OPEN);
                        level.setBlock(pos, state, 10);
                    }else if(state.getBlock() == MCPaintballBlocks.ORANGE_DOOR && data.team == 6){
                        state = state.cycle(OPEN);
                        level.setBlock(pos, state, 10);
                    }else {
                        return InteractionResult.PASS;
                    }
                    this.playSound(player, level, pos, state.getValue(OPEN));
                    level.gameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
                    level.scheduleTick(pos,this,20);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    protected void tick(@NonNull BlockState state, @NonNull ServerLevel level, @NonNull BlockPos pos, @NonNull RandomSource random) {
        state = state.cycle(OPEN);
        level.setBlock(pos, state, 10);
        super.tick(state, level, pos, random);
    }

    private void playSound(final @Nullable Entity entity, final Level level, final BlockPos pos, final boolean open) {
        level.playSound(entity, pos, open ? this.type.doorOpen() : this.type.doorClose(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
    }


}

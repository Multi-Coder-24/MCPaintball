package org.multicoder.mcpaintball.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.block.explosives.RedClaymoreBlock;
import org.multicoder.mcpaintball.core.MCPaintballBlockEntities;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballParticles;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class BlueClaymoreBlockEntity extends BlockEntity{
    public int Ticker = 0;
    public BlueClaymoreBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(MCPaintballBlockEntities.BLUE_CLAYMORE_BLOCK_ENTITY, worldPosition, blockState);
    }

    public static void tick(@NonNull Level level, @NonNull BlockPos pos, @NonNull BlockState state, @NonNull BlueClaymoreBlockEntity entity) {
        if(!Objects.requireNonNull(level).isClientSide()){
            if(entity.Ticker == 20){
                if(MCPaintballGameEvents.INSTANCE.tournamentStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                    ServerLevel serverLevel = (ServerLevel) level;
                    Direction direction = state.getValue(RedClaymoreBlock.FACING);
                    AABB box = switch (direction){
                        case NORTH -> new AABB(entity.getBlockPos()).contract(0,0,5);
                        case SOUTH -> new AABB(entity.getBlockPos()).contract(0,0,-5);
                        case EAST -> new AABB(entity.getBlockPos()).contract(-5,0,0);
                        case WEST -> new AABB(entity.getBlockPos()).contract(5,0,0);
                        default -> new AABB(entity.getBlockPos());
                    };
                    serverLevel.getEntitiesOfClass(ServerPlayer.class,box).forEach(player -> {
                        AABB explosionBox = AABB.encapsulatingFullBlocks(entity.getBlockPos().offset(-5, 0, -5), entity.getBlockPos().offset(5, 0, 5));
                        BlockPos.betweenClosed(explosionBox).forEach(blockPos -> serverLevel.sendParticles(MCPaintballParticles.BLUE_PAINT, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 3, 1, 1, 1, 0.01));
                        level.setBlockAndUpdate(pos,Blocks.AIR.defaultBlockState());
                        if(player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER).team > 0 && player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER).team != 3){
                            MCPaintballGameEvents.INSTANCE.bluePoints++;
                            MCPaintballGameEvents.INSTANCE.setDirty(true);
                            if(player.getRespawnConfig() == null){return;}
                            BlockPos respawn = Objects.requireNonNull(player.getRespawnConfig()).respawnData().pos();
                            player.teleportTo(respawn.getX(), respawn.getY(), respawn.getZ());
                        }
                    });
                }
            }
            else{
                if(MCPaintballGameEvents.INSTANCE.tournamentStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                    entity.Ticker++;
                }
            }
        }
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        output.putInt("ticker", Ticker);
        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        Ticker = input.getIntOr("ticker",0);
        super.loadAdditional(input);
    }
}

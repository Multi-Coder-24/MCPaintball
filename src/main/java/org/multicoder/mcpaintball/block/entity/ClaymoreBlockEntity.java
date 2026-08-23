package org.multicoder.mcpaintball.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.block.explosives.*;
import org.multicoder.mcpaintball.core.MCPaintballBlockEntities;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballParticles;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class ClaymoreBlockEntity extends BlockEntity{
    public int Ticker = 0;

    public ClaymoreBlockEntity(BlockEntityType<ClaymoreBlockEntity>type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
    public ClaymoreBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(MCPaintballBlockEntities.RED_CLAYMORE_BLOCK_ENTITY, worldPosition, blockState);
    }

    public static void tick(@NonNull Level level, @NonNull BlockPos pos, @NonNull BlockState state, @NonNull ClaymoreBlockEntity entity) {
        if(!Objects.requireNonNull(level).isClientSide()){
            if(entity.Ticker == 20){
                if(MCPaintballGameEvents.INSTANCE.tournamentStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                    ServerLevel serverLevel = (ServerLevel) level;
                    Block claymore = state.getBlock();
                    Direction direction = state.getValue(ClaymoreBlock.FACING);
                    int Team;
                    SimpleParticleType type;
                    if(claymore == MCPaintballBlocks.RED_CLAYMORE_BLOCK){
                        Team = 1;
                        type = MCPaintballParticles.RED_PAINT;
                    }
                    else if(claymore == MCPaintballBlocks.GREEN_CLAYMORE_BLOCK){
                        Team = 2;
                        type = MCPaintballParticles.GREEN_PAINT;
                    }
                    else if(claymore == MCPaintballBlocks.BLUE_CLAYMORE_BLOCK){
                        Team = 3;
                        type = MCPaintballParticles.BLUE_PAINT;
                    }
                    else if(claymore == MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK){
                        Team = 4;
                        type = MCPaintballParticles.YELLOW_PAINT;
                    }
                    else if(claymore == MCPaintballBlocks.PINK_CLAYMORE_BLOCK){
                        Team = 5;
                        type = MCPaintballParticles.PINK_PAINT;
                    }
                    else if(claymore == MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK){
                        Team = 6;
                        type = MCPaintballParticles.ORANGE_PAINT;
                    } else {return;}
                    AABB box = switch (direction){
                        case NORTH -> new AABB(entity.getBlockPos()).contract(0,0,5);
                        case SOUTH -> new AABB(entity.getBlockPos()).contract(0,0,-5);
                        case EAST -> new AABB(entity.getBlockPos()).contract(-5,0,0);
                        case WEST -> new AABB(entity.getBlockPos()).contract(5,0,0);
                        default -> new AABB(entity.getBlockPos());
                    };
                    serverLevel.getEntitiesOfClass(ServerPlayer.class,box).forEach(player -> {
                        AABB explosionBox = AABB.encapsulatingFullBlocks(entity.getBlockPos().offset(-5, 0, -5), entity.getBlockPos().offset(5, 0, 5));
                        BlockPos.betweenClosed(explosionBox).forEach(blockPos -> serverLevel.sendParticles(type, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 3, 1, 1, 1, 0.01));
                        level.setBlockAndUpdate(pos,Blocks.AIR.defaultBlockState());
                        if(player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER).team > 0 && player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER).team != Team){
                            MCPaintballGameEvents.INSTANCE.incrementByChecker(Team);
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

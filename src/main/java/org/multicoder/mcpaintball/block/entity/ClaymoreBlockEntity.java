package org.multicoder.mcpaintball.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.block.explosives.ClaymoreBlock;
import org.multicoder.mcpaintball.core.MCPaintballBlockEntities;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballParticles;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;
import java.util.function.Supplier;

public class ClaymoreBlockEntity extends BlockEntity{
    public int Ticker = 0;
    public ClaymoreBlockEntity(BlockEntityType<?> type, BlockPos worldPosition, BlockState blockState) {
        super(type, worldPosition, blockState);
    }

    public static void tick(@NonNull Level level, @NonNull BlockPos pos, @NonNull BlockState state, @NonNull ClaymoreBlockEntity entity) {
        if(!Objects.requireNonNull(level).isClientSide()){
            if(entity.Ticker == 20){
                if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                    ServerLevel serverLevel = (ServerLevel) level;
                    Direction direction = state.getValue(ClaymoreBlock.FACING);
                    AABB box = switch (direction){
                        case NORTH -> new AABB(entity.getBlockPos()).contract(0,0,5);
                        case SOUTH -> new AABB(entity.getBlockPos()).contract(0,0,-5);
                        case EAST -> new AABB(entity.getBlockPos()).contract(-5,0,0);
                        case WEST -> new AABB(entity.getBlockPos()).contract(5,0,0);
                        default -> new AABB(entity.getBlockPos());
                    };
                    serverLevel.getEntitiesOfClass(ServerPlayer.class,box).forEach(player -> {
                        Supplier<SimpleParticleType> typeSupplier;
                        int Checker = 0;
                        if(entity.getType() == MCPaintballBlockEntities.RED_CLAYMORE_BLOCK_ENTITY.get()){
                            typeSupplier = MCPaintballParticles.RED_PAINT;
                            Checker = 1;
                        }else if(entity.getType() == MCPaintballBlockEntities.GREEN_CLAYMORE_BLOCK_ENTITY.get()){
                            typeSupplier = MCPaintballParticles.GREEN_PAINT;
                            Checker = 2;
                        } else if(entity.getType() == MCPaintballBlockEntities.BLUE_CLAYMORE_BLOCK_ENTITY.get()){
                            typeSupplier = MCPaintballParticles.BLUE_PAINT;
                            Checker = 3;
                        }else if(entity.getType() == MCPaintballBlockEntities.YELLOW_CLAYMORE_BLOCK_ENTITY.get()){
                            typeSupplier = MCPaintballParticles.YELLOW_PAINT;
                            Checker = 4;
                        }else if(entity.getType() == MCPaintballBlockEntities.PINK_CLAYMORE_BLOCK_ENTITY.get()){
                            typeSupplier = MCPaintballParticles.PINK_PAINT;
                            Checker = 5;
                        }else if(entity.getType() == MCPaintballBlockEntities.ORANGE_CLAYMORE_BLOCK_ENTITY.get()){
                            typeSupplier = MCPaintballParticles.ORANGE_PAINT;
                            Checker = 6;
                        }else {
                            typeSupplier = MCPaintballParticles.RED_PAINT;
                        }
                        AABB explosionBox = AABB.encapsulatingFullBlocks(entity.getBlockPos().offset(-5, 0, -5), entity.getBlockPos().offset(5, 0, 5));
                        BlockPos.betweenClosed(explosionBox).forEach(blockPos -> serverLevel.sendParticles(typeSupplier.get(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 3, 1, 1, 1, 0.01));
                        level.setBlockAndUpdate(pos,Blocks.AIR.defaultBlockState());
                        if(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER).Team > 0 && player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER).Team != Checker){
                            MCPaintballGameEvents.INSTANCE.IncrementByChecker(Checker);
                            if(player.getRespawnConfig() == null){return;}
                            BlockPos respawn = Objects.requireNonNull(player.getRespawnConfig()).respawnData().pos();
                            player.teleportTo(respawn.getX(), respawn.getY(), respawn.getZ());
                        }
                    });
                }
            }
            else{
                if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
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

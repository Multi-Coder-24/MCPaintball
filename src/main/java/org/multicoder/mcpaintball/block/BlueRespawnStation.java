package org.multicoder.mcpaintball.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.LevelData;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class BlueRespawnStation extends Block {

    public BlueRespawnStation(Properties properties) {
        super(properties);
    }

//    @Override
//    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
//        return makeShape();
//    }
//
//    public VoxelShape makeShape(){
//        VoxelShape shape = Shapes.empty();
//        shape = Shapes.join(shape, Shapes.box(0, 0.25, 0.4375, 1, 1, 0.5625), BooleanOp.OR);
//        shape = Shapes.join(shape, Shapes.box(0, 0, 0.328125, 1, 0.25, 0.703125), BooleanOp.OR);
//        shape = Shapes.join(shape, Shapes.box(0, 0.28125, 0.5625, 1, 0.34375, 0.625), BooleanOp.OR);
//        shape = Shapes.join(shape, Shapes.box(0, 0.59375, 0.5625, 1, 0.65625, 0.625), BooleanOp.OR);
//        shape = Shapes.join(shape, Shapes.box(0, 0.90625, 0.5625, 1, 0.96875, 0.625), BooleanOp.OR);
//        shape = Shapes.join(shape, Shapes.box(0, 0.90625, 0.375, 1, 0.96875, 0.4375), BooleanOp.OR);
//        shape = Shapes.join(shape, Shapes.box(0, 0.59375, 0.375, 1, 0.65625, 0.4375), BooleanOp.OR);
//        shape = Shapes.join(shape, Shapes.box(0, 0.28125, 0.375, 1, 0.34375, 0.4375), BooleanOp.OR);
//        return shape;
//    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                if(Objects.requireNonNull(data).Team == 3){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }
}

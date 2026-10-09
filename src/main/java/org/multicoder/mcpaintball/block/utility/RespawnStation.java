package org.multicoder.mcpaintball.block.utility;

import net.minecraft.world.level.block.Block;

public class RespawnStation extends Block {

    public RespawnStation(Properties properties) {
        super(properties);
    }

//    @Override
//    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
//        if(!level.isClientSide()){
//            if(MCPaintballGameEvents.INSTANCE.matchStarted && !MCPaintballGameEvents.INSTANCE.roundStarted){
//                MCPaintballPlayerData data = player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
//                if(state.getBlock() == MCPaintballBlocks.RED_RESPAWN_STATION && Objects.requireNonNull(data).team == 1){
//                    ServerPlayer sp = (ServerPlayer) player;
//                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
//                }else if(state.getBlock() == MCPaintballBlocks.GREEN_RESPAWN_STATION && Objects.requireNonNull(data).team == 2){
//                    ServerPlayer sp = (ServerPlayer) player;
//                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
//                }else if(state.getBlock() == MCPaintballBlocks.BLUE_RESPAWN_STATION && Objects.requireNonNull(data).team == 3){
//                    ServerPlayer sp = (ServerPlayer) player;
//                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
//                }else if(state.getBlock() == MCPaintballBlocks.YELLOW_RESPAWN_STATION && Objects.requireNonNull(data).team == 4){
//                    ServerPlayer sp = (ServerPlayer) player;
//                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
//                }else if(state.getBlock() == MCPaintballBlocks.PINK_RESPAWN_STATION && Objects.requireNonNull(data).team == 5){
//                    ServerPlayer sp = (ServerPlayer) player;
//                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
//                }else if(state.getBlock() == MCPaintballBlocks.ORANGE_RESPAWN_STATION && Objects.requireNonNull(data).team == 6){
//                    ServerPlayer sp = (ServerPlayer) player;
//                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
//                }
//            }
//        }
//        return super.useWithoutItem(state, level, pos, player, hitResult);
//    }
}

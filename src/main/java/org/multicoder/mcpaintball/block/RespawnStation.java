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
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class RespawnStation extends Block {

    public RespawnStation(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.matchStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                MCPaintballPlayerData data = player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                if(state.getBlock() == MCPaintballBlocks.RED_RESPAWN_STATION && Objects.requireNonNull(data).team == 1){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.GREEN_RESPAWN_STATION && Objects.requireNonNull(data).team == 2){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.BLUE_RESPAWN_STATION && Objects.requireNonNull(data).team == 3){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.YELLOW_RESPAWN_STATION && Objects.requireNonNull(data).team == 4){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.PINK_RESPAWN_STATION && Objects.requireNonNull(data).team == 5){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.ORANGE_RESPAWN_STATION && Objects.requireNonNull(data).team == 6){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }
}

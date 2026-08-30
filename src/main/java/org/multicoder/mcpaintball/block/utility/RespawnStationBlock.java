package org.multicoder.mcpaintball.block.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.LevelData;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class RespawnStationBlock extends Block {

    public RespawnStationBlock(Properties properties) {
        super(properties.dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5F));
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && !MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                if(state.getBlock() == MCPaintballBlocks.RED_RESPAWN_STATION.get() && Objects.requireNonNull(data).Team == 1){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.GREEN_RESPAWN_STATION.get() && Objects.requireNonNull(data).Team == 2){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.BLUE_RESPAWN_STATION.get() && Objects.requireNonNull(data).Team == 3){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.YELLOW_RESPAWN_STATION.get() && Objects.requireNonNull(data).Team == 4){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.PINK_RESPAWN_STATION.get() && Objects.requireNonNull(data).Team == 5){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }else if(state.getBlock() == MCPaintballBlocks.ORANGE_RESPAWN_STATION.get() && Objects.requireNonNull(data).Team == 6){
                    ServerPlayer sp = (ServerPlayer) player;
                    sp.setRespawnPosition(new ServerPlayer.RespawnConfig(new LevelData.RespawnData(GlobalPos.of(level.dimension(),pos.above()),0.0f,0f),true),true);
                }
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }
}

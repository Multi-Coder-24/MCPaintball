package org.multicoder.mcpaintball.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballParticles;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.data.MCPaintballSaveData;
import org.multicoder.mcpaintball.entity.PaintGrenadeEntity;
import org.multicoder.mcpaintball.entity.PaintballEntity;

import java.util.Objects;

public class PlayManager {
    public static boolean IsValid(MinecraftServer server, ServerPlayer player){
        MCPaintballSaveData saveData = Objects.requireNonNull(server.overworld().getDataStorage().get(MCPaintballSaveData.TYPE));
        if(saveData.TournamentData.TournamentStarted && saveData.TournamentData.RoundStarted){
            if(player.hasAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)){
                MCPaintballPlayerData playerData = Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER));
                return playerData.team != PaintballTeam.None && playerData.role != PaintballRole.None;
            }
        }
        return false;
    }
    public static boolean HandlePaintGrenade(ServerPlayer player, ServerLevel serverLevel,ItemStack heldStack){
        MCPaintballPlayerData playerData = Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER));
        PaintGrenadeEntity grenadeEntity = playerData.team.getPaintGrenade(serverLevel,player,heldStack);
        if(grenadeEntity != null){
            grenadeEntity.shootFromRotation(player,player.getXRot(),player.getYRot(),0f,3f,0.25f);
            serverLevel.addFreshEntity(grenadeEntity);
            return true;
        }
        return false;
    }
    public static void HandlePaintball(ServerPlayer player, ServerLevel serverLevel, float offset, float power, float inaccuracy, ItemStack weapon){
        MCPaintballPlayerData playerData = Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER));
        PaintballEntity paintballEntity = Objects.requireNonNull(playerData.team.getPaintball(serverLevel,weapon,player));
        paintballEntity.shootFromRotation(player,player.getXRot(),player.getYRot() + offset,0f,power,inaccuracy);
        serverLevel.addFreshEntity(paintballEntity);
    }
    public static void HandlePaintGrenadeHit(ServerLevel level, EntityType<PaintGrenadeEntity> entityType, BlockPos hitPos,ServerPlayer owner){
        AABB box = AABB.encapsulatingFullBlocks(hitPos.offset(-5,-2,-5),hitPos.offset(5,2,5));
        if(entityType == MCPaintballEntities.RED_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.RED_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.GREEN_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.GREEN_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.BLUE_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.BLUE_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.CYAN_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.CYAN_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.MAGENTA_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.MAGENTA_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.YELLOW_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.YELLOW_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.PINK_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.PINK_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.LIME_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.LIME_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.LIGHT_BLUE_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.LIGHT_BLUE_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.LIGHT_GRAY_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.LIGHT_GRAY_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.GRAY_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.GRAY_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.BLACK_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.BLACK_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.WHITE_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.BROWN_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.BROWN_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.BROWN_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.PURPLE_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.PURPLE_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
        else if(entityType == MCPaintballEntities.ORANGE_PAINT_GRENADE){
            BlockPos.betweenClosed(box).forEach(blockPos -> level.sendParticles(MCPaintballParticles.ORANGE_PAINT,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5,0.1,0.1,0.1,0.01));
        }
    }
}

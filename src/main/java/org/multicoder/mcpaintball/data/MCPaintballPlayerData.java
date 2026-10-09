package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.UUIDUtil;
import net.minecraft.util.Util;
import org.multicoder.mcpaintball.util.TeamColors;

import java.util.UUID;

public class MCPaintballPlayerData {
    public static final Codec<MCPaintballPlayerData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            UUIDUtil.CODEC.fieldOf("game_id").forGetter(MCPaintballPlayerData::gameID),
            TeamColors.CODEC.fieldOf("team_color").forGetter(MCPaintballPlayerData::teamColor),
            UUIDUtil.CODEC.fieldOf("team_id").forGetter(MCPaintballPlayerData::teamID)
    ).apply(instance, MCPaintballPlayerData::new));

    public UUID gameID = Util.NIL_UUID;
    public TeamColors teamColor = TeamColors.NONE;
    public UUID teamID = Util.NIL_UUID;

    public MCPaintballPlayerData(UUID gameID, TeamColors teamColor, UUID teamID) {
        this.gameID = gameID;
        this.teamColor = teamColor;
        this.teamID = teamID;
    }
    public MCPaintballPlayerData() {}


    public UUID gameID(){
        return gameID;
    }
    public TeamColors teamColor(){
        return teamColor;
    }
    public UUID teamID(){
        return teamID;
    }
}

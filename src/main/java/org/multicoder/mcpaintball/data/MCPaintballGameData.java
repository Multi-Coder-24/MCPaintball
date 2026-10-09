package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.UUIDUtil;
import net.minecraft.util.Util;
import org.multicoder.mcpaintball.util.TeamColors;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("all")
public class MCPaintballGameData {
    //  Codec
    public static final Codec<MCPaintballGameData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            UUIDUtil.CODEC.fieldOf("game_id").forGetter(MCPaintballGameData::gameID),
            Codec.STRING.fieldOf("game_name").forGetter(MCPaintballGameData::gameName),
            Codec.unboundedMap(Codec.STRING,UUIDUtil.CODEC).fieldOf("teams").forGetter(MCPaintballGameData::teams),
            Codec.unboundedMap(UUIDUtil.CODEC,TeamColors.CODEC).fieldOf("team_colors").forGetter(MCPaintballGameData::teamColors),
            Codec.unboundedMap(UUIDUtil.CODEC,Codec.INT).fieldOf("team_wins").forGetter(MCPaintballGameData::teamWins),
            Codec.unboundedMap(UUIDUtil.CODEC,Codec.INT).fieldOf("team_points").forGetter(MCPaintballGameData::teamPoints)

    ).apply(instance,MCPaintballGameData::new));
    //  Fields
    public UUID gameID = Util.NIL_UUID;
    public String gameName = "";
    public Map<String,UUID> teams = new HashMap<>();
    public Map<UUID, TeamColors> teamColors = new HashMap<>();
    public Map<UUID,Integer> teamWins = new HashMap<>();
    public Map<UUID,Integer> teamPoints = new HashMap<>();
    //  Constructors
    public MCPaintballGameData() {}
    public MCPaintballGameData(UUID game_id, String game_name, Map<String,UUID> teams,Map<UUID,TeamColors>  team_colors,Map<UUID,Integer> team_wins,Map<UUID,Integer> team_points) {
        gameID = game_id;
        gameName = game_name;
        this.teams = teams;
        teamColors = team_colors;
        teamWins = team_wins;
        teamPoints = team_points;
    }
    //  Codec Helper Methods
    public UUID gameID() { return gameID; }
    public String gameName() { return gameName; }
    public Map<String,UUID> teams() { return teams; }
    public Map<UUID,TeamColors> teamColors() { return teamColors; }
    public Map<UUID,Integer> teamWins() { return teamWins; }
    public Map<UUID,Integer> teamPoints() { return teamPoints; }
    //  Methods


}

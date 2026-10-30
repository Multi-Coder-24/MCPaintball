package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import org.multicoder.mcpaintball.MCPaintball;
import java.util.*;


public class MCPaintballSaveData extends SavedData {
    public MCPaintballMetaData TournamentData = new MCPaintballMetaData();
    public MCPaintballMetaData TournamentData(){return TournamentData;}
    public MCPaintballTournamentWinsData TournamentWinData = new MCPaintballTournamentWinsData();
    public MCPaintballTournamentWinsData TournamentWinData(){return TournamentWinData;}
    public MCPaintballRoundPointsData RoundPointsData = new MCPaintballRoundPointsData();
    public MCPaintballRoundPointsData RoundPointsData(){return RoundPointsData;}

    public static final Codec<MCPaintballSaveData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            MCPaintballMetaData.CODEC.fieldOf("meta_data").forGetter(MCPaintballSaveData::TournamentData),
            MCPaintballTournamentWinsData.CODEC.fieldOf("tournament_win_data").forGetter(MCPaintballSaveData::TournamentWinData),
            MCPaintballRoundPointsData.CODEC.fieldOf("round_data").forGetter(MCPaintballSaveData::RoundPointsData)
    ).apply(instance,MCPaintballSaveData::new));

    public static final SavedDataType<MCPaintballSaveData> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"paintball_data"),MCPaintballSaveData::new,CODEC,null);

    public MCPaintballSaveData(){}
    public MCPaintballSaveData(MCPaintballMetaData metaData,MCPaintballTournamentWinsData winsData,MCPaintballRoundPointsData roundPointsData){
        TournamentData = metaData;
        TournamentWinData = winsData;
        RoundPointsData = roundPointsData;
    }

}

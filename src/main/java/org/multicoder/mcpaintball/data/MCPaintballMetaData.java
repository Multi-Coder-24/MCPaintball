package org.multicoder.mcpaintball.data;


import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import java.util.ArrayList;
import java.util.List;

public class MCPaintballMetaData {
    public boolean TournamentStarted = false;
    public boolean TournamentStarted(){return TournamentStarted;}
    public boolean RoundStarted = false;
    public boolean RoundStarted(){return RoundStarted;}
    public String TournamentName = "";
    public String TournamentName(){return TournamentName;}
    public List<BlockPos> CapturePoints = new ArrayList<>();
    public List<BlockPos> CapturePoints(){return CapturePoints;}

    public static final Codec<MCPaintballMetaData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("tournament_name").forGetter(MCPaintballMetaData::TournamentName),
            Codec.BOOL.fieldOf("tournament_started").forGetter(MCPaintballMetaData::TournamentStarted),
            Codec.BOOL.fieldOf("round_started").forGetter(MCPaintballMetaData::RoundStarted),
            Codec.list(BlockPos.CODEC).fieldOf("capture_points").forGetter(MCPaintballMetaData::CapturePoints)
    ).apply(instance,MCPaintballMetaData::new));

    public MCPaintballMetaData() {}
    public MCPaintballMetaData(String tournamentName, boolean tournamentStarted, boolean roundStarted, List<BlockPos> capturePoints) {
        TournamentName = tournamentName;
        TournamentStarted = tournamentStarted;
        RoundStarted = roundStarted;
        CapturePoints = capturePoints;
    }

}

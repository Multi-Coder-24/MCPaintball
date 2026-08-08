package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;

import java.util.ArrayList;
import java.util.List;

public class MCPaintballSaveData extends SavedData {
    public int RedPoints = 0;
    public int GreenPoints = 0;
    public int BluePoints = 0;
    public int YellowPoints = 0;
    public int PinkPoints = 0;
    public int OrangePoints = 0;
    public boolean MatchStarted = false;
    public boolean RoundStarted = false;
    public List<BlockPos> CapturePoints = new ArrayList<>();
    public static final Codec<MCPaintballSaveData> CODEC = RecordCodecBuilder.create(instance  -> instance.group(
            Codec.INT.fieldOf("red_points").forGetter(MCPaintballSaveData::RedPoints),
            Codec.INT.fieldOf("blue_points").forGetter(MCPaintballSaveData::BluePoints),
            Codec.INT.fieldOf("green_points").forGetter(MCPaintballSaveData::GreenPoints),
            Codec.INT.fieldOf("yellow_points").forGetter(MCPaintballSaveData::YellowPoints),
            Codec.INT.fieldOf("pink_points").forGetter(MCPaintballSaveData::PinkPoints),
            Codec.INT.fieldOf("orange_points").forGetter(MCPaintballSaveData::OrangePoints),
            Codec.BOOL.fieldOf("match_started").forGetter(MCPaintballSaveData::MatchStarted),
            Codec.BOOL.fieldOf("round_started").forGetter(MCPaintballSaveData::RoundStarted),
            Codec.list(BlockPos.CODEC).fieldOf("capture_points").forGetter(MCPaintballSaveData::CapturePoints)
    ).apply(instance,MCPaintballSaveData::new));

    private List<BlockPos> CapturePoints() {
        return CapturePoints;
    }

    public static final SavedDataType<MCPaintballSaveData> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"paintball_data"),MCPaintballSaveData::new,CODEC,null);

    public MCPaintballSaveData(){}


    public MCPaintballSaveData(int redPoints, int bluePoints, int greenPoints,int yellowPoints,int pinkPoints,int orangePoints, boolean matchStarted, boolean roundStarted,List<BlockPos> capturePoints){
        RedPoints = redPoints;
        BluePoints = bluePoints;
        GreenPoints = greenPoints;
        YellowPoints = yellowPoints;
        PinkPoints = pinkPoints;
        OrangePoints = orangePoints;
        MatchStarted = matchStarted;
        RoundStarted = roundStarted;
        CapturePoints = capturePoints;
    }

    public int RedPoints(){
        return RedPoints;
    }
    public int GreenPoints(){
        return GreenPoints;
    }
    public int BluePoints(){
        return BluePoints;
    }
    public int YellowPoints(){return YellowPoints;}
    public int PinkPoints(){return PinkPoints;}
    public int OrangePoints(){return OrangePoints;}
    public boolean MatchStarted(){
        return MatchStarted;
    }
    public boolean RoundStarted(){
        return RoundStarted;
    }

    public void IncrementByChecker(int Checker){
        switch (Checker){
            case 1-> RedPoints++;
            case 2-> GreenPoints++;
            case 3-> BluePoints++;
            case 4-> YellowPoints++;
            case 5-> PinkPoints++;
            case 6-> OrangePoints++;
        }
        setDirty(true);
    }

    public void removeCapturePoint(@NonNull BlockPos pos) {
        ArrayList<BlockPos> points = new ArrayList<>(CapturePoints);
        points.remove(pos);
        CapturePoints = points;
        setDirty(true);
    }

    public void addCapturePoint(@NonNull BlockPos pos) {
        ArrayList<BlockPos> points = new ArrayList<>(CapturePoints);
        points.add(pos);
        CapturePoints = points;
        setDirty(true);
    }

    public void incrementCapturePointByChecker(int team) {
        switch (team){
            case 1 -> RedPoints += 10;
            case 2 -> GreenPoints += 10;
            case 3 -> BluePoints += 10;
            case 4 -> YellowPoints += 10;
            case 5 -> PinkPoints += 10;
            case 6 -> OrangePoints += 10;
        }
        setDirty(true);
    }
}


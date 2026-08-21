package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import org.multicoder.mcpaintball.MCPaintball;

import java.util.*;


@SuppressWarnings("all")
public class MCPaintballSaveData extends SavedData {
    public int redPoints = 0;
    public int greenPoints = 0;
    public int bluePoints = 0;
    public int yellowPoints = 0;
    public int pinkPoints = 0;
    public int orangePoints = 0;
    public int RedWins = 0;
    public int GreenWins = 0;
    public int BlueWins = 0;
    public int YellowWins = 0;
    public int PinkWins = 0;
    public int OrangeWins = 0;
    public boolean tournamentStarted = false;
    public boolean roundStarted = false;
    public List<BlockPos> capturePoints = new ArrayList<BlockPos>();

    public static final Codec<MCPaintballSaveData> CODEC = RecordCodecBuilder.create( instance  -> instance.group(
            Codec.INT.fieldOf("red_points").forGetter(MCPaintballSaveData::redPoints),
            Codec.INT.fieldOf("blue_points").forGetter(MCPaintballSaveData::bluePoints),
            Codec.INT.fieldOf("green_points").forGetter(MCPaintballSaveData::greenPoints),
            Codec.INT.fieldOf("yellow_points").forGetter(MCPaintballSaveData::yellowPoints),
            Codec.INT.fieldOf("pink_points").forGetter(MCPaintballSaveData::pinkPoints),
            Codec.INT.fieldOf("orange_points").forGetter(MCPaintballSaveData::orangePoints),
            Codec.INT.fieldOf("red_wins").forGetter(MCPaintballSaveData::RedWins),
            Codec.INT.fieldOf("green_wins").forGetter(MCPaintballSaveData::GreenWins),
            Codec.INT.fieldOf("blue_wins").forGetter(MCPaintballSaveData::BlueWins),
            Codec.INT.fieldOf("yellow_wins").forGetter(MCPaintballSaveData::YellowWins),
            Codec.INT.fieldOf("pink_wins").forGetter(MCPaintballSaveData::PinkWins),
            Codec.INT.fieldOf("orange_wins").forGetter(MCPaintballSaveData::OrangeWins),
            Codec.BOOL.fieldOf("tournament_started").forGetter(MCPaintballSaveData::tournamentStarted),
            Codec.BOOL.fieldOf("round_started").forGetter(MCPaintballSaveData::roundStarted),
            Codec.list(BlockPos.CODEC).fieldOf("capture_points").forGetter(MCPaintballSaveData::capturePoints)
    ).apply(instance,MCPaintballSaveData::new));

    public static final StreamCodec<RegistryFriendlyByteBuf,MCPaintballSaveData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(CODEC),MCPaintballSaveData::instance,
            MCPaintballSaveData::new
    );

    public MCPaintballSaveData() {

    }

    public MCPaintballSaveData(MCPaintballSaveData saveData) {
        this.redPoints = saveData.redPoints;
        this.bluePoints = saveData.bluePoints;
        this.greenPoints = saveData.greenPoints;
        this.yellowPoints = saveData.yellowPoints;
        this.pinkPoints = saveData.pinkPoints;
        this.orangePoints = saveData.orangePoints;
        this.RedWins = saveData.RedWins;
        this.GreenWins = saveData.GreenWins;
        this.BlueWins = saveData.BlueWins;
        this.YellowWins = saveData.YellowWins;
        this.PinkWins = saveData.PinkWins;
        this.OrangeWins = saveData.OrangeWins;
        this.tournamentStarted = saveData.tournamentStarted;
        this.roundStarted = saveData.roundStarted;
        this.capturePoints = saveData.capturePoints;
    }


    private List<BlockPos> capturePoints() {
        return capturePoints;
    }

    public static final SavedDataType<MCPaintballSaveData> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"paintball_data"),MCPaintballSaveData::new,CODEC,null);

    public MCPaintballSaveData instance(){
        return this;
    }


    public MCPaintballSaveData(int redPoints, int bluePoints, int greenPoints,int yellowPoints,int pinkPoints,int orangePoints,int red_wins,int green_wins,int blue_wins,int yellow_wins,int pink_wins,int orange_wins, boolean tournamentStarted, boolean roundStarted,List<BlockPos> capturePoints){
        this.redPoints = redPoints;
        this.bluePoints = bluePoints;
        this.greenPoints = greenPoints;
        this.yellowPoints = yellowPoints;
        this.pinkPoints = pinkPoints;
        this.orangePoints = orangePoints;
        this.RedWins = red_wins;
        this.GreenWins = green_wins;
        this.BlueWins = blue_wins;
        this.YellowWins = yellow_wins;
        this.PinkWins = pink_wins;
        this.OrangeWins = orange_wins;
        this.tournamentStarted = tournamentStarted;
        this.roundStarted = roundStarted;
        this.capturePoints = capturePoints;
    }
    public int redPoints(){
        return redPoints;
    }
    public int greenPoints(){
        return greenPoints;
    }
    public int bluePoints(){
        return bluePoints;
    }
    public int yellowPoints(){return yellowPoints;}
    public int pinkPoints(){return pinkPoints;}
    public int orangePoints(){return orangePoints;}
    public int RedWins(){return RedWins;}
    public int GreenWins(){return GreenWins;}
    public int BlueWins(){return BlueWins;}
    public int YellowWins(){return YellowWins;}
    public int PinkWins(){return PinkWins;}
    public int OrangeWins(){return OrangeWins;}
    public boolean tournamentStarted(){
        return tournamentStarted;
    }
    public boolean roundStarted(){
        return roundStarted;
    }
    public void incrementByChecker(int checker){
        switch (checker){
            case 1 -> redPoints++;
            case 2 -> greenPoints++;
            case 3 -> bluePoints++;
            case 4 -> yellowPoints++;
            case 5 -> pinkPoints++;
            case 6 -> orangePoints++;
        }
        setDirty(true);
    }

    public void IncrementWinCount(int Team){
        switch (Team){
            case 0 -> this.RedWins++;
            case 1 -> this.GreenWins++;
            case 2 -> this.BlueWins++;
            case 3 -> this.YellowWins++;
            case 4 -> this.PinkWins++;
            case 5 -> this.OrangeWins++;
        }
        this.setDirty(true);
    }

    public void addCapturePoint(BlockPos pos){
        ArrayList<BlockPos> capturePointsTemp = new ArrayList<BlockPos>();
        capturePointsTemp.addAll(capturePoints);
        capturePointsTemp.add(pos);
        capturePoints = capturePointsTemp;
        setDirty(true);
    }
    public void removeCapturePoint(BlockPos pos){
        ArrayList<BlockPos> capturePointsTemp = new ArrayList<BlockPos>();
        capturePointsTemp.addAll(capturePoints);
        capturePointsTemp.remove(pos);
        capturePoints = capturePointsTemp;
        setDirty(true);
    }

    public void incrementCapturePointByChecker(int team) {
        switch (team){
            case 1 -> redPoints += 10;
            case 2 -> greenPoints += 10;
            case 3 -> bluePoints += 10;
            case 4 -> yellowPoints += 10;
            case 5 -> pinkPoints += 10;
            case 6 -> orangePoints += 10;
        }
        setDirty(true);
    }

    public void resetPoints() {
        redPoints = 0;
        greenPoints = 0;
        bluePoints = 0;
        yellowPoints = 0;
        pinkPoints = 0;
        orangePoints = 0;
        setDirty(true);
    }

    public void resetAll() {
        redPoints = 0;
        greenPoints = 0;
        bluePoints = 0;
        yellowPoints = 0;
        pinkPoints = 0;
        orangePoints = 0;
        RedWins = 0;
        GreenWins = 0;
        BlueWins = 0;
        YellowWins = 0;
        PinkWins = 0;
        OrangeWins = 0;
        setDirty(true);
    }
}

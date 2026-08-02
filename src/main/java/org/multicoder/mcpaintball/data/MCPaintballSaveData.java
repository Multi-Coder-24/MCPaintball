package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballSaveData extends SavedData {
    public int RedPoints = 0;
    public int GreenPoints = 0;
    public int BluePoints = 0;
    public int YellowPoints = 0;
    public int PinkPoints = 0;
    public int OrangePoints = 0;
    public boolean MatchStarted = false;
    public boolean RoundStarted = false;
    public static final Codec<MCPaintballSaveData> CODEC = RecordCodecBuilder.create(instance  -> instance.group(
            Codec.INT.fieldOf("red_points").forGetter(MCPaintballSaveData::RedPoints),
            Codec.INT.fieldOf("blue_points").forGetter(MCPaintballSaveData::BluePoints),
            Codec.INT.fieldOf("green_points").forGetter(MCPaintballSaveData::GreenPoints),
            Codec.INT.fieldOf("yellow_points").forGetter(MCPaintballSaveData::YellowPoints),
            Codec.INT.fieldOf("pink_points").forGetter(MCPaintballSaveData::PinkPoints),
            Codec.INT.fieldOf("orange_points").forGetter(MCPaintballSaveData::OrangePoints),
            Codec.BOOL.fieldOf("match_started").forGetter(MCPaintballSaveData::MatchStarted),
            Codec.BOOL.fieldOf("round_started").forGetter(MCPaintballSaveData::RoundStarted)
    ).apply(instance,MCPaintballSaveData::new));

    public static final SavedDataType<MCPaintballSaveData> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"paintball_data"),MCPaintballSaveData::new,CODEC,null);

    public MCPaintballSaveData(){}


    public MCPaintballSaveData(int redPoints, int bluePoints, int greenPoints,int yellowPoints,int pinkPoints,int orangePoints, boolean matchStarted, boolean roundStarted){
        RedPoints = redPoints;
        BluePoints = bluePoints;
        GreenPoints = greenPoints;
        YellowPoints = yellowPoints;
        PinkPoints = pinkPoints;
        OrangePoints = orangePoints;
        MatchStarted = matchStarted;
        RoundStarted = roundStarted;
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
}


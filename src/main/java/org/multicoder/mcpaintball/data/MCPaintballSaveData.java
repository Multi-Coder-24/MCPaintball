package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import org.multicoder.mcpaintball.MCPaintball;


@SuppressWarnings("all")
public class MCPaintballSaveData extends SavedData {
    public int redPoints = 0;
    public int greenPoints = 0;
    public int bluePoints = 0;
    public int yellowPoints = 0;
    public int pinkPoints = 0;
    public int orangePoints = 0;
    public boolean matchStarted = false;
    public boolean roundStarted = false;
    public static final Codec<MCPaintballSaveData> CODEC = RecordCodecBuilder.create( instance  -> instance.group(
            Codec.INT.fieldOf("red_points").forGetter(MCPaintballSaveData::redPoints),
            Codec.INT.fieldOf("blue_points").forGetter(MCPaintballSaveData::bluePoints),
            Codec.INT.fieldOf("green_points").forGetter(MCPaintballSaveData::greenPoints),
            Codec.INT.fieldOf("yellow_points").forGetter(MCPaintballSaveData::yellowPoints),
            Codec.INT.fieldOf("pink_points").forGetter(MCPaintballSaveData::pinkPoints),
            Codec.INT.fieldOf("orange_points").forGetter(MCPaintballSaveData::orangePoints),
            Codec.BOOL.fieldOf("match_started").forGetter(MCPaintballSaveData::matchStarted),
            Codec.BOOL.fieldOf("round_started").forGetter(MCPaintballSaveData::roundStarted)
    ).apply(instance,MCPaintballSaveData::new));

    public static final SavedDataType<MCPaintballSaveData> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"paintball_data"),MCPaintballSaveData::new,CODEC,null);

    public MCPaintballSaveData(){

    }


    public MCPaintballSaveData(int redPoints, int bluePoints, int greenPoints,int yellowPoints,int pinkPoints,int orangePoints, boolean matchStarted, boolean roundStarted){
        this.redPoints = redPoints;
        this.bluePoints = bluePoints;
        this.greenPoints = greenPoints;
        this.yellowPoints = yellowPoints;
        this.pinkPoints = pinkPoints;
        this.orangePoints = orangePoints;
        this.matchStarted = matchStarted;
        this.roundStarted = roundStarted;
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
    public boolean matchStarted(){
        return matchStarted;
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
}

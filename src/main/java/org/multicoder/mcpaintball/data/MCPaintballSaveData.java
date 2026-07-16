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
    public boolean MatchStarted = false;
    public boolean RoundStarted = false;
    public static final Codec<MCPaintballSaveData> CODEC = RecordCodecBuilder.create(instance  -> instance.group(
            Codec.INT.fieldOf("red_points").forGetter(MCPaintballSaveData::RedPoints),
            Codec.INT.fieldOf("blue_points").forGetter(MCPaintballSaveData::BluePoints),
            Codec.INT.fieldOf("green_points").forGetter(MCPaintballSaveData::GreenPoints),
            Codec.BOOL.fieldOf("match_started").forGetter(MCPaintballSaveData::MatchStarted),
            Codec.BOOL.fieldOf("round_started").forGetter(MCPaintballSaveData::RoundStarted)
    ).apply(instance,MCPaintballSaveData::new));

    public static final SavedDataType<MCPaintballSaveData> TYPE = new SavedDataType<>(Identifier.fromNamespaceAndPath(MCPaintball.MODID,"paintball_data"),MCPaintballSaveData::new,CODEC,null);

    public MCPaintballSaveData(){

    }


    public MCPaintballSaveData(int redPoints, int bluePoints, int greenPoints, boolean matchStarted, boolean roundStarted){
        RedPoints = redPoints;
        BluePoints = bluePoints;
        GreenPoints = greenPoints;
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
    public boolean MatchStarted(){
        return MatchStarted;
    }
    public boolean RoundStarted(){
        return RoundStarted;
    }
}


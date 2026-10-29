package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class MCPaintballRoundPointsData {
    public int RedPoints = 0;
    public int RedPoints(){return RedPoints;}
    public int GreenPoints = 0;
    public int GreenPoints(){return GreenPoints;}
    public int BluePoints = 0;
    public int BluePoints(){return BluePoints;}
    public int CyanPoints = 0;
    public int CyanPoints(){return CyanPoints;}
    public int MagentaPoints = 0;
    public int MagentaPoints(){return MagentaPoints;}
    public int YellowPoints = 0;
    public int YellowPoints(){return YellowPoints;}
    public int LimePoints = 0;
    public int LimePoints(){return LimePoints;}
    public int LightBluePoints = 0;
    public int LightBluePoints(){return LightBluePoints;}
    public int LightGrayPoints = 0;
    public int LightGrayPoints(){return LightGrayPoints;}
    public int GrayPoints = 0;
    public int GrayPoints(){return GrayPoints;}
    public int WhitePoints = 0;
    public int WhitePoints(){return WhitePoints;}
    public int BlackPoints = 0;
    public int BlackPoints(){return BlackPoints;}
    public int BrownPoints = 0;
    public int BrownPoints(){return BrownPoints;}
    public int PurplePoints = 0;
    public int PurplePoints(){return PurplePoints;}
    public int OrangePoints = 0;
    public int OrangePoints(){return OrangePoints;}
    public int PinkPoints = 0;
    public int PinkPoints(){return PinkPoints;}
    public static final Codec<MCPaintballRoundPointsData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("red_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("green_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("blue_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("cyan_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("magenta_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("yellow_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("lime_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("light_blue_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("light_gray_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("gray_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("white_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("black_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("brown_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("purple_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("orange_points").forGetter(MCPaintballRoundPointsData::RedPoints),
            Codec.INT.fieldOf("pink_points").forGetter(MCPaintballRoundPointsData::RedPoints)
    ).apply(instance, MCPaintballRoundPointsData::new));

    public MCPaintballRoundPointsData() {}
    public MCPaintballRoundPointsData(int redPoints, int greenPoints, int bluePoints, int cyanPoints, int magentaPoints, int yellowPoints, int limePoints, int lightBluePoints, int lightGrayPoints, int grayPoints, int whitePoints, int blackPoints, int brownPoints, int purplePoints, int orangePoints, int pinkPoints){
        RedPoints = redPoints;
        GreenPoints = greenPoints;
        BluePoints = bluePoints;
        CyanPoints = cyanPoints;
        MagentaPoints = magentaPoints;
        YellowPoints = yellowPoints;
        LimePoints = limePoints;
        LightBluePoints = lightBluePoints;
        LightGrayPoints = lightGrayPoints;
        GrayPoints = grayPoints;
        WhitePoints = whitePoints;
        BlackPoints = blackPoints;
        BrownPoints = brownPoints;
        PurplePoints = purplePoints;
        OrangePoints = orangePoints;
        PinkPoints = pinkPoints;
    }


}

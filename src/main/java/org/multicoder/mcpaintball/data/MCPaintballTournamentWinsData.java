package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class MCPaintballTournamentWinsData {
    public int RedWins = 0;
    public int RedWins(){return RedWins;}
    public int GreenWins = 0;
    public int GreenWins(){return GreenWins;}
    public int BlueWins = 0;
    public int BlueWins(){return BlueWins;}
    public int CyanWins = 0;
    public int CyanWins(){return CyanWins;}
    public int MagentaWins = 0;
    public int MagentaWins(){return MagentaWins;}
    public int YellowWins = 0;
    public int YellowWins(){return YellowWins;}
    public int LimeWins = 0;
    public int LimeWins(){return LimeWins;}
    public int LightBlueWins = 0;
    public int LightBlueWins(){return LightBlueWins;}
    public int LightGrayWins = 0;
    public int LightGrayWins(){return LightGrayWins;}
    public int GrayWins = 0;
    public int GrayWins(){return GrayWins;}
    public int WhiteWins = 0;
    public int WhiteWins(){return WhiteWins;}
    public int BlackWins = 0;
    public int BlackWins(){return BlackWins;}
    public int BrownWins = 0;
    public int BrownWins(){return BrownWins;}
    public int PurpleWins = 0;
    public int PurpleWins(){return PurpleWins;}
    public int OrangeWins = 0;
    public int OrangeWins(){return OrangeWins;}
    public int PinkWins = 0;
    public int PinkWins(){return PinkWins;}
    public static final Codec<MCPaintballTournamentWinsData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("red_wins").forGetter(MCPaintballTournamentWinsData::RedWins),
            Codec.INT.fieldOf("green_wins").forGetter(MCPaintballTournamentWinsData::GreenWins),
            Codec.INT.fieldOf("blue_wins").forGetter(MCPaintballTournamentWinsData::BlueWins),
            Codec.INT.fieldOf("cyan_wins").forGetter(MCPaintballTournamentWinsData::CyanWins),
            Codec.INT.fieldOf("magenta_wins").forGetter(MCPaintballTournamentWinsData::MagentaWins),
            Codec.INT.fieldOf("yellow_wins").forGetter(MCPaintballTournamentWinsData::YellowWins),
            Codec.INT.fieldOf("lime_wins").forGetter(MCPaintballTournamentWinsData::LimeWins),
            Codec.INT.fieldOf("light_blue_wins").forGetter(MCPaintballTournamentWinsData::LightBlueWins),
            Codec.INT.fieldOf("light_gray_wins").forGetter(MCPaintballTournamentWinsData::LightGrayWins),
            Codec.INT.fieldOf("gray_wins").forGetter(MCPaintballTournamentWinsData::GrayWins),
            Codec.INT.fieldOf("white_wins").forGetter(MCPaintballTournamentWinsData::WhiteWins),
            Codec.INT.fieldOf("black_wins").forGetter(MCPaintballTournamentWinsData::BlackWins),
            Codec.INT.fieldOf("brown_wins").forGetter(MCPaintballTournamentWinsData::BrownWins),
            Codec.INT.fieldOf("purple_wins").forGetter(MCPaintballTournamentWinsData::PurpleWins),
            Codec.INT.fieldOf("orange_wins").forGetter(MCPaintballTournamentWinsData::OrangeWins),
            Codec.INT.fieldOf("pink_wins").forGetter(MCPaintballTournamentWinsData::PinkWins)
    ).apply(instance, MCPaintballTournamentWinsData::new));

    public MCPaintballTournamentWinsData() {}
    public MCPaintballTournamentWinsData(int redWins, int greenWins, int blueWins, int cyanWins, int magentaWins, int yellowWins, int limeWins, int lightBlueWins, int lightGrayWins, int grayWins, int whiteWins, int blackWins, int brownWins, int purpleWins, int orangeWins, int pinkWins){
        RedWins = redWins;
        GreenWins = greenWins;
        BlueWins = blueWins;
        CyanWins = cyanWins;
        MagentaWins = magentaWins;
        YellowWins = yellowWins;
        LimeWins = limeWins;
        LightBlueWins = lightBlueWins;
        LightGrayWins = lightGrayWins;
        GrayWins = grayWins;
        WhiteWins = whiteWins;
        BlackWins = blackWins;
        BrownWins = brownWins;
        PurpleWins = purpleWins;
        OrangeWins = orangeWins;
        PinkWins = pinkWins;
    }


}

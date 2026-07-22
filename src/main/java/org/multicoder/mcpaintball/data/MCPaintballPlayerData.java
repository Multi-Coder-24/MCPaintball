package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class MCPaintballPlayerData {
    public int Team = 0;
    public int Type = 0;

    public int Team(){
        return Team;
    }
    public int Type(){
        return Type;
    }
    public MCPaintballPlayerData(int Team, int Type){
        this.Team = Team;
        this.Type = Type;
    }
    public MCPaintballPlayerData(){}
    public static final Codec<MCPaintballPlayerData> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.INT.fieldOf("team").forGetter(MCPaintballPlayerData::Team),
            Codec.INT.fieldOf("type").forGetter(MCPaintballPlayerData::Type)
    ).apply(builder, MCPaintballPlayerData::new));

    public static final StreamCodec<ByteBuf,MCPaintballPlayerData> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,MCPaintballPlayerData::Team, ByteBufCodecs.INT,MCPaintballPlayerData::Type, MCPaintballPlayerData::new);

}

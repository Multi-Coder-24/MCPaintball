package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.multicoder.mcpaintball.util.PaintballRole;
import org.multicoder.mcpaintball.util.PaintballTeam;

public class MCPaintballPlayerData {
    public PaintballTeam team = PaintballTeam.None;
    public PaintballRole role = PaintballRole.None;

    public PaintballTeam team(){
        return team;
    }
    public PaintballRole type(){
        return role;
    }
    public MCPaintballPlayerData(PaintballTeam team, PaintballRole role){
        this.team = team;
        this.role = role;
    }
    public MCPaintballPlayerData(){}
    public static final Codec<MCPaintballPlayerData> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            PaintballTeam.CODEC.fieldOf("team").forGetter(MCPaintballPlayerData::team),
            PaintballRole.CODEC.fieldOf("role").forGetter(MCPaintballPlayerData::type)
    ).apply(builder, MCPaintballPlayerData::new));
    public static final StreamCodec<RegistryFriendlyByteBuf,MCPaintballPlayerData> STREAM_CODEC = StreamCodec.composite(
            PaintballTeam.STREAM_CODEC,MCPaintballPlayerData::team,
            PaintballRole.STREAM_CODEC,MCPaintballPlayerData::type,
            MCPaintballPlayerData::new
    );
}

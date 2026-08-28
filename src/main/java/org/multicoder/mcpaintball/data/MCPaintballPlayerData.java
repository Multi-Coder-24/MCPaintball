package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.EntityType;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.entity.PaintballEntity;

public class MCPaintballPlayerData {
    public int team = 0;
    public int role = 0;

    public int team(){
        return team;
    }
    public int type(){
        return role;
    }
    public MCPaintballPlayerData(int team, int role){
        this.team = team;
        this.role = role;
    }
    public MCPaintballPlayerData(){}
    public static final Codec<MCPaintballPlayerData> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.INT.fieldOf("team").forGetter(MCPaintballPlayerData::team),
            Codec.INT.fieldOf("role").forGetter(MCPaintballPlayerData::type)
    ).apply(builder, MCPaintballPlayerData::new));

    public static final StreamCodec<ByteBuf,MCPaintballPlayerData> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,MCPaintballPlayerData::team, ByteBufCodecs.INT,MCPaintballPlayerData::type, MCPaintballPlayerData::new);

    public EntityType<PaintballEntity> getFromTeam(){
        return switch (team) {
            case 1 -> MCPaintballEntities.RED_PAINTBALL;
            case 2 -> MCPaintballEntities.GREEN_PAINTBALL;
            case 3 -> MCPaintballEntities.BLUE_PAINTBALL;
            case 4 -> MCPaintballEntities.YELLOW_PAINTBALL;
            case 5 -> MCPaintballEntities.PINK_PAINTBALL;
            case 6 -> MCPaintballEntities.ORANGE_PAINTBALL;
            default -> null;
        };
    }
}

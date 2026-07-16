package org.multicoder.mcpaintball.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public class MCPaintballPlayerData {
        public int Team = 0;
        public int Type = 0;

        public static final Codec<org.multicoder.mcpaintball.data.MCPaintballPlayerData> CODEC = RecordCodecBuilder.create(inst ->inst.group(
                Codec.INT.fieldOf("team").forGetter(org.multicoder.mcpaintball.data.MCPaintballPlayerData::Team),
                Codec.INT.fieldOf("type").forGetter(org.multicoder.mcpaintball.data.MCPaintballPlayerData::Type)
        ).apply(inst, org.multicoder.mcpaintball.data.MCPaintballPlayerData::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, org.multicoder.mcpaintball.data.MCPaintballPlayerData> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.INT, org.multicoder.mcpaintball.data.MCPaintballPlayerData::Team,
                ByteBufCodecs.INT, org.multicoder.mcpaintball.data.MCPaintballPlayerData::Type,
                org.multicoder.mcpaintball.data.MCPaintballPlayerData::new);

        public MCPaintballPlayerData(int Team, int Type){
            this.Team = Team;
            this.Type = Type;
        }
        public MCPaintballPlayerData(){
        }
        public int Team(){
            return Team;
        }
        public int Type(){
            return Type;
        }
}


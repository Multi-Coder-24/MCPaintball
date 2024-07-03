package org.multicoder.mcpaintball.common.networking;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Team;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Class;

@SuppressWarnings("all")
public record TeamsDataSyncPacket(int Points, int PTeam,int PClass) implements CustomPacketPayload
{
    public static final CustomPacketPayload.Type TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MCPaintball.MOD_ID,"teamdatasync"));

    public static final StreamCodec<ByteBuf, TeamsDataSyncPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            TeamsDataSyncPacket::Points,
            ByteBufCodecs.INT,
            TeamsDataSyncPacket::PTeam,
            ByteBufCodecs.INT,
            TeamsDataSyncPacket::PClass,
            TeamsDataSyncPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }
}

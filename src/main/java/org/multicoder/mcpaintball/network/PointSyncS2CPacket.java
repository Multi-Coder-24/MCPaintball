package org.multicoder.mcpaintball.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.MCPaintballClient;

public record PointSyncS2CPacket(int Red, int Green, int Blue,int Yellow,int Pink,int Orange,boolean GameRunning,boolean RoundRunning) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"point_sync");
    public static final Type<PointSyncS2CPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,PointSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,PointSyncS2CPacket::Red, ByteBufCodecs.INT,PointSyncS2CPacket::Green, ByteBufCodecs.INT,PointSyncS2CPacket::Blue,ByteBufCodecs.INT,PointSyncS2CPacket::Yellow,ByteBufCodecs.INT,PointSyncS2CPacket::Pink,ByteBufCodecs.INT,PointSyncS2CPacket::Orange,ByteBufCodecs.BOOL,PointSyncS2CPacket::GameRunning,ByteBufCodecs.BOOL,PointSyncS2CPacket::RoundRunning, PointSyncS2CPacket::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void HandlePacket(PointSyncS2CPacket packet, IPayloadContext ignored) {
        MCPaintballClient.redPoints = packet.Red;
        MCPaintballClient.greenPoints = packet.Green;
        MCPaintballClient.bluePoints = packet.Blue;
        MCPaintballClient.yellowPoints = packet.Yellow;
        MCPaintballClient.pinkPoints = packet.Pink;
        MCPaintballClient.orangePoints = packet.Orange;
        MCPaintballClient.gameRunning = packet.GameRunning;
        MCPaintballClient.roundRunning = packet.RoundRunning;
    }
}

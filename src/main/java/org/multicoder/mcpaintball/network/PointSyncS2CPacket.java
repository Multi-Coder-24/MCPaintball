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

public record PointSyncS2CPacket(int Red, int Green, int Blue,int Yellow,boolean GameRunning,boolean RoundRunning) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"point_sync");
    public static final Type<PointSyncS2CPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,PointSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,PointSyncS2CPacket::Red, ByteBufCodecs.INT,PointSyncS2CPacket::Green, ByteBufCodecs.INT,PointSyncS2CPacket::Blue,ByteBufCodecs.INT,PointSyncS2CPacket::Yellow,ByteBufCodecs.BOOL,PointSyncS2CPacket::GameRunning,ByteBufCodecs.BOOL,PointSyncS2CPacket::RoundRunning, PointSyncS2CPacket::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void HandlePacket(PointSyncS2CPacket packet, IPayloadContext ignored) {
        MCPaintballClient.RedPoints = packet.Red;
        MCPaintballClient.GreenPoints = packet.Green;
        MCPaintballClient.BluePoints = packet.Blue;
        MCPaintballClient.YellowPoints = packet.Yellow;
        MCPaintballClient.GameRunning = packet.GameRunning;
        MCPaintballClient.RoundRunning = packet.RoundRunning;
    }
}

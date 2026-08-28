package org.multicoder.mcpaintball.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.MCPaintballClient;

public record PointSyncS2CPacket(int red, int green, int blue, int yellow, int pink, int orange, boolean gameRunning, boolean roundRunning) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"point_sync");
    public static final CustomPacketPayload.Type<PointSyncS2CPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,PointSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,PointSyncS2CPacket::red, ByteBufCodecs.INT,PointSyncS2CPacket::green, ByteBufCodecs.INT,PointSyncS2CPacket::blue,ByteBufCodecs.INT,PointSyncS2CPacket::yellow,ByteBufCodecs.INT,PointSyncS2CPacket::pink,ByteBufCodecs.INT,PointSyncS2CPacket::orange, ByteBufCodecs.BOOL,PointSyncS2CPacket::gameRunning,ByteBufCodecs.BOOL,PointSyncS2CPacket::roundRunning, PointSyncS2CPacket::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(PointSyncS2CPacket packet, ClientPlayNetworking.Context ignored) {
        MCPaintballClient.redPoints = packet.red;
        MCPaintballClient.greenPoints = packet.green;
        MCPaintballClient.bluePoints = packet.blue;
        MCPaintballClient.yellowPoints = packet.yellow;
        MCPaintballClient.pinkPoints = packet.pink;
        MCPaintballClient.orangePoints = packet.orange;
        MCPaintballClient.gameRunning = packet.gameRunning;
        MCPaintballClient.roundRunning = packet.roundRunning;
    }
}

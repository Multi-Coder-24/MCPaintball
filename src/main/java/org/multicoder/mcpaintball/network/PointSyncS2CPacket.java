package org.multicoder.mcpaintball.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.MCPaintballClient;
import org.multicoder.mcpaintball.data.MCPaintballSaveData;

public record PointSyncS2CPacket(MCPaintballSaveData data) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"point_sync");
    public static final CustomPacketPayload.Type<PointSyncS2CPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,PointSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(MCPaintballSaveData.CODEC_PACKET,PointSyncS2CPacket::data, PointSyncS2CPacket::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(PointSyncS2CPacket packet, ClientPlayNetworking.Context ignored) {
        MCPaintballSaveData saveData = packet.data;
        MCPaintballClient.redPoints = saveData.redPoints;
        MCPaintballClient.greenPoints = saveData.greenPoints;
        MCPaintballClient.bluePoints = saveData.bluePoints;
        MCPaintballClient.yellowPoints = saveData.yellowPoints;
        MCPaintballClient.pinkPoints = saveData.pinkPoints;
        MCPaintballClient.orangePoints = saveData.orangePoints;
        MCPaintballClient.tournamentRunning = saveData.tournamentStarted;
        MCPaintballClient.roundRunning = saveData.roundStarted;
    }
}

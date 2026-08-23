package org.multicoder.mcpaintball.network.ServerToClient;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.MCPaintballClient;
import org.multicoder.mcpaintball.data.MCPaintballSaveData;

public record SaveDataSyncS2CPacket(MCPaintballSaveData data) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"point_sync");
    public static final CustomPacketPayload.Type<SaveDataSyncS2CPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, SaveDataSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(MCPaintballSaveData.STREAM_CODEC, SaveDataSyncS2CPacket::data, SaveDataSyncS2CPacket::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(SaveDataSyncS2CPacket packet, ClientPlayNetworking.Context ignored) {
        MCPaintballSaveData saveData = packet.data;
        MCPaintballClient.redPoints = saveData.redPoints;
        MCPaintballClient.greenPoints = saveData.greenPoints;
        MCPaintballClient.bluePoints = saveData.bluePoints;
        MCPaintballClient.yellowPoints = saveData.yellowPoints;
        MCPaintballClient.pinkPoints = saveData.pinkPoints;
        MCPaintballClient.orangePoints = saveData.orangePoints;
        MCPaintballClient.RedWins = saveData.RedWins;
        MCPaintballClient.GreenWins = saveData.GreenWins;
        MCPaintballClient.BlueWins = saveData.BlueWins;
        MCPaintballClient.YellowWins = saveData.YellowWins;
        MCPaintballClient.PinkWins = saveData.PinkWins;
        MCPaintballClient.OrangeWins = saveData.OrangeWins;
        MCPaintballClient.tournamentRunning = saveData.tournamentStarted;
        MCPaintballClient.roundRunning = saveData.roundStarted;
        MCPaintballClient.capture_points = saveData.capturePoints;
    }
}

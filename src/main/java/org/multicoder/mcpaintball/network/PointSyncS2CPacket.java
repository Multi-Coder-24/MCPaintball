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

public record PointSyncS2CPacket(int Red, int Green, int Blue) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"point_sync");
    public static final CustomPacketPayload.Type<PointSyncS2CPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,PointSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,PointSyncS2CPacket::Red, ByteBufCodecs.INT,PointSyncS2CPacket::Green, ByteBufCodecs.INT,PointSyncS2CPacket::Blue, PointSyncS2CPacket::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void HandlePacket(PointSyncS2CPacket packet, ClientPlayNetworking.Context ignored) {
        MCPaintballClient.RedPoints = packet.Red;
        MCPaintballClient.GreenPoints = packet.Green;
        MCPaintballClient.BluePoints = packet.Blue;
    }
}

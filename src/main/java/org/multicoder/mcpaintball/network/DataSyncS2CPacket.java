package org.multicoder.mcpaintball.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;

import java.util.Objects;

public record DataSyncS2CPacket(MCPaintballPlayerData data) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"data_sync");
    public static final CustomPacketPayload.Type<DataSyncS2CPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,DataSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(MCPaintballPlayerData.STREAM_CODEC,DataSyncS2CPacket::data,DataSyncS2CPacket::new);
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
    public static void HandlePacket(DataSyncS2CPacket packet, ClientPlayNetworking.Context ignored) {
        MCPaintballPlayerData data = packet.data();
        Objects.requireNonNull(Minecraft.getInstance().player).setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
    }
}

package org.multicoder.mcpaintball.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.MCPaintballClient;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;

import java.util.Objects;

public record DataSyncS2CPacket(MCPaintballPlayerData data) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"data_sync");
    public static final Type<DataSyncS2CPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, DataSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(MCPaintballPlayerData.STREAM_CODEC,DataSyncS2CPacket::data,DataSyncS2CPacket::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void HandlePacket(DataSyncS2CPacket packet, IPayloadContext ignored) {
        Objects.requireNonNull(Minecraft.getInstance().player).setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), packet.data);
    }
}

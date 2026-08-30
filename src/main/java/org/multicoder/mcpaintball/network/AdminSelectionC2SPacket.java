package org.multicoder.mcpaintball.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public record AdminSelectionC2SPacket(int Selection) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"admin_selection");
    public static final CustomPacketPayload.Type<AdminSelectionC2SPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, AdminSelectionC2SPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, AdminSelectionC2SPacket::Selection,
            AdminSelectionC2SPacket::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(AdminSelectionC2SPacket packet, ServerPlayNetworking.Context context) {
        MinecraftServer server = Objects.requireNonNull(context.server());
        ServerPlayer player = Objects.requireNonNull(context.player());
        switch (packet.Selection) {
            case 0 ->// Start Game
                    MCPaintballGameEvents.INSTANCE.StartGame(server);
            case 1 ->// Stop Game
                    MCPaintballGameEvents.INSTANCE.StopGame(server);
            case 2 ->// Start Round
                    MCPaintballGameEvents.INSTANCE.StartRound(server,player);
            case 3 ->// Stop Round
                    MCPaintballGameEvents.INSTANCE.StopRound(server,player);
            case 4 ->// Round Winner
                    MCPaintballGameEvents.INSTANCE.RoundWinner(server);
        }

    }
}

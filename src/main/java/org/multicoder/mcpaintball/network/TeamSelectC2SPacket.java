package org.multicoder.mcpaintball.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;


public record TeamSelectC2SPacket(int Team) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"team_select");
    public static final CustomPacketPayload.Type<TeamSelectC2SPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,TeamSelectC2SPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,TeamSelectC2SPacket::Team,
            TeamSelectC2SPacket::new);
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(TeamSelectC2SPacket packet, ServerPlayNetworking.Context context) {
        ServerPlayer player = context.player();
        int Team = packet.Team;
        MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
        data.team = Team;
        player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
        player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
        ServerPlayNetworking.send(player,new DataSyncS2CPacket(player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
    }
}

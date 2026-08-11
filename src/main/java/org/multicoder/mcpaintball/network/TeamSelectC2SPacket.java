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
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.MinecraftTeamSystem;

import java.util.Objects;


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
        if(MCPaintballGameEvents.INSTANCE.matchStarted && !MCPaintballGameEvents.INSTANCE.roundStarted) {
            ServerPlayer player = context.player();
            MinecraftServer server = Objects.requireNonNull(context.server());
            int Team = packet.Team;
            MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            data.team = Team;
            player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
            switch (Team) {
                case 1 -> server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.RED);
                case 2 -> server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.GREEN);
                case 3 -> server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.BLUE);
                case 4 -> server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.YELLOW);
                case 5 -> server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.PINK);
                case 6 -> server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.ORANGE);
            }
            ServerPlayNetworking.send(player,new DataSyncS2CPacket(player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
        }
    }
}

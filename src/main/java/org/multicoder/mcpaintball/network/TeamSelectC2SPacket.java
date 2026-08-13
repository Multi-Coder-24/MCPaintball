package org.multicoder.mcpaintball.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.integration.MCPaintballVoiceChatPlugin;
import org.multicoder.mcpaintball.integration.MinecraftTeamSystem;

import java.util.Objects;

@SuppressWarnings("unused")

public record TeamSelectC2SPacket(int Team) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"team_select");
    public static final Type<TeamSelectC2SPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,TeamSelectC2SPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,TeamSelectC2SPacket::Team,
            TeamSelectC2SPacket::new);
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(TeamSelectC2SPacket packet, IPayloadContext context) {
        if(MCPaintballGameEvents.INSTANCE.MatchStarted && !MCPaintballGameEvents.INSTANCE.RoundStarted) {
            ServerPlayer player = (ServerPlayer) context.player();
            MinecraftServer server = Objects.requireNonNull(player.level().getServer());
            int Team = packet.Team;
            MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            data.Team = Team;
            player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
            switch (Team) {
                case 1 -> {
                    server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.RED);
                    if(ModList.get().isLoaded("voicechat")){
                        Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(player.getUUID())).setGroup(MCPaintballVoiceChatPlugin.RED);
                    }
                }
                case 2 -> {
                    server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.GREEN);
                    if(ModList.get().isLoaded("voicechat")){
                        Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(player.getUUID())).setGroup(MCPaintballVoiceChatPlugin.GREEN);
                    }
                }
                case 3 -> {
                    server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.BLUE);
                    if(ModList.get().isLoaded("voicechat")){
                        Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(player.getUUID())).setGroup(MCPaintballVoiceChatPlugin.BLUE);
                    }
                }
                case 4 -> {
                    server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.YELLOW);
                    if(ModList.get().isLoaded("voicechat")){
                        Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(player.getUUID())).setGroup(MCPaintballVoiceChatPlugin.YELLOW);
                    }
                }
                case 5 -> {
                    server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.PINK);
                    if(ModList.get().isLoaded("voicechat")){
                        Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(player.getUUID())).setGroup(MCPaintballVoiceChatPlugin.PINK);
                    }
                }
                case 6 -> {
                    server.getScoreboard().addPlayerToTeam(player.getName().getString(),MinecraftTeamSystem.ORANGE);
                    if(ModList.get().isLoaded("voicechat")){
                        Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(player.getUUID())).setGroup(MCPaintballVoiceChatPlugin.ORANGE);
                    }
                }
            }
            PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
        }
    }
}

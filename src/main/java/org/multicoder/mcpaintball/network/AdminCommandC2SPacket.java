
package org.multicoder.mcpaintball.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public record AdminCommandC2SPacket(int Option) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"admin_option");
    public static final Type<AdminCommandC2SPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, AdminCommandC2SPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, AdminCommandC2SPacket::Option,
            AdminCommandC2SPacket::new);
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(AdminCommandC2SPacket packet, ServerPlayNetworking.Context context) {
        int Option = packet.Option;
        switch (Option) {
            case 0 ->{
                MCPaintballGameEvents.INSTANCE.matchStarted = true;
                MCPaintballGameEvents.INSTANCE.setDirty(true);
                Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.game_start"),false);
            }
            case 1 ->{
                MCPaintballGameEvents.INSTANCE.matchStarted = false;
                MCPaintballGameEvents.INSTANCE.roundStarted = false;
                MCPaintballGameEvents.INSTANCE.redPoints = 0;
                MCPaintballGameEvents.INSTANCE.greenPoints = 0;
                MCPaintballGameEvents.INSTANCE.bluePoints = 0;
                MCPaintballGameEvents.INSTANCE.yellowPoints = 0;
                MCPaintballGameEvents.INSTANCE.pinkPoints = 0;
                MCPaintballGameEvents.INSTANCE.orangePoints = 0;
                MCPaintballGameEvents.INSTANCE.setDirty(true);
                Objects.requireNonNull(context.server()).getPlayerList().getPlayers().forEach(player -> {
                    MCPaintballPlayerData playerData = new MCPaintballPlayerData(0,0);
                    player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,playerData);
                });
                Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.game_stopped"),false);
            }
            case 2 ->{
                if(MCPaintballGameEvents.INSTANCE.matchStarted){
                    MCPaintballGameEvents.INSTANCE.roundStarted = true;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_started"),false);
                }
                else{
                    Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"),false);
                }
            }
            case 3 ->{
                if(MCPaintballGameEvents.INSTANCE.matchStarted){
                    MCPaintballGameEvents.INSTANCE.roundStarted = false;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_ended"),false);
                }
                else{
                    Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"),false);
                }
            }
            case 4 ->{
                List<Integer> points = new ArrayList<>();
                points.add(MCPaintballGameEvents.INSTANCE.redPoints);
                points.add(MCPaintballGameEvents.INSTANCE.greenPoints);
                points.add(MCPaintballGameEvents.INSTANCE.bluePoints);
                points.add(MCPaintballGameEvents.INSTANCE.yellowPoints);
                points.add(MCPaintballGameEvents.INSTANCE.pinkPoints);
                points.add(MCPaintballGameEvents.INSTANCE.orangePoints);
                int Winner = points.indexOf(points.stream().max(Comparator.naturalOrder()).get());
                Component Team = switch (Winner){
                    case 0 -> Component.translatable("text.mcpaintball.team_red");
                    case 1 -> Component.translatable("text.mcpaintball.team_green");
                    case 2 -> Component.translatable("text.mcpaintball.team_blue");
                    case 3 -> Component.translatable("text.mcpaintball.team_yellow");
                    case 4 -> Component.translatable("text.mcpaintball.team_pink");
                    case 5 -> Component.translatable("text.mcpaintball.team_orange");
                    default -> throw new IllegalStateException("Unexpected value: " + Winner);
                };
                Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_winner",Team),false);
            }
        }
    }
}

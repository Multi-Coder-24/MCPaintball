
package org.multicoder.mcpaintball.network.ClientToServer;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.objectives.CapturePointBlock;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
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
            case 0 ->{ //Tournament Start
                MCPaintballGameEvents.INSTANCE.tournamentStarted = true;
                MCPaintballGameEvents.INSTANCE.setDirty(true);
                Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.tournament_start"),false);
            }
            case 1 ->{ //Tournament End
                MCPaintballGameEvents.INSTANCE.tournamentStarted = false;
                MCPaintballGameEvents.INSTANCE.roundStarted = false;
                MCPaintballGameEvents.INSTANCE.setDirty(true);
                Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.tournament_stopped"),false);
            }
            case 2 ->{ //Round Started
                if(MCPaintballGameEvents.INSTANCE.tournamentStarted){
                    MCPaintballGameEvents.INSTANCE.roundStarted = true;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_started"),false);
                }
                else{
                    Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.error_tournament_not_started"),false);
                }
            }
            case 3 ->{ //Round End
                if(MCPaintballGameEvents.INSTANCE.tournamentStarted){
                    MCPaintballGameEvents.INSTANCE.roundStarted = false;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    MCPaintballGameEvents.INSTANCE.capturePoints.forEach(point -> {
                        BlockState state = Objects.requireNonNull(context.server()).overworld().getBlockState(point);
                        if(state.getBlock() == MCPaintballBlocks.CAPTURE_POINT){
                            int Value = state.getValue(CapturePointBlock.TEAM);
                            MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(Value);
                            state = state.setValue(CapturePointBlock.TEAM,0);
                            Objects.requireNonNull(context.server()).overworld().setBlock(point,state, Block.UPDATE_ALL_IMMEDIATE);
                        }
                    });
                    Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_ended"),false);
                }
                else{
                    Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.error_tournament_not_started"),false);
                }
            }
            case 4 ->{ //Round Winner
                MCPaintball.LOGGER.info("Round Winner");
                List<Integer> points = new ArrayList<>();
                points.add(MCPaintballGameEvents.INSTANCE.redPoints);
                points.add(MCPaintballGameEvents.INSTANCE.greenPoints);
                points.add(MCPaintballGameEvents.INSTANCE.bluePoints);
                points.add(MCPaintballGameEvents.INSTANCE.yellowPoints);
                points.add(MCPaintballGameEvents.INSTANCE.pinkPoints);
                points.add(MCPaintballGameEvents.INSTANCE.orangePoints);
                int Winner = points.indexOf(points.stream().max(Comparator.naturalOrder()).orElseThrow());
                MCPaintball.LOGGER.info("Winner: " + Winner);
                Component Team = switch (Winner){
                    case 0 -> Component.translatable("text.mcpaintball.team_red");
                    case 1 -> Component.translatable("text.mcpaintball.team_green");
                    case 2 -> Component.translatable("text.mcpaintball.team_blue");
                    case 3 -> Component.translatable("text.mcpaintball.team_yellow");
                    case 4 -> Component.translatable("text.mcpaintball.team_pink");
                    case 5 -> Component.translatable("text.mcpaintball.team_orange");
                    default -> throw new IllegalStateException("Unexpected value: " + Winner);
                };
                MCPaintballGameEvents.INSTANCE.IncrementWinCount(Winner);
                Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_winner",Team),false);
                MCPaintballGameEvents.INSTANCE.resetPoints();
            }
            case 5 ->{ //Tournament Winner
                MCPaintball.LOGGER.info("Tournament Winner");
                List<Integer> points = new ArrayList<>();
                points.add(MCPaintballGameEvents.INSTANCE.RedWins);
                points.add(MCPaintballGameEvents.INSTANCE.GreenWins);
                points.add(MCPaintballGameEvents.INSTANCE.BlueWins);
                points.add(MCPaintballGameEvents.INSTANCE.YellowWins);
                points.add(MCPaintballGameEvents.INSTANCE.PinkWins);
                points.add(MCPaintballGameEvents.INSTANCE.OrangeWins);
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
                Objects.requireNonNull(context.server()).getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.tournament_winner",Team),false);
                Objects.requireNonNull(context.server()).getPlayerList().getPlayers().forEach(player -> {
                    MCPaintballPlayerData data = new MCPaintballPlayerData(0,0);
                    player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
                });
                MCPaintballGameEvents.INSTANCE.resetAll();
            }
        }
    }
}

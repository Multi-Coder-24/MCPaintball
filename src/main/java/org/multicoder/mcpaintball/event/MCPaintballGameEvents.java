package org.multicoder.mcpaintball.event;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.permissions.Permissions;
import org.multicoder.mcpaintball.command.MCPaintballCommands;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballSaveData;
import org.multicoder.mcpaintball.network.PointSyncS2CPacket;

import java.util.Objects;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

public class MCPaintballGameEvents {
    public static MCPaintballSaveData INSTANCE;
    public static int Ticker = 0;
    public static void ServerStart(MinecraftServer server) {
        INSTANCE = server.overworld().getDataStorage().computeIfAbsent(MCPaintballSaveData.TYPE);
        Objects.requireNonNull(server.overworld().getDataStorage().get(MCPaintballSaveData.TYPE)).setDirty();
        server.addTickable((() -> {
            if(Ticker == 20){
                server.getPlayerList().getPlayers().forEach(player -> {
                    if(Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Team != 0 && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).Type != 0) {
                        ServerPlayNetworking.send(player,new PointSyncS2CPacket(MCPaintballGameEvents.INSTANCE.RedPoints,MCPaintballGameEvents.INSTANCE.GreenPoints,MCPaintballGameEvents.INSTANCE.BluePoints));
                    }
                });
                Ticker = 0;
            }else{
                Ticker++;
            }
        }));
    }

    public static void Join(ServerPlayer player) {
        player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
    }

    public static void CommandRegister(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext ignored, Commands.CommandSelection ignored2) {
        dispatcher.register(literal(Component.translatable("command.mcpaintball.prefix").getString()).then(literal(Component.translatable("command.mcpaintball.team_prefix").getString()).executes(MCPaintballCommands::CheckTeam).then(literal(Component.translatable("command.mcpaintball.set").getString()).then(argument("team",StringArgumentType.word()).executes(MCPaintballCommands::SetTeam))))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("command.mcpaintball.prefix").getString()).then(literal(Component.translatable("command.mcpaintball.type_prefix").getString()).executes(MCPaintballCommands::CheckType).then(literal(Component.translatable("command.mcpaintball.set").getString()).then(argument("type",StringArgumentType.word()).executes(MCPaintballCommands::SetType))))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("command.mcpaintball.prefix").getString()).then(literal(Component.translatable("command.mcpaintball.game_prefix").getString()).then(literal(Component.translatable("command.mcpaintball.start").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::StartGame)).then(literal(Component.translatable("command.mcpaintball.stop").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::StopGame)))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("command.mcpaintball.prefix").getString()).then(literal(Component.translatable("command.mcpaintball.round_prefix").getString()).then(literal(Component.translatable("command.mcpaintball.start").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::StartRound)).then(literal(Component.translatable("command.mcpaintball.end").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::StopRound)).then(literal(Component.translatable("command.mcpaintball.winner").getString()).requires(commandSourceStack -> commandSourceStack.permissions().hasPermission(Permissions.COMMANDS_MODERATOR)).executes(MCPaintballCommands::RoundWinner)))).createBuilder().build();
        dispatcher.register(literal(Component.translatable("command.mcpaintball.prefix").getString()).then(literal(Component.translatable("command.mcpaintball.kit").getString()).executes(MCPaintballCommands::GiveKit))).createBuilder().build();
    }
}

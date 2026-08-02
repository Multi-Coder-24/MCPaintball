package org.multicoder.mcpaintball.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.integration.MCPaintballVoiceChatPlugin;
import org.multicoder.mcpaintball.network.DataSyncS2CPacket;
import org.multicoder.mcpaintball.util.KitHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MCPaintballCommands {
    public static int setTeam(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String selectedTeam = StringArgumentType.getString(context, "team");
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
        selectedTeam = selectedTeam.toLowerCase();
        switch (selectedTeam) {
            case "red" -> {
                data.team = 1;
                player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                if(FabricLoader.getInstance().isModLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.RED);
                }
            }
            case "green" -> {
                data.team = 2;
                player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                if(FabricLoader.getInstance().isModLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.GREEN);
                }
            }
            case "blue" -> {
                data.team = 3;
                player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                if(FabricLoader.getInstance().isModLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.BLUE);
                }
            }
            case "yellow" -> {
                data.team = 4;
                player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                if(FabricLoader.getInstance().isModLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.YELLOW);
                }
            }case "pink" -> {
                data.team = 5;
                player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                if(FabricLoader.getInstance().isModLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.PINK);
                }
            }case "orange" -> {
                data.team = 6;
                player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                if(FabricLoader.getInstance().isModLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.ORANGE);
                }
            }
            default -> player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_team"));
        }
        return 0;
    }

    public static int setType(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String selectedType = StringArgumentType.getString(context, "type");
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.matchStarted){
            if(!MCPaintballGameEvents.INSTANCE.roundStarted){
                MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                selectedType = selectedType.toLowerCase();
                switch (selectedType) {
                    case "standard" -> {
                        data.type = 1;
                        player.removeAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                        player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                        ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                    }
                    case "sniper" -> {
                        data.type = 2;
                        player.removeAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                        player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                        ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                    }
                    case "assault" -> {
                        data.type = 3;
                        player.removeAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                        player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                        ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                    }
                    case "heavy" -> {
                        data.type = 4;
                        player.removeAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                        player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                        ServerPlayNetworking.send(context.getSource().getPlayerOrException(),new DataSyncS2CPacket(context.getSource().getPlayerOrException().getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                    }
                    default -> player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_type"));
                }
            }
            else{
                player.sendSystemMessage(Component.translatable("text.mcpaintball.error_round_started"));
            }
        }
        else {
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_no_game"));
        }
        return 0;
    }

    public static int startGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballGameEvents.INSTANCE.matchStarted = true;
        MCPaintballGameEvents.INSTANCE.setDirty(true);
        player.sendSystemMessage(Component.translatable("text.mcpaintball.game_start"));
        return 0;
    }

    public static int stopGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballGameEvents.INSTANCE.matchStarted = false;
        MCPaintballGameEvents.INSTANCE.roundStarted = false;
        MCPaintballGameEvents.INSTANCE.redPoints = 0;
        MCPaintballGameEvents.INSTANCE.greenPoints = 0;
        MCPaintballGameEvents.INSTANCE.bluePoints = 0;
        MCPaintballGameEvents.INSTANCE.yellowPoints = 0;
        MCPaintballGameEvents.INSTANCE.setDirty(true);
        context.getSource().getServer().getPlayerList().getPlayers().forEach(serverPlayer ->{
            MCPaintballPlayerData data = new MCPaintballPlayerData(0,0);
            serverPlayer.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
        });
        player.sendSystemMessage(Component.translatable("text.mcpaintball.game_stopped"));
        return 0;
    }

    public static int stopRound(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.matchStarted){
            MCPaintballGameEvents.INSTANCE.roundStarted = false;
            MCPaintballGameEvents.INSTANCE.setDirty();
            player.sendSystemMessage(Component.translatable("text.mcpaintball.round_ended"));
        }
        else{
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_no_game"));
        }
        return 0;
    }

    public static int startRound(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.matchStarted){
            MCPaintballGameEvents.INSTANCE.roundStarted = true;
            MCPaintballGameEvents.INSTANCE.setDirty();
            player.sendSystemMessage(Component.translatable("text.mcpaintball.round_started"));
        }
        else{
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"));
        }
        return 0;
    }

    public static int roundWinner(CommandContext<CommandSourceStack> context) {
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
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_winner",Team),false);
        return 0;
    }

    public static int giveKit(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        if(MCPaintballGameEvents.INSTANCE.matchStarted && !MCPaintballGameEvents.INSTANCE.roundStarted){
            ServerPlayer player = context.getSource().getPlayerOrException();
            MCPaintballPlayerData data = player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            if(data != null && data.team != 0 && data.type != 0){
                KitHandler.grantKit(player, data.team, data.type);
            }
        }
        return 0;
    }
}

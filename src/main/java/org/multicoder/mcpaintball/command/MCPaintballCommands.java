package org.multicoder.mcpaintball.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.network.PacketDistributor;
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
    public static int SetTeam(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String selectedTeam = StringArgumentType.getString(context, "team");
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
        selectedTeam = selectedTeam.toLowerCase();
        switch (selectedTeam) {
            case "red" -> {
                data.Team = 1;
                player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
                if(ModList.get().isLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.RED);
                }
            }
            case "green" -> {
                data.Team = 2;
                player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
                if(ModList.get().isLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.GREEN);
                }
            }
            case "blue" -> {
                data.Team = 3;
                player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
                if(ModList.get().isLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.BLUE);
                }
            }case "yellow" -> {
                data.Team = 4;
                player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
                if(ModList.get().isLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.YELLOW);
                }

            }case "pink" -> {
                data.Team = 5;
                player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
                if(ModList.get().isLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.PINK);
                }

            }case "orange" -> {
                data.Team = 6;
                player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
                PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
                if(ModList.get().isLoaded("voicechat")){
                    Objects.requireNonNull(MCPaintballVoiceChatPlugin.SERVER.getConnectionOf(context.getSource().getPlayerOrException().getUUID())).setGroup(MCPaintballVoiceChatPlugin.ORANGE);
                }

            }
            default -> player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_team"));
        }
        return 0;
    }

    public static int SetType(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String selectedType = StringArgumentType.getString(context, "type");
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.MatchStarted){
            if(!MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                selectedType = selectedType.toLowerCase();
                switch (selectedType) {
                    case "standard" -> {
                        data.Type = 1;
                        player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                        PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
                    }
                    case "sniper" -> {
                        data.Type = 2;
                        player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                        PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
                    }
                    case "assault" -> {
                        data.Type = 3;
                        player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get(), data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                        PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
                    }
                    case "heavy" -> {
                        data.Type = 4;
                        player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                        PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get())));
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


    public static int StartGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballGameEvents.INSTANCE.MatchStarted = true;
        MCPaintballGameEvents.INSTANCE.setDirty();
        player.sendSystemMessage(Component.translatable("text.mcpaintball.game_start"));
        return 0;
    }

    public static int StopGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballGameEvents.INSTANCE.MatchStarted = false;
        MCPaintballGameEvents.INSTANCE.RoundStarted = false;
        MCPaintballGameEvents.INSTANCE.RedPoints = 0;
        MCPaintballGameEvents.INSTANCE.GreenPoints = 0;
        MCPaintballGameEvents.INSTANCE.BluePoints = 0;
        MCPaintballGameEvents.INSTANCE.YellowPoints = 0;
        MCPaintballGameEvents.INSTANCE.PinkPoints = 0;
        MCPaintballGameEvents.INSTANCE.OrangePoints = 0;
        MCPaintballGameEvents.INSTANCE.setDirty();
        player.sendSystemMessage(Component.translatable("text.mcpaintball.game_stopped"));
        return 0;
    }

    public static int StopRound(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.MatchStarted){
            MCPaintballGameEvents.INSTANCE.RoundStarted = false;
            MCPaintballGameEvents.INSTANCE.setDirty();
            player.sendSystemMessage(Component.translatable("text.mcpaintball.round_ended"));
        }
        else{
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_no_game"));
        }
        return 0;
    }

    public static int StartRound(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.MatchStarted){
            MCPaintballGameEvents.INSTANCE.RoundStarted = true;
            MCPaintballGameEvents.INSTANCE.setDirty();
            player.sendSystemMessage(Component.translatable("text.mcpaintball.round_started"));
        }
        else{
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"));
        }
        return 0;
    }

    public static int RoundWinner(CommandContext<CommandSourceStack> context) {
        List<Integer> points = new ArrayList<>();
        points.add(MCPaintballGameEvents.INSTANCE.RedPoints);
        points.add(MCPaintballGameEvents.INSTANCE.GreenPoints);
        points.add(MCPaintballGameEvents.INSTANCE.BluePoints);
        points.add(MCPaintballGameEvents.INSTANCE.YellowPoints);
        points.add(MCPaintballGameEvents.INSTANCE.PinkPoints);
        points.add(MCPaintballGameEvents.INSTANCE.OrangePoints);
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

    public static int GiveKit(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        if(MCPaintballGameEvents.INSTANCE.MatchStarted && !MCPaintballGameEvents.INSTANCE.RoundStarted){
            ServerPlayer player = context.getSource().getPlayerOrException();
            MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
            if(data.Team != 0 && data.Type != 0){
                KitHandler.GrantKit(player, data.Team, data.Type);
            }
        }
        return 0;
    }
}

package org.multicoder.mcpaintball.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.KitHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MCPaintballCommands {
    public static int SetTeam(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String selectedTeam = StringArgumentType.getString(context, "team");
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
        selectedTeam = selectedTeam.toLowerCase();
        switch (selectedTeam) {
            case "red" -> {
                data.Team = 1;
                player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
            }
            case "green" -> {
                data.Team = 2;
                player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
            }
            case "blue" -> {
                data.Team = 3;
                player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                player.sendSystemMessage(Component.translatable("text.mcpaintball.team_set"));
            }
            default -> player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_team"));
        }
        return 0;
    }

    public static int CheckTeam(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
        String team = switch (data.Team) {
            case 1 -> "Red";
            case 2 -> "Green";
            case 3 -> "Blue";
            default -> "";
        };
        if(team.isEmpty()){
            player.sendSystemMessage(Component.translatable("text.mcpaintball.team_not_set"));
        }
        else {
            player.sendSystemMessage(Component.translatable("text.mcpaintball.team_check",team));
        }
        return 0;
    }

    public static int SetType(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String selectedType = StringArgumentType.getString(context, "type");
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.MatchStarted){
            if(!MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                selectedType = selectedType.toLowerCase();
                switch (selectedType) {
                    case "standard" -> {
                        data.Type = 1;
                        player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                    }
                    case "medic" -> {
                        data.Type = 2;
                        player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                    }
                    case "assault" -> {
                        data.Type = 3;
                        player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
                    }
                    case "heavy" -> {
                        data.Type = 4;
                        player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
                        player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
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

    public static int CheckType(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
        String type = switch (data.Type) {
            case 1 -> "Standard";
            case 2 -> "Medic";
            case 3 -> "Assault";
            case 4 -> "Heavy";
            default -> "";
        };
        if(type.isEmpty()){
            player.sendSystemMessage(Component.translatable("text.mcpaintball.type_not_set"));
        }
        else {
            player.sendSystemMessage(Component.translatable("text.mcpaintball.type_check",type));
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
        int Winner = points.indexOf(points.stream().max(Comparator.naturalOrder()).get());
        String Team = switch (Winner){
            case 0 -> "Red";
            case 1 -> "Green";
            case 2 -> "Blue";
            default -> throw new IllegalStateException("Unexpected value: " + Winner);
        };
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_winner",Team),false);
        return 0;
    }

    public static int GiveKit(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        if(MCPaintballGameEvents.INSTANCE.MatchStarted && !MCPaintballGameEvents.INSTANCE.RoundStarted){
            ServerPlayer player = context.getSource().getPlayerOrException();
            MCPaintballPlayerData data = player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            if(data != null && data.Team != 0 && data.Type != 0){
                KitHandler.GrantKit(player, data.Team, data.Type);
            }
        }
        return 0;
    }
}

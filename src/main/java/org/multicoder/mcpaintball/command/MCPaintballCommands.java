package org.multicoder.mcpaintball.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;

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
        MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
        selectedType = selectedType.toLowerCase();
        if(selectedType.equals("standard")){
            data.Type = 1;
            player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
            player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
        }else if(selectedType.equals("medic")){
            data.Type = 2;
            player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
            player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
        }else if(selectedType.equals("assault")){
            data.Type = 3;
            player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
            player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
        }else if(selectedType.equals("heavy")){
            data.Type = 4;
            player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
            player.sendSystemMessage(Component.translatable("text.mcpaintball.type_set"));
        }else{
            player.sendSystemMessage(Component.translatable("text.mcpaintball.invalid_type"));
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

    public static int StartGame(CommandContext<CommandSourceStack> context) {

        return 0;
    }

    public static int StopGame(CommandContext<CommandSourceStack> context) {

        return 0;
    }
}

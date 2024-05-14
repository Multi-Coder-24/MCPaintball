package org.multicoder.mcpaintball.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import org.apache.logging.log4j.MarkerManager;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.data.MCPaintballMatch;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;

import java.rmi.AccessException;

public class MatchCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("start").then(Commands.argument("name", StringArgumentType.string()).executes(MatchCommands::GameStart))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("stop").then(Commands.argument("name", StringArgumentType.string()).executes(MatchCommands::GameStop))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("create").then(Commands.argument("name", StringArgumentType.string()).executes(MatchCommands::MatchCreate))))).createBuilder().build();
    }

    private static int MatchCreate(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String name = StringArgumentType.getString(context, "name");
        MCPaintballMatch Match = new MCPaintballMatch(name);
        try {
            MCPaintballWorldData.INSTANCE.AddMatch(Match, context.getSource().getPlayerOrException(), context.getSource().getServer(), MatchCommands.class);
        } catch (AccessException e) {MCPaintball.SECURITY_LOG.fatal(MarkerManager.getMarker("MCPaintball"),"An attempt Was made to access an anti-cheat protected class");}
        return 0;
    }

    private static int GameStart(CommandContext<CommandSourceStack> context){
        String name = StringArgumentType.getString(context, "name");
        try {
            MCPaintballWorldData.INSTANCE.StartMatch(name, MatchCommands.class);
        } catch (AccessException e) {
            MCPaintball.SECURITY_LOG.fatal(MarkerManager.getMarker("MCPaintball"),"An attempt Was made to access an anti-cheat protected class");}
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game_start", name), true);
        return 0;
    }

    private static int GameStop(CommandContext<CommandSourceStack> context) {
        String name = StringArgumentType.getString(context, "name");
        try {
            MCPaintballWorldData.INSTANCE.StopMatch(name, MatchCommands.class);
        } catch (AccessException e) {MCPaintball.SECURITY_LOG.fatal(MarkerManager.getMarker("MCPaintball"),"An attempt Was made to access an anti-cheat protected class");}
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game_stop", name), true);
        return 0;
    }
}

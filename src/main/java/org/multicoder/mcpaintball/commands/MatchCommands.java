package org.multicoder.mcpaintball.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.GameRules;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class MatchCommands
{
    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher)
    {

        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("match").then(Commands.literal("start").executes(MatchCommands::MatchStart)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("match").then(Commands.literal("stop").executes(MatchCommands::MatchStop)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("start").executes(MatchCommands::GameStart)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("stop").executes(MatchCommands::GameStop)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("winner").executes(MatchCommands::Winner)))).createBuilder().build();
    }

    private static int Winner(CommandContext<CommandSourceStack> context)
    {
        List<Integer> Points = new ArrayList<>();
        Points.add(MCPaintballWorldData.INSTANCE.NULL_POINTS);
        Points.add(MCPaintballWorldData.INSTANCE.RED_POINTS);
        Points.add(MCPaintballWorldData.INSTANCE.GREEN_POINTS);
        Points.add(MCPaintballWorldData.INSTANCE.BLUE_POINTS);
        int Index = Points.indexOf(Points.stream().max(Comparator.naturalOrder()).get());
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.winner", PaintballTeam.getFromOrdinal(Index)), true);
        MCPaintballWorldData.INSTANCE.GREEN_POINTS = 0;
        MCPaintballWorldData.INSTANCE.BLUE_POINTS = 0;
        MCPaintballWorldData.INSTANCE.RED_POINTS = 0;
        MCPaintballWorldData.INSTANCE.NULL_POINTS = -1;
        MCPaintballWorldData.INSTANCE.setDirty();
        return 0;
    }

    private static int MatchStart(CommandContext<CommandSourceStack> context)
    {
        context.getSource().getServer().getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set(true,context.getSource().getServer());
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.match_start"), true);
        MCPaintballWorldData.INSTANCE.MatchStarted = true;
        MCPaintballWorldData.INSTANCE.setDirty();
        return 0;
    }

    private static int MatchStop(CommandContext<CommandSourceStack> context)
    {
        context.getSource().getServer().getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set(false,context.getSource().getServer());
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.match_stop"), true);
        MCPaintballWorldData.INSTANCE.MatchStarted = false;
        MCPaintballWorldData.INSTANCE.setDirty();
        return 0;
    }

    private static int GameStart(CommandContext<CommandSourceStack> context) {
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game_start"), true);
        MCPaintballWorldData.INSTANCE.GameStarted = true;
        MCPaintballWorldData.INSTANCE.setDirty();
        return 0;
    }

    private static int GameStop(CommandContext<CommandSourceStack> context) {
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game_stop"), true);
        MCPaintballWorldData.INSTANCE.MatchStarted = false;
        MCPaintballWorldData.INSTANCE.GameStarted = false;
        context.getSource().getServer().getPlayerList().getPlayers().forEach(serverPlayer ->
        {
            if (MCPaintballTeamsDataHelper.HasTeam(serverPlayer)) {
                MCPaintballTeamsDataHelper.ResetAll(serverPlayer);
            }
        });
        MCPaintballWorldData.INSTANCE.setDirty();
        return 0;
    }
}

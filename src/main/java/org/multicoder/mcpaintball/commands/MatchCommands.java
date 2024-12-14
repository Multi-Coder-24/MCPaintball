package org.multicoder.mcpaintball.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.*;
import net.minecraft.network.chat.Component;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;
import java.util.*;

import static net.minecraft.world.level.GameRules.RULE_KEEPINVENTORY;
import static org.multicoder.mcpaintball.data.MCPaintballWorldData.INSTANCE;


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
        Points.add(INSTANCE.NULL_POINTS);
        Points.add(INSTANCE.RED_POINTS);
        Points.add(INSTANCE.GREEN_POINTS);
        Points.add(INSTANCE.BLUE_POINTS);
        int Index = Points.indexOf(Points.stream().max(Comparator.naturalOrder()).get());
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.winner", PaintballTeam.getFromOrdinal(Index)), true);
        INSTANCE.GREEN_POINTS = 0;
        INSTANCE.BLUE_POINTS = 0;
        INSTANCE.RED_POINTS = 0;
        INSTANCE.NULL_POINTS = -1;
        INSTANCE.setDirty();
        return 0;
    }

    private static int MatchStart(CommandContext<CommandSourceStack> context)
    {
        context.getSource().getServer().getGameRules().getRule(RULE_KEEPINVENTORY).set(true,context.getSource().getServer());
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.match_start"), true);
        INSTANCE.MatchStarted = true;
        INSTANCE.setDirty();
        return 0;
    }

    private static int MatchStop(CommandContext<CommandSourceStack> context)
    {
        context.getSource().getServer().getGameRules().getRule(RULE_KEEPINVENTORY).set(false,context.getSource().getServer());
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.match_stop"), true);
        INSTANCE.MatchStarted = false;
        INSTANCE.setDirty();
        return 0;
    }

    private static int GameStart(CommandContext<CommandSourceStack> context) {
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game_start"), true);
        INSTANCE.GameStarted = true;
        INSTANCE.setDirty();
        return 0;
    }

    private static int GameStop(CommandContext<CommandSourceStack> context) {
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game_stop"), true);
        INSTANCE.MatchStarted = false;
        INSTANCE.GameStarted = false;
        context.getSource().getServer().getPlayerList().getPlayers().forEach(serverPlayer ->
        {
            if (MCPaintballTeamsDataHelper.HasTeam(serverPlayer)) {
                MCPaintballTeamsDataHelper.ResetAll(serverPlayer);
            }
        });
        INSTANCE.setDirty();
        return 0;
    }
}

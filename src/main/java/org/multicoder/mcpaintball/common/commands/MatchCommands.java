package org.multicoder.mcpaintball.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.server.command.EnumArgument;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class MatchCommands
{
    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher)
    {

        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("match").then(Commands.literal("start").executes(MatchCommands::MatchStart)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("match").then(Commands.literal("stop").executes(MatchCommands::MatchStop)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("start").executes(MatchCommands::GameStart)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("stop").executes(MatchCommands::GameStop)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("winner").executes(MatchCommands::Winner)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("mode").then(Commands.argument("Type", EnumArgument.enumArgument(PaintballDataUtility.GameType.class)).executes(MatchCommands::GameTypeSet))))).createBuilder().build();
    }


    private static int GameTypeSet(CommandContext<CommandSourceStack> context)
    {
        MCPaintballWorldData.INSTANCE.GAME_TYPE = context.getArgument("Type", PaintballDataUtility.GameType.class).ordinal();
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game.mode",context.getArgument("Type", PaintballDataUtility.GameType.class).name().toLowerCase().replace('_',' ')),true);
        return 0;
    }

    private static int Winner(CommandContext<CommandSourceStack> context)
    {
        if(MCPaintballWorldData.INSTANCE.GAME_TYPE == 0 || MCPaintballWorldData.INSTANCE.GAME_TYPE == 2)
        {
            List<Integer> Points = new ArrayList<>();
            Points.add(MCPaintballWorldData.INSTANCE.NULL_POINTS);
            Points.add(MCPaintballWorldData.INSTANCE.RED_POINTS);
            Points.add(MCPaintballWorldData.INSTANCE.GREEN_POINTS);
            Points.add(MCPaintballWorldData.INSTANCE.BLUE_POINTS);
            int Index = Points.indexOf(Points.stream().max(Comparator.naturalOrder()).get());
            Team WinningTeam = Team.values()[Index];
            context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.winner", WinningTeam.name()), true);
            MCPaintballWorldData.INSTANCE.GREEN_POINTS = 0;
            MCPaintballWorldData.INSTANCE.BLUE_POINTS = 0;
            MCPaintballWorldData.INSTANCE.RED_POINTS = 0;
            MCPaintballWorldData.INSTANCE.NULL_POINTS = -1;
            MCPaintballWorldData.INSTANCE.setDirty();
        } else if (MCPaintballWorldData.INSTANCE.GAME_TYPE == 1 || MCPaintballWorldData.INSTANCE.GAME_TYPE == 3)
        {
            List<String> NAMES = new ArrayList<>();
            List<Integer> POINTS = new ArrayList<>();
            context.getSource().getServer().getPlayerList().getPlayers().forEach(serverPlayer ->
            {
                if(MCPaintballTeamsDataHelper.HasTeam(serverPlayer))
                {
                   NAMES.add(serverPlayer.getName().getString());
                   POINTS.add(MCPaintballTeamsDataHelper.FetchPoints(serverPlayer));
                }
            });
            int MaxValue = POINTS.stream().max(Comparator.naturalOrder()).get();
            int Index = POINTS.indexOf(MaxValue);
            String Winner = NAMES.get(Index);
            context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.winner.solo",Winner),true);
        }
        return 0;
    }

    private static int MatchStart(CommandContext<CommandSourceStack> context)
    {
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.match_start"), true);
        MCPaintballWorldData.INSTANCE.MatchStarted = true;
        MCPaintballWorldData.INSTANCE.setDirty();
        return 0;
    }

    private static int MatchStop(CommandContext<CommandSourceStack> context) {
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

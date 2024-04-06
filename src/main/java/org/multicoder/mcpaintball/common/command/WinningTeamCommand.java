package org.multicoder.mcpaintball.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.config.MCPaintballConfig;
import org.multicoder.mcpaintball.common.util.enums.Teams;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class WinningTeamCommand {
    public static void Register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("winner").executes(WinningTeamCommand::Run).build()));
    }

    private static int Run(CommandContext<CommandSourceStack> stackCommandContext) {
        try {
            CommandSourceStack Source = stackCommandContext.getSource();
            ServerLevel level = Source.getLevel();
            ServerPlayer player = Source.getPlayer();
            boolean Op = player.hasPermissions(2);
            if (Op && MCPaintballConfig.WINNER_OP_ONLY.get()) {
                return Command(Source, level, player);
            }
            if (!MCPaintballConfig.WINNER_OP_ONLY.get()) {
                return Command(Source, level, player);
            }
            return -1;
        } catch (Exception e) {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
            return -1;
        }
    }

    private static int Command(CommandSourceStack source, ServerLevel level, ServerPlayer player) {
        List<Integer> Points = new ArrayList<>();
        for (Teams ignored : Teams.values()) {
            Points.add(0);
        }
        List<ServerPlayer> Players = level.players();
        Players.forEach(Serverplayer ->
        {
            PaintballPlayer PPlayer = Serverplayer.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().orElseThrow();
            int Index = PPlayer.Team.ordinal();
            int PointsCache = Points.get(Index);
            PointsCache += PPlayer.Points;
            Points.set(Index, PointsCache);
            PPlayer.Points = 0;
        });
        int Max = Points.stream().max(Integer::compare).orElseThrow();
        int Index = Points.indexOf(Max);
        Teams Winner = Teams.getTeam(Index);
        String WinMesage = Component.translatable("text.mcpaintball.match_winner").getString() + Component.translatable(Winner.GetTranslationKey()).getString();
        level.getServer().getPlayerList().broadcastChatMessage(PlayerChatMessage.system(WinMesage), player, ChatType.bind(ChatType.CHAT, source));
        return 0;
    }
}

package org.multicoder.mcpaintball.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.server.command.EnumArgument;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.plugins.SimpleVoicePlugin;
import org.multicoder.mcpaintball.common.util.enums.Teams;

@SuppressWarnings("all")
public class SetTeamCommand {
    public static void RegisterCommand(CommandDispatcher<CommandSourceStack> Dispatcher) {
        Dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("setTeam").then(Commands.argument("team", EnumArgument.enumArgument(Teams.class)).executes(SetTeamCommand::run).build().createBuilder())));
    }

    private static int run(CommandContext<CommandSourceStack> context) {
        ServerPlayer Player = context.getSource().getPlayer();
        Teams Team = context.getArgument("team", Teams.class);
        PaintballPlayer PPlayer = Player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
        PPlayer.SetTeam(Team);
        SimpleVoicePlugin.AddPlayerToGroup(Player, Team.ordinal());
        return 1;
    }
}

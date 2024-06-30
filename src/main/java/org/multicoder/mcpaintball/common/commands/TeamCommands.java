package org.multicoder.mcpaintball.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.server.command.EnumArgument;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Team;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Class;
import org.multicoder.mcpaintball.common.utility.TeamLoadoutManager;

import java.util.List;

public class TeamCommands {
    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("team").then(Commands.literal("set").then(Commands.argument("team", EnumArgument.enumArgument(Team.class)).executes(TeamCommands::setTeamCommand))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("class").then(Commands.literal("set").then(Commands.argument("class", EnumArgument.enumArgument(Class.class)).executes(TeamCommands::setClassCommand))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("kit").executes(TeamCommands::GiveKit))).createBuilder().build();
    }

    private static int GiveKit(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        List<ItemStack> Equipment = TeamLoadoutManager.FetchEquipment(player);
        Equipment.forEach(player::addItem);
        return 0;
    }

    private static int setClassCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        ServerPlayer player = source.getPlayerOrException();
        if (MCPaintballWorldData.INSTANCE.GameStarted && !MCPaintballWorldData.INSTANCE.MatchStarted) {
            Class selected = context.getArgument("class", Class.class);
            MCPaintballTeamsDataHelper.UpdateClass(selected.ordinal(), player);
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.class.set", selected.name().toLowerCase()));
            return 0;
        }
        return -1;
    }

    private static int setTeamCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        ServerPlayer player = source.getPlayerOrException();
        if (MCPaintballWorldData.INSTANCE.GameStarted && !MCPaintballWorldData.INSTANCE.MatchStarted)
        {
            Team selected = context.getArgument("team", Team.class);
            MCPaintballTeamsDataHelper.UpdateTeam(selected.ordinal(), player);
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.team.set", selected.name().toLowerCase()));
            return 0;
        }
        return -1;
    }
}

package org.multicoder.mcpaintball.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.*;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.server.command.EnumArgument;
import org.multicoder.mcpaintball.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.utility.TeamLoadoutManager;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;
import java.util.List;

import static org.multicoder.mcpaintball.data.MCPaintballWorldData.INSTANCE;

public class TeamCommands
{
    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("team").then(Commands.literal("set").then(Commands.argument("team", EnumArgument.enumArgument(PaintballTeam.class)).executes(TeamCommands::setTeamCommand))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("kit").executes(TeamCommands::GiveKit))).createBuilder().build();
    }

    private static int GiveKit(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        List<ItemStack> Equipment = TeamLoadoutManager.FetchEquipment(player);
        Equipment.forEach(player::addItem);
        return 0;
    }


    private static int setTeamCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        ServerPlayer player = source.getPlayerOrException();
        if (INSTANCE.GameStarted && !INSTANCE.MatchStarted)
        {
            PaintballTeam selected = context.getArgument("team", PaintballTeam.class);
            MCPaintballTeamsDataHelper.UpdateTeam(selected.ordinal(), player);
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.team.set", selected.name().toLowerCase()));
            return 0;
        }
        return -1;
    }
}

package org.multicoder.mcpaintball.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.server.command.EnumArgument;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.data.MCPaintballTeamsDataHelper;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.utility.PaintballClass;
import org.multicoder.mcpaintball.common.utility.PaintballTeam;

public class TeamCommands
{
    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("team").then(Commands.literal("set").then(Commands.argument("team",EnumArgument.enumArgument(PaintballTeam.class)).executes(TeamCommands::setTeamCommand))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("class").then(Commands.literal("set").then(Commands.argument("class",EnumArgument.enumArgument(PaintballClass.class)).executes(TeamCommands::setClassCommand))))).createBuilder().build();
    }

    private static int setClassCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        CommandSourceStack source = context.getSource();
        ServerPlayer player = source.getPlayerOrException();
        if(MCPaintballWorldData.INSTANCE.GameStarted && !MCPaintballWorldData.INSTANCE.MatchStarted){
            PaintballClass selected = context.getArgument("class", PaintballClass.class);
            MCPaintballTeamsDataHelper.UpdateClass(selected.ordinal(),player);
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.class.set",selected.name().toLowerCase()));
            return 0;
        }
        return -1;
    }

    private static int setTeamCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException
    {
        CommandSourceStack source = context.getSource();
        ServerPlayer player = source.getPlayerOrException();
        if(MCPaintballWorldData.INSTANCE.GameStarted && !MCPaintballWorldData.INSTANCE.MatchStarted){
            PaintballTeam selected = context.getArgument("team", PaintballTeam.class);
            MCPaintballTeamsDataHelper.UpdateTeam(selected.ordinal(),player);
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.team.set",selected.name().toLowerCase()));
            return 0;
        }
        return -1;
    }
}

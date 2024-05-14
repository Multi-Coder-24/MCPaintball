package org.multicoder.mcpaintball.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.server.command.EnumArgument;
import org.multicoder.mcpaintball.common.blocks.RespawnBlock;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.utility.PaintballClass;
import org.multicoder.mcpaintball.common.utility.PaintballTeam;

import java.rmi.AccessException;
import java.util.Objects;

public class TeamCommands {
    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("team").then(Commands.literal("set").then(Commands.argument("team", EnumArgument.enumArgument(PaintballTeam.class)).executes(TeamCommands::setTeamCommand))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("team").then(Commands.literal("get").executes(TeamCommands::getTeamCommand)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("match").then(Commands.literal("join").then(Commands.argument("name", StringArgumentType.string()).executes(TeamCommands::JoinMatch))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("match").then(Commands.literal("leave").executes(TeamCommands::LeaveMatch)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("class").then(Commands.literal("set").then(Commands.argument("class", EnumArgument.enumArgument(PaintballClass.class)).executes(TeamCommands::setClassCommand))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("class").then(Commands.literal("get").executes(TeamCommands::getClassCommand)))).createBuilder().build();
    }

    private static int getClassCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        player.getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(cap ->
        {
            try{
                player.sendSystemMessage(Component.translatable("mcpaintball.command.response.class.get", Component.translatable(cap.GetType(TeamCommands.class).GetTKey(TeamCommands.class)).getString()));
            }
            catch (Exception e){}
        });
        return 0;
    }

    private static int getTeamCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        player.getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(cap -> {
            try {
                player.sendSystemMessage(Component.translatable("mcpaintball.command.response.team.get", Component.translatable(cap.GetTeam(TeamCommands.class).GetTKey()).getString()));
            } catch (AccessException e) {}
        });
        return 0;
    }

    private static int LeaveMatch(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        Player player = context.getSource().getPlayerOrException();
        player.getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(cap -> {
            String Name = null;
            try {
                Name = cap.getName(TeamCommands.class);
                cap.SetName("",TeamCommands.class);
            } catch (AccessException e) {
            }
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.match.left", Name));
        });
        return 0;
    }

    private static int JoinMatch(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String Name = StringArgumentType.getString(context, "name");
        Player player = context.getSource().getPlayerOrException();
        player.getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(cap ->
        {
            try {
                cap.SetName(Name,TeamCommands.class);
            } catch (AccessException e) {}
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.match.joined", Name));
        });
        return 0;
    }

    private static int setClassCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        ServerPlayer player = source.getPlayerOrException();
        PaintballClass selected = context.getArgument("class", PaintballClass.class);
        player.getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(cap ->
        {
            try {
                if (Objects.equals(cap.getName(TeamCommands.class), ""))
                {
                    cap.SetType(selected,TeamCommands.class);
                    try{
                        player.sendSystemMessage(Component.translatable("mcpaintball.command.response.class.get", Component.translatable(cap.GetType(TeamCommands.class).GetTKey(TeamCommands.class)).getString()));
                    }
                    catch (Exception e){}
                    return;
                }
            } catch (AccessException e) {
            }
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.invalid"));

        });
        return 0;
    }

    private static int setTeamCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        ServerPlayer player = source.getPlayerOrException();
        PaintballTeam selected = context.getArgument("team", PaintballTeam.class);
        player.getCapability(PaintballPlayerProvider.CAPABILITY).ifPresent(cap ->
        {
            try {
                if (Objects.equals(cap.getName(TeamCommands.class), "")) {
                    cap.SetTeam(selected,TeamCommands.class);
                    player.sendSystemMessage(Component.translatable("mcpaintball.command.response.team.set", Component.translatable(selected.GetTKey())));
                    return;
                }
            } catch (AccessException e) {}
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.invalid"));
        });
        return 0;
    }
}

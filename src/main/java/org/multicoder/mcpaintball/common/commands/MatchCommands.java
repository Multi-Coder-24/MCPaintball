package org.multicoder.mcpaintball.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.PlayerChatMessage;
import org.multicoder.mcpaintball.common.data.MCPaintballMatch;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;

public class MatchCommands
{
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("match").then(Commands.literal("start").then(Commands.argument("name", StringArgumentType.string()).executes(MatchCommands::MatchStart))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("match").then(Commands.literal("stop").then(Commands.argument("name", StringArgumentType.string()).executes(MatchCommands::MatchStop))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("start").then(Commands.argument("name", StringArgumentType.string()).executes(MatchCommands::GameStart))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("game").then(Commands.literal("stop").then(Commands.argument("name", StringArgumentType.string()).executes(MatchCommands::GameStop))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("match").then(Commands.literal("create").then(Commands.argument("name", StringArgumentType.string()).executes(MatchCommands::MatchCreate))))).createBuilder().build();
    }

    private static int MatchCreate(CommandContext<CommandSourceStack> context)
    {
        String name = StringArgumentType.getString(context,"name");
        MCPaintballMatch Match = new MCPaintballMatch(name);
        MCPaintballWorldData.INSTANCE.AddMatch(Match);
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.match_create",name),true);
        return 0;
    }

    private static int MatchStart(CommandContext<CommandSourceStack> context)
    {
        String name = StringArgumentType.getString(context,"name");
        MCPaintballWorldData.INSTANCE.StartMatch(name);
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.match_start",name),true);
        return 0;
    }
    private static int MatchStop(CommandContext<CommandSourceStack> context)
    {
        String name = StringArgumentType.getString(context,"name");
        MCPaintballWorldData.INSTANCE.StopMatch(name);
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.match_stop",name),true);
        return 0;
    }

    private static int GameStart(CommandContext<CommandSourceStack> context)
    {
        String name = StringArgumentType.getString(context,"name");
        MCPaintballWorldData.INSTANCE.StartGame(name);
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game_start",name),true);
        return 0;
    }
    private static int GameStop(CommandContext<CommandSourceStack> context)
    {
        String name = StringArgumentType.getString(context,"name");
        MCPaintballWorldData.INSTANCE.StopGame(name);
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("mcpaintball.command.response.game_stop",name),true);
        return 0;
    }
}

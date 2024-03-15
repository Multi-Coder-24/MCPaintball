package org.multicoder.mcpaintball.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.server.command.EnumArgument;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.utility.PaintballClass;
import org.multicoder.mcpaintball.common.utility.PaintballTeam;

public class TeamCommands
{
    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("team").then(Commands.literal("set").then(Commands.argument("team",EnumArgument.enumArgument(PaintballTeam.class)).executes(TeamCommands::setTeamCommand))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("round").then(Commands.literal("join").then(Commands.argument("name", StringArgumentType.string()).executes(TeamCommands::JoinMatch))))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("round").then(Commands.literal("leave").executes(TeamCommands::LeaveMatch)))).createBuilder().build();
        dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("class").then(Commands.literal("set").then(Commands.argument("class",EnumArgument.enumArgument(PaintballClass.class)).executes(TeamCommands::setClassCommand))))).createBuilder().build();
    }

    private static int LeaveMatch(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        Player player = context.getSource().getPlayerOrException();
        CompoundTag Persist = player.getPersistentData();
        if(Persist.contains("mcpaintball.teamsTag"))
        {
            CompoundTag TeamData = Persist.getCompound("mcpaintball.teamsTag");
            String Name = TeamData.getString("name");
            TeamData.remove("name");
            player.sendSystemMessage(Component.translatable("mcpaintball.command.response.match.left",Name));
        }
        return 0;
    }

    private static int JoinMatch(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String Name = StringArgumentType.getString(context,"name");
        Player player = context.getSource().getPlayerOrException();
        CompoundTag Persist = player.getPersistentData();
        CompoundTag TeamData;
        if(Persist.contains("mcpaintbal.teamsTag"))
        {
             TeamData = Persist.getCompound("mcpaintball.teamsTag");
        }
        else {
            TeamData = new CompoundTag();
        }
        TeamData.putString("name",Name);
        player.sendSystemMessage(Component.translatable("mcpaintball.command.response.match.joined",Name));
        return 0;
    }

    private static int setClassCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        ServerPlayer player = source.getPlayerOrException();
        PaintballClass selected = context.getArgument("class", PaintballClass.class);
        CompoundTag playerData = player.getPersistentData();
        if (playerData.contains("mcpaintball.teamsTag"))
        {
            CompoundTag TeamData = playerData.getCompound("mcpaintball.teamsTag");
            boolean Enabled = MCPaintballWorldData.INSTANCE.EnabledByName(TeamData.getString("name"));
            boolean Started = MCPaintballWorldData.INSTANCE.StartedByName(TeamData.getString("name"));
            if(Enabled || Started)
            {
                TeamData.putInt("class",selected.ordinal());
                player.sendSystemMessage(Component.translatable("mcpaintball.command.response.class.set", selected.name().toLowerCase()));
            }
        }
        return 0;
    }

    private static int setTeamCommand(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        ServerPlayer player = source.getPlayerOrException();
        PaintballTeam selected = context.getArgument("team", PaintballTeam.class);
        CompoundTag playerData = player.getPersistentData();
        if (playerData.contains("mcpaintball.teamsTag"))
        {
            CompoundTag TeamData = playerData.getCompound("mcpaintball.teamsTag");
            boolean Enabled = MCPaintballWorldData.INSTANCE.EnabledByName(TeamData.getString("name"));
            boolean Started = MCPaintballWorldData.INSTANCE.StartedByName(TeamData.getString("name"));
            if(Enabled && !Started){
                TeamData.putInt("team", selected.ordinal());
                player.sendSystemMessage(Component.translatable("mcpaintball.command.response.team.set", selected.name().toLowerCase()));
            }
        }

        return 0;
    }
}

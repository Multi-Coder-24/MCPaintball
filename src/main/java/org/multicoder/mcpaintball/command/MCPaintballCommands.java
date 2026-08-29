package org.multicoder.mcpaintball.command;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.multicoder.mcpaintball.block.objectives.CapturePointBlock;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.KitHandler;
import org.multicoder.mcpaintball.util.PaintballRole;
import org.multicoder.mcpaintball.util.PaintballTeam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MCPaintballCommands {


    public static int StartGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballGameEvents.INSTANCE.MatchStarted = true;
        MCPaintballGameEvents.INSTANCE.setDirty();
        player.sendSystemMessage(Component.translatable("text.mcpaintball.game_start"));
        return 0;
    }

    public static int StopGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballGameEvents.INSTANCE.MatchStarted = false;
        MCPaintballGameEvents.INSTANCE.RoundStarted = false;
        MCPaintballGameEvents.INSTANCE.RedPoints = 0;
        MCPaintballGameEvents.INSTANCE.GreenPoints = 0;
        MCPaintballGameEvents.INSTANCE.BluePoints = 0;
        MCPaintballGameEvents.INSTANCE.YellowPoints = 0;
        MCPaintballGameEvents.INSTANCE.PinkPoints = 0;
        MCPaintballGameEvents.INSTANCE.OrangePoints = 0;
        MCPaintballGameEvents.INSTANCE.setDirty();
        player.sendSystemMessage(Component.translatable("text.mcpaintball.game_stopped"));
        return 0;
    }

    public static int StopRound(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.MatchStarted){
            List<BlockPos> positions = new ArrayList<>(MCPaintballGameEvents.INSTANCE.CapturePoints);
            positions.forEach(position -> {
                BlockState state = Objects.requireNonNull(context.getSource().getServer()).overworld().getBlockState(position);
                if(state.getBlock() == MCPaintballBlocks.CAPTURE_POINT.get()){
                    int Team = state.getValue(CapturePointBlock.TEAM);
                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(Team);
                    Objects.requireNonNull(context.getSource().getServer()).overworld().setBlockAndUpdate(position,state.setValue(CapturePointBlock.TEAM,0));
                }
            });
            MCPaintballGameEvents.INSTANCE.RoundStarted = false;
            MCPaintballGameEvents.INSTANCE.setDirty();
            player.sendSystemMessage(Component.translatable("text.mcpaintball.round_ended"));
        }
        else{
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"));
        }
        return 0;
    }

    public static int StartRound(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.MatchStarted){
            MCPaintballGameEvents.INSTANCE.RoundStarted = true;
            MCPaintballGameEvents.INSTANCE.setDirty();
            player.sendSystemMessage(Component.translatable("text.mcpaintball.round_started"));
        }
        else{
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"));
        }
        return 0;
    }

    public static int RoundWinner(CommandContext<CommandSourceStack> context) {
        List<Integer> points = new ArrayList<>();
        points.add(MCPaintballGameEvents.INSTANCE.RedPoints);
        points.add(MCPaintballGameEvents.INSTANCE.GreenPoints);
        points.add(MCPaintballGameEvents.INSTANCE.BluePoints);
        points.add(MCPaintballGameEvents.INSTANCE.YellowPoints);
        points.add(MCPaintballGameEvents.INSTANCE.PinkPoints);
        points.add(MCPaintballGameEvents.INSTANCE.OrangePoints);
        int Winner = points.indexOf(points.stream().max(Comparator.naturalOrder()).get());
        Component Team = switch (Winner){
            case 0 -> Component.translatable("text.mcpaintball.team_red");
            case 1 -> Component.translatable("text.mcpaintball.team_green");
            case 2 -> Component.translatable("text.mcpaintball.team_blue");
            case 3 -> Component.translatable("text.mcpaintball.team_yellow");
            case 4 -> Component.translatable("text.mcpaintball.team_pink");
            case 5 -> Component.translatable("text.mcpaintball.team_orange");
            default -> throw new IllegalStateException("Unexpected value: " + Winner);
        };
        int FWinner = Winner + 1;
        context.getSource().getServer().getPlayerList().broadcastSystemMessage(Component.translatable("text.mcpaintball.round_winner",Team),false);
        context.getSource().getServer().getPlayerList().getPlayers().forEach(player -> {
            if(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get()).Team == FWinner){
                player.addItem(new ItemStack(MCPaintballItems.MEDAL.get())); 
            }
        });
        return 0;
    }

    public static int GiveKit(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        if(MCPaintballGameEvents.INSTANCE.MatchStarted && !MCPaintballGameEvents.INSTANCE.RoundStarted){
            ServerPlayer player = context.getSource().getPlayerOrException();
            MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
            if(data.Team != 0 && data.Role != 0){
                PaintballTeam team = PaintballTeam.values()[data.Team];
                PaintballRole role = PaintballRole.values()[data.Role];
                KitHandler.grantKit(player, team, role);
            }
        }
        return 0;
    }
}

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


    public static int startGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballGameEvents.INSTANCE.matchStarted = true;
        MCPaintballGameEvents.INSTANCE.setDirty(true);
        player.sendSystemMessage(Component.translatable("text.mcpaintball.game_start"));
        return 0;
    }

    public static int stopGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        MCPaintballGameEvents.INSTANCE.matchStarted = false;
        MCPaintballGameEvents.INSTANCE.roundStarted = false;
        MCPaintballGameEvents.INSTANCE.redPoints = 0;
        MCPaintballGameEvents.INSTANCE.greenPoints = 0;
        MCPaintballGameEvents.INSTANCE.bluePoints = 0;
        MCPaintballGameEvents.INSTANCE.yellowPoints = 0;
        MCPaintballGameEvents.INSTANCE.pinkPoints = 0;
        MCPaintballGameEvents.INSTANCE.orangePoints = 0;
        MCPaintballGameEvents.INSTANCE.setDirty(true);
        context.getSource().getServer().getPlayerList().getPlayers().forEach(serverPlayer ->{
            MCPaintballPlayerData data = new MCPaintballPlayerData(0,0);
            serverPlayer.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER, data);
        });
        player.sendSystemMessage(Component.translatable("text.mcpaintball.game_stopped"));
        return 0;
    }

    public static int stopRound(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.matchStarted){
            List<BlockPos> positions = new ArrayList<>(MCPaintballGameEvents.INSTANCE.capturePoints);
            positions.forEach(position -> {
                BlockState state = Objects.requireNonNull(context.getSource().getServer()).overworld().getBlockState(position);
                if(state.getBlock() == MCPaintballBlocks.CAPTURE_POINT){
                    int Team = state.getValue(CapturePointBlock.TEAM);
                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(Team);
                    Objects.requireNonNull(context.getSource().getServer()).overworld().setBlockAndUpdate(position,state.setValue(CapturePointBlock.TEAM,0));
                }
            });
            MCPaintballGameEvents.INSTANCE.roundStarted = false;
            MCPaintballGameEvents.INSTANCE.setDirty();
            player.sendSystemMessage(Component.translatable("text.mcpaintball.round_ended"));
        }
        else{
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"));
        }
        return 0;
    }

    public static int startRound(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        if(MCPaintballGameEvents.INSTANCE.matchStarted){
            MCPaintballGameEvents.INSTANCE.roundStarted = true;
            MCPaintballGameEvents.INSTANCE.setDirty();
            player.sendSystemMessage(Component.translatable("text.mcpaintball.round_started"));
        }
        else{
            player.sendSystemMessage(Component.translatable("text.mcpaintball.error_game_not_started"));
        }
        return 0;
    }

    public static int roundWinner(CommandContext<CommandSourceStack> context) {
        List<Integer> points = new ArrayList<>();
        points.add(MCPaintballGameEvents.INSTANCE.redPoints);
        points.add(MCPaintballGameEvents.INSTANCE.greenPoints);
        points.add(MCPaintballGameEvents.INSTANCE.bluePoints);
        points.add(MCPaintballGameEvents.INSTANCE.yellowPoints);
        points.add(MCPaintballGameEvents.INSTANCE.pinkPoints);
        points.add(MCPaintballGameEvents.INSTANCE.orangePoints);
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
        context.getSource().getServer().getPlayerList().getPlayers().forEach(serverPlayer ->{
            if(Objects.requireNonNull(serverPlayer.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == FWinner){
                serverPlayer.addItem(new ItemStack(MCPaintballItems.MEDAL));
            }
        });
        return 0;
    }

    public static int giveKit(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        if(MCPaintballGameEvents.INSTANCE.matchStarted && !MCPaintballGameEvents.INSTANCE.roundStarted){
            ServerPlayer player = context.getSource().getPlayerOrException();
            MCPaintballPlayerData data = player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            if(data != null && data.team != 0 && data.role != 0){
                PaintballTeam team = PaintballTeam.values()[data.team];
                PaintballRole role = PaintballRole.values()[data.role];
                KitHandler.grantKit(player, team, role);
            }
        }
        return 0;
    }
}

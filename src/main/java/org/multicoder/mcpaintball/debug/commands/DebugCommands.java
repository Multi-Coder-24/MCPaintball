package org.multicoder.mcpaintball.debug.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;

import java.util.Objects;

import static net.minecraft.commands.Commands.literal;


public class DebugCommands {
    public static void RegisterDebugCommands(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(literal("simulate").executes(DebugCommands::SimulateHit)).createBuilder().build();
    }

    private static int SimulateHit(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        BlockPos pos = Objects.requireNonNull(player.getRespawnConfig()).respawnData().pos();
        player.teleportTo(pos.getX(), pos.getY(), pos.getZ());
        return 0;
    }

}

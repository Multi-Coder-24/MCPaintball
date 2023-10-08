package org.multicoder.mcpaintball.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.world.entity.player.Player;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;

@SuppressWarnings("all")
public class PointTestCommand {
    public static void Regsiter(CommandDispatcher<CommandSourceStack> dispatcher) {
        if (MCPaintball.DEV_MODE) {
            dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("point").then(Commands.literal("add").then(Commands.argument("amount", IntegerArgumentType.integer()).executes(PointTestCommand::add).build()))));
        }
    }

    private static int add(CommandContext<CommandSourceStack> context) {
        try {
            Player player = context.getSource().getPlayerOrException();
            PaintballPlayer PPlayer = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
            int Cache = PPlayer.Points;
            Cache += IntegerArgumentType.getInteger(context, "amount");
            PPlayer.Points = Cache;
            return 0;
        } catch (Exception e) {
            System.err.println(e.getCause());
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
            return 1;
        }
    }
}

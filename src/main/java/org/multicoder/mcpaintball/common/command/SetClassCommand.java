package org.multicoder.mcpaintball.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.server.command.EnumArgument;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.util.enums.KitType;

@SuppressWarnings("all")
public class SetClassCommand {
    public static void RegisterCommand(CommandDispatcher<CommandSourceStack> Dispatcher) {
        Dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("setClass").then(Commands.argument("class", EnumArgument.enumArgument(KitType.class)).executes(SetClassCommand::run).build().createBuilder())));
    }

    private static int run(CommandContext<CommandSourceStack> context) {
        ServerPlayer Player = context.getSource().getPlayer();
        KitType Type = context.getArgument("class", KitType.class);
        PaintballPlayer PPlayer = Player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
        PPlayer.SetClass(Type);
        return 1;
    }
}

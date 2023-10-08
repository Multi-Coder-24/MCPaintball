package org.multicoder.mcpaintball.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.util.holders.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings("all")
public class GiveKitCommand {
    public static void RegisterCommand(CommandDispatcher<CommandSourceStack> Dispatcher) {
        Dispatcher.register(Commands.literal("mcpaintball").then(Commands.literal("giveKit").executes(GiveKitCommand::Run).build().createBuilder()));
    }

    private static int Run(CommandContext<CommandSourceStack> context) {
        ServerPlayer Player = context.getSource().getPlayer();
        PaintballPlayer PPlayer = Player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
        String Code = PPlayer.GetCode();
        ApplyCode(Code, Player);
        return 1;
    }

    private static void ApplyCode(String Code, ServerPlayer Player) {
        try {
            char T = Code.charAt(0);
            char C = Code.charAt(1);
            AtomicReference<Class<?>> Selected = new AtomicReference<>();
            switch (T) {
                case '1' -> Selected.set(RedClass.class);
                case '2' -> Selected.set(GreenClass.class);
                case '3' -> Selected.set(BlueClass.class);
                case '4' -> Selected.set(MagentaClass.class);
                case '5' -> Selected.set(PinkClass.class);
                case '6' -> Selected.set(PurpleClass.class);
                case '7' -> Selected.set(LimeClass.class);
                case '8' -> Selected.set(LightBlueClass.class);
                case '9' -> Selected.set(CyanClass.class);
            }
            switch (C) {
                case '1' -> {
                    Class<?> Cl = Selected.get();
                    List<ItemStack> Stacks = (List<ItemStack>) Cl.getField("STANDARD").get(ArrayList.class);
                    Stacks.forEach(stack -> {
                        Player.drop(stack, true);
                    });
                }
                case '2' -> {
                    Class<?> Cl = Selected.get();
                    List<ItemStack> Stacks = (List<ItemStack>) Cl.getField("MEDICAL").get(ArrayList.class);
                    Stacks.forEach(stack -> {
                        Player.drop(stack, true);
                    });
                }
                case '3' -> {
                    Class<?> Cl = Selected.get();
                    List<ItemStack> Stacks = (List<ItemStack>) Cl.getField("HEAVY").get(ArrayList.class);
                    Stacks.forEach(stack -> {
                        Player.drop(stack, true);
                    });
                }
                case '4' -> {
                    Class<?> Cl = Selected.get();
                    List<ItemStack> Stacks = (List<ItemStack>) Cl.getField("SNIPER").get(ArrayList.class);
                    Stacks.forEach(stack -> {
                        Player.drop(stack, true);
                    });
                }
                case '5' -> {
                    Class<?> Cl = Selected.get();
                    List<ItemStack> Stacks = (List<ItemStack>) Cl.getField("ENGINEER").get(ArrayList.class);
                    Stacks.forEach(stack -> {
                        Player.drop(stack, true);
                    });
                }
            }
        } catch (Exception ex) {
        }
    }
}

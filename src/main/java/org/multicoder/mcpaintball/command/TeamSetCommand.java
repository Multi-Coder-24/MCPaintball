package org.multicoder.mcpaintball.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.init.iteminit;
import org.multicoder.mcpaintball.util.KitType;
import org.multicoder.mcpaintball.util.Teams;
import org.multicoder.mcpaintball.util.player.ItemKitHandler;

import java.util.concurrent.atomic.AtomicReference;

public class TeamSetCommand
{
    public static void register(CommandDispatcher<CommandSourceStack> registry)
    {
        registry.register(Commands.literal("SetTeam").then(Commands.argument("Colour",StringArgumentType.string()).executes(TeamSetCommand::Execute)));
    }

    public static int Execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
            ServerPlayer Caller = context.getSource().getPlayerOrException();
            String Team = context.getArgument("Colour",String.class);
            MCPaintball.LOG.info("Colour Set: " + Team);
            Teams TeamSet = Teams.getTeam(Team);
            ItemStack KitItem = Caller.getItemInHand(InteractionHand.MAIN_HAND);
            MCPaintball.LOG.info("Held Item: " + KitItem.getDisplayName().getString());
            MCPaintball.LOG.info("Team: " + TeamSet.name());
            Item I = KitItem.getItem();
            AtomicReference<KitType> Type = new AtomicReference<>();
            if(I.equals(iteminit.PAINTBALL_STANDARD_KIT.get())) {
                Type.set(KitType.STANDARD);
                MCPaintball.LOG.info("Standard Class");
            } else if (I.equals(iteminit.PAINTBALL_MEDICAL_KIT.get())) {
                Type.set(KitType.MEDICAL);
                MCPaintball.LOG.info("Medical Class");
            } else if (I.equals(iteminit.PAINTBALL_HEAVY_KIT.get())) {
                Type.set(KitType.HEAVY);
                MCPaintball.LOG.info("Heavy Class");
            } else if (I.equals(iteminit.PAINTBALL_TRAINEE_KIT.get())) {
                Type.set(KitType.TRAINEE);
                MCPaintball.LOG.info("Trainee Class");
            }
            ItemKitHandler.checkAndApply(TeamSet,Caller,Type.get());
            return 0;
    }
}

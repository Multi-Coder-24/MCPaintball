package org.multicoder.mcpaintball.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.util.Teams;

public class TeamCheckCommand
{
    public static void register(CommandDispatcher<CommandSourceStack> registry)
    {
        registry.register(Commands.literal("TeamCheck").executes(context ->
        {
            if(context.getSource().getEntityOrException() instanceof Player)
            {
                Player player = (Player) context.getSource().getEntityOrException();
                return Check(player);
            }
            else
            {
                return 0;
            }
        }));
    }

    private static int Check(Player player)
    {
        if(player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).isPresent())
        {
            player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
            {
                int Team = cap.GetTeam();
                Teams T = Teams.getTeam(Team);
                String C1 = new TranslatableComponent("text.mcpaintball.team").getString();
                String C2 = new TranslatableComponent(T.GetTranslationKey()).getString();
                String Comp = C1 + C2;
                player.displayClientMessage(new TextComponent(Comp).withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD),false);
            });
            return 1;
        }
        return 0;
    }

}

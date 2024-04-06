package org.multicoder.mcpaintball.item.utility.medical;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.init.tabinit;
import org.multicoder.mcpaintball.util.player.TeamUtils;

import java.util.List;

public class PinkMedKitItem extends Item
{

    public PinkMedKitItem()
    {
        super(new Properties().tab(tabinit.Utility));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if(!level.isClientSide())
        {
            ServerPlayer SP = (ServerPlayer) player;
            SP.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
            {
                if(cap.GetTeam() == 5 || MCPaintball.DEV_MODE)
                {
                    SP.heal(2.5f);
                    SP.getItemInHand(hand).shrink(1);
                }
            });
        }
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
    {
        if(!player.level.isClientSide())
        {
            if(entity instanceof Player)
            {
                ServerPlayer Medic = (ServerPlayer) player;
                ServerPlayer Teammate = (ServerPlayer) entity;
                if(TeamUtils.HasTeam(Medic,Teammate) && TeamUtils.IsSameTeam(Medic,Teammate))
                {
                    Teammate.heal(2.5f);
                    stack.shrink(1);
                }
            }
        }
        return true;
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_)
    {
        if(Screen.hasShiftDown()){
            components.add(new TranslatableComponent("text.mcpaintball.med").withStyle(ChatFormatting.BOLD));
        }
        else{
            components.add(new TranslatableComponent("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
    }
}

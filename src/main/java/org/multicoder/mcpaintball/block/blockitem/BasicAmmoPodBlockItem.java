package org.multicoder.mcpaintball.block.blockitem;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.init.tabinit;

import java.util.List;

public class BasicAmmoPodBlockItem extends BlockItem
{

    public BasicAmmoPodBlockItem(Block p_40565_)
    {
        super(p_40565_, new Properties().tab(tabinit.Utility));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level p_40573_, List<Component> components, TooltipFlag flag)
    {
        if(Screen.hasShiftDown())
        {
            components.add(new TranslatableComponent("text.mcpaintball.ammo_pod").withStyle(ChatFormatting.BOLD));
        }
        else
        {
            components.add(new TranslatableComponent("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
    }
}

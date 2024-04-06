package org.multicoder.mcpaintball.common.blockitem;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("all")
public class ExplosivesStationBlockItem extends BlockItem {

    public ExplosivesStationBlockItem(Block pBlock) {
        super(pBlock, new Properties());
    }


    @Override
    public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
        if (Screen.hasShiftDown()) {
            p_40574_.add(Component.translatable("text.mcpaintball.explosive_station"));
        } else {
            p_40574_.add(Component.translatable("text.mcpaintball.press_shift"));
        }
    }
}

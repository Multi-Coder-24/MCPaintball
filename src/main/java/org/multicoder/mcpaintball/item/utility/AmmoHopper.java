package org.multicoder.mcpaintball.item.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.block.RefillStationBlock;
import org.multicoder.mcpaintball.data.component.ItemTeamDataComponent;
import org.multicoder.mcpaintball.init.MCPaintballDataComponents;

public class AmmoHopper extends Item {
    public AmmoHopper(int Team) {
        super(new Properties().stacksTo(1).durability(128).component(MCPaintballDataComponents.ITEM_TEAM.get(),new ItemTeamDataComponent(Team)));
    }

    @SuppressWarnings("all")
    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos position = context.getClickedPos();
        Block clickedBlock = level.getBlockState(position).getBlock();
        if(clickedBlock instanceof RefillStationBlock) {
            ItemStack Stack = context.getItemInHand();
            Thread Ext = new Thread(() -> {
                try {
                    while(Stack.getDamageValue() > 0){
                        Thread.sleep(1000);
                        Stack.setDamageValue(Math.max(0,Stack.getDamageValue() - 16));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            Ext.start();
        }
        return super.useOn(context);
    }
}

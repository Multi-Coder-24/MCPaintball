package org.multicoder.mcpaintball.item.utility;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.block.MCPaintballBlocks;
import org.multicoder.mcpaintball.item.MCPaintballArmor;
import org.multicoder.mcpaintball.item.MCPaintballUtilities;

public class YellowTeamTokenItem extends Item {

    public YellowTeamTokenItem()
    {
        super(new Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand)
    {
        player.addItem(new ItemStack(MCPaintballArmor.YELLOW_BOOTS));
        player.addItem(new ItemStack(MCPaintballArmor.YELLOW_LEGGINGS));
        player.addItem(new ItemStack(MCPaintballArmor.YELLOW_CHESTPLATE));
        player.addItem(new ItemStack(MCPaintballArmor.YELLOW_HELMET));
        player.addItem(new ItemStack(MCPaintballUtilities.YELLOW_AMMO_HOPPER));
        player.addItem(new ItemStack(MCPaintballUtilities.TEAM_REMOVER_TOKEN));
        player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_REFILL_STATION.value().asItem()));
        player.getItemInHand(usedHand).shrink(1);
        return super.use(level, player, usedHand);
    }
}

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

public class CyanTeamTokenItem extends Item {

    public CyanTeamTokenItem()
    {
        super(new Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand)
    {
        player.addItem(new ItemStack(MCPaintballArmor.CYAN_BOOTS));
        player.addItem(new ItemStack(MCPaintballArmor.CYAN_LEGGINGS));
        player.addItem(new ItemStack(MCPaintballArmor.CYAN_CHESTPLATE));
        player.addItem(new ItemStack(MCPaintballArmor.CYAN_HELMET));
        player.addItem(new ItemStack(MCPaintballUtilities.CYAN_AMMO_HOPPER));
        player.addItem(new ItemStack(MCPaintballUtilities.TEAM_REMOVER_TOKEN));
        player.addItem(new ItemStack(MCPaintballBlocks.CYAN_REFILL_STATION.value().asItem()));
        player.addItem(new ItemStack(MCPaintballUtilities.STANDARD_CLASS_TOKEN));
        player.addItem(new ItemStack(MCPaintballUtilities.SNIPER_CLASS_TOKEN));
        player.addItem(new ItemStack(MCPaintballUtilities.MEDIC_CLASS_TOKEN));
        player.addItem(new ItemStack(MCPaintballUtilities.HEAVY_CLASS_TOKEN));
        player.addItem(new ItemStack(MCPaintballUtilities.ASSAULT_CLASS_TOKEN));
        player.getItemInHand(usedHand).shrink(1);
        return super.use(level, player, usedHand);
    }
}

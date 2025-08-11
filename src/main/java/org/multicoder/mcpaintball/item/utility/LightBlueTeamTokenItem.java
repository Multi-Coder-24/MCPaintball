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

public class LightBlueTeamTokenItem extends Item {

    public LightBlueTeamTokenItem()
    {
        super(new Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand)
    {
        player.addItem(new ItemStack(MCPaintballArmor.LIGHT_BLUE_BOOTS));
        player.addItem(new ItemStack(MCPaintballArmor.LIGHT_BLUE_LEGGINGS));
        player.addItem(new ItemStack(MCPaintballArmor.LIGHT_BLUE_CHESTPLATE));
        player.addItem(new ItemStack(MCPaintballArmor.LIGHT_BLUE_HELMET));
        player.addItem(new ItemStack(MCPaintballUtilities.LIGHT_BLUE_AMMO_HOPPER));
        player.addItem(new ItemStack(MCPaintballUtilities.TEAM_REMOVER_TOKEN));
        player.addItem(new ItemStack(MCPaintballBlocks.LIGHT_BLUE_REFILL_STATION.value().asItem()));
        player.addItem(new ItemStack(MCPaintballUtilities.STANDARD_CLASS_TOKEN));
        player.addItem(new ItemStack(MCPaintballUtilities.SNIPER_CLASS_TOKEN));
        player.addItem(new ItemStack(MCPaintballUtilities.MEDIC_CLASS_TOKEN));
        player.addItem(new ItemStack(MCPaintballUtilities.HEAVY_CLASS_TOKEN));
        player.addItem(new ItemStack(MCPaintballUtilities.ASSAULT_CLASS_TOKEN));
        player.getItemInHand(usedHand).shrink(1);
        return super.use(level, player, usedHand);
    }
}

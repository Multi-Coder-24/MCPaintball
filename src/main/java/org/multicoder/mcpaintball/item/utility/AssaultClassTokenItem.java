package org.multicoder.mcpaintball.item.utility;

import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.item.MCPaintballWeapons;

public class AssaultClassTokenItem extends Item {
    public AssaultClassTokenItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        ItemStack Stack = player.getItemInHand(usedHand);
        Stack.shrink(1);
        player.addItem(new ItemStack(MCPaintballWeapons.BURST_RIFLE));
        player.addItem(new ItemStack(MCPaintballWeapons.ASSAULT_RIFLE));
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(), x -> x.getItem() instanceof HeavyClassTokenItem,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(), x -> x.getItem() instanceof MedicClassTokenItem,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(), x -> x.getItem() instanceof SniperClassTokenItem,5,false);
        ContainerHelper.clearOrCountMatchingItems(player.getInventory(), x -> x.getItem() instanceof StandardClassTokenItem,5,false);
        return super.use(level, player, usedHand);
    }
}

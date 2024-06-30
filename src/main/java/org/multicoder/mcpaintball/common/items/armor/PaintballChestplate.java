package org.multicoder.mcpaintball.common.items.armor;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.common.utility.PaintballArmorMaterial;

public class PaintballChestplate extends ArmorItem {
    public PaintballChestplate(PaintballArmorMaterial material) {
        super(material, Type.CHESTPLATE, new Properties());
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        stack.setDamageValue(0);
        super.onArmorTick(stack, level, player);
    }
}

package org.multicoder.mcpaintball.common.items.weapons;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@SuppressWarnings("all")
public class PaintballBoots extends ArmorItem
{
    public PaintballBoots(ArmorMaterial material)
    {
        super(Holder.direct(material), Type.BOOTS, new Properties());
    }

    @Override
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        p_41404_.setDamageValue(0);
        super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
    }
}

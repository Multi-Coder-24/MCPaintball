package org.multicoder.mcpaintball.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.item.armor.material.MCPaintballArmorMaterial;

public class PaintballBoots extends ArmorItem
{
    public PaintballBoots(Holder<ArmorMaterial> material) {
        super(material, Type.BOOTS, new Properties().stacksTo(1));
    }
}

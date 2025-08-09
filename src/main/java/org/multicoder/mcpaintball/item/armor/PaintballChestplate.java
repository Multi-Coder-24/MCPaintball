package org.multicoder.mcpaintball.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import org.multicoder.mcpaintball.item.armor.material.MCPaintballArmorMaterial;

public class PaintballChestplate extends ArmorItem
{
    public PaintballChestplate(Holder<ArmorMaterial> material) {
        super(material, Type.CHESTPLATE, new Properties().stacksTo(1));
    }
}

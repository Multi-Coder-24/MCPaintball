package org.multicoder.mcpaintball.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import org.multicoder.mcpaintball.item.armor.material.MCPaintballArmorMaterial;

public class PaintballLeggings extends ArmorItem
{
    public PaintballLeggings(Holder<ArmorMaterial> material) {
        super(material, Type.LEGGINGS, new Properties().stacksTo(1));
    }
}

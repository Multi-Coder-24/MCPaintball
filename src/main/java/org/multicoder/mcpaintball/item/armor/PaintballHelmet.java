package org.multicoder.mcpaintball.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import org.multicoder.mcpaintball.item.armor.material.MCPaintballArmorMaterial;

public class PaintballHelmet extends ArmorItem
{
    public PaintballHelmet(Holder<ArmorMaterial> material) {
        super(material, Type.HELMET, new Properties().stacksTo(1));
    }
}

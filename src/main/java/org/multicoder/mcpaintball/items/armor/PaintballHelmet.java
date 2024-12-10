package org.multicoder.mcpaintball.items.armor;

import net.minecraft.world.item.ArmorItem;
import org.multicoder.mcpaintball.utility.PaintballArmorMaterial;

public class PaintballHelmet extends ArmorItem {
    public PaintballHelmet(PaintballArmorMaterial material) {
        super(material, Type.HELMET, new Properties());
    }
}

package org.multicoder.mcpaintball.common.items.armor;

import net.minecraft.world.item.ArmorItem;
import org.multicoder.mcpaintball.common.utility.PaintballArmorMaterial;

public class PaintballHelmet extends ArmorItem {
    public PaintballHelmet(PaintballArmorMaterial material) {
        super(material, Type.HELMET, new Properties());
    }
}

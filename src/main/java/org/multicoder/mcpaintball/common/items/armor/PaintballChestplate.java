package org.multicoder.mcpaintball.common.items.armor;

import net.minecraft.world.item.ArmorItem;
import org.multicoder.mcpaintball.common.utility.PaintballArmorMaterial;

public class PaintballChestplate extends ArmorItem {
    public PaintballChestplate(PaintballArmorMaterial material) {
        super(material, Type.CHESTPLATE, new Properties());
    }
}

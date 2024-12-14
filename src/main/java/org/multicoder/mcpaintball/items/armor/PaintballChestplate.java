package org.multicoder.mcpaintball.items.armor;

import net.minecraft.world.item.ArmorItem;
import org.multicoder.mcpaintball.utility.enums.PaintballArmorMaterial;

import static net.minecraft.world.item.ArmorItem.Type.CHESTPLATE;

public class PaintballChestplate extends ArmorItem {
    public PaintballChestplate(PaintballArmorMaterial material) {
        super(material, CHESTPLATE, new Properties());
    }
}

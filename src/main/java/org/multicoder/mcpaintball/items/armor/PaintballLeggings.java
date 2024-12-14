package org.multicoder.mcpaintball.items.armor;

import net.minecraft.world.item.ArmorItem;
import org.multicoder.mcpaintball.utility.enums.PaintballArmorMaterial;

import static net.minecraft.world.item.ArmorItem.Type.LEGGINGS;

public class PaintballLeggings extends ArmorItem {
    public PaintballLeggings(PaintballArmorMaterial material) {
        super(material, LEGGINGS, new Properties());
    }
}

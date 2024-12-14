package org.multicoder.mcpaintball.items.armor;

import net.minecraft.world.item.ArmorItem;
import org.multicoder.mcpaintball.utility.enums.PaintballArmorMaterial;

import static net.minecraft.world.item.ArmorItem.Type.BOOTS;

public class PaintballBoots extends ArmorItem {
    public PaintballBoots(PaintballArmorMaterial material) {
        super(material, BOOTS, new Properties());
    }
}

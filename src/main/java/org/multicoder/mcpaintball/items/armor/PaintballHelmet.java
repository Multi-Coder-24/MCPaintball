package org.multicoder.mcpaintball.items.armor;

import net.minecraft.world.item.ArmorItem;
import org.multicoder.mcpaintball.utility.enums.PaintballArmorMaterial;

import static net.minecraft.world.item.ArmorItem.Type.HELMET;

public class PaintballHelmet extends ArmorItem {
    public PaintballHelmet(PaintballArmorMaterial material) {
        super(material, HELMET, new Properties());
    }
}

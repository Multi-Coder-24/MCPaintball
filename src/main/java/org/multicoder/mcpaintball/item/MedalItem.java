package org.multicoder.mcpaintball.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class MedalItem extends Item {

    public MedalItem(Properties properties) {
        super(properties.stacksTo(1).rarity(Rarity.EPIC));
    }
}

package org.multicoder.mcpaintball.item.utility;

import net.minecraft.world.item.Item;
import org.multicoder.mcpaintball.data.component.ItemTeamDataComponent;
import org.multicoder.mcpaintball.data.component.MCPaintballDataComponents;

@SuppressWarnings("unused")
public class MedKitItem extends Item {
    public MedKitItem() {
        super(new Properties().component(MCPaintballDataComponents.ITEM_TEAM.value(),new ItemTeamDataComponent(0)));
    }
}

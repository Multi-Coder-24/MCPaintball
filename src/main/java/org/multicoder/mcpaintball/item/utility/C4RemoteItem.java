package org.multicoder.mcpaintball.item.utility;

import net.minecraft.world.item.Item;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.data.MCPaintballRemoteLinksDataComponent;

import java.util.ArrayList;

public class C4RemoteItem extends Item {
    public C4RemoteItem(Properties properties) {
        super(properties.component(MCPaintballDataComponents.LINK_COMPONENT.get(),new MCPaintballRemoteLinksDataComponent(new ArrayList<>())));
    }
}

package org.multicoder.mcpaintball.item.utility;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.data.MCPaintballRemoteLinksDataComponent;

import java.util.ArrayList;

public class BlueC4RemoteItem extends Item {
    public BlueC4RemoteItem() {
        super(new Properties().component(MCPaintballDataComponents.REMOTE_LINKS,new MCPaintballRemoteLinksDataComponent(new ArrayList<>())).setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"util/blue_c4_remote"))));
    }
}

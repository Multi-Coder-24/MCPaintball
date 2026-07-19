package org.multicoder.mcpaintball.core;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.data.MCPaintballRemoteLinksDataComponent;

public class MCPaintballDataComponents {

    public static final DataComponentType<MCPaintballRemoteLinksDataComponent> REMOTE_LINKS = Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"remote_links"),
            new DataComponentType.Builder<MCPaintballRemoteLinksDataComponent>().persistent(MCPaintballRemoteLinksDataComponent.CODEC).ignoreSwapAnimation().build());


    public static void Initialize() {
        MCPaintball.LOGGER.info("Initializing Data Components");
    }
}

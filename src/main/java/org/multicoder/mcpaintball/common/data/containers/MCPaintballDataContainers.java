package org.multicoder.mcpaintball.common.data.containers;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballDataContainers
{
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(MCPaintball.MOD_ID);
    public static final DeferredHolder<DataComponentType<?>,DataComponentType<C4LocationData>> C4_REMOTE = DATA_COMPONENTS.registerComponentType("c4_remote", builder -> builder.persistent(C4LocationData.CODEC));
}

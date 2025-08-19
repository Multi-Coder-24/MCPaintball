package org.multicoder.mcpaintball.init;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.data.component.ComponentCodecs;
import org.multicoder.mcpaintball.data.component.ItemClassComponent;
import org.multicoder.mcpaintball.data.component.ItemTeamDataComponent;
import org.multicoder.mcpaintball.data.component.RemoteDetonatorList;

public class MCPaintballDataComponents
{
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(MCPaintball.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>,DataComponentType<ItemTeamDataComponent>> ITEM_TEAM = COMPONENTS.registerComponentType("item_team", builder -> builder.networkSynchronized(ComponentCodecs.ITEM_TEAM_NETWORKED_CODEC).persistent(ComponentCodecs.ITEM_TEAM_CODEC));
    public static final DeferredHolder<DataComponentType<?>,DataComponentType<ItemClassComponent>> ITEM_CLASS = COMPONENTS.registerComponentType("item_class", builder -> builder.persistent(ComponentCodecs.ITEM_CLASS_CODEC).networkSynchronized(ComponentCodecs.ITEM_CLASS_NETWORKED_CODEC));
    public static final DeferredHolder<DataComponentType<?>,DataComponentType<RemoteDetonatorList>> REMOTE_DETONATOR = COMPONENTS.registerComponentType("remote_detonator", builder -> builder.persistent(ComponentCodecs.REMOTE_DETONATOR_LIST_CODEC).networkSynchronized(ComponentCodecs.REMOTE_DETONATOR_LIST_NETWORKED_CODEC));
}

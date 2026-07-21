package org.multicoder.mcpaintball.core;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.data.MCPaintballGrenadeLauncherSetting;
import org.multicoder.mcpaintball.data.MCPaintballRemoteLinksDataComponent;


public class MCPaintballDataComponents {
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MCPaintball.MODID);

    public static final DeferredHolder<DataComponentType<?>,DataComponentType<MCPaintballRemoteLinksDataComponent>> LINK_COMPONENT = COMPONENTS.register("remote_links",() -> new DataComponentType.Builder<MCPaintballRemoteLinksDataComponent>().ignoreSwapAnimation().persistent(MCPaintballRemoteLinksDataComponent.CODEC).build());
    public static final DeferredHolder<DataComponentType<?>,DataComponentType<MCPaintballGrenadeLauncherSetting>> SETTING = COMPONENTS.register("grenade_launcher_setting",() -> new DataComponentType.Builder<MCPaintballGrenadeLauncherSetting>().ignoreSwapAnimation().persistent(MCPaintballGrenadeLauncherSetting.CODEC).build());
}

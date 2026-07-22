package org.multicoder.mcpaintball.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCPaintball.MODID);

    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> WEAPONS_TAB = TABS.register("weapons_tab",() -> CreativeModeTab.builder().title(Component.translatable("text.mcpaintball.weapons_tab")).icon(() -> new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get())).build());
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> UTILITY_TAB = TABS.register("utility_tab",() -> CreativeModeTab.builder().title(Component.translatable("text.mcpaintball.utility_tab")).icon(() -> new ItemStack(MCPaintballItems.RED_HELMET.get())).build());
}

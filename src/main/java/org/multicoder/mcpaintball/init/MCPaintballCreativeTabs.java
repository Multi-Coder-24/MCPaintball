package org.multicoder.mcpaintball.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB;
import static org.multicoder.mcpaintball.MCPaintball.MOD_ID;

public class MCPaintballCreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(CREATIVE_MODE_TAB,MOD_ID);

    static
    {
        TABS.register("paintball",() -> CreativeModeTab.builder().title(Component.translatable("tab.mcpaintball.paintball")).icon(() -> new ItemStack(MCPaintballItems.RED_GRENADE.get())).displayItems(((params, output) -> MCPaintballItems.ITEMS.getEntries().forEach(object -> output.accept(object.get())))).build());
    }
}

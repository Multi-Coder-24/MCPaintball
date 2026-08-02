package org.multicoder.mcpaintball.core;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.multicoder.mcpaintball.MCPaintball;

@SuppressWarnings("unused")
public class MCPaintballCreativeTabs {
    public static final ResourceKey<CreativeModeTab> WEAPONS_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"weapons_tab"));
    public static final ResourceKey<CreativeModeTab> UTILITY_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"utility_tab"));
    public static final CreativeModeTab WEAPONS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"weapons_tab"),FabricCreativeModeTab.builder().title(Component.translatable("text.mcpaintball.weapons_tab")).icon(() -> new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.asItem())).build());
    public static final CreativeModeTab UTILITY_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"utility_tab"),FabricCreativeModeTab.builder().title(Component.translatable("text.mcpaintball.utility_tab")).icon(() -> new ItemStack(MCPaintballItems.RED_HELMET.asItem())).build());

    public static void initialize(){
        MCPaintball.LOGGER.info("Initializing CreativeModeTabs");
    }
}

package org.multicoder.mcpaintball.common.init;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.multicoder.mcpaintball.MCPaintball;

@SuppressWarnings("all")
public class tabinit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCPaintball.MOD_ID);
    public static final RegistryObject<CreativeModeTab> Weapons = TABS.register("paintball_weapons", () -> CreativeModeTab.builder().icon(() -> new ItemStack(iteminit.PAINTBALL_PISTOL.get())).title(Component.translatable("itemGroup.mcpaintball.paintball.weapons")).build());
    public static final RegistryObject<CreativeModeTab> Utility = TABS.register("paintball_utilities", () -> CreativeModeTab.builder().icon(() -> new ItemStack(iteminit.RED_REMOTE.get())).title(Component.translatable("itemGroup.mcpaintball.paintball.utilities")).build());
    public static final RegistryObject<CreativeModeTab> Armor = TABS.register("paintball_armor", () -> CreativeModeTab.builder().icon(() -> new ItemStack(iteminit.RED_BOOTS.get())).title(Component.translatable("itemGroup.mcpaintball.paintball.armor")).build());
}

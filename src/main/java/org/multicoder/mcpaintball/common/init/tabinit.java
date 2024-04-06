package org.multicoder.mcpaintball.common.init;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.multicoder.mcpaintball.MCPaintball;

@SuppressWarnings("all")
@Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class tabinit {
    public static CreativeModeTab Weapons;
    public static CreativeModeTab Utility;
    public static CreativeModeTab Armor;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        Weapons = event.registerCreativeModeTab(new ResourceLocation(MCPaintball.MOD_ID,"paintball.weapons"), builder -> builder.icon(() -> new ItemStack(iteminit.PAINTBALL_PISTOL.get())).title(Component.translatable("itemGroup.mcpaintball.paintball.weapons")).build());
        Utility = event.registerCreativeModeTab(new ResourceLocation(MCPaintball.MOD_ID,"paintball.utilities"), builder -> builder.icon(() -> new ItemStack(iteminit.RED_REMOTE.get())).title(Component.translatable("itemGroup.mcpaintball.paintball.utilities")).build());
        Armor = event.registerCreativeModeTab(new ResourceLocation(MCPaintball.MOD_ID,"paintball.armor"), builder -> builder.icon(() -> new ItemStack(iteminit.RED_BOOTS.get())).title(Component.translatable("itemGroup.mcpaintball.paintball.armor")).build());
    }
}

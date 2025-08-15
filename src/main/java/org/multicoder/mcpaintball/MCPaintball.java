package org.multicoder.mcpaintball;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.block.MCPaintballBlocks;
import org.multicoder.mcpaintball.data.component.MCPaintballDataComponents;
import org.multicoder.mcpaintball.item.*;
import org.multicoder.mcpaintball.item.armor.material.MCPaintballArmorMaterial;
import org.multicoder.mcpaintball.sounds.MCPaintballSounds;

@SuppressWarnings("unused")
@Mod(MCPaintball.MOD_ID)
public class MCPaintball {
    public static final String MOD_ID = "mcpaintball";
    public static Logger LOG = LogManager.getLogger(MOD_ID);

    public MCPaintball(IEventBus eventBus, ModContainer modContainer) {
        MCPaintballSounds.SOUNDS.register(eventBus);
        MCPaintballDataComponents.COMPONENTS.register(eventBus);
        MCPaintballWeapons.WEAPONS.register(eventBus);
        MCPaintballArmorMaterial.MATERIALS.register(eventBus);
        MCPaintballArmor.ARMORS.register(eventBus);
        MCPaintballUtilities.UTILITIES.register(eventBus);
        MCPaintballBlocks.BLOCKS.register(eventBus);
        MCPaintballBlocks.ITEMS.register(eventBus);
        eventBus.addListener(this::AppendCreativeTabs);
    }

    public void AppendCreativeTabs(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            MCPaintballWeapons.WEAPONS.getEntries().forEach(entry -> event.accept(new ItemStack(entry.value())));
            MCPaintballArmor.ARMORS.getEntries().forEach(entry -> event.accept(new ItemStack(entry.value())));
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            MCPaintballUtilities.UTILITIES.getEntries().forEach(entry -> event.accept(new ItemStack(entry.value())));
            MCPaintballBlocks.ITEMS.getEntries().forEach(entry -> event.accept(new ItemStack(entry.value())));
        }
    }
}

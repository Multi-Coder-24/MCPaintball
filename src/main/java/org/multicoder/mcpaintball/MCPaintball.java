package org.multicoder.mcpaintball;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.init.*;
import org.multicoder.mcpaintball.data.attachments.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.attachments.PlayerTeamDataAttachment;
import org.multicoder.mcpaintball.item.armor.material.MCPaintballArmorMaterial;

@SuppressWarnings("unused")
@Mod(MCPaintball.MOD_ID)
@EventBusSubscriber(modid = MCPaintball.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class MCPaintball {
    public static final String MOD_ID = "mcpaintball";
    public static Logger LOG = LogManager.getLogger(MOD_ID);

    public MCPaintball(IEventBus eventBus, ModContainer modContainer) {
        MCPaintballSounds.SOUNDS.register(eventBus);
        MCPaintballDataComponents.COMPONENTS.register(eventBus);
        MCPaintballDataAttachments.DATA_ATTACHMENTS.register(eventBus);
        MCPaintballWeapons.WEAPONS.register(eventBus);
        MCPaintballArmorMaterial.MATERIALS.register(eventBus);
        MCPaintballArmor.ARMORS.register(eventBus);
        MCPaintballUtilities.UTILITIES.register(eventBus);
        MCPaintballBlocks.BLOCKS.register(eventBus);
        MCPaintballBlocks.ITEMS.register(eventBus);
        MCPaintballExplosives.EXPLOSIVES_REGISTER.register(eventBus);
        MCPaintballEntities.PAINTBALLS.register(eventBus);
        eventBus.addListener(this::AppendCreativeTabs);
        eventBus.addListener(MCPaintballEntityRenderers::RegisterRenderers);
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
    @SubscribeEvent
    public static void PlayerJoin(PlayerEvent.PlayerLoggedInEvent event){
        event.getEntity().setData(MCPaintballDataAttachments.PLAYER_TEAM.get(),new PlayerTeamDataAttachment());
    }
}

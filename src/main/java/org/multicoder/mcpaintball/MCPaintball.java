package org.multicoder.mcpaintball;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.multicoder.mcpaintball.core.*;
import org.slf4j.Logger;

@Mod(MCPaintball.MODID)
public class MCPaintball {
    public static final String MODID = "mcpaintball";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static boolean DEBUG = false;

    public MCPaintball(IEventBus eventBus, ModContainer ignored) {
        LOGGER.info("Debug Mode Check");
        if(System.getenv().containsKey("MultiCoderDebug")){DEBUG = Boolean.parseBoolean(System.getenv("MultiCoderDebug"));if(DEBUG){LOGGER.info("Debug Mode Enabled");}}
        LOGGER.info("Initializing MCPaintball");
        LOGGER.info("Initializing Registries");
        MCPaintballDataComponents.COMPONENTS.register(eventBus);
        MCPaintballBlocks.BLOCKS.register(eventBus);
        MCPaintballItems.ITEMS.register(eventBus);
        MCPaintballEntities.ENTITIES.register(eventBus);
        MCPaintballSounds.SOUNDS.register(eventBus);
        MCPaintballParticles.PARTICLES.register(eventBus);
        MCPaintballDataAttachments.ATTACHMENTS.register(eventBus);
        MCPaintballCreativeTabs.TABS.register(eventBus);
        LOGGER.info("Initialized MCPaintball");
    }
}

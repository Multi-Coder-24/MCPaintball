package org.multicoder.mcpaintball;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.core.MCPaintballArmorMaterials;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.core.MCPaintballParticles;
import org.multicoder.mcpaintball.event.CreativeTabEvents;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

public class MCPaintball implements ModInitializer {
    public static final String MOD_ID = "mcpaintball";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing MCPaintball");
        MCPaintballItems.Initialize();
        MCPaintballEntities.Initialize();
        MCPaintballArmorMaterials.Initialize();
        MCPaintballParticles.Initialize();
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"red_paint"), MCPaintballParticles.RED_PAINT);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"green_paint"),MCPaintballParticles.GREEN_PAINT);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"blue_paint"),MCPaintballParticles.BLUE_PAINT);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(CreativeTabEvents::CombatModify);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(CreativeTabEvents::ToolModify);
        ServerLifecycleEvents.SERVER_STARTED.register(MCPaintballGameEvents::ServerStart);
        ServerPlayerEvents.JOIN.register(MCPaintballGameEvents::Join);
        CommandRegistrationCallback.EVENT.register(MCPaintballGameEvents::CommandRegister);
    }
}

package org.multicoder.mcpaintball;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.core.*;
import org.multicoder.mcpaintball.event.CreativeTabEvents;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.network.CycleGLTypeC2SPacket;
import org.multicoder.mcpaintball.network.DataSyncS2CPacket;
import org.multicoder.mcpaintball.network.PointSyncS2CPacket;

public class MCPaintball implements ModInitializer {
    public static final String MOD_ID = "mcpaintball";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static boolean DEBUG = false;
    @Override
    public void onInitialize() {
        LOGGER.info("Debug Mode Check");
        if(System.getenv().containsKey("MultiCoderDebug")){DEBUG = Boolean.parseBoolean(System.getenv("MultiCoderDebug"));if(DEBUG){LOGGER.info("Debug Mode Enabled");}}
        LOGGER.info("Initializing MCPaintball");
        LOGGER.info("Initializing Registries");
        MCPaintballDataComponents.Initialize();
        MCPaintballDataAttachments.Initialize();
        MCPaintballBlocks.Initialize();
        MCPaintballItems.Initialize();
        MCPaintballEntities.Initialize();
        MCPaintballArmorMaterials.Initialize();
        MCPaintballParticles.Initialize();
        MCPaintballSounds.Initialize();
        MCPaintballCreativeTabs.Initialize();
        LOGGER.info("Initializing Particles");
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"red_paint"), MCPaintballParticles.RED_PAINT);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"green_paint"),MCPaintballParticles.GREEN_PAINT);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"blue_paint"),MCPaintballParticles.BLUE_PAINT);
        LOGGER.info("Initializing Creative Tab Events");
        CreativeModeTabEvents.modifyOutputEvent(MCPaintballCreativeTabs.WEAPONS_TAB_KEY).register(CreativeTabEvents::WeaponsInit);
        CreativeModeTabEvents.modifyOutputEvent(MCPaintballCreativeTabs.UTILITY_TAB_KEY).register(CreativeTabEvents::UtilityInit);
        LOGGER.info("Initializing Server Events");
        ServerLifecycleEvents.SERVER_STARTED.register(MCPaintballGameEvents::ServerStart);
        ServerPlayerEvents.JOIN.register(MCPaintballGameEvents::Join);
        LOGGER.info("Initializing Command Events");
        CommandRegistrationCallback.EVENT.register(MCPaintballGameEvents::CommandRegister);
        LOGGER.info("Initializing Networking");
        PayloadTypeRegistry.clientboundPlay().register(PointSyncS2CPacket.TYPE,PointSyncS2CPacket.STREAM_CODEC);
        PayloadTypeRegistry.clientboundPlay().register(DataSyncS2CPacket.TYPE,DataSyncS2CPacket.STREAM_CODEC);
        PayloadTypeRegistry.serverboundPlay().register(CycleGLTypeC2SPacket.TYPE,CycleGLTypeC2SPacket.STREAM_CODEC);
        ServerPlayNetworking.registerGlobalReceiver(CycleGLTypeC2SPacket.TYPE,CycleGLTypeC2SPacket::HandlePacket);
        LOGGER.info("Initialized MCPaintball");
    }
}

package org.multicoder.mcpaintball;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.world.item.CreativeModeTabs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.core.*;
import org.multicoder.mcpaintball.event.CreativeTabEvents;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.network.ClientToServer.*;
import org.multicoder.mcpaintball.network.ServerToClient.*;

public class MCPaintball implements ModInitializer {
    public static final String MOD_ID = "mcpaintball";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("Initialization Started For MCPaintball");
        LOGGER.info("Initializing Registries");
        MCPaintballKeybinding.initialize();
        MCPaintballDataComponents.initialize();
        MCPaintballDataAttachments.initialize();
        MCPaintballBlocks.initialize();
        MCPaintballBlockEntities.initialize();
        MCPaintballItems.initialize();
        MCPaintballEntities.initialize();
        MCPaintballArmorMaterials.initialize();
        MCPaintballParticles.initialize();
        MCPaintballSounds.initialize();
        MCPaintballCreativeTabs.initialize();
        MCPaintballStats.Initialize();
        LOGGER.info("Initializing Creative Tab Events");
        CreativeModeTabEvents.modifyOutputEvent(MCPaintballCreativeTabs.WEAPONS_TAB_KEY).register(CreativeTabEvents::weaponsInit);
        CreativeModeTabEvents.modifyOutputEvent(MCPaintballCreativeTabs.UTILITY_TAB_KEY).register(CreativeTabEvents::utilityInit);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.OP_BLOCKS).register(CreativeTabEvents::moderator);
        LOGGER.info("Initializing Server Events");
        ServerLifecycleEvents.SERVER_STARTED.register(MCPaintballGameEvents::serverStart);
        ServerPlayerEvents.JOIN.register(MCPaintballGameEvents::join);
        LOGGER.info("Initializing Network Packets");
        PayloadTypeRegistry.clientboundPlay().register(SaveDataSyncS2CPacket.TYPE, SaveDataSyncS2CPacket.STREAM_CODEC);
        PayloadTypeRegistry.clientboundPlay().register(DataSyncS2CPacket.TYPE,DataSyncS2CPacket.STREAM_CODEC);
        PayloadTypeRegistry.serverboundPlay().register(CycleGLTypeC2SPacket.TYPE,CycleGLTypeC2SPacket.STREAM_CODEC);
        PayloadTypeRegistry.serverboundPlay().register(TeamSelectC2SPacket.TYPE,TeamSelectC2SPacket.STREAM_CODEC);
        PayloadTypeRegistry.serverboundPlay().register(RoleSelectC2SPacket.TYPE,RoleSelectC2SPacket.STREAM_CODEC);
        PayloadTypeRegistry.serverboundPlay().register(AdminCommandC2SPacket.TYPE,AdminCommandC2SPacket.STREAM_CODEC);
        PayloadTypeRegistry.serverboundPlay().register(GiveKitC2SPacket.TYPE, GiveKitC2SPacket.STREAM_CODEC);
        LOGGER.info("Initializing Network Packet Handlers");
        ServerPlayNetworking.registerGlobalReceiver(CycleGLTypeC2SPacket.TYPE,CycleGLTypeC2SPacket::handlePacket);
        ServerPlayNetworking.registerGlobalReceiver(TeamSelectC2SPacket.TYPE,TeamSelectC2SPacket::handlePacket);
        ServerPlayNetworking.registerGlobalReceiver(RoleSelectC2SPacket.TYPE,RoleSelectC2SPacket::handlePacket);
        ServerPlayNetworking.registerGlobalReceiver(AdminCommandC2SPacket.TYPE,AdminCommandC2SPacket::handlePacket);
        ServerPlayNetworking.registerGlobalReceiver(GiveKitC2SPacket.TYPE,GiveKitC2SPacket::handlePacket);
        LOGGER.info("Initialization Complete For MCPaintball");
    }
}

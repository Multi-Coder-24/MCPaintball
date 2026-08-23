package org.multicoder.mcpaintball.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.core.EntityRenderersRegistry;
import org.multicoder.mcpaintball.client.core.ParticleRegistry;
import org.multicoder.mcpaintball.client.renderer.PaintballDataOverlay;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.network.ServerToClient.DataSyncS2CPacket;
import org.multicoder.mcpaintball.network.ServerToClient.SaveDataSyncS2CPacket;

import java.util.List;

import static org.multicoder.mcpaintball.MCPaintball.MOD_ID;


public class MCPaintballClient implements ClientModInitializer {
    public static final Logger CLIENT_LOGGER = LogManager.getLogger(MOD_ID + "_client");
    public static int redPoints = 0;
    public static int greenPoints = 0;
    public static int bluePoints = 0;
    public static int yellowPoints = 0;
    public static int pinkPoints = 0;
    public static int orangePoints = 0;
    public static int RedWins = 0;
    public static int GreenWins = 0;
    public static int BlueWins = 0;
    public static int YellowWins = 0;
    public static int PinkWins = 0;
    public static int OrangeWins = 0;
    public static boolean tournamentRunning = false;
    public static boolean roundRunning = false;
    public static List<BlockPos> capture_points;
    @Override
    public void onInitializeClient() {
        CLIENT_LOGGER.info("Initializing MCPaintball Client");
        EntityRenderersRegistry.Initialize();
        ParticleRegistry.Initialize();
        CLIENT_LOGGER.info("Initializing Packet Handlers");
        ClientPlayNetworking.registerGlobalReceiver(SaveDataSyncS2CPacket.TYPE, SaveDataSyncS2CPacket::handlePacket);
        ClientPlayNetworking.registerGlobalReceiver(DataSyncS2CPacket.TYPE,DataSyncS2CPacket::handlePacket);
        CLIENT_LOGGER.info("Registering Overlay");
        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"overlay"), new PaintballDataOverlay());
        ClientTickEvents.END_CLIENT_TICK.register(MCPaintballGameEvents::clientEndTick);
        CLIENT_LOGGER.info("Initialized MCPaintball Client");
    }
}

package org.multicoder.mcpaintball.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.particle.GlowParticle;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.renderer.PaintballDataOverlay;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballParticles;
import org.multicoder.mcpaintball.entity.renderer.*;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.network.DataSyncS2CPacket;
import org.multicoder.mcpaintball.network.PointSyncS2CPacket;

import static org.multicoder.mcpaintball.MCPaintball.MOD_ID;

public class MCPaintballClient implements ClientModInitializer {
    public static final Logger CLIENT_LOGGER = LogManager.getLogger(MOD_ID + "_client");
    public static int RedPoints = 0;
    public static int GreenPoints = 0;
    public static int BluePoints = 0;
    public static int YellowPoints = 0;
    public static boolean GameRunning = false;
    public static boolean RoundRunning = false;
    @Override
    public void onInitializeClient() {
        CLIENT_LOGGER.info("Initializing MCPaintball Client");
        CLIENT_LOGGER.info("Initializing EntityRenderers");
        EntityRenderers.register(MCPaintballEntities.RED_PAINTBALL,RedPaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.GREEN_PAINTBALL, GreenPaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.BLUE_PAINTBALL, BluePaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.YELLOW_PAINTBALL, YellowPaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.RED_PAINT_GRENADE, RedPaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.GREEN_PAINT_GRENADE, GreenPaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.BLUE_PAINT_GRENADE, BluePaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.YELLOW_PAINT_GRENADE, YellowPaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.SMOKE_GRENADE, SmokeGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.EMP_GRENADE, EMPGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.SIGHT_GRENADE, SightGrenadeEntityRenderer::new);
        CLIENT_LOGGER.info("Initializing Client Particles");
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.RED_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.GREEN_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.BLUE_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.YELLOW_PAINT, GlowParticle.ElectricSparkProvider::new);
        CLIENT_LOGGER.info("Initializing Packet Handlers");
        ClientPlayNetworking.registerGlobalReceiver(PointSyncS2CPacket.TYPE,PointSyncS2CPacket::HandlePacket);
        ClientPlayNetworking.registerGlobalReceiver(DataSyncS2CPacket.TYPE,DataSyncS2CPacket::HandlePacket);
        CLIENT_LOGGER.info("Registering Overlay");
        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"overlay"), new PaintballDataOverlay());

        ClientTickEvents.END_CLIENT_TICK.register(MCPaintballGameEvents::ClientEndTick);
        CLIENT_LOGGER.info("Initialized MCPaintball Client");
    }
}

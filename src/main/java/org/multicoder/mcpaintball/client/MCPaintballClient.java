package org.multicoder.mcpaintball.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.GlowParticle;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballParticles;
import org.multicoder.mcpaintball.entity.renderer.*;

import static org.multicoder.mcpaintball.MCPaintball.MOD_ID;

public class MCPaintballClient implements ClientModInitializer {
    public static final Logger CLIENT_LOGGER = LogManager.getLogger(MOD_ID + "_client");
    @Override
    public void onInitializeClient() {
        CLIENT_LOGGER.info("Initializing MCPaintball Client");
        CLIENT_LOGGER.info("Registering EntityRenderers");
        EntityRenderers.register(MCPaintballEntities.RED_PAINTBALL,RedPaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.GREEN_PAINTBALL, GreenPaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.BLUE_PAINTBALL, BluePaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.RED_PAINT_GRENADE, RedPaintGrenadeRenderer::new);
        EntityRenderers.register(MCPaintballEntities.GREEN_PAINT_GRENADE, ThrownItemRenderer::new);
        EntityRenderers.register(MCPaintballEntities.BLUE_PAINT_GRENADE, ThrownItemRenderer::new);
        CLIENT_LOGGER.info("Registering Particles");
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.RED_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.GREEN_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.BLUE_PAINT, GlowParticle.ElectricSparkProvider::new);
    }
}

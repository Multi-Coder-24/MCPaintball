package org.multicoder.mcpaintball.client.core;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.GlowParticle;
import org.multicoder.mcpaintball.client.MCPaintballClient;
import org.multicoder.mcpaintball.core.MCPaintballParticles;

public class ParticleRegistry {
    public static void Initialize() {
        MCPaintballClient.CLIENT_LOGGER.info("Initializing Client Particles");
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.RED_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.GREEN_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.BLUE_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.YELLOW_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.PINK_PAINT, GlowParticle.ElectricSparkProvider::new);
        ParticleProviderRegistry.getInstance().register(MCPaintballParticles.ORANGE_PAINT, GlowParticle.ElectricSparkProvider::new);
    }
}

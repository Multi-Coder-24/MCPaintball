package org.multicoder.mcpaintball.core;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballParticles {
    public static final SimpleParticleType RED_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType GREEN_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType BLUE_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType YELLOW_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType PINK_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType ORANGE_PAINT = FabricParticleTypes.simple(true);
    public static void Initialize() {
        MCPaintball.LOGGER.debug("Initializing Particles");
    }
}

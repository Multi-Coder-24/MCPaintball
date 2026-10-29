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
    public static final SimpleParticleType CYAN_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType MAGENTA_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType LIME_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType LIGHT_BLUE_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType LIGHT_GRAY_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType GRAY_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType WHITE_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType BLACK_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType BROWN_PAINT = FabricParticleTypes.simple(true);
    public static final SimpleParticleType PURPLE_PAINT = FabricParticleTypes.simple(true);
    public static void initialize() {
        MCPaintball.LOGGER.debug("Initializing Particles");
    }
}

package org.multicoder.mcpaintball.core;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballParticles {
    public static final SimpleParticleType RED_PAINT = register(FabricParticleTypes.simple(true),"red_paint");
    public static final SimpleParticleType GREEN_PAINT = register(FabricParticleTypes.simple(true),"green_paint");
    public static final SimpleParticleType BLUE_PAINT = register(FabricParticleTypes.simple(true),"blue_paint");
    public static final SimpleParticleType YELLOW_PAINT = register(FabricParticleTypes.simple(true),"yellow_paint");
    public static final SimpleParticleType PINK_PAINT = register(FabricParticleTypes.simple(true),"pink_paint");
    public static final SimpleParticleType ORANGE_PAINT = register(FabricParticleTypes.simple(true),"orange_paint");

    public static SimpleParticleType register(SimpleParticleType type,String name){
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,name),type);
        return type;
    }

    public static void initialize() {
        MCPaintball.LOGGER.debug("Initializing Particles");
    }
}

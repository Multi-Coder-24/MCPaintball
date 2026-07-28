package org.multicoder.mcpaintball.core;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

import java.util.function.Supplier;

public class MCPaintballParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, MCPaintball.MODID);
    public static final Supplier<SimpleParticleType> RED_PAINT = PARTICLES.register("red_paint", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> GREEN_PAINT = PARTICLES.register("green_paint", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> BLUE_PAINT = PARTICLES.register("blue_paint", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> YELLOW_PAINT = PARTICLES.register("yellow_paint", () -> new SimpleParticleType(true));
}

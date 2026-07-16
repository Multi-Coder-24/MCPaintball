package org.multicoder.mcpaintball.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class RedPaintParticle extends SingleQuadParticle{

    public RedPaintParticle(ClientLevel level, double x, double y, double z, double xa, double ya, double za,SpriteSet spriteSet) {
        super(level, x, y, z, xa, ya, za,spriteSet.first());
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    protected @NonNull Layer getLayer() {
        return Layer.TRANSLUCENT;
    }
    public static class Provider implements ParticleProvider<SimpleParticleType>{
        private final SpriteSet spriteSet;
        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public @Nullable Particle createParticle(@NonNull SimpleParticleType simpleParticleType, @NonNull ClientLevel clientLevel, double v, double v1, double v2, double v3, double v4, double v5, @NonNull RandomSource randomSource) {
            return new RedPaintParticle(clientLevel,v,v1,v2,v3,v4,v5,spriteSet);
        }
    }
}

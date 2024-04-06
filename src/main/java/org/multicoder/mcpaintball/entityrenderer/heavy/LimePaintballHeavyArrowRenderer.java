package org.multicoder.mcpaintball.entityrenderer.heavy;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.heavy.BluePaintballHeavyArrowEntity;
import org.multicoder.mcpaintball.entity.heavy.LimePaintballHeavyArrowEntity;

@OnlyIn(Dist.CLIENT)
public class LimePaintballHeavyArrowRenderer extends ArrowRenderer<LimePaintballHeavyArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/lime_paintball_heavy.png");

    public LimePaintballHeavyArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(LimePaintballHeavyArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}

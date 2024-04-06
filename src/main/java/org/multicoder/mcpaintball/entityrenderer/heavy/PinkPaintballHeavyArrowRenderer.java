package org.multicoder.mcpaintball.entityrenderer.heavy;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.heavy.PinkPaintballHeavyArrowEntity;

@OnlyIn(Dist.CLIENT)
public class PinkPaintballHeavyArrowRenderer extends ArrowRenderer<PinkPaintballHeavyArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/pink_paintball_heavy.png");

    public PinkPaintballHeavyArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(PinkPaintballHeavyArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}

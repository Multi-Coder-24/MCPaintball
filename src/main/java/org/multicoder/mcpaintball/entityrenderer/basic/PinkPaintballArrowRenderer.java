package org.multicoder.mcpaintball.entityrenderer.basic;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.base.BluePaintballArrowEntity;
import org.multicoder.mcpaintball.entity.base.PinkPaintballArrowEntity;

@OnlyIn(Dist.CLIENT)
public class PinkPaintballArrowRenderer extends ArrowRenderer<PinkPaintballArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/pink_paintball.png");

    public PinkPaintballArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(PinkPaintballArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}

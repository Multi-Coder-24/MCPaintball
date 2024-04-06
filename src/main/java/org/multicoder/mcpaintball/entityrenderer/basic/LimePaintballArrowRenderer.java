package org.multicoder.mcpaintball.entityrenderer.basic;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.base.BluePaintballArrowEntity;
import org.multicoder.mcpaintball.entity.base.LimePaintballArrowEntity;

@OnlyIn(Dist.CLIENT)
public class LimePaintballArrowRenderer extends ArrowRenderer<LimePaintballArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/lime_paintball.png");

    public LimePaintballArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(LimePaintballArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}

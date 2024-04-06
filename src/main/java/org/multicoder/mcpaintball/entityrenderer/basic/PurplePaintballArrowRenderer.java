package org.multicoder.mcpaintball.entityrenderer.basic;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.base.BluePaintballArrowEntity;
import org.multicoder.mcpaintball.entity.base.PurplePaintballArrowEntity;

@OnlyIn(Dist.CLIENT)
public class PurplePaintballArrowRenderer extends ArrowRenderer<PurplePaintballArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/purple_paintball.png");

    public PurplePaintballArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(PurplePaintballArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}

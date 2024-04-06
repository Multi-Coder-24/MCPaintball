package org.multicoder.mcpaintball.entityrenderer.basic;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.base.BluePaintballArrowEntity;
import org.multicoder.mcpaintball.entity.base.LightBluePaintballArrowEntity;

@OnlyIn(Dist.CLIENT)
public class LightBluePaintballArrowRenderer extends ArrowRenderer<LightBluePaintballArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/light_blue_paintball.png");

    public LightBluePaintballArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(LightBluePaintballArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}

package org.multicoder.mcpaintball.entityrenderer.heavy;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.heavy.BluePaintballHeavyArrowEntity;
import org.multicoder.mcpaintball.entity.heavy.LightBluePaintballHeavyArrowEntity;

@OnlyIn(Dist.CLIENT)
public class LightBluePaintballHeavyArrowRenderer extends ArrowRenderer<LightBluePaintballHeavyArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/light_blue_paintball_heavy.png");

    public LightBluePaintballHeavyArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(LightBluePaintballHeavyArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}

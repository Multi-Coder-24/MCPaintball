package org.multicoder.mcpaintball.entityrenderer.heavy;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.entity.heavy.BluePaintballHeavyArrowEntity;
import org.multicoder.mcpaintball.entity.heavy.PurplePaintballHeavyArrowEntity;

@OnlyIn(Dist.CLIENT)
public class PurplePaintballHeavyArrowRenderer extends ArrowRenderer<PurplePaintballHeavyArrowEntity>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/purple_paintball_heavy.png");

    public PurplePaintballHeavyArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(PurplePaintballHeavyArrowEntity p_114482_)
    {
        return TEXTURE;
    }
}

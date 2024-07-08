package org.multicoder.mcpaintball.common.entityrenderers.paintball;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.multicoder.mcpaintball.common.entity.paintball.GrayHeavyPaintballEntity;

@SuppressWarnings("all")
public class GrayHeavyPaintballRenderer extends ArrowRenderer<GrayHeavyPaintballEntity> {
    public static final ResourceLocation G = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball_heavy/gray_paintball_heavy.png");

    public GrayHeavyPaintballRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    @Override
    public ResourceLocation getTextureLocation(GrayHeavyPaintballEntity entity)
    {
        return G;
    }
}

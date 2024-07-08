package org.multicoder.mcpaintball.common.entityrenderers.paintball;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.multicoder.mcpaintball.common.entity.paintball.GrayPaintballEntity;

@SuppressWarnings("all")
public class GrayPaintballEntityRenderer extends ArrowRenderer<GrayPaintballEntity> {
    public static final ResourceLocation G = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/gray_paintball.png");

    public GrayPaintballEntityRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    @Override
    public ResourceLocation getTextureLocation(GrayPaintballEntity entity) {
        return G;
    }
}

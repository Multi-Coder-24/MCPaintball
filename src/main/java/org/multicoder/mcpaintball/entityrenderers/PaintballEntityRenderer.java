package org.multicoder.mcpaintball.entityrenderers;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.init.MCPaintballEntities;
import org.multicoder.mcpaintball.entity.paintball.PaintballEntity;


public class PaintballEntityRenderer extends ArrowRenderer<PaintballEntity> {
    public static final ResourceLocation R = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/red_paintball.png");
    public static final ResourceLocation G = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/green_paintball.png");
    public static final ResourceLocation B = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/blue_paintball.png");

    public PaintballEntityRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(PaintballEntity entity) {
        if (entity.getType().equals(MCPaintballEntities.RED_PAINTBALL.get())) {
            return R;
        } else if (entity.getType().equals(MCPaintballEntities.GREEN_PAINTBALL.get())) {
            return G;
        } else if (entity.getType().equals(MCPaintballEntities.BLUE_PAINTBALL.get())) {
            return B;
        } else {
            return R;
        }
    }
}

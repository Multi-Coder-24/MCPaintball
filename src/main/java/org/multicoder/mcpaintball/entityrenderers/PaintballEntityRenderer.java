package org.multicoder.mcpaintball.entityrenderers;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.entity.paintball.PaintballEntity;

import static org.multicoder.mcpaintball.init.MCPaintballEntities.*;


public class PaintballEntityRenderer extends ArrowRenderer<PaintballEntity> {
    public static final ResourceLocation R = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/red_paintball.png");
    public static final ResourceLocation G = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/green_paintball.png");
    public static final ResourceLocation B = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/blue_paintball.png");

    public PaintballEntityRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(PaintballEntity entity) {
        if (entity.getType().equals(RED_PAINTBALL.get())) {
            return R;
        } else if (entity.getType().equals(GREEN_PAINTBALL.get())) {
            return G;
        } else if (entity.getType().equals(BLUE_PAINTBALL.get())) {
            return B;
        } else {
            return R;
        }
    }
}

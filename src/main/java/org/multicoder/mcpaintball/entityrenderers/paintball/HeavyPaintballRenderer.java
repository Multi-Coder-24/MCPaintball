package org.multicoder.mcpaintball.entityrenderers.paintball;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.init.MCPaintballEntities;
import org.multicoder.mcpaintball.entity.paintball.HeavyPaintballEntity;


public class HeavyPaintballRenderer extends ArrowRenderer<HeavyPaintballEntity> {
    public static final ResourceLocation R = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball_heavy/red_paintball_heavy.png");
    public static final ResourceLocation G = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball_heavy/green_paintball_heavy.png");
    public static final ResourceLocation B = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball_heavy/blue_paintball_heavy.png");

    public HeavyPaintballRenderer(EntityRendererProvider.Context p_173917_) {
        super(p_173917_);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(HeavyPaintballEntity entity) {
        if (entity.getType().equals(MCPaintballEntities.RED_HEAVY_PAINTBALL.get())) {
            return R;
        } else if (entity.getType().equals(MCPaintballEntities.GREEN_HEAVY_PAINTBALL.get())) {
            return G;
        } else if (entity.getType().equals(MCPaintballEntities.BLUE_HEAVY_PAINTBALL.get())) {
            return B;
        } else {
            return R;
        }
    }
}

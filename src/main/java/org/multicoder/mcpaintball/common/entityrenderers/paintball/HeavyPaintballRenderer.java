package org.multicoder.mcpaintball.common.entityrenderers.paintball;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;
import org.multicoder.mcpaintball.common.entity.paintball.HeavyPaintballEntity;

public class HeavyPaintballRenderer extends ArrowRenderer<HeavyPaintballEntity>
{
    public static final ResourceLocation R = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball_heavy/red_paintball_heavy.png");
    public static final ResourceLocation G = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball_heavy/green_paintball_heavy.png");
    public static final ResourceLocation B = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball_heavy/blue_paintball_heavy.png");

    public HeavyPaintballRenderer(EntityRendererProvider.Context p_173917_)
    {
        super(p_173917_);
    }

    @Override
    public ResourceLocation getTextureLocation(HeavyPaintballEntity entity)
    {
        if(entity.getType().equals(MCPaintballEntities.RED_HEAVY_PAINTBALL.get())){
            return R;
        } else if (entity.getType().equals(MCPaintballEntities.GREEN_HEAVY_PAINTBALL.get())) {
            return G;
        }else if (entity.getType().equals(MCPaintballEntities.BLUE_HEAVY_PAINTBALL.get())) {
            return B;
        }else{
            return null;
        }
    }
}

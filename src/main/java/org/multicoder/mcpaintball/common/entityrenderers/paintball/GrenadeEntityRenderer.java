package org.multicoder.mcpaintball.common.entityrenderers.paintball;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;

@SuppressWarnings("all")
public class GrenadeEntityRenderer extends ThrownItemRenderer
{
    public static final ResourceLocation RED = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/grenades/red_grenade.png");
    public static final ResourceLocation GREEN = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/grenades/green_grenade.png");
    public static final ResourceLocation BLUE = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/grenades/blue_grenade.png");

    public GrenadeEntityRenderer(EntityRendererProvider.Context p_174416_)
    {
        super(p_174416_);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_116083_)
    {
        if(p_116083_.getType().equals(MCPaintballEntities.RED_GRENADE.value()))
        {
            return RED;
        } else if (p_116083_.getType().equals(MCPaintballEntities.GREEN_GRENADE.value()))
        {
            return GREEN;
        } else if (p_116083_.getType().equals(MCPaintballEntities.BLUE_GRENADE.value()))
        {
            return BLUE;
        }
        return super.getTextureLocation(p_116083_);
    }
}

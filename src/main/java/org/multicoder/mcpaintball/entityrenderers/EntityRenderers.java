package org.multicoder.mcpaintball.entityrenderers;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.multicoder.mcpaintball.init.MCPaintballEntities;

public class EntityRenderers
{
    public static void RegisterRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(MCPaintballEntities.RED_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer(MCPaintballEntities.GREEN_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer(MCPaintballEntities.BLUE_PAINTBALL.get(), PaintballEntityRenderer::new);

        event.registerEntityRenderer(MCPaintballEntities.RED_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(MCPaintballEntities.GREEN_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(MCPaintballEntities.BLUE_GRENADE.get(), ThrownItemRenderer::new);

    }
}

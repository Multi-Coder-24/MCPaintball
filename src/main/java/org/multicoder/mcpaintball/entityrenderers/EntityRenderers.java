package org.multicoder.mcpaintball.entityrenderers;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import static org.multicoder.mcpaintball.init.MCPaintballEntities.*;

public class EntityRenderers
{
    public static void RegisterRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(RED_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer(GREEN_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer(BLUE_PAINTBALL.get(), PaintballEntityRenderer::new);

        event.registerEntityRenderer(RED_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(GREEN_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(BLUE_GRENADE.get(), ThrownItemRenderer::new);

    }
}

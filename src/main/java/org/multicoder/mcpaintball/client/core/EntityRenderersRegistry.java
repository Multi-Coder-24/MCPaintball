package org.multicoder.mcpaintball.client.core;

import net.minecraft.client.renderer.entity.EntityRenderers;
import org.multicoder.mcpaintball.client.MCPaintballClient;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.entity.renderer.*;

public class EntityRenderersRegistry {
    public static void Initialize() {
        MCPaintballClient.CLIENT_LOGGER.info("Registering EntityRenderers");
        EntityRenderers.register(MCPaintballEntities.RED_PAINTBALL, PaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.GREEN_PAINTBALL, PaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.BLUE_PAINTBALL, PaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.YELLOW_PAINTBALL, PaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.PINK_PAINTBALL, PaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.ORANGE_PAINTBALL, PaintballEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.RED_PAINT_GRENADE, PaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.GREEN_PAINT_GRENADE, PaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.BLUE_PAINT_GRENADE, PaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.YELLOW_PAINT_GRENADE, PaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.PINK_PAINT_GRENADE, PaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.ORANGE_PAINT_GRENADE, PaintGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.SMOKE_GRENADE, SmokeGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.EMP_GRENADE, EMPGrenadeEntityRenderer::new);
        EntityRenderers.register(MCPaintballEntities.SIGHT_GRENADE, SightGrenadeEntityRenderer::new);

    }
}

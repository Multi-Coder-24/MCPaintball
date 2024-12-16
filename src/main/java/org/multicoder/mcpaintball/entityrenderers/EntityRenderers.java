package org.multicoder.mcpaintball.entityrenderers;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.multicoder.mcpaintball.entity.paintball.PaintballEntity;

import static org.multicoder.mcpaintball.init.MCPaintballEntities.*;

public class EntityRenderers
{
    @SuppressWarnings("all")
    public static void RegisterRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer((EntityType<PaintballEntity>) RED_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) GREEN_PAINTBALL.get(), PaintballEntityRenderer::new);
        event.registerEntityRenderer((EntityType<PaintballEntity>) BLUE_PAINTBALL.get(), PaintballEntityRenderer::new);

        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) RED_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>)GREEN_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>)BLUE_GRENADE.get(), ThrownItemRenderer::new);

    }
}

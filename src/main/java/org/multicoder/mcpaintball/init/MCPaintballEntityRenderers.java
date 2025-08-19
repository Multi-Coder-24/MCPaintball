package org.multicoder.mcpaintball.init;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@SuppressWarnings("all")
public class MCPaintballEntityRenderers {
    public static void RegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.RED_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.GREEN_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.BLUE_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.CYAN_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.MAGENTA_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.YELLOW_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.LIME_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.LIGHT_BLUE_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.PINK_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.WHITE_PAINT_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer((EntityType<? extends ThrowableItemProjectile>) MCPaintballExplosives.EMP_GRENADE.get(), ThrownItemRenderer::new);
    }
}

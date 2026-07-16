package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.BluePaintballEntity;

public class BluePaintballEntityRenderer extends ArrowRenderer<BluePaintballEntity,ArrowRenderState> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"textures/entity/projectiles/blue_paintball.png");
    public BluePaintballEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected @NonNull Identifier getTextureLocation(@NonNull ArrowRenderState state) {
        return TEXTURE;
    }

    @Override
    public @NonNull ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}

package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.YellowPaintballEntity;

public class YellowPaintballEntityRenderer extends ArrowRenderer<YellowPaintballEntity,ArrowRenderState> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/yellow_paintball.png");
    public YellowPaintballEntityRenderer(EntityRendererProvider.Context context) {
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

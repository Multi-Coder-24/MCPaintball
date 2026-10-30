package org.multicoder.mcpaintball.entity.renderer.paintball;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.entity.PaintballEntity;

public class MagentaPaintballEntityRenderer extends ArrowRenderer<PaintballEntity,ArrowRenderState> {
    public static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/magenta_paintball.png");
    public MagentaPaintballEntityRenderer(EntityRendererProvider.Context context) {
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

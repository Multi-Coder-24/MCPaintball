package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.entity.PaintballEntity;

public class PaintballEntityRenderer extends ArrowRenderer<PaintballEntity,ArrowRenderState> {
    public static final Identifier RED = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"textures/entity/projectiles/red_paintball.png");
    public static final Identifier GREEN = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"textures/entity/projectiles/green_paintball.png");
    public static final Identifier BLUE = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"textures/entity/projectiles/blue_paintball.png");
    public static final Identifier YELLOW = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"textures/entity/projectiles/yellow_paintball.png");
    public PaintballEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected @NonNull Identifier getTextureLocation(@NonNull ArrowRenderState state) {
        EntityType<?> type = state.entityType;
        if(type == MCPaintballEntities.RED_PAINTBALL.get()){
            return RED;
        }else if(type == MCPaintballEntities.GREEN_PAINTBALL.get()){
            return GREEN;
        }else if(type == MCPaintballEntities.BLUE_PAINTBALL.get()){
            return BLUE;
        }else if(type == MCPaintballEntities.YELLOW_PAINTBALL.get()){
            return YELLOW;
        }
        return RED;
    }

    @Override
    public @NonNull ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}

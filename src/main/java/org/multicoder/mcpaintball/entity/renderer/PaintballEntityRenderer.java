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
    public static final Identifier RED = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/red_paintball.png");
    public static final Identifier GREEN = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/green_paintball.png");
    public static final Identifier BLUE = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/blue_paintball.png");
    public static final Identifier CYAN = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/cyan_paintball.png");
    public static final Identifier MAGENTA = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/magenta_paintball.png");
    public static final Identifier YELLOW = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/yellow_paintball.png");
    public static final Identifier ORANGE = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/orange_paintball.png");
    public static final Identifier WHITE = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/white_paintball.png");
    public static final Identifier BLACK = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/entity/projectiles/black_paintball.png");
    public PaintballEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected @NonNull Identifier getTextureLocation(@NonNull ArrowRenderState state) {
        EntityType<?> type = state.entityType;
        if(type == MCPaintballEntities.RED_PAINTBALL){
            return RED;
        }else if(type == MCPaintballEntities.GREEN_PAINTBALL){
            return GREEN;
        }else if(type == MCPaintballEntities.BLUE_PAINTBALL){
            return BLUE;
        }else if(type == MCPaintballEntities.CYAN_PAINTBALL){
            return CYAN;
        }else if(type == MCPaintballEntities.MAGENTA_PAINTBALL){
            return MAGENTA;
        }else if(type == MCPaintballEntities.YELLOW_PAINTBALL){
            return YELLOW;
        }else if(type == MCPaintballEntities.ORANGE_PAINTBALL){
            return ORANGE;
        }else if(type == MCPaintballEntities.WHITE_PAINTBALL){
            return WHITE;
        }else if(type == MCPaintballEntities.BLACK_PAINTBALL){
            return BLACK;
        }
        return RED;
    }

    @Override
    public @NonNull ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}

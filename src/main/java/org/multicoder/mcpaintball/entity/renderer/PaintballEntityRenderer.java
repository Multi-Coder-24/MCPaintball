package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.entity.PaintballEntity;
import static org.multicoder.mcpaintball.init.MCPaintballEntities.*;

public class PaintballEntityRenderer extends ArrowRenderer<PaintballEntity>
{
    public static final ResourceLocation RED = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/red_paintball.png");
    public static final ResourceLocation GREEN = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/green_paintball.png");
    public static final ResourceLocation BLUE = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/blue_paintball.png");
    public static final ResourceLocation CYAN = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/blue_paintball.png");
    public static final ResourceLocation MAGENTA = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/blue_paintball.png");
    public static final ResourceLocation YELLOW = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/blue_paintball.png");
    public static final ResourceLocation LIME = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/blue_paintball.png");
    public static final ResourceLocation LIGHT_BLUE = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/blue_paintball.png");
    public static final ResourceLocation PINK = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/blue_paintball.png");
    public static final ResourceLocation WHITE = ResourceLocation.fromNamespaceAndPath("mcpaintball","textures/entity/projectiles/paintball/blue_paintball.png");
    public PaintballEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(PaintballEntity paintballEntity)
    {
        if(paintballEntity.getType() == RED_PAINTBALL.get()){
            return RED;
        }
        if(paintballEntity.getType() == GREEN_PAINTBALL.get()){
            return GREEN;
        }
        if(paintballEntity.getType() == BLUE_PAINTBALL.get()){
            return BLUE;
        }
        if(paintballEntity.getType() == CYAN_PAINTBALL.get()){
            return CYAN;
        }
        if(paintballEntity.getType() == MAGENTA_PAINTBALL.get()){
            return MAGENTA;
        }
        if(paintballEntity.getType() == YELLOW_PAINTBALL.get()){
            return YELLOW;
        }
        if(paintballEntity.getType() == LIME_PAINTBALL.get()){
            return LIME;
        }
        if(paintballEntity.getType() == LIGHT_BLUE_PAINTBALL.get()){
            return LIGHT_BLUE;
        }
        if(paintballEntity.getType() == PINK_PAINTBALL.get()){
            return PINK;
        }
        if(paintballEntity.getType() == WHITE_PAINTBALL.get()){
            return WHITE;
        }
        return WHITE;
    }
}

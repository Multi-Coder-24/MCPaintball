package org.multicoder.mcpaintball.client.entityrenderer;


import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.entity.PaintballEntity;
import org.multicoder.mcpaintball.common.init.entityinit;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

import java.util.Objects;

@SuppressWarnings("all")
@OnlyIn(Dist.CLIENT)
public class PaintballRenderer extends ArrowRenderer<PaintballEntity> {
    public static final ResourceLocation RED = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/red_paintball.png");
    public static final ResourceLocation BLUE = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/blue_paintball.png");
    public static final ResourceLocation GREEN = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/green_paintball.png");
    public static final ResourceLocation MAGENTA = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/magenta_paintball.png");
    public static final ResourceLocation PINK = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/pink_paintball.png");
    public static final ResourceLocation PURPLE = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/purple_paintball.png");
    public static final ResourceLocation LIME = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/lime_paintball.png");
    public static final ResourceLocation LIGHT_BLUE = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/light_blue_paintball.png");
    public static final ResourceLocation CYAN = new ResourceLocation("mcpaintball:textures/entity/projectiles/paintball/cyan_paintball.png");

    public PaintballRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(PaintballEntity p_114482_)
    {
        try{
            EntityType<?> Type = p_114482_.getType();
            if (Objects.equals(Type, entityinit.RED_PAINTBALL.get())) {
                return RED;
            } else if (Objects.equals(Type, entityinit.GREEN_PAINTBALL.get())) {
                return GREEN;
            } else if (Objects.equals(Type, entityinit.BLUE_PAINTBALL.get())) {
                return BLUE;
            } else if (Objects.equals(Type, entityinit.MAGENTA_PAINTBALL.get())) {
                return MAGENTA;
            } else if (Objects.equals(Type, entityinit.PINK_PAINTBALL.get())) {
                return PINK;
            } else if (Objects.equals(Type, entityinit.PURPLE_PAINTBALL.get())) {
                return PURPLE;
            } else if (Objects.equals(Type, entityinit.LIME_PAINTBALL.get())) {
                return LIME;
            } else if (Objects.equals(Type, entityinit.LIGHT_BLUE_PAINTBALL.get())) {
                return LIGHT_BLUE;
            } else if (Objects.equals(Type, entityinit.CYAN_PAINTBALL.get())) {
                return CYAN;
            }
            return RED;
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
        return null;
    }
}

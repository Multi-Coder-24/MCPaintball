package org.multicoder.mcpaintball.common.entityrenderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.entity.MCPaintballEntities;
import org.multicoder.mcpaintball.common.entity.throwable.GrenadeEntity;

public class GrenadeRenderer extends EntityRenderer<GrenadeEntity>
{
    public static final ResourceLocation R = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/red_grenade.png");
    public static final ResourceLocation G = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/green_grenade.png");
    public static final ResourceLocation B = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/blue_grenade.png");
    public static final ResourceLocation C = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/cyan_grenade.png");
    public static final ResourceLocation M = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/magenta_grenade.png");
    public static final ResourceLocation Y = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/yellow_grenade.png");
    public static final ResourceLocation LI = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/lime_grenade.png");
    public static final ResourceLocation LB = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/light_blue_grenade.png");
    public static final ResourceLocation PI = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/pink_grenade.png");
    public static final ResourceLocation PU = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/purple_grenade.png");

    public GrenadeRenderer(EntityRendererProvider.Context p_174008_)
    {
        super(p_174008_);
    }

    @Override
    public void render(GrenadeEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight)
    {
        ResourceLocation TEXTURE = getTextureLocation(entity);
        poseStack.pushPose();
        poseStack.scale(0.75F, 0.75F, 0.75F);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));

        PoseStack.Pose posestack$pose = poseStack.last();
        Matrix4f matrix4f = posestack$pose.pose();
        Matrix3f matrix3f = posestack$pose.normal();

        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));
        vertex(vertexconsumer, matrix4f, matrix3f, packedLight, 0.0F, 0, 0, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, packedLight, 1.0F, 0, 1, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, packedLight, 1.0F, 1, 1, 0);
        vertex(vertexconsumer, matrix4f, matrix3f, packedLight, 0.0F, 1, 0, 0);

        poseStack.popPose();
        super.render(entity, entityYaw, partialTick, poseStack, multiBufferSource, packedLight);
    }
    private static void vertex(VertexConsumer vertexConsumer, Matrix4f matrix4f, Matrix3f matrix3f, int packedLight, float xVec, int yVec, int xUV, int yUV)
    {
        vertexConsumer.vertex(matrix4f, xVec - 0.5F, (float) yVec - 0.25F, 0.0F).color(255, 255, 255, 255).uv((float) xUV, (float) yUV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
    }
    @Override
    public ResourceLocation getTextureLocation(GrenadeEntity entity)
    {
        if(entity.getType().equals(MCPaintballEntities.RED_GRENADE.get())){
            return R;
        } else if (entity.getType().equals(MCPaintballEntities.GREEN_GRENADE.get())) {
            return G;
        }else if (entity.getType().equals(MCPaintballEntities.BLUE_GRENADE.get())) {
            return B;
        }else if (entity.getType().equals(MCPaintballEntities.CYAN_GRENADE.get())) {
            return C;
        }else if (entity.getType().equals(MCPaintballEntities.MAGENTA_GRENADE.get())) {
            return M;
        }else if (entity.getType().equals(MCPaintballEntities.YELLOW_GRENADE.get())) {
            return Y;
        }else if (entity.getType().equals(MCPaintballEntities.LIME_GRENADE.get())) {
            return LI;
        }else if (entity.getType().equals(MCPaintballEntities.LIGHT_BLUE_GRENADE.get())) {
            return LB;
        }else if (entity.getType().equals(MCPaintballEntities.PINK_GRENADE.get())) {
            return PI;
        }else if (entity.getType().equals(MCPaintballEntities.PURPLE_GRENADE.get())) {
            return PU;
        }else{
            return null;
        }
    }
}

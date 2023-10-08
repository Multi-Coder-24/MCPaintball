package org.multicoder.mcpaintball.client.entityrenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.multicoder.mcpaintball.common.entity.PaintballGrenade;
import org.multicoder.mcpaintball.common.init.entityinit;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
@SuppressWarnings("all")
public class GrenadeRenderer extends EntityRenderer<PaintballGrenade> {
    public static final ResourceLocation RED = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/red_grenade.png");
    public static final ResourceLocation GREEN = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/green_grenade.png");
    public static final ResourceLocation BLUE = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/blue_grenade.png");
    public static final ResourceLocation MAGENTA = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/magenta_grenade.png");
    public static final ResourceLocation PINK = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/pink_grenade.png");
    public static final ResourceLocation PURPLE = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/purple_grenade.png");
    public static final ResourceLocation LIME = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/lime_grenade.png");
    public static final ResourceLocation LIGHT_BLUE = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/light_blue_grenade.png");
    public static final ResourceLocation CYAN = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/cyan_grenade.png");

    public GrenadeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(@NotNull PaintballGrenade grenade, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        ResourceLocation TEXTURE = new ResourceLocation("mcpaintball:textures/entity/projectiles/grenades/red_grenade.png");
        EntityType<?> Type = grenade.getType();
        if (Objects.equals(Type, entityinit.RED_GRENADE.get())) {
            TEXTURE = RED;
        } else if (Objects.equals(Type, entityinit.GREEN_GRENADE.get())) {
            TEXTURE = GREEN;
        } else if (Objects.equals(Type, entityinit.BLUE_GRENADE.get())) {
            TEXTURE = BLUE;
        } else if (Objects.equals(Type, entityinit.MAGENTA_GRENADE.get())) {
            TEXTURE = MAGENTA;
        } else if (Objects.equals(Type, entityinit.PINK_GRENADE.get())) {
            TEXTURE = PINK;
        } else if (Objects.equals(Type, entityinit.PURPLE_GRENADE.get())) {
            TEXTURE = PURPLE;
        } else if (Objects.equals(Type, entityinit.LIME_GRENADE.get())) {
            TEXTURE = LIME;
        } else if (Objects.equals(Type, entityinit.LIGHT_BLUE_GRENADE.get())) {
            TEXTURE = LIGHT_BLUE;
        } else if (Objects.equals(Type, entityinit.CYAN_GRENADE.get())) {
            TEXTURE = CYAN;
        }
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
        super.render(grenade, entityYaw, partialTick, poseStack, multiBufferSource, packedLight);
    }

    private static void vertex(VertexConsumer vertexConsumer, Matrix4f matrix4f, Matrix3f matrix3f, int packedLight, float xVec, int yVec, int xUV, int yUV) {
        vertexConsumer.vertex(matrix4f, xVec - 0.5F, (float) yVec - 0.25F, 0.0F).color(255, 255, 255, 255).uv((float) xUV, (float) yUV).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(PaintballGrenade p_114482_) {
        EntityType<?> Type = p_114482_.getType();
        if (Objects.equals(Type, entityinit.RED_GRENADE.get())) {
            return RED;
        } else if (Objects.equals(Type, entityinit.GREEN_GRENADE.get())) {
            return GREEN;
        } else if (Objects.equals(Type, entityinit.BLUE_GRENADE.get())) {
            return BLUE;
        } else if (Objects.equals(Type, entityinit.MAGENTA_GRENADE.get())) {
            return MAGENTA;
        } else if (Objects.equals(Type, entityinit.PINK_GRENADE.get())) {
            return PINK;
        } else if (Objects.equals(Type, entityinit.PURPLE_GRENADE.get())) {
            return PURPLE;
        } else if (Objects.equals(Type, entityinit.LIME_GRENADE.get())) {
            return LIME;
        } else if (Objects.equals(Type, entityinit.LIGHT_BLUE_GRENADE.get())) {
            return LIGHT_BLUE;
        }
        return RED;
    }
}

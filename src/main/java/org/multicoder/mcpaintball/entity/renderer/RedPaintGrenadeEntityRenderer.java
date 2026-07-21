package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.state.ThrownItemRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.entity.RedPaintGrenadeEntity;

public class RedPaintGrenadeEntityRenderer extends ThrownItemRenderer<RedPaintGrenadeEntity> {
    private final ItemModelResolver itemModelResolver;
    public RedPaintGrenadeEntityRenderer(EntityRendererProvider.Context context) {
        super(context,1f,false);
        itemModelResolver = context.getItemModelResolver();
    }

    @Override
    public void extractRenderState(@NonNull RedPaintGrenadeEntity entity, @NonNull ThrownItemRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        itemModelResolver.updateForNonLiving(state.item,new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get()), ItemDisplayContext.GROUND,entity);
    }
}

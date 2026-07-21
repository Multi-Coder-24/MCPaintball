package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.state.ThrownItemRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.entity.GreenPaintGrenadeEntity;

public class GreenPaintGrenadeEntityRenderer extends ThrownItemRenderer<GreenPaintGrenadeEntity> {
    private final ItemModelResolver itemModelResolver;
    public GreenPaintGrenadeEntityRenderer(EntityRendererProvider.Context context) {
        super(context,1f,false);
        itemModelResolver = context.getItemModelResolver();
    }

    @Override
    public void extractRenderState(@NonNull GreenPaintGrenadeEntity entity, @NonNull ThrownItemRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        itemModelResolver.updateForNonLiving(state.item,new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get()), ItemDisplayContext.GROUND,entity);
    }
}

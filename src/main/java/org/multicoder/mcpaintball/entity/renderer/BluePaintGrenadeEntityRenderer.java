package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.state.ThrownItemRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.entity.BluePaintGrenadeEntity;

public class BluePaintGrenadeEntityRenderer extends ThrownItemRenderer<BluePaintGrenadeEntity>{
    private final ItemModelResolver itemModelResolver;

    public BluePaintGrenadeEntityRenderer(EntityRendererProvider.Context context) {
        super(context, 0.5f, false);
        itemModelResolver = context.getItemModelResolver();
    }

    @Override
    public void extractRenderState(@NonNull BluePaintGrenadeEntity entity, @NonNull ThrownItemRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        this.itemModelResolver.updateForNonLiving(state.item, new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.asItem()), ItemDisplayContext.GROUND, entity);
    }
}

package org.multicoder.mcpaintball.entity.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.state.ThrownItemRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballEntities;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.entity.PaintGrenadeEntity;

public class PaintGrenadeEntityRenderer extends ThrownItemRenderer<PaintGrenadeEntity> {
    private final ItemModelResolver itemModelResolver;
    public PaintGrenadeEntityRenderer(EntityRendererProvider.Context context) {
        super(context,0.5f,false);
        itemModelResolver = context.getItemModelResolver();
    }

    @Override
    public void extractRenderState(@NonNull PaintGrenadeEntity entity, @NonNull ThrownItemRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        EntityType<?> type = entity.getType();
        if (type == MCPaintballEntities.RED_PAINT_GRENADE.get()){
            itemModelResolver.updateForNonLiving(state.item,new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get()), ItemDisplayContext.GROUND,entity);
        }else if (type == MCPaintballEntities.GREEN_PAINT_GRENADE.get()){
            itemModelResolver.updateForNonLiving(state.item,new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get()), ItemDisplayContext.GROUND,entity);
        }else if (type == MCPaintballEntities.BLUE_PAINT_GRENADE.get()){
            itemModelResolver.updateForNonLiving(state.item,new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get()), ItemDisplayContext.GROUND,entity);
        }else if (type == MCPaintballEntities.YELLOW_PAINT_GRENADE.get()){
            itemModelResolver.updateForNonLiving(state.item,new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get()), ItemDisplayContext.GROUND,entity);
        }else if (type == MCPaintballEntities.PINK_PAINT_GRENADE.get()){
            itemModelResolver.updateForNonLiving(state.item,new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get()), ItemDisplayContext.GROUND,entity);
        }else if (type == MCPaintballEntities.ORANGE_PAINT_GRENADE.get()){
            itemModelResolver.updateForNonLiving(state.item,new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get()), ItemDisplayContext.GROUND,entity);
        }
    }
}

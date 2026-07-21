package org.multicoder.mcpaintball.core;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

public class MCPaintballBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MCPaintball.MODID);
    public static final DeferredBlock<?> RED_C4 = BLOCKS.registerSimpleBlock("explosives/red_c4_block",() -> BlockBehaviour.Properties.of().noOcclusion().noCollision().destroyTime(20f).explosionResistance(50f).pushReaction(PushReaction.BLOCK));
    public static final DeferredBlock<?> GREEN_C4 = BLOCKS.registerSimpleBlock("explosives/green_c4_block",() -> BlockBehaviour.Properties.of().noOcclusion().noCollision().destroyTime(20f).explosionResistance(50f).pushReaction(PushReaction.BLOCK));
    public static final DeferredBlock<?> BLUE_C4 = BLOCKS.registerSimpleBlock("explosives/blue_c4_block",() -> BlockBehaviour.Properties.of().noOcclusion().noCollision().destroyTime(20f).explosionResistance(50f).pushReaction(PushReaction.BLOCK));

    public static final DeferredItem<BlockItem> RED_C4_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(RED_C4);
    public static final DeferredItem<BlockItem> GREEN_C4_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(GREEN_C4);
    public static final DeferredItem<BlockItem> BLUE_C4_BI = MCPaintballItems.ITEMS.registerSimpleBlockItem(BLUE_C4);
}

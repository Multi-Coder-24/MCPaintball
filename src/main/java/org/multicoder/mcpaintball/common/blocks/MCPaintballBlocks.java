package org.multicoder.mcpaintball.common.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.items.MCPaintballItems;

import java.util.function.Supplier;

public class MCPaintballBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(MCPaintball.MOD_ID);

    public static final DeferredHolder<Block,?> RED_EXPLOSIVE = RegisterBlock("red_explosive",ExplosiveBlock::new);
    public static final DeferredHolder<Block,?> GREEN_EXPLOSIVE = RegisterBlock("green_explosive",ExplosiveBlock::new);
    public static final DeferredHolder<Block,?> BLUE_EXPLOSIVE = RegisterBlock("blue_explosive",ExplosiveBlock::new);
    public static final DeferredHolder<Block,?> CYAN_EXPLOSIVE = RegisterBlock("cyan_explosive",ExplosiveBlock::new);
    public static final DeferredHolder<Block,?> MAGENTA_EXPLOSIVE = RegisterBlock("magenta_explosive",ExplosiveBlock::new);
    public static final DeferredHolder<Block,?> YELLOW_EXPLOSIVE = RegisterBlock("yellow_explosive",ExplosiveBlock::new);
    public static final DeferredHolder<Block,?> LIME_EXPLOSIVE = RegisterBlock("lime_explosive",ExplosiveBlock::new);
    public static final DeferredHolder<Block,?> LIGHT_BLUE_EXPLOSIVE = RegisterBlock("light_blue_explosive",ExplosiveBlock::new);
    public static final DeferredHolder<Block,?> PINK_EXPLOSIVE = RegisterBlock("pink_explosive",ExplosiveBlock::new);
    public static final DeferredHolder<Block,?> PURPLE_EXPLOSIVE = RegisterBlock("purple_explosive",ExplosiveBlock::new);


    private static DeferredHolder<Block,?> RegisterBlock(String name, Supplier<Block> supplier)
    {
        DeferredHolder<Block,?> Block = BLOCKS.register(name,supplier);
        DeferredHolder<Item,?> Block_Item = MCPaintballItems.ITEMS.register(name,() -> new BlockItem(Block.get(),new Item.Properties()));
        return Block;
    }
}

package org.multicoder.mcpaintball.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.BlueExplosive;
import org.multicoder.mcpaintball.block.GreenExplosive;
import org.multicoder.mcpaintball.block.RedExplosive;

public class blockinit
{
    public static final Block RED_EXPLOSIVE = RegisterBlock("utility/red_explosive",new RedExplosive());
    public static final Block BLUE_EXPLOSIVE = RegisterBlock("utility/blue_explosive",new BlueExplosive());
    public static final Block GREEN_EXPLOSIVE = RegisterBlock("utility/green_explosive",new GreenExplosive());

    private static Block RegisterBlock(String name, Block block)
    {
        RegisterBlockItem(name,block);
        return Registry.register(Registries.BLOCK,new Identifier(MCPaintball.ModID,name),block);
    }

    private static Item RegisterBlockItem(String name, Block block)
    {
        Item item =  Registry.register(Registries.ITEM,new Identifier(MCPaintball.ModID,name),new BlockItem(block,new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(tabinit.paintball).register(entries -> {entries.add(item);});
        return item;
    }

    public static void RegsiterBlocks(){

    }
}

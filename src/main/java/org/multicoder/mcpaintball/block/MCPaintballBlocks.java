package org.multicoder.mcpaintball.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;

@SuppressWarnings("unused")
public class MCPaintballBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MCPaintball.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MCPaintball.MOD_ID);

    public static final DeferredHolder<Block,Block> RED_REFILL_STATION = BLOCKS.register("util/red_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> GREEN_REFILL_STATION = BLOCKS.register("util/green_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> BLUE_REFILL_STATION = BLOCKS.register("util/blue_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> CYAN_REFILL_STATION = BLOCKS.register("util/cyan_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> MAGENTA_REFILL_STATION = BLOCKS.register("util/magenta_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> YELLOW_REFILL_STATION = BLOCKS.register("util/yellow_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> LIME_REFILL_STATION = BLOCKS.register("util/lime_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> LIGHT_BLUE_REFILL_STATION = BLOCKS.register("util/light_blue_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> PINK_REFILL_STATION = BLOCKS.register("util/pink_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> WHITE_REFILL_STATION = BLOCKS.register("util/white_refill_station",RefillStationBlock::new);

    public static final DeferredHolder<Item,Item> RED_REFILL_STATION_BI = ITEMS.register("util/red_refill_station",() -> new BlockItem(RED_REFILL_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> GREEN_REFILL_STATION_BI = ITEMS.register("util/green_refill_station",() -> new BlockItem(GREEN_REFILL_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> BLUE_REFILL_STATION_BI = ITEMS.register("util/blue_refill_station",() -> new BlockItem(BLUE_REFILL_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> CYAN_REFILL_STATION_BI = ITEMS.register("util/cyan_refill_station",() -> new BlockItem(CYAN_REFILL_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> MAGENTA_REFILL_STATION_BI = ITEMS.register("util/magenta_refill_station",() -> new BlockItem(MAGENTA_REFILL_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> YELLOW_REFILL_STATION_BI = ITEMS.register("util/yellow_refill_station",() -> new BlockItem(YELLOW_REFILL_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> LIME_REFILL_STATION_BI = ITEMS.register("util/lime_refill_station",() -> new BlockItem(LIME_REFILL_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_REFILL_STATION_BI = ITEMS.register("util/light_blue_refill_station",() -> new BlockItem(LIGHT_BLUE_REFILL_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> PINK_REFILL_STATION_BI = ITEMS.register("util/pink_refill_station",() -> new BlockItem(PINK_REFILL_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> WHITE_REFILL_STATION_BI = ITEMS.register("util/white_refill_station",() -> new BlockItem(WHITE_REFILL_STATION.value(),new Item.Properties()));
}

package org.multicoder.mcpaintball.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.C4ExplosiveBlock;
import org.multicoder.mcpaintball.block.C4ExplosiveBlockItem;
import org.multicoder.mcpaintball.block.RefillStationBlock;
import org.multicoder.mcpaintball.block.RefillStationBlockItem;

@SuppressWarnings("unused")
public class MCPaintballBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MCPaintball.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MCPaintball.MOD_ID);

    public static final DeferredHolder<Block,Block> RED_REFILL_STATION = BLOCKS.register("util/red_refill_station", RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> GREEN_REFILL_STATION = BLOCKS.register("util/green_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> BLUE_REFILL_STATION = BLOCKS.register("util/blue_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> CYAN_REFILL_STATION = BLOCKS.register("util/cyan_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> MAGENTA_REFILL_STATION = BLOCKS.register("util/magenta_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> YELLOW_REFILL_STATION = BLOCKS.register("util/yellow_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> LIME_REFILL_STATION = BLOCKS.register("util/lime_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> LIGHT_BLUE_REFILL_STATION = BLOCKS.register("util/light_blue_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> PINK_REFILL_STATION = BLOCKS.register("util/pink_refill_station",RefillStationBlock::new);
    public static final DeferredHolder<Block,Block> WHITE_REFILL_STATION = BLOCKS.register("util/white_refill_station",RefillStationBlock::new);

    public static final DeferredHolder<Block,Block> RED_C4_EXPLOSIVE = BLOCKS.register("util/red_c4_explosive", C4ExplosiveBlock::new);
    public static final DeferredHolder<Block,Block> GREEN_C4_EXPLOSIVE = BLOCKS.register("util/green_c4_explosive",C4ExplosiveBlock::new);
    public static final DeferredHolder<Block,Block> BLUE_C4_EXPLOSIVE = BLOCKS.register("util/blue_c4_explosive",C4ExplosiveBlock::new);
    public static final DeferredHolder<Block,Block> CYAN_C4_EXPLOSIVE = BLOCKS.register("util/cyan_c4_explosive",C4ExplosiveBlock::new);
    public static final DeferredHolder<Block,Block> MAGENTA_C4_EXPLOSIVE = BLOCKS.register("util/magenta_c4_explosive",C4ExplosiveBlock::new);
    public static final DeferredHolder<Block,Block> YELLOW_C4_EXPLOSIVE = BLOCKS.register("util/yellow_c4_explosive",C4ExplosiveBlock::new);
    public static final DeferredHolder<Block,Block> LIME_C4_EXPLOSIVE = BLOCKS.register("util/lime_c4_explosive",C4ExplosiveBlock::new);
    public static final DeferredHolder<Block,Block> LIGHT_BLUE_C4_EXPLOSIVE = BLOCKS.register("util/light_blue_c4_explosive",C4ExplosiveBlock::new);
    public static final DeferredHolder<Block,Block> PINK_C4_EXPLOSIVE = BLOCKS.register("util/pink_c4_explosive",C4ExplosiveBlock::new);
    public static final DeferredHolder<Block,Block> WHITE_C4_EXPLOSIVE = BLOCKS.register("util/white_c4_explosive",C4ExplosiveBlock::new);

    public static final DeferredHolder<Item,Item> RED_REFILL_STATION_BI = ITEMS.register("util/red_refill_station",() -> new RefillStationBlockItem(RED_REFILL_STATION.value()));
    public static final DeferredHolder<Item,Item> GREEN_REFILL_STATION_BI = ITEMS.register("util/green_refill_station",() -> new RefillStationBlockItem(GREEN_REFILL_STATION.value()));
    public static final DeferredHolder<Item,Item> BLUE_REFILL_STATION_BI = ITEMS.register("util/blue_refill_station",() -> new RefillStationBlockItem(BLUE_REFILL_STATION.value()));
    public static final DeferredHolder<Item,Item> CYAN_REFILL_STATION_BI = ITEMS.register("util/cyan_refill_station",() -> new RefillStationBlockItem(CYAN_REFILL_STATION.value()));
    public static final DeferredHolder<Item,Item> MAGENTA_REFILL_STATION_BI = ITEMS.register("util/magenta_refill_station",() -> new RefillStationBlockItem(MAGENTA_REFILL_STATION.value()));
    public static final DeferredHolder<Item,Item> YELLOW_REFILL_STATION_BI = ITEMS.register("util/yellow_refill_station",() -> new RefillStationBlockItem(YELLOW_REFILL_STATION.value()));
    public static final DeferredHolder<Item,Item> LIME_REFILL_STATION_BI = ITEMS.register("util/lime_refill_station",() -> new RefillStationBlockItem(LIME_REFILL_STATION.value()));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_REFILL_STATION_BI = ITEMS.register("util/light_blue_refill_station",() -> new RefillStationBlockItem(LIGHT_BLUE_REFILL_STATION.value()));
    public static final DeferredHolder<Item,Item> PINK_REFILL_STATION_BI = ITEMS.register("util/pink_refill_station",() -> new RefillStationBlockItem(PINK_REFILL_STATION.value()));
    public static final DeferredHolder<Item,Item> WHITE_REFILL_STATION_BI = ITEMS.register("util/white_refill_station",() -> new RefillStationBlockItem(WHITE_REFILL_STATION.value()));

    public static final DeferredHolder<Item,Item> RED_C4_EXPLOSIVE_BI = ITEMS.register("util/red_c4_explosive",() -> new C4ExplosiveBlockItem(RED_C4_EXPLOSIVE.value()));
    public static final DeferredHolder<Item,Item> GREEN_C4_EXPLOSIVE_BI = ITEMS.register("util/green_c4_explosive",() -> new C4ExplosiveBlockItem(GREEN_C4_EXPLOSIVE.value()));
    public static final DeferredHolder<Item,Item> BLUE_C4_EXPLOSIVE_BI = ITEMS.register("util/blue_c4_explosive",() -> new C4ExplosiveBlockItem(BLUE_C4_EXPLOSIVE.value()));
    public static final DeferredHolder<Item,Item> CYAN_C4_EXPLOSIVE_BI = ITEMS.register("util/cyan_c4_explosive",() -> new C4ExplosiveBlockItem(CYAN_C4_EXPLOSIVE.value()));
    public static final DeferredHolder<Item,Item> MAGENTA_C4_EXPLOSIVE_BI = ITEMS.register("util/magenta_c4_explosive",() -> new C4ExplosiveBlockItem(MAGENTA_C4_EXPLOSIVE.value()));
    public static final DeferredHolder<Item,Item> YELLOW_C4_EXPLOSIVE_BI = ITEMS.register("util/yellow_c4_explosive",() -> new C4ExplosiveBlockItem(YELLOW_C4_EXPLOSIVE.value()));
    public static final DeferredHolder<Item,Item> LIME_C4_EXPLOSIVE_BI = ITEMS.register("util/lime_c4_explosive",() -> new C4ExplosiveBlockItem(LIME_C4_EXPLOSIVE.value()));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_C4_EXPLOSIVE_BI = ITEMS.register("util/light_blue_c4_explosive",() -> new C4ExplosiveBlockItem(LIGHT_BLUE_C4_EXPLOSIVE.value()));
    public static final DeferredHolder<Item,Item> PINK_C4_EXPLOSIVE_BI = ITEMS.register("util/pink_c4_explosive",() -> new C4ExplosiveBlockItem(PINK_C4_EXPLOSIVE.value()));
    public static final DeferredHolder<Item,Item> WHITE_C4_EXPLOSIVE_BI = ITEMS.register("util/white_c4_explosive",() -> new C4ExplosiveBlockItem(WHITE_C4_EXPLOSIVE.value()));

}

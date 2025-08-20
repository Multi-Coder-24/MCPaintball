package org.multicoder.mcpaintball.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.*;
import org.multicoder.mcpaintball.block.flag.*;

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

    public static final DeferredHolder<Block,Block> RED_FLAG_BLOCK = BLOCKS.register("util/red_flag_block", RedFlagBlock::new);
    public static final DeferredHolder<Block,Block> GREEN_FLAG_BLOCK = BLOCKS.register("util/green_flag_block", GreenFlagBlock::new);
    public static final DeferredHolder<Block,Block> BLUE_FLAG_BLOCK = BLOCKS.register("util/blue_flag_block", BlueFlagBlock::new);
    public static final DeferredHolder<Block,Block> CYAN_FLAG_BLOCK = BLOCKS.register("util/cyan_flag_block", CyanFlagBlock::new);
    public static final DeferredHolder<Block,Block> MAGENTA_FLAG_BLOCK = BLOCKS.register("util/magenta_flag_block", MagentaFlagBlock::new);
    public static final DeferredHolder<Block,Block> YELLOW_FLAG_BLOCK = BLOCKS.register("util/yellow_flag_block", YellowFlagBlock::new);
    public static final DeferredHolder<Block,Block> LIME_FLAG_BLOCK = BLOCKS.register("util/lime_flag_block", LimeFlagBlock::new);
    public static final DeferredHolder<Block,Block> LIGHT_BLUE_FLAG_BLOCK = BLOCKS.register("util/light_blue_flag_block", LightBlueFlagBlock::new);
    public static final DeferredHolder<Block,Block> PINK_FLAG_BLOCK = BLOCKS.register("util/pink_flag_block", PinkFlagBlock::new);
    public static final DeferredHolder<Block,Block> WHITE_FLAG_BLOCK = BLOCKS.register("util/white_flag_block", WhiteFlagBlock::new);

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

    public static final DeferredHolder<Block,Block> RED_RESPAWN_STATION = BLOCKS.register("util/red_respawn_station", RespawnStationBlock::new);
    public static final DeferredHolder<Block,Block> GREEN_RESPAWN_STATION = BLOCKS.register("util/green_respawn_station",RespawnStationBlock::new);
    public static final DeferredHolder<Block,Block> BLUE_RESPAWN_STATION = BLOCKS.register("util/blue_respawn_station",RespawnStationBlock::new);
    public static final DeferredHolder<Block,Block> CYAN_RESPAWN_STATION = BLOCKS.register("util/cyan_respawn_station",RespawnStationBlock::new);
    public static final DeferredHolder<Block,Block> MAGENTA_RESPAWN_STATION = BLOCKS.register("util/magenta_respawn_station",RespawnStationBlock::new);
    public static final DeferredHolder<Block,Block> YELLOW_RESPAWN_STATION = BLOCKS.register("util/yellow_respawn_station",RespawnStationBlock::new);
    public static final DeferredHolder<Block,Block> LIME_RESPAWN_STATION = BLOCKS.register("util/lime_respawn_station",RespawnStationBlock::new);
    public static final DeferredHolder<Block,Block> LIGHT_BLUE_RESPAWN_STATION = BLOCKS.register("util/light_blue_respawn_station",RespawnStationBlock::new);
    public static final DeferredHolder<Block,Block> PINK_RESPAWN_STATION = BLOCKS.register("util/pink_respawn_station",RespawnStationBlock::new);
    public static final DeferredHolder<Block,Block> WHITE_RESPAWN_STATION = BLOCKS.register("util/white_respawn_station",RespawnStationBlock::new);

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

    public static final DeferredHolder<Item,Item> RED_FLAG_BLOCK_BI = ITEMS.register("util/red_flag_block",() -> new BlockItem(RED_FLAG_BLOCK.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> GREEN_FLAG_BLOCK_BI = ITEMS.register("util/green_flag_block",() -> new BlockItem(GREEN_FLAG_BLOCK.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> BLUE_FLAG_BLOCK_BI = ITEMS.register("util/blue_flag_block",() -> new BlockItem(BLUE_FLAG_BLOCK.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> CYAN_FLAG_BLOCK_BI = ITEMS.register("util/cyan_flag_block",() -> new BlockItem(CYAN_FLAG_BLOCK.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> MAGENTA_FLAG_BLOCK_BI = ITEMS.register("util/magenta_flag_block",() -> new BlockItem(MAGENTA_FLAG_BLOCK.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> YELLOW_FLAG_BLOCK_BI = ITEMS.register("util/yellow_flag_block",() -> new BlockItem(YELLOW_FLAG_BLOCK.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> LIME_FLAG_BLOCK_BI = ITEMS.register("util/lime_flag_block",() -> new BlockItem(LIME_FLAG_BLOCK.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_FLAG_BLOCK_BI = ITEMS.register("util/light_blue_flag_block",() -> new BlockItem(LIGHT_BLUE_FLAG_BLOCK.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> PINK_FLAG_BLOCK_BI = ITEMS.register("util/pink_flag_block",() -> new BlockItem(PINK_FLAG_BLOCK.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> WHITE_FLAG_BLOCK_BI = ITEMS.register("util/white_flag_block",() -> new BlockItem(WHITE_FLAG_BLOCK.value(),new Item.Properties()));

    public static final DeferredHolder<Item,Item> RED_RESPAWN_STATION_BI = ITEMS.register("util/red_respawn_station",() -> new BlockItem(RED_RESPAWN_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> GREEN_RESPAWN_STATION_BI = ITEMS.register("util/green_respawn_station",() -> new BlockItem(GREEN_RESPAWN_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> BLUE_RESPAWN_STATION_BI = ITEMS.register("util/blue_respawn_station",() -> new BlockItem(BLUE_RESPAWN_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> CYAN_RESPAWN_STATION_BI = ITEMS.register("util/cyan_respawn_station",() -> new BlockItem(CYAN_RESPAWN_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> MAGENTA_RESPAWN_STATION_BI = ITEMS.register("util/magenta_respawn_station",() -> new BlockItem(MAGENTA_RESPAWN_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> YELLOW_RESPAWN_STATION_BI = ITEMS.register("util/yellow_respawn_station",() -> new BlockItem(YELLOW_RESPAWN_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> LIME_RESPAWN_STATION_BI = ITEMS.register("util/lime_respawn_station",() -> new BlockItem(LIME_RESPAWN_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> LIGHT_BLUE_RESPAWN_STATION_BI = ITEMS.register("util/light_blue_respawn_station",() -> new BlockItem(LIGHT_BLUE_RESPAWN_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> PINK_RESPAWN_STATION_BI = ITEMS.register("util/pink_respawn_station",() -> new BlockItem(PINK_RESPAWN_STATION.value(),new Item.Properties()));
    public static final DeferredHolder<Item,Item> WHITE_RESPAWN_STATION_BI = ITEMS.register("util/white_respawn_station",() -> new BlockItem(WHITE_RESPAWN_STATION.value(),new Item.Properties()));


}

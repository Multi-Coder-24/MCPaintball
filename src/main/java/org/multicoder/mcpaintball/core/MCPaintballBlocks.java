package org.multicoder.mcpaintball.core;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.doors.TeamedDoor;
import org.multicoder.mcpaintball.block.explosives.*;
import org.multicoder.mcpaintball.block.objectives.*;
import org.multicoder.mcpaintball.block.utility.*;

import java.util.function.Function;

public class MCPaintballBlocks {
    public static final Block RED_GRENADE_STATION = register("utility/red_grenade_station", GrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block GREEN_GRENADE_STATION = register("utility/green_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BLUE_GRENADE_STATION = register("utility/blue_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block YELLOW_GRENADE_STATION = register("utility/yellow_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block PINK_GRENADE_STATION = register("utility/pink_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block ORANGE_GRENADE_STATION = register("utility/orange_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));

    public static final Block RED_RESPAWN_STATION = register("utility/red_respawn_station", RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block GREEN_RESPAWN_STATION = register("utility/green_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BLUE_RESPAWN_STATION = register("utility/blue_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block YELLOW_RESPAWN_STATION = register("utility/yellow_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block PINK_RESPAWN_STATION = register("utility/pink_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block ORANGE_RESPAWN_STATION = register("utility/orange_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));

    public static final Block RED_PAINT_MINE = register("explosives/red_paint_mine", PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block GREEN_PAINT_MINE = register("explosives/green_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BLUE_PAINT_MINE = register("explosives/blue_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block YELLOW_PAINT_MINE = register("explosives/yellow_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block PINK_PAINT_MINE = register("explosives/pink_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block ORANGE_PAINT_MINE = register("explosives/orange_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));

    public static final Block RED_FLAG = register("objectives/red_flag", FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block GREEN_FLAG = register("objectives/green_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BLUE_FLAG = register("objectives/blue_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block YELLOW_FLAG = register("objectives/yellow_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block PINK_FLAG = register("objectives/pink_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block ORANGE_FLAG = register("objectives/orange_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));

    public static final Block CAPTURE_POINT = register("objectives/capture_point", CapturePointBlock::new,BlockBehaviour.Properties.of());

    public static final Block RED_DOOR = register("doors/red_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block GREEN_DOOR = register("doors/green_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BLUE_DOOR = register("doors/blue_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block YELLOW_DOOR = register("doors/yellow_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block PINK_DOOR = register("doors/pink_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block ORANGE_DOOR = register("doors/orange_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));

    public static final Block RED_TOWER = register("utility/red_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block GREEN_TOWER = register("utility/green_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BLUE_TOWER = register("utility/blue_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block YELLOW_TOWER = register("utility/yellow_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block PINK_TOWER = register("utility/pink_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block ORANGE_TOWER = register("utility/orange_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));

    public static final Block RED_CLAYMORE_BLOCK = register("explosives/red_claymore_block", RedClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block GREEN_CLAYMORE_BLOCK = register("explosives/green_claymore_block", GreenClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block BLUE_CLAYMORE_BLOCK = register("explosives/blue_claymore_block", BlueClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block YELLOW_CLAYMORE_BLOCK = register("explosives/yellow_claymore_block", YellowClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block PINK_CLAYMORE_BLOCK = register("explosives/pink_claymore_block", PinkClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block ORANGE_CLAYMORE_BLOCK = register("explosives/orange_claymore_block", OrangeClaymoreBlock::new,BlockBehaviour.Properties.of());

    public static void initialize() {
        MCPaintball.LOGGER.info("Initializing Blocks");
    }


    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(properties.setId(blockKey));
        ResourceKey<Item> itemKey = keyOfItem(name);
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
    }
}

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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MCPaintballBlocks {

    public static List<Block> UTILITY_BLOCKS = new ArrayList<>();
    public static List<Block> WEAPON_BLOCKS = new ArrayList<>();

    public static final Block RED_GRENADE_STATION = registerUtilityTab("utility/red_grenade_station", GrenadeStation::new,BlockBehaviour.Properties.of());
    public static final Block GREEN_GRENADE_STATION = registerUtilityTab("utility/green_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block BLUE_GRENADE_STATION = registerUtilityTab("utility/blue_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block CYAN_GRENADE_STATION = registerUtilityTab("utility/cyan_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block MAGENTA_GRENADE_STATION = registerUtilityTab("utility/magenta_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block YELLOW_GRENADE_STATION = registerUtilityTab("utility/yellow_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block LIME_GRENADE_STATION = registerUtilityTab("utility/lime_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block LIGHT_BLUE_GRENADE_STATION = registerUtilityTab("utility/light_blue_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block LIGHT_GRAY_GRENADE_STATION = registerUtilityTab("utility/light_gray_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block GRAY_GRENADE_STATION = registerUtilityTab("utility/gray_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block WHITE_GRENADE_STATION = registerUtilityTab("utility/white_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block BLACK_GRENADE_STATION = registerUtilityTab("utility/black_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block PINK_GRENADE_STATION = registerUtilityTab("utility/pink_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block BROWN_GRENADE_STATION = registerUtilityTab("utility/brown_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block PURPLE_GRENADE_STATION = registerUtilityTab("utility/purple_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());
    public static final Block ORANGE_GRENADE_STATION = registerUtilityTab("utility/orange_grenade_station",GrenadeStation::new, BlockBehaviour.Properties.of());

    public static final Block RED_RESPAWN_STATION = registerUtilityTab("utility/red_respawn_station", RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block GREEN_RESPAWN_STATION = registerUtilityTab("utility/green_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BLUE_RESPAWN_STATION = registerUtilityTab("utility/blue_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block CYAN_RESPAWN_STATION = registerUtilityTab("utility/cyan_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block MAGENTA_RESPAWN_STATION = registerUtilityTab("utility/magenta_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block YELLOW_RESPAWN_STATION = registerUtilityTab("utility/yellow_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block PINK_RESPAWN_STATION = registerUtilityTab("utility/pink_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block LIME_RESPAWN_STATION = registerUtilityTab("utility/lime_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block LIGHT_BLUE_RESPAWN_STATION = registerUtilityTab("utility/light_blue_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block LIGHT_GRAY_RESPAWN_STATION = registerUtilityTab("utility/light_gray_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block GRAY_RESPAWN_STATION = registerUtilityTab("utility/gray_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block WHITE_RESPAWN_STATION = registerUtilityTab("utility/white_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BLACK_RESPAWN_STATION = registerUtilityTab("utility/black_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BROWN_RESPAWN_STATION = registerUtilityTab("utility/brown_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block PURPLE_RESPAWN_STATION = registerUtilityTab("utility/purple_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block ORANGE_RESPAWN_STATION = registerUtilityTab("utility/orange_respawn_station",RespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));

    public static final Block RED_PAINT_MINE = registerWeaponTab("explosives/red_paint_mine", PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block GREEN_PAINT_MINE = registerWeaponTab("explosives/green_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BLUE_PAINT_MINE = registerWeaponTab("explosives/blue_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block CYAN_PAINT_MINE = registerWeaponTab("explosives/cyan_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block MAGENTA_PAINT_MINE = registerWeaponTab("explosives/magenta_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block YELLOW_PAINT_MINE = registerWeaponTab("explosives/yellow_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block PINK_PAINT_MINE = registerWeaponTab("explosives/pink_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block LIME_PAINT_MINE = registerWeaponTab("explosives/lime_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block LIGHT_BLUE_PAINT_MINE = registerWeaponTab("explosives/light_blue_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block LIGHT_GRAY_PAINT_MINE = registerWeaponTab("explosives/light_gray_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block GRAY_PAINT_MINE = registerWeaponTab("explosives/gray_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block WHITE_PAINT_MINE = registerWeaponTab("explosives/white_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BLACK_PAINT_MINE = registerWeaponTab("explosives/black_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BROWN_PAINT_MINE = registerWeaponTab("explosives/brown_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block PURPLE_PAINT_MINE = registerWeaponTab("explosives/purple_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block ORANGE_PAINT_MINE = registerWeaponTab("explosives/orange_paint_mine",PaintMine::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block RED_FLAG = registerUtilityTab("objectives/red_flag", FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block GREEN_FLAG = registerUtilityTab("objectives/green_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BLUE_FLAG = registerUtilityTab("objectives/blue_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block CYAN_FLAG = registerUtilityTab("objectives/cyan_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block MAGENTA_FLAG = registerUtilityTab("objectives/magenta_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block YELLOW_FLAG = registerUtilityTab("objectives/yellow_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block PINK_FLAG = registerUtilityTab("objectives/pink_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block LIME_FLAG = registerUtilityTab("objectives/lime_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block LIGHT_BLUE_FLAG = registerUtilityTab("objectives/light_blue_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block LIGHT_GRAY_FLAG = registerUtilityTab("objectives/light_gray_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block GRAY_FLAG = registerUtilityTab("objectives/gray_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block WHITE_FLAG = registerUtilityTab("objectives/white_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BLACK_FLAG = registerUtilityTab("objectives/black_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BROWN_FLAG = registerUtilityTab("objectives/brown_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block PURPLE_FLAG = registerUtilityTab("objectives/purple_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block ORANGE_FLAG = registerUtilityTab("objectives/orange_flag",FlagBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block CAPTURE_POINT = registerUtilityTab("objectives/capture_point", CapturePointBlock::new,BlockBehaviour.Properties.of());
    public static final Block RED_DOOR = registerUtilityTab("doors/red_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block GREEN_DOOR = registerUtilityTab("doors/green_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BLUE_DOOR = registerUtilityTab("doors/blue_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block CYAN_DOOR = registerUtilityTab("doors/cyan_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block MAGENTA_DOOR = registerUtilityTab("doors/magenta_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block YELLOW_DOOR = registerUtilityTab("doors/yellow_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block PINK_DOOR = registerUtilityTab("doors/pink_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block LIME_DOOR = registerUtilityTab("doors/lime_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block LIGHT_BLUE_DOOR = registerUtilityTab("doors/light_blue_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block LIGHT_GRAY_DOOR = registerUtilityTab("doors/light_gray_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block GRAY_DOOR = registerUtilityTab("doors/gray_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block WHITE_DOOR = registerUtilityTab("doors/white_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BLACK_DOOR = registerUtilityTab("doors/black_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BROWN_DOOR = registerUtilityTab("doors/brown_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block PURPLE_DOOR = registerUtilityTab("doors/purple_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block ORANGE_DOOR = registerUtilityTab("doors/orange_door", TeamedDoor::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block RED_TOWER = registerUtilityTab("utility/red_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block GREEN_TOWER = registerUtilityTab("utility/green_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BLUE_TOWER = registerUtilityTab("utility/blue_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block CYAN_TOWER = registerUtilityTab("utility/cyan_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block MAGENTA_TOWER = registerUtilityTab("utility/magenta_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block YELLOW_TOWER = registerUtilityTab("utility/yellow_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block PINK_TOWER = registerUtilityTab("utility/pink_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block LIME_TOWER = registerUtilityTab("utility/lime_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block LIGHT_BLUE_TOWER = registerUtilityTab("utility/light_blue_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block LIGHT_GRAY_TOWER = registerUtilityTab("utility/light_gray_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block GRAY_TOWER = registerUtilityTab("utility/gray_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BLACK_TOWER = registerUtilityTab("utility/black_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block WHITE_TOWER = registerUtilityTab("utility/white_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block BROWN_TOWER = registerUtilityTab("utility/brown_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block PURPLE_TOWER = registerUtilityTab("utility/purple_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block ORANGE_TOWER = registerUtilityTab("utility/orange_tower", BasicTowerBlock::new,BlockBehaviour.Properties.of().noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(2f));
    public static final Block RED_CLAYMORE_BLOCK = registerWeaponTab("explosives/red_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block GREEN_CLAYMORE_BLOCK = registerWeaponTab("explosives/green_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block BLUE_CLAYMORE_BLOCK = registerWeaponTab("explosives/blue_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block CYAN_CLAYMORE_BLOCK = registerWeaponTab("explosives/cyan_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block MAGENTA_CLAYMORE_BLOCK = registerWeaponTab("explosives/magenta_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block YELLOW_CLAYMORE_BLOCK = registerWeaponTab("explosives/yellow_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block PINK_CLAYMORE_BLOCK = registerWeaponTab("explosives/pink_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block LIME_CLAYMORE_BLOCK = registerWeaponTab("explosives/lime_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block LIGHT_BLUE_CLAYMORE_BLOCK = registerWeaponTab("explosives/light_blue_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block LIGHT_GRAY_CLAYMORE_BLOCK = registerWeaponTab("explosives/light_gray_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block GRAY_CLAYMORE_BLOCK = registerWeaponTab("explosives/gray_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block BLACK_CLAYMORE_BLOCK = registerWeaponTab("explosives/black_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block WHITE_CLAYMORE_BLOCK = registerWeaponTab("explosives/white_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block BROWN_CLAYMORE_BLOCK = registerWeaponTab("explosives/brown_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block PURPLE_CLAYMORE_BLOCK = registerWeaponTab("explosives/purple_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());
    public static final Block ORANGE_CLAYMORE_BLOCK = registerWeaponTab("explosives/orange_claymore_block", ClaymoreBlock::new,BlockBehaviour.Properties.of());

    public static void initialize() {
        MCPaintball.LOGGER.info("Initializing Blocks");
    }

    private static Block registerUtilityTab(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        Block block = blockFactory.apply(properties.setId(blockKey));
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        UTILITY_BLOCKS.add(block);
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }
    private static Block registerWeaponTab(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        Block block = blockFactory.apply(properties.setId(blockKey));
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name));
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        WEAPON_BLOCKS.add(block);
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }
}

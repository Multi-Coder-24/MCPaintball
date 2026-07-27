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
import org.multicoder.mcpaintball.block.*;

import java.util.function.Function;

public class MCPaintballBlocks {
    public static final Block RED_GRENADE_STATION = register("utility/red_grenade_station",RedGrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block GREEN_GRENADE_STATION = register("utility/green_grenade_station",GreenGrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BLUE_GRENADE_STATION = register("utility/blue_grenade_station",BlueGrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block YELLOW_GRENADE_STATION = register("utility/yellow_grenade_station",YellowGrenadeStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));

    public static final Block RED_RESPAWN_STATION = register("utility/red_respawn_station",RedRespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block GREEN_RESPAWN_STATION = register("utility/green_respawn_station",GreenRespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block BLUE_RESPAWN_STATION = register("utility/blue_respawn_station",BlueRespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));
    public static final Block YELLOW_RESPAWN_STATION = register("utility/yellow_respawn_station",YellowRespawnStation::new, BlockBehaviour.Properties.of().dynamicShape().noOcclusion().pushReaction(PushReaction.BLOCK).destroyTime(5f));

    public static void Initialize() {
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

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

@SuppressWarnings("unused")
public class MCPaintballBlocks {
    public static final Block RED_C4_BLOCK = Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/red_c4_block"),new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/red_c4_block"))).noOcclusion().destroyTime(20f).explosionResistance(50f).noCollision().pushReaction(PushReaction.BLOCK)));
    public static final Block GREEN_C4_BLOCK = Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/green_c4_block"),new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/green_c4_block"))).noOcclusion().destroyTime(20f).explosionResistance(50f).noCollision().pushReaction(PushReaction.BLOCK)));
    public static final Block BLUE_C4_BLOCK = Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/blue_c4_block"),new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/blue_c4_block"))).noOcclusion().destroyTime(20f).explosionResistance(50f).noCollision().pushReaction(PushReaction.BLOCK)));

    public static final Item RED_C4_BLOCK_BI = Registry.register(BuiltInRegistries.ITEM,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/red_c4_block"),new BlockItem(RED_C4_BLOCK,new Item.Properties().setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/red_c4_block")))));
    public static final Item GREEN_C4_BLOCK_BI = Registry.register(BuiltInRegistries.ITEM,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/green_c4_block"),new BlockItem(GREEN_C4_BLOCK,new Item.Properties().setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/green_c4_block")))));
    public static final Item BLUE_C4_BLOCK_BI = Registry.register(BuiltInRegistries.ITEM,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/blue_c4_block"),new BlockItem(BLUE_C4_BLOCK,new Item.Properties().setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"explosives/blue_c4_block")))));

    public static void Initialize(){
        MCPaintball.LOGGER.debug("Initializing Blocks");
    }

}

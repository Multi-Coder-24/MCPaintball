package org.multicoder.mcpaintball.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.entity.*;

public class MCPaintballBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MCPaintball.MODID);

    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<ClaymoreBlockEntity>> RED_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("red_claymore", () -> new BlockEntityType<>((pos,blockState) -> new ClaymoreBlockEntity(MCPaintballBlockEntities.RED_CLAYMORE_BLOCK_ENTITY.get(),pos,blockState),MCPaintballBlocks.RED_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<ClaymoreBlockEntity>> GREEN_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("green_claymore", () -> new BlockEntityType<>((pos,blockState) -> new ClaymoreBlockEntity(MCPaintballBlockEntities.GREEN_CLAYMORE_BLOCK_ENTITY.get(),pos,blockState),MCPaintballBlocks.GREEN_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<ClaymoreBlockEntity>> BLUE_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("blue_claymore", () -> new BlockEntityType<>((pos,blockState) -> new ClaymoreBlockEntity(MCPaintballBlockEntities.BLUE_CLAYMORE_BLOCK_ENTITY.get(),pos,blockState) ,MCPaintballBlocks.BLUE_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<ClaymoreBlockEntity>> YELLOW_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("yellow_claymore", () -> new BlockEntityType<>((pos,blockState) -> new ClaymoreBlockEntity(MCPaintballBlockEntities.YELLOW_CLAYMORE_BLOCK_ENTITY.get(),pos,blockState),MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<ClaymoreBlockEntity>> PINK_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("pink_claymore", () -> new BlockEntityType<>((pos,blockState) -> new ClaymoreBlockEntity(MCPaintballBlockEntities.PINK_CLAYMORE_BLOCK_ENTITY.get(),pos,blockState),MCPaintballBlocks.PINK_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<ClaymoreBlockEntity>> ORANGE_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("orange_claymore", () -> new BlockEntityType<>((pos,blockState) -> new ClaymoreBlockEntity(MCPaintballBlockEntities.ORANGE_CLAYMORE_BLOCK_ENTITY.get(),pos,blockState),MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK.get()));
}

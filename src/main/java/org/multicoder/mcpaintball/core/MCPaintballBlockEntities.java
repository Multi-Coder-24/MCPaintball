package org.multicoder.mcpaintball.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.entity.*;

public class MCPaintballBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MCPaintball.MODID);

    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<RedClaymoreBlockEntity>> RED_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("red_claymore", () -> new BlockEntityType<>(RedClaymoreBlockEntity::new,MCPaintballBlocks.RED_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<GreenClaymoreBlockEntity>> GREEN_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("green_claymore", () -> new BlockEntityType<>(GreenClaymoreBlockEntity::new,MCPaintballBlocks.RED_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<BlueClaymoreBlockEntity>> BLUE_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("blue_claymore", () -> new BlockEntityType<>(BlueClaymoreBlockEntity::new,MCPaintballBlocks.RED_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<YellowClaymoreBlockEntity>> YELLOW_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("yellow_claymore", () -> new BlockEntityType<>(YellowClaymoreBlockEntity::new,MCPaintballBlocks.RED_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<PinkClaymoreBlockEntity>> PINK_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("pink_claymore", () -> new BlockEntityType<>(PinkClaymoreBlockEntity::new,MCPaintballBlocks.RED_CLAYMORE_BLOCK.get()));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<OrangeClaymoreBlockEntity>> ORANGE_CLAYMORE_BLOCK_ENTITY = BLOCK_ENTITIES.register("orange_claymore", () -> new BlockEntityType<>(OrangeClaymoreBlockEntity::new,MCPaintballBlocks.RED_CLAYMORE_BLOCK.get()));
}

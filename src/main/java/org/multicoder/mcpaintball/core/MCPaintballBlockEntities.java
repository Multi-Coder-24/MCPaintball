package org.multicoder.mcpaintball.core;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.entity.*;

@SuppressWarnings("all")
public class MCPaintballBlockEntities {
    public static final BlockEntityType<RedClaymoreBlockEntity> RED_CLAYMORE_BLOCK_ENTITY = register("red_claymore",RedClaymoreBlockEntity::new, MCPaintballBlocks.RED_CLAYMORE_BLOCK);
    public static final BlockEntityType<GreenClaymoreBlockEntity> GREEN_CLAYMORE_BLOCK_ENTITY = register("green_claymore",GreenClaymoreBlockEntity::new, MCPaintballBlocks.GREEN_CLAYMORE_BLOCK);
    public static final BlockEntityType<BlueClaymoreBlockEntity> BLUE_CLAYMORE_BLOCK_ENTITY = register("blue_claymore",BlueClaymoreBlockEntity::new, MCPaintballBlocks.BLUE_CLAYMORE_BLOCK);
    public static final BlockEntityType<YellowClaymoreBlockEntity> YELLOW_CLAYMORE_BLOCK_ENTITY = register("yellow_claymore",YellowClaymoreBlockEntity::new, MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK);
    public static final BlockEntityType<PinkClaymoreBlockEntity> PINK_CLAYMORE_BLOCK_ENTITY = register("pink_claymore",PinkClaymoreBlockEntity::new, MCPaintballBlocks.PINK_CLAYMORE_BLOCK);
    public static final BlockEntityType<OrangeClaymoreBlockEntity> ORANGE_CLAYMORE_BLOCK_ENTITY = register("orange_claymore",OrangeClaymoreBlockEntity::new, MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK);


    public static void initialize() {
        MCPaintball.LOGGER.info("Initializing Block Entities");
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
        Identifier id = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
}

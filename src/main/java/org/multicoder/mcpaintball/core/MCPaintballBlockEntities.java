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
    public static final BlockEntityType<ClaymoreBlockEntity> RED_CLAYMORE_BLOCK_ENTITY = register("red_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.RED_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> GREEN_CLAYMORE_BLOCK_ENTITY = register("green_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.GREEN_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> BLUE_CLAYMORE_BLOCK_ENTITY = register("blue_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.BLUE_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> CYAN_CLAYMORE_BLOCK_ENTITY = register("cyan_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.CYAN_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> MAGENTA_CLAYMORE_BLOCK_ENTITY = register("magenta_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.MAGENTA_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> YELLOW_CLAYMORE_BLOCK_ENTITY = register("yellow_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> PINK_CLAYMORE_BLOCK_ENTITY = register("pink_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.PINK_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> LIME_CLAYMORE_BLOCK_ENTITY = register("lime_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.LIME_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> LIGHT_BLUE_CLAYMORE_BLOCK_ENTITY = register("light_blue_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.LIGHT_BLUE_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> LIGHT_GRAY_CLAYMORE_BLOCK_ENTITY = register("light_gray_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.LIGHT_GRAY_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> GRAY_CLAYMORE_BLOCK_ENTITY = register("gray_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.GRAY_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> WHITE_CLAYMORE_BLOCK_ENTITY = register("white_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.WHITE_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> BLACK_CLAYMORE_BLOCK_ENTITY = register("black_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.BLACK_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> BROWN_CLAYMORE_BLOCK_ENTITY = register("brown_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.BROWN_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> PURPLE_CLAYMORE_BLOCK_ENTITY = register("purple_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.PURPLE_CLAYMORE_BLOCK);
    public static final BlockEntityType<ClaymoreBlockEntity> ORANGE_CLAYMORE_BLOCK_ENTITY = register("orange_claymore",ClaymoreBlockEntity::new, MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK);


    public static void initialize() {
        MCPaintball.LOGGER.info("Initializing Block Entities");
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
        Identifier id = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
}

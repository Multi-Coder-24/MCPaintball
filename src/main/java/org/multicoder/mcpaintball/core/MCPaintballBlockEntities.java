package org.multicoder.mcpaintball.core;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.entity.RedClaymoreBlockEntity;

@SuppressWarnings("all")
public class MCPaintballBlockEntities {
    public static final BlockEntityType<RedClaymoreBlockEntity> RED_CLAYMORE_BLOCK_ENTITY = register("red_claymore",RedClaymoreBlockEntity::new, MCPaintballBlocks.RED_CLAYMORE_BLOCK);


    public static void initialize() {
        MCPaintball.LOGGER.info("Initializing Block Entities");
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
        Identifier id = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }
}

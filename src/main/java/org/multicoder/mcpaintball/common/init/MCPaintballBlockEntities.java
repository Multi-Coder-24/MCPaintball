package org.multicoder.mcpaintball.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.blockentities.SoloC4PaintballBlockEntity;
import org.multicoder.mcpaintball.common.blockentities.SoloPaintballTeamStationBlockEntity;

@SuppressWarnings("all")
public class MCPaintballBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MCPaintball.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<?>> SOLO_STATION = BLOCK_ENTITIES.register("gray_team_station", () -> BlockEntityType.Builder.of(SoloPaintballTeamStationBlockEntity::new, MCPaintballBlocks.SOLO_TEAM_STATION.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<?>> SOLO_C4 = BLOCK_ENTITIES.register("gray_c4", () -> BlockEntityType.Builder.of(SoloC4PaintballBlockEntity::new, MCPaintballBlocks.SOLO_C4.get()).build(null));
}

package org.multicoder.mcpaintball.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.block.explosives.ClaymoreBlock;
import org.multicoder.mcpaintball.core.MCPaintballBlockEntities;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballParticles;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class ClaymoreBlockEntity extends BlockEntity{
    public int Ticker = 0;
    public ClaymoreBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(MCPaintballBlockEntities.RED_CLAYMORE_BLOCK_ENTITY, worldPosition, blockState);
    }
    public ClaymoreBlockEntity(BlockEntityType<?> type,BlockPos worldPosition, BlockState blockState){
        super(type, worldPosition, blockState);
    }

    public static void tick(@NonNull Level level, @NonNull BlockPos pos, @NonNull BlockState state, @NonNull ClaymoreBlockEntity entity) {
        //if(!Objects.requireNonNull(level).isClientSide()){}
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        output.putInt("ticker", Ticker);
        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        Ticker = input.getIntOr("ticker",0);
        super.loadAdditional(input);
    }
}

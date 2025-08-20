package org.multicoder.mcpaintball.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class RespawnStationBlock extends Block {
    public RespawnStationBlock() {
        super(Properties.of().noOcclusion().dynamicShape());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return makeShape();
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if(!level.isClientSide){
            ServerPlayer  serverPlayer = (ServerPlayer) player;
            serverPlayer.setRespawnPosition(level.dimension(),pos.above(),0F,true,true);
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    public VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.0625, 0.9375, 0.625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.625, 0.0625, 0.1875, 0.75, 0.1875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.625, 0.8125, 0.1875, 0.75, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.8125, 0.625, 0.8125, 0.9375, 0.75, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.8125, 0.625, 0.0625, 0.9375, 0.75, 0.1875), BooleanOp.OR);

        return shape;
    }
}

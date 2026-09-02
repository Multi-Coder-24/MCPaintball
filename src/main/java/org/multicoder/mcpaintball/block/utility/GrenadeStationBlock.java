package org.multicoder.mcpaintball.block.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class GrenadeStationBlock extends Block {

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    public GrenadeStationBlock(Properties properties) {
        super(properties.noOcclusion().dynamicShape().pushReaction(PushReaction.BLOCK).destroyTime(5F));
    }
    @Override
    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return makeShape(state.getValue(FACING));
    }

    public VoxelShape makeShape(Direction direction) {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0.25, 0.4375, 1, 1, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0, 0.328125, 1, 0.25, 0.703125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.28125, 0.5625, 1, 0.34375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.59375, 0.5625, 1, 0.65625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.90625, 0.5625, 1, 0.96875, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.90625, 0.375, 1, 0.96875, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.59375, 0.375, 1, 0.65625, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.28125, 0.375, 1, 0.34375, 0.4375), BooleanOp.OR);
        return Shapes.rotateAll(shape).get(direction);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
                Block block = state.getBlock();
                if(block == MCPaintballBlocks.RED_GRENADE_STATION.get() && Objects.requireNonNull(data).Team == 1){
                    player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                    player.addItem(new ItemStack(MCPaintballBlocks.RED_PAINT_MINE.get(),2));
                    switch (data.Role){
                        case 1 ->{
                            player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                        }case 2 ->{
                            player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                        }case 3 ->{
                            player.addItem(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                        }
                    }
                }else if(block == MCPaintballBlocks.GREEN_GRENADE_STATION.get() && Objects.requireNonNull(data).Team == 2){
                    player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                    player.addItem(new ItemStack(MCPaintballBlocks.GREEN_PAINT_MINE.get(),2));
                    switch (data.Role){
                        case 1 ->{
                            player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                        }case 2 ->{
                            player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                        }case 3 ->{
                            player.addItem(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                        }
                    }
                }else if(block == MCPaintballBlocks.BLUE_GRENADE_STATION.get() && Objects.requireNonNull(data).Team == 3){
                    player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                    player.addItem(new ItemStack(MCPaintballBlocks.BLUE_PAINT_MINE.get(),2));
                    switch (data.Role){
                        case 1 ->{
                            player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                        }case 2 ->{
                            player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                        }case 3 ->{
                            player.addItem(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                        }
                    }
                }else if(block == MCPaintballBlocks.YELLOW_GRENADE_STATION.get() && Objects.requireNonNull(data).Team == 4){
                    player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                    player.addItem(new ItemStack(MCPaintballBlocks.YELLOW_PAINT_MINE.get(),2));
                    switch (data.Role){
                        case 1 ->{
                            player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                        }case 2 ->{
                            player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                        }case 3 ->{
                            player.addItem(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                        }
                    }
                }else if(block == MCPaintballBlocks.PINK_GRENADE_STATION.get() && Objects.requireNonNull(data).Team == 5){
                    player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                    player.addItem(new ItemStack(MCPaintballBlocks.PINK_PAINT_MINE.get(),2));
                    switch (data.Role){
                        case 1 ->{
                            player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                        }case 2 ->{
                            player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                        }case 3 ->{
                            player.addItem(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                        }
                    }
                }else if(block == MCPaintballBlocks.ORANGE_GRENADE_STATION.get() && Objects.requireNonNull(data).Team == 6){
                    player.addItem(new ItemStack(MCPaintballItems.SIGHT_GRENADE.get(),4));
                    player.addItem(new ItemStack(MCPaintballBlocks.ORANGE_PAINT_MINE.get(),2));
                    switch (data.Role){
                        case 1 ->{
                            player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),4));
                        }case 2 ->{
                            player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),16));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),6));
                        }case 3 ->{
                            player.addItem(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE.get(),8));
                            player.addItem(new ItemStack(MCPaintballItems.SMOKE_GRENADE.get(),4));
                            player.addItem(new ItemStack(MCPaintballItems.EMP_GRENADE.get(),2));
                        }
                    }
                }
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@NonNull BlockPlaceContext context) {
        return Objects.requireNonNull(super.getStateForPlacement(context)).setValue(FACING,context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NonNull Builder<Block, BlockState> builder) {
        builder.add(FACING);
        super.createBlockStateDefinition(builder);
    }
}

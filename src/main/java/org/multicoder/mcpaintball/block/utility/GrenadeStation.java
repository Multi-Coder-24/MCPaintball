package org.multicoder.mcpaintball.block.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.PaintballRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrenadeStation extends Block {

    public GrenadeStation(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return makeShape();
    }

    public VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0.25, 0.4375, 1, 1, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0, 0.328125, 1, 0.25, 0.703125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.28125, 0.5625, 1, 0.34375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.59375, 0.5625, 1, 0.65625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.90625, 0.5625, 1, 0.96875, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.90625, 0.375, 1, 0.96875, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.59375, 0.375, 1, 0.65625, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.28125, 0.375, 1, 0.34375, 0.4375), BooleanOp.OR);
        return shape;
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.tournamentStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                MCPaintballPlayerData data = Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER));
                PaintballRole role = PaintballRole.values()[data.role];
                List<ItemStack> toAdd = new ArrayList<>();
                if(state.getBlock() == MCPaintballBlocks.RED_GRENADE_STATION && Objects.requireNonNull(data).team == 1){
                    switch (role) {
                        case Captain, Gunner -> {
                            toAdd.add(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 2));
                        }
                        case Sniper -> {
                            toAdd.add(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 6));
                        }
                        case Specialist -> {
                            toAdd.add(new ItemStack(MCPaintballBlocks.RED_PAINT_MINE, 8));
                            toAdd.add(new ItemStack(MCPaintballBlocks.RED_CLAYMORE_BLOCK, 4));
                        }
                        case Grenadier -> {
                            toAdd.add(new ItemStack(MCPaintballItems.RED_PAINT_GRENADE, 16));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        }
                    }
                }else if(state.getBlock() == MCPaintballBlocks.GREEN_GRENADE_STATION && Objects.requireNonNull(data).team == 2){
                    switch (role) {
                        case Captain, Gunner -> {
                            toAdd.add(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 2));
                        }
                        case Sniper -> {
                            toAdd.add(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 6));
                        }
                        case Specialist -> {
                            toAdd.add(new ItemStack(MCPaintballBlocks.GREEN_PAINT_MINE, 8));
                            toAdd.add(new ItemStack(MCPaintballBlocks.GREEN_CLAYMORE_BLOCK, 4));
                        }
                        case Grenadier -> {
                            toAdd.add(new ItemStack(MCPaintballItems.GREEN_PAINT_GRENADE, 16));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        }
                    }
                }else if(state.getBlock() == MCPaintballBlocks.BLUE_GRENADE_STATION && Objects.requireNonNull(data).team == 3){
                    switch (role) {
                        case Captain, Gunner -> {
                            toAdd.add(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 2));
                        }
                        case Sniper -> {
                            toAdd.add(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 6));
                        }
                        case Specialist -> {
                            toAdd.add(new ItemStack(MCPaintballBlocks.BLUE_PAINT_MINE, 8));
                            toAdd.add(new ItemStack(MCPaintballBlocks.BLUE_CLAYMORE_BLOCK, 4));
                        }
                        case Grenadier -> {
                            toAdd.add(new ItemStack(MCPaintballItems.BLUE_PAINT_GRENADE, 16));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        }
                    }
                }else if(state.getBlock() == MCPaintballBlocks.YELLOW_GRENADE_STATION && Objects.requireNonNull(data).team == 4){
                    switch (role) {
                        case Captain, Gunner -> {
                            toAdd.add(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 2));
                        }
                        case Sniper -> {
                            toAdd.add(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 6));
                        }
                        case Specialist -> {
                            toAdd.add(new ItemStack(MCPaintballBlocks.YELLOW_PAINT_MINE, 8));
                            toAdd.add(new ItemStack(MCPaintballBlocks.YELLOW_CLAYMORE_BLOCK, 4));
                        }
                        case Grenadier -> {
                            toAdd.add(new ItemStack(MCPaintballItems.YELLOW_PAINT_GRENADE, 16));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        }
                    }
                }else if(state.getBlock() == MCPaintballBlocks.PINK_GRENADE_STATION && Objects.requireNonNull(data).team == 5){
                    switch (role) {
                        case Captain, Gunner -> {
                            toAdd.add(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 2));
                        }
                        case Sniper -> {
                            toAdd.add(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 6));
                        }
                        case Specialist -> {
                            toAdd.add(new ItemStack(MCPaintballBlocks.PINK_PAINT_MINE, 8));
                            toAdd.add(new ItemStack(MCPaintballBlocks.PINK_CLAYMORE_BLOCK, 4));
                        }
                        case Grenadier -> {
                            toAdd.add(new ItemStack(MCPaintballItems.PINK_PAINT_GRENADE, 16));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        }
                    }
                }else if(state.getBlock() == MCPaintballBlocks.ORANGE_GRENADE_STATION && Objects.requireNonNull(data).team == 6){
                    switch (role) {
                        case Captain, Gunner -> {
                            toAdd.add(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 4));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 2));
                        }
                        case Sniper -> {
                            toAdd.add(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 8));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 6));
                        }
                        case Specialist -> {
                            toAdd.add(new ItemStack(MCPaintballBlocks.ORANGE_PAINT_MINE, 8));
                            toAdd.add(new ItemStack(MCPaintballBlocks.ORANGE_CLAYMORE_BLOCK, 4));
                        }
                        case Grenadier -> {
                            toAdd.add(new ItemStack(MCPaintballItems.ORANGE_PAINT_GRENADE, 16));
                            toAdd.add(new ItemStack(MCPaintballItems.SMOKE_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.EMP_GRENADE, 10));
                            toAdd.add(new ItemStack(MCPaintballItems.SIGHT_GRENADE, 10));
                        }
                    }
                }
                toAdd.forEach(player::addItem);
                return InteractionResult.SUCCESS;
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }
}

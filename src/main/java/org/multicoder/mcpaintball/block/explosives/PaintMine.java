package org.multicoder.mcpaintball.block.explosives;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;

public class PaintMine extends Block {

    public PaintMine(Properties properties) {
        super(properties);
    }

    public VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.375, 0, 0.375, 0.625, 0.03125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.03125, 0.4375, 0.5625, 0.046875, 0.5625), BooleanOp.OR);

        return shape;
    }

    @Override
    protected @NonNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return makeShape();
    }

    @Override
    protected void entityInside(@NonNull BlockState state, Level level, @NonNull BlockPos pos, @NonNull Entity entity, @NonNull InsideBlockEffectApplier effectApplier, boolean isPrecise) {
//        if(!level.isClientSide()) {
////            if (MCPaintballGameEvents.INSTANCE.matchStarted && MCPaintballGameEvents.INSTANCE.roundStarted) {
////                if (entity instanceof ServerPlayer player) {
////                    ServerLevel serverLevel = (ServerLevel) level;
////                    if (Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team != 0) {
////                        AABB box = AABB.encapsulatingFullBlocks(pos.offset(-3, 0, -3), pos.offset(3, 1, 3));
////                        int checker;
////                        SimpleParticleType type;
////                        if (state.getBlock() == MCPaintballBlocks.RED_PAINT_MINE) {
////                            checker = 1;
////                            type = MCPaintballParticles.RED_PAINT;
////                        } else if (state.getBlock() == MCPaintballBlocks.GREEN_PAINT_MINE) {
////                            checker = 2;
////                            type = MCPaintballParticles.GREEN_PAINT;
////                        } else if (state.getBlock() == MCPaintballBlocks.BLUE_PAINT_MINE) {
////                            checker = 3;
////                            type = MCPaintballParticles.BLUE_PAINT;
////                        }  else if (state.getBlock() == MCPaintballBlocks.CYAN_PAINT_MINE) {
////                            checker = 3;
////                            type = MCPaintballParticles.CYAN_PAINT;
////                        }  else if (state.getBlock() == MCPaintballBlocks.MAGENTA_PAINT_MINE) {
////                            checker = 3;
////                            type = MCPaintballParticles.MAGENTA_PAINT;
////                        } else if (state.getBlock() == MCPaintballBlocks.YELLOW_PAINT_MINE) {
////                            checker = 4;
////                            type = MCPaintballParticles.YELLOW_PAINT;
////                        } else if (state.getBlock() == MCPaintballBlocks.ORANGE_PAINT_MINE) {
////                            checker = 6;
////                            type = MCPaintballParticles.ORANGE_PAINT;
////                        }  else if (state.getBlock() == MCPaintballBlocks.WHITE_PAINT_MINE) {
////                            checker = 6;
////                            type = MCPaintballParticles.MAGENTA_PAINT;
////                        }  else if (state.getBlock() == MCPaintballBlocks.BLACK_PAINT_MINE) {
////                            checker = 6;
////                            type = MCPaintballParticles.BLACK_PAINT;
////                        } else {
////                            return;
////                        }
//////                        BlockPos.betweenClosed(box).forEach(blockPos -> serverLevel.sendParticles(type, true, true, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 5, 0.1, 0.1, 0.1, 0.01));
//////                        serverLevel.getEntities(null, box).forEach(found -> {
//////                            if (found instanceof ServerPlayer serverPlayer) {
//////                                if (Objects.requireNonNull(serverPlayer.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team != checker && Objects.requireNonNull(serverPlayer.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team != 0) {
//////                                    MCPaintballGameEvents.INSTANCE.incrementByChecker(checker);
//////                                }
//////                            }
//////                        });
////                        level.setBlock(pos, Blocks.AIR.defaultBlockState(), UPDATE_ALL_IMMEDIATE);
////                    }
////                }
////            }
//        }
        super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
    }

//    @Override
//    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
//        if(!context.getLevel().isClientSide()){
//            if(MCPaintballGameEvents.INSTANCE.matchStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
//                Item toPlace = context.getItemInHand().getItem();
//                int team = Objects.requireNonNull(Objects.requireNonNull(context.getPlayer()).getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team;
//                if(toPlace == MCPaintballBlocks.RED_PAINT_MINE.asItem() && team == 1){
//                    return super.getStateForPlacement(context);
//                } else if (toPlace == MCPaintballBlocks.GREEN_PAINT_MINE.asItem() && team == 2) {
//                    return super.getStateForPlacement(context);
//                }else if (toPlace == MCPaintballBlocks.BLUE_PAINT_MINE.asItem() && team == 3) {
//                    return super.getStateForPlacement(context);
//                }else if (toPlace == MCPaintballBlocks.YELLOW_PAINT_MINE.asItem() && team == 4) {
//                    return super.getStateForPlacement(context);
//                }else if (toPlace == MCPaintballBlocks.ORANGE_PAINT_MINE.asItem() && team == 6) {
//                    return super.getStateForPlacement(context);
//                }
//            }
//        }
//        return null;
//    }
}

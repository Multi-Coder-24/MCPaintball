package org.multicoder.mcpaintball.block.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Map;
import java.util.Objects;

public class BasicTowerBlock extends Block {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public BasicTowerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(@NonNull BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hitResult) {
        if(!level.isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.tournamentStarted && !MCPaintballGameEvents.INSTANCE.roundStarted){
                String Appender = state.getValue(FACING).getOpposite().getName();
                StructureTemplateManager manager = Objects.requireNonNull(level.getServer()).getStructureManager();
                StructureTemplate template;
                if(state.getBlock() == MCPaintballBlocks.RED_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 1){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"red_tower_" + Appender)).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.GREEN_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 2){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"green_tower_" + Appender)).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.BLUE_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 3){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"blue_tower_" + Appender)).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.YELLOW_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 4){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"yellow_tower_" + Appender)).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.PINK_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 5){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"pink_tower_" + Appender)).orElseThrow();
                }else if(state.getBlock() == MCPaintballBlocks.ORANGE_TOWER && Objects.requireNonNull(player.getAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER)).team == 6){
                    template = manager.get(Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"orange_tower_" + Appender)).orElseThrow();
                }else {
                    return InteractionResult.PASS;
                }
                template.placeInWorld((ServerLevelAccessor) level,pos.offset(0,-1,0),pos,new StructurePlaceSettings(),level.getRandom(),Block.UPDATE_ALL_IMMEDIATE);
                level.setBlock(pos, Blocks.AIR.defaultBlockState(),Block.UPDATE_ALL_IMMEDIATE);
                return InteractionResult.SUCCESS;
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(@NonNull BlockPlaceContext context) {
        return Objects.requireNonNull(super.getStateForPlacement(context)).setValue(FACING,context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected @NonNull VoxelShape getShape(BlockState state, @NonNull BlockGetter level, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return makeShape(state.getValue(FACING));
    }

    public VoxelShape makeShape(Direction direction){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.3125, 0, 0.25, 0.6875, 0.3125, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.3125, 0.25, 0.6875, 0.375, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.3125, 0.6875, 0.6875, 0.375, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0, 0.3125, 0.3125, 0.375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 0, 0.3125, 0.75, 0.375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.3125, 0.3125, 0.4375, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.375, 0.25, 0.375, 0.4375, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.625, 0.3125, 0.4375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 0.375, 0.625, 0.75, 0.4375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 0.375, 0.3125, 0.75, 0.4375, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0.375, 0.25, 0.6875, 0.4375, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.375, 0.6875, 0.375, 0.4375, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0.375, 0.6875, 0.6875, 0.4375, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.375, 0.6875, 0.5625, 0.4375, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.375, 0.25, 0.5625, 0.4375, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.4375, 0.3125, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 0.375, 0.4375, 0.75, 0.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0, 0.21875, 0.5625, 0.1875, 0.25), BooleanOp.OR);
        Map<Direction,VoxelShape> shapes = Shapes.rotateAll(shape);
        return shapes.get(direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NonNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
}

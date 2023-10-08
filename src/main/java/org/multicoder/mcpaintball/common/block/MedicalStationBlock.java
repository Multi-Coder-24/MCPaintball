package org.multicoder.mcpaintball.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.init.iteminit;
import org.multicoder.mcpaintball.common.util.enums.KitType;
import org.multicoder.mcpaintball.common.util.enums.Teams;

import java.util.Objects;

@SuppressWarnings("all")
public class MedicalStationBlock extends Block {
    public Teams Team;

    public VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 0.25, 1.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.25, 0, 0.125, 0.375, 1.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.875, 0.25, 0, 1, 0.375, 1.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.25, 0, 0.875, 0.375, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.25, 0.9375, 0.875, 0.375, 1.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.375, 0.375, 1, 0.625, 1.0625), BooleanOp.OR);
        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return makeShape();
    }

    public MedicalStationBlock(Teams In) {
        super(Properties.copy(Blocks.IRON_BLOCK));
        Team = In;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            if (Objects.equals(player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get().Team, Team)) {
                if (Objects.equals(player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get().ClassType, KitType.MEDICAL)) {
                    switch (player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get().Team) {
                        case RED -> {
                            player.drop(new ItemStack(iteminit.RED_MED_KIT.get(), 16), true);
                        }
                        case BLUE -> {
                            player.drop(new ItemStack(iteminit.BLUE_MED_KIT.get(), 16), true);
                        }
                        case GREEN -> {
                            player.drop(new ItemStack(iteminit.GREEN_MED_KIT.get(), 16), true);
                        }
                        case MAGENTA -> {
                            player.drop(new ItemStack(iteminit.MAGENTA_MED_KIT.get(), 16), true);
                        }
                        case PURPLE -> {
                            player.drop(new ItemStack(iteminit.PURPLE_MED_KIT.get(), 16), true);
                        }
                        case PINK -> {
                            player.drop(new ItemStack(iteminit.PINK_MED_KIT.get(), 16), true);
                        }
                        case LIME -> {
                            player.drop(new ItemStack(iteminit.LIME_MED_KIT.get(), 16), true);
                        }
                        case LIGHT_BLUE -> {
                            player.drop(new ItemStack(iteminit.LIGHT_BLUE_MED_KIT.get(), 16), true);
                        }
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}

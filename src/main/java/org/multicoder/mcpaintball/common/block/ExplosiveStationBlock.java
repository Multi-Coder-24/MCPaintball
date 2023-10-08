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
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.util.enums.Teams;
import org.multicoder.mcpaintball.common.util.holders.*;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("all")
public class ExplosiveStationBlock extends Block {
    public Teams Team;

    public VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.0625, 0.9375, 0.5625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.5875, 0.04375, 0.9375, 0.7125, 0.91875), BooleanOp.OR);

        return shape;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return makeShape();
    }

    public ExplosiveStationBlock(Teams In) {
        super(Properties.copy(Blocks.IRON_BLOCK));
        Team = In;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            PaintballPlayer PPlayer = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
            if (Objects.equals(Team, PPlayer.Team)) {
                List<ItemStack> Stacks = null;
                switch (PPlayer.Team) {
                    case RED -> {
                        Stacks = RedClass.GetExplosives(PPlayer.ClassType);
                    }
                    case BLUE -> {
                        Stacks = BlueClass.GetExplosives(PPlayer.ClassType);
                    }
                    case GREEN -> {
                        Stacks = GreenClass.GetExplosives(PPlayer.ClassType);
                    }
                    case MAGENTA -> {
                        Stacks = MagentaClass.GetExplosives(PPlayer.ClassType);
                    }
                    case PINK -> {
                        Stacks = PinkClass.GetExplosives(PPlayer.ClassType);
                    }
                    case PURPLE -> {
                        Stacks = PurpleClass.GetExplosives(PPlayer.ClassType);
                    }
                    case LIME -> {
                        Stacks = LimeClass.GetExplosives(PPlayer.ClassType);
                    }
                    case LIGHT_BLUE -> {
                        Stacks = LightBlueClass.GetExplosives(PPlayer.ClassType);
                    }
                    case CYAN -> {
                        Stacks = CyanClass.GetExplosives(PPlayer.ClassType);
                    }
                }
                if (Objects.nonNull(Stacks)) {
                    Stacks.forEach(stack -> {
                        player.drop(stack, true);
                    });
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}

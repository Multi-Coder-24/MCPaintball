package org.multicoder.mcpaintball.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.init.iteminit;
import org.multicoder.mcpaintball.common.util.enums.KitType;

import java.util.Objects;

@SuppressWarnings("all")
public class AmmoPodBlock extends Block {
    public static final BooleanProperty ENABLED = BooleanProperty.create("enabled");

    public AmmoPodBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().randomTicks());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide() && state.getValue(ENABLED)) {
            PaintballPlayer PPlayer = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
            KitType Class = PPlayer.ClassType;
            switch (Class) {
                case HEAVY -> {
                    ItemStack Stack_1 = new ItemStack(iteminit.HEAVY_AMMO.get(), 24);
                    ItemStack Stack_2 = new ItemStack(iteminit.BASIC_AMMO.get(), 32);
                    player.drop(Stack_1, true);
                    player.drop(Stack_2, true);
                    level.setBlockAndUpdate(pos, state.cycle(ENABLED));
                }
                case SNIPER, STANDARD -> {
                    ItemStack Stack_1 = new ItemStack(iteminit.BASIC_AMMO.get(), 24);
                    ItemStack Stack_2 = new ItemStack(iteminit.BASIC_AMMO.get(), 32);
                    player.drop(Stack_1, true);
                    player.drop(Stack_2, true);
                    level.setBlockAndUpdate(pos, state.cycle(ENABLED));
                }
                case MEDICAL, ENGINEER -> {
                    ItemStack Stack_1 = new ItemStack(iteminit.SHELL_AMMO.get(), 24);
                    ItemStack Stack_2 = new ItemStack(iteminit.BASIC_AMMO.get(), 32);
                    player.drop(Stack_1, true);
                    player.drop(Stack_2, true);
                    level.setBlockAndUpdate(pos, state.cycle(ENABLED));
                }
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void randomTick(BlockState p_222954_, ServerLevel p_222955_, BlockPos p_222956_, RandomSource p_222957_) {
        if (p_222954_.getValue(ENABLED).booleanValue()) {
            return;
        } else {
            p_222955_.setBlockAndUpdate(p_222956_, p_222954_.cycle(ENABLED));
        }
        super.randomTick(p_222954_, p_222955_, p_222956_, p_222957_);
    }

    @Override
    public boolean isRandomlyTicking(@NotNull BlockState p_49921_) {
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext p_49820_) {
        return Objects.requireNonNull(super.getStateForPlacement(p_49820_)).setValue(ENABLED, true);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> p_49915_) {
        super.createBlockStateDefinition(p_49915_);
        p_49915_.add(ENABLED);
    }
}

package org.multicoder.mcpaintball.block.objectives;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.data.FlagItemSettings;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

public class FlagBlock extends Block{

    public FlagBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void playerDestroy(Level level, @NonNull Player player, @NonNull BlockPos pos, @NonNull BlockState state, @Nullable BlockEntity blockEntity, @NonNull ItemStack destroyedWith) {
        if(!level.isClientSide()) {
            if(MCPaintballGameEvents.INSTANCE.tournamentStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
                Block block = state.getBlock();
                int team;
                ItemStack stack;
                if(block == MCPaintballBlocks.RED_FLAG){
                    stack = new ItemStack(MCPaintballItems.RED_FLAG_ITEM);
                    team = 1;
                } else if (block == MCPaintballBlocks.GREEN_FLAG) {
                    stack = new ItemStack(MCPaintballItems.GREEN_FLAG_ITEM);
                    team = 2;
                } else if (block == MCPaintballBlocks.BLUE_FLAG) {
                    stack = new ItemStack(MCPaintballItems.BLUE_FLAG_ITEM);
                    team = 3;
                } else if (block == MCPaintballBlocks.YELLOW_FLAG) {
                    stack = new ItemStack(MCPaintballItems.YELLOW_FLAG_ITEM);
                    team = 4;
                } else if (block == MCPaintballBlocks.PINK_FLAG) {
                    stack = new ItemStack(MCPaintballItems.PINK_FLAG_ITEM);
                    team = 5;
                } else if (block == MCPaintballBlocks.ORANGE_FLAG) {
                    stack = new ItemStack(MCPaintballItems.ORANGE_FLAG_ITEM);
                    team = 6;
                }else{return;}
                stack.set(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(pos,team));
                player.addItem(stack);
            }
        }
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }
}

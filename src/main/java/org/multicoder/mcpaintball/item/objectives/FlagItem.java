package org.multicoder.mcpaintball.item.objectives;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.data.FlagItemSettings;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;

import java.util.Objects;

public class FlagItem extends Item {

    public FlagItem(Properties properties) {
        super(properties.component(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(BlockPos.ZERO,0)));
    }

    @Override
    public @NonNull InteractionResult useOn(@NonNull UseOnContext context) {
        if(!context.getLevel().isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                ItemStack itemStack = context.getItemInHand();
                Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
                FlagItemSettings settings = Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.FLAGITEMSETTINGS));
                BlockState state = switch (settings.Team()){
                    case 1 -> MCPaintballBlocks.RED_FLAG.get().defaultBlockState();
                    case 2 -> MCPaintballBlocks.GREEN_FLAG.get().defaultBlockState();
                    case 3 -> MCPaintballBlocks.BLUE_FLAG.get().defaultBlockState();
                    case 4 -> MCPaintballBlocks.YELLOW_FLAG.get().defaultBlockState();
                    case 5 -> MCPaintballBlocks.PINK_FLAG.get().defaultBlockState();
                    case 6 -> MCPaintballBlocks.ORANGE_FLAG.get().defaultBlockState();
                    default -> throw new IllegalStateException("Unexpected value: " + settings.Team());
                };
                if(itemStack.getItem() != MCPaintballItems.RED_FLAG_ITEM.get() && block == MCPaintballBlocks.RED_FLAG.get()){
                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(1);
                }else if(itemStack.getItem() != MCPaintballItems.GREEN_FLAG_ITEM.get() && block == MCPaintballBlocks.GREEN_FLAG.get()){
                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(2);
                }else if(itemStack.getItem() != MCPaintballItems.BLUE_FLAG_ITEM.get() && block == MCPaintballBlocks.BLUE_FLAG.get()){
                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(3);
                }else if(itemStack.getItem() != MCPaintballItems.YELLOW_FLAG_ITEM.get() && block == MCPaintballBlocks.YELLOW_FLAG.get()){
                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(4);
                }else if(itemStack.getItem() != MCPaintballItems.PINK_FLAG_ITEM.get() && block == MCPaintballBlocks.PINK_FLAG.get()){
                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(5);
                }else if(itemStack.getItem() != MCPaintballItems.ORANGE_FLAG_ITEM.get() && block == MCPaintballBlocks.ORANGE_FLAG.get()){
                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(6);
                }
                itemStack.shrink(1);
                context.getLevel().setBlock(settings.position(), state, Block.UPDATE_ALL_IMMEDIATE);
            }
        }
        return InteractionResult.SUCCESS;
    }
}

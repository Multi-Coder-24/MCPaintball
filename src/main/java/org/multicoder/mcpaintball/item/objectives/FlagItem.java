package org.multicoder.mcpaintball.item.objectives;

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

import static net.minecraft.world.level.block.Block.UPDATE_ALL_IMMEDIATE;

public class FlagItem extends Item {

    public FlagItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull InteractionResult useOn(@NonNull UseOnContext context) {
        if(!context.getLevel().isClientSide()){
            if(MCPaintballGameEvents.INSTANCE.MatchStarted && MCPaintballGameEvents.INSTANCE.RoundStarted){
                ItemStack itemStack = context.getItemInHand();
                Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
                FlagItemSettings settings = Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.FLAGITEMSETTINGS));
                BlockState state = switch (settings.Team()){
                    case 1 -> MCPaintballBlocks.RED_FLAG.defaultBlockState();
                    case 2 -> MCPaintballBlocks.GREEN_FLAG.defaultBlockState();
                    case 3 -> MCPaintballBlocks.BLUE_FLAG.defaultBlockState();
                    case 4 -> MCPaintballBlocks.YELLOW_FLAG.defaultBlockState();
                    case 5 -> MCPaintballBlocks.PINK_FLAG.defaultBlockState();
                    case 6 -> MCPaintballBlocks.ORANGE_FLAG.defaultBlockState();
                    default -> throw new IllegalStateException("Unexpected value: " + settings.Team());
                };
                if(itemStack.getItem() != MCPaintballItems.RED_FLAG_ITEM && block == MCPaintballBlocks.RED_FLAG){
                    MCPaintballGameEvents.INSTANCE.RedPoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    context.getLevel().setBlock(settings.Position(),state, UPDATE_ALL_IMMEDIATE);
                }else if(itemStack.getItem() != MCPaintballItems.GREEN_FLAG_ITEM && block == MCPaintballBlocks.GREEN_FLAG){
                    MCPaintballGameEvents.INSTANCE.GreenPoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    context.getLevel().setBlock(settings.Position(),state, UPDATE_ALL_IMMEDIATE);
                }else if(itemStack.getItem() != MCPaintballItems.BLUE_FLAG_ITEM && block == MCPaintballBlocks.BLUE_FLAG){
                    MCPaintballGameEvents.INSTANCE.BluePoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    context.getLevel().setBlock(settings.Position(),state, UPDATE_ALL_IMMEDIATE);
                }else if(itemStack.getItem() != MCPaintballItems.YELLOW_FLAG_ITEM && block == MCPaintballBlocks.YELLOW_FLAG){
                    MCPaintballGameEvents.INSTANCE.YellowPoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    context.getLevel().setBlock(settings.Position(),state, UPDATE_ALL_IMMEDIATE);
                }else if(itemStack.getItem() != MCPaintballItems.PINK_FLAG_ITEM && block == MCPaintballBlocks.PINK_FLAG){
                    MCPaintballGameEvents.INSTANCE.PinkPoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);

                    context.getLevel().setBlock(settings.Position(),state, UPDATE_ALL_IMMEDIATE);
                }else if(itemStack.getItem() != MCPaintballItems.ORANGE_FLAG_ITEM && block == MCPaintballBlocks.ORANGE_FLAG){
                    MCPaintballGameEvents.INSTANCE.OrangePoints += 10;
                    MCPaintballGameEvents.INSTANCE.setDirty(true);
                    itemStack.shrink(1);
                    context.getLevel().setBlock(settings.Position(),state, UPDATE_ALL_IMMEDIATE);
                }
            }
        }
        return super.useOn(context);
    }
}

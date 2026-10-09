package org.multicoder.mcpaintball.item.objectives;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.data.FlagItemSettings;

public class FlagItem extends Item {

    public FlagItem(Properties properties) {
        super(properties.component(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(BlockPos.ZERO,0,0)).stacksTo(1));
    }

//    @Override
//    public @NonNull InteractionResult useOn(@NonNull UseOnContext context) {
//        if(!context.getLevel().isClientSide()){
//            if(MCPaintballGameEvents.INSTANCE.matchStarted && MCPaintballGameEvents.INSTANCE.roundStarted){
//                ItemStack itemStack = context.getItemInHand();
//                Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
//                FlagItemSettings settings = Objects.requireNonNull(itemStack.get(MCPaintballDataComponents.FLAGITEMSETTINGS));
//                BlockState state = switch (settings.team()){
//                    case 1 -> MCPaintballBlocks.RED_FLAG.defaultBlockState();
//                    case 2 -> MCPaintballBlocks.GREEN_FLAG.defaultBlockState();
//                    case 3 -> MCPaintballBlocks.BLUE_FLAG.defaultBlockState();
//                    case 4 -> MCPaintballBlocks.YELLOW_FLAG.defaultBlockState();
//                    case 6 -> MCPaintballBlocks.ORANGE_FLAG.defaultBlockState();
//                    default -> throw new IllegalStateException("Unexpected value: " + settings.team());
//                };
//                if(itemStack.getItem() != MCPaintballItems.RED_FLAG_ITEM && block == MCPaintballBlocks.RED_FLAG){
//                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(1);
//                }else if(itemStack.getItem() != MCPaintballItems.GREEN_FLAG_ITEM && block == MCPaintballBlocks.GREEN_FLAG){
//                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(2);
//                }else if(itemStack.getItem() != MCPaintballItems.BLUE_FLAG_ITEM && block == MCPaintballBlocks.BLUE_FLAG){
//                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(3);
//                }else if(itemStack.getItem() != MCPaintballItems.YELLOW_FLAG_ITEM && block == MCPaintballBlocks.YELLOW_FLAG){
//                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(4);
//                }else if(itemStack.getItem() != MCPaintballItems.ORANGE_FLAG_ITEM && block == MCPaintballBlocks.ORANGE_FLAG){
//                    MCPaintballGameEvents.INSTANCE.incrementCapturePointByChecker(6);
//                }else {
//                    throw new IllegalStateException("Unexpected value: " + settings.team());
//                }
//                itemStack.shrink(1);
//                Direction facing = Direction.values()[settings.Facing()];
//                context.getLevel().setBlock(settings.position(),state.setValue(FlagBlock.FACING,facing), Block.UPDATE_ALL_IMMEDIATE);
//                return InteractionResult.SUCCESS;
//            }
//        }
//        return InteractionResult.SUCCESS;
//    }
}

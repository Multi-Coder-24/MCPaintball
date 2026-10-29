package org.multicoder.mcpaintball.item.objectives;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.block.objectives.FlagBlock;
import org.multicoder.mcpaintball.core.*;
import org.multicoder.mcpaintball.data.FlagItemSettings;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import java.util.Objects;

public class FlagItem extends Item {

    public FlagItem(Properties properties) {
        super(properties.component(MCPaintballDataComponents.FLAGITEMSETTINGS,new FlagItemSettings(BlockPos.ZERO,0,0)).stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult useOn(@NonNull UseOnContext context) {
        //if(!context.getLevel().isClientSide()){}
        return InteractionResult.SUCCESS;
    }
}

package org.multicoder.mcpaintball.item.weapon;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.data.MCPaintballGrenadeLauncherSetting;

public class  GrenadeLauncherItem extends Item {

    public GrenadeLauncherItem(Properties properties) {
        super(properties.component(MCPaintballDataComponents.SETTING,new MCPaintballGrenadeLauncherSetting(1)).stacksTo(1));
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        //if(!level.isClientSide()){}
        return super.use(level, player, hand);
    }
}

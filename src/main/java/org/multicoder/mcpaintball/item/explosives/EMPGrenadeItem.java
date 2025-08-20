package org.multicoder.mcpaintball.item.explosives;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.entity.EMPGrenadeEntity;
import org.multicoder.mcpaintball.init.MCPaintballSounds;

public class EMPGrenadeItem extends Item {
    public EMPGrenadeItem() {
        super(new Properties().stacksTo(6));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        if(!level.isClientSide) {
            ItemStack Stack = player.getItemInHand(usedHand);
            EMPGrenadeEntity emp = new EMPGrenadeEntity(player, level);
            emp.shootFromRotation(player,player.getXRot(),player.getYRot(),0F,2F,0F);
            level.addFreshEntity(emp);
            Stack.shrink(1);
            level.playSound(null,player.blockPosition(), MCPaintballSounds.GRENADE.get(), SoundSource.PLAYERS,1F,1F);
        }
        return super.use(level, player, usedHand);
    }
}

package org.multicoder.mcpaintball.item.weapons;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PistolItem extends Item {

    public PistolItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        Arrow bullet = new Arrow(level,player,new ItemStack(Items.AIR),null);
        bullet.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,2.0F,0.0F);
        level.addFreshEntity(bullet);
        player.getCooldowns().addCooldown(this,40);
        return super.use(level, player, hand);
    }
}

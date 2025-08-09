package org.multicoder.mcpaintball.item.weapons;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SniperRifleItem extends Item {

    public SniperRifleItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand)
    {
        Arrow P1 = new Arrow(level,player,new ItemStack(Items.AIR),null);
        P1.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,7.5F,0.0F);
        level.addFreshEntity(P1);
        player.getCooldowns().addCooldown(this, 60);
        return super.use(level, player, usedHand);
    }
}

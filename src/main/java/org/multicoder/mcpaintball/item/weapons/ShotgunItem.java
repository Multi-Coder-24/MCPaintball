package org.multicoder.mcpaintball.item.weapons;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class ShotgunItem extends Item {

    public ShotgunItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand)
    {
        Arrow P1 = new Arrow(level,player,new ItemStack(Items.AIR),null);
        Arrow P2 = new Arrow(level,player,new ItemStack(Items.AIR),null);
        Arrow P3 = new Arrow(level,player,new ItemStack(Items.AIR),null);
        P1.shootFromRotation(player,player.getXRot(),player.getYRot() - 30.0F,0.0F,3.0F,0.0F);
        P2.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,3.0F,0.0F);
        P3.shootFromRotation(player,player.getXRot(),player.getYRot() + 30.0F,0.0F,3.0F,0.0F);
        level.addFreshEntity(P1);
        level.addFreshEntity(P2);
        level.addFreshEntity(P3);
        player.getCooldowns().addCooldown(this, 80);
        return super.use(level, player, usedHand);
    }
}

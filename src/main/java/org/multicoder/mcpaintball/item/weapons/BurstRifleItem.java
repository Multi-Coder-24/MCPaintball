package org.multicoder.mcpaintball.item.weapons;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.MCPaintball;

public class BurstRifleItem extends Item {

    public BurstRifleItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration)
    {
        if(livingEntity instanceof Player player)
        {
            if((remainingUseDuration % 10) == 0) {
                Arrow P1 = new Arrow(level, player, new ItemStack(Items.AIR), null);
                P1.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 4.5F, 0.0F);
                level.addFreshEntity(P1);
            }
            MCPaintball.LOG.info("Use Tick");
        }
        super.onUseTick(level, livingEntity, stack, remainingUseDuration);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand)
    {
        ItemStack stack = player.getItemInHand(usedHand);
        stack.onUseTick(level,player,250);
        player.getCooldowns().addCooldown(this,100);
        return super.use(level, player, usedHand);
    }

}

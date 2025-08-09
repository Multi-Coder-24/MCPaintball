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
import org.multicoder.mcpaintball.data.component.MCPaintballDataComponents;
import org.multicoder.mcpaintball.data.component.WeaponTeamDataComponent;

public class SniperRifleItem extends Item {

    public SniperRifleItem() {
        super(new Properties().stacksTo(1).component(MCPaintballDataComponents.WEAPON_TEAM.value(),new WeaponTeamDataComponent(0)));    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand usedHand)
    {
        ItemStack stack = player.getItemInHand(usedHand);
        Arrow P1 = new Arrow(level,player,new ItemStack(Items.ARROW),stack);
        P1.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,7.5F,0.0F);
        level.addFreshEntity(P1);
        player.getCooldowns().addCooldown(this, 60);
        return super.use(level, player, usedHand);
    }
}

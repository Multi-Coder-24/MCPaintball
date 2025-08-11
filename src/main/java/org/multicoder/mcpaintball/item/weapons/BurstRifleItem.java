package org.multicoder.mcpaintball.item.weapons;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
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
import org.multicoder.mcpaintball.item.utility.AmmoHopper;

public class BurstRifleItem extends Item {

    public BurstRifleItem() {
        super(new Properties().stacksTo(1).component(MCPaintballDataComponents.WEAPON_TEAM.value(),new WeaponTeamDataComponent(0)));    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        if(!level.isClientSide) {
            if (player.getOffhandItem().getItem() instanceof AmmoHopper) {
                ItemStack Ammo = player.getOffhandItem();
                if (Ammo.getDamageValue() < Ammo.getMaxDamage()) {
                    ItemStack stack = player.getItemInHand(usedHand);
                    Thread thread = new Thread(() -> {
                        try{
                            for(int i = 0; i < 5; i++){
                                Arrow P1 = new Arrow(level, player, new ItemStack(Items.ARROW), stack);
                                P1.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 4.5F, 0.0F);
                                level.addFreshEntity(P1);
                                Thread.sleep(100);
                            }
                        }
                        catch (Exception e){
                            throw new RuntimeException(e);
                        }
                    });
                    thread.start();
                    Ammo.setDamageValue(Ammo.getDamageValue() + 1);
                    player.getCooldowns().addCooldown(this,60);
                }
                else {
                    player.displayClientMessage(Component.translatable("text.mcpaintball.ammo_hopper_empty").withStyle(ChatFormatting.DARK_RED),true);
                }
            }
        }
        return super.use(level, player, usedHand);
    }

}

package org.multicoder.mcpaintball.item.weapons;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.data.component.ItemTeamDataComponent;
import org.multicoder.mcpaintball.init.MCPaintballDataComponents;
import org.multicoder.mcpaintball.item.utility.AmmoHopper;
import org.multicoder.mcpaintball.init.MCPaintballSounds;

public class BazookaItem extends Item {

    public BazookaItem() {
        super(new Properties().stacksTo(1).component(MCPaintballDataComponents.ITEM_TEAM.value(),new ItemTeamDataComponent(0)));    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if(!level.isClientSide) {
            if (player.getOffhandItem().getItem() instanceof AmmoHopper) {
                ItemStack Ammo = player.getOffhandItem();
                if (Ammo.getDamageValue() < Ammo.getMaxDamage()) {
                    Ammo.setDamageValue(Ammo.getDamageValue() + 1);
                    ItemStack stack = player.getItemInHand(hand);
                    Arrow bullet = new Arrow(level,player,new ItemStack(Items.ARROW),stack);
                    bullet.shootFromRotation(player,player.getXRot(),player.getYRot(),0.0F,2.0F,0.0F);
                    level.addFreshEntity(bullet);
                    player.getCooldowns().addCooldown(this,120);
                    level.playSound(null,player.blockPosition(), MCPaintballSounds.BAZOOKA.get(), SoundSource.PLAYERS,1.0F,1.0F);
                }
                else {
                    player.displayClientMessage(Component.translatable("text.mcpaintball.ammo_hopper_empty").withStyle(ChatFormatting.DARK_RED),true);
                }
            }
        }
        return super.use(level, player, hand);
    }
}

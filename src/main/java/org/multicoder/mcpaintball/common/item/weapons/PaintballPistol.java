package org.multicoder.mcpaintball.common.item.weapons;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.config.MCPaintballConfig;
import org.multicoder.mcpaintball.common.entity.PaintballEntity;
import org.multicoder.mcpaintball.common.init.soundinit;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

import java.util.List;

@SuppressWarnings("all")
public class PaintballPistol extends Item {

    public PaintballPistol() {
        super(new Properties().durability(16));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        try{
            if (!pLevel.isClientSide())
            {
                if(pPlayer.getItemInHand(pUsedHand).getDamageValue() < 16)
                {
                    AbstractArrow Bullet;
                    PaintballPlayer Player = pPlayer.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                    EntityType<?> ET = Player.Team.GetPaintball();
                    Bullet = new PaintballEntity((EntityType<? extends AbstractArrow>) ET, pPlayer, pLevel);
                    Bullet.addTag("true");
                    Bullet.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0f, 2f, MCPaintballConfig.PISTOL_INACCURACY.get().floatValue());
                    pLevel.addFreshEntity(Bullet);
                    pPlayer.getCooldowns().addCooldown(this, 20);
                    pLevel.playSound(null, pPlayer.blockPosition(), soundinit.SINGLE_SHOT.get(), SoundSource.PLAYERS, 1f, 1f);
                    pPlayer.getItemInHand(pUsedHand).setDamageValue(pPlayer.getItemInHand(pUsedHand).getDamageValue() + 1);
                    return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
                }
                else
                {
                    pPlayer.sendSystemMessage(Component.translatable("text.mcpaintball.reload_needed").withStyle(ChatFormatting.BOLD));
                }
            }
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("text.mcpaintball.pistol_spec").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        } else {
            pTooltipComponents.add(Component.translatable("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_RED));
        }
    }
}

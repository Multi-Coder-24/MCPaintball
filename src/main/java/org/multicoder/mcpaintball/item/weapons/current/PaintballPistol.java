package org.multicoder.mcpaintball.item.weapons.current;

import com.mojang.blaze3d.platform.ScreenManager;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.entity.base.*;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;
import org.multicoder.mcpaintball.util.Teams;
import org.multicoder.mcpaintball.util.config.MCPaintballConfig;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PaintballPistol extends Item
{

    public PaintballPistol()
    {
        super(new Properties().tab(tabinit.Weapons).durability(16));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        if(!pLevel.isClientSide())
        {
            AtomicReference<AbstractArrow> Projectile = new AtomicReference<>();
            ServerPlayer Player = (ServerPlayer) pPlayer;
            ItemStack Weapon = Player.getItemInHand(pUsedHand);
            Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
            {
                int T = cap.GetTeam();
                Teams Team = Teams.getTeam(T);
                switch(Team) {
                    case NONE ->
                    {
                        return;
                    }
                    case RED -> {
                        Projectile.set(new RedPaintballArrowEntity(pLevel, pPlayer));
                    }
                    case BLUE -> {
                        Projectile.set(new BluePaintballArrowEntity(pLevel, pPlayer));
                    }
                    case GREEN -> {
                        Projectile.set(new GreenPaintballArrowEntity(pLevel, pPlayer));
                    }
                    case PINK ->
                    {
                        Projectile.set(new PinkPaintballArrowEntity(pLevel, pPlayer));
                    }
                    case MAGENTA ->
                    {
                        Projectile.set(new MagentaPaintballArrowEntity(pLevel, pPlayer));
                    }
                    case LIME ->
                    {
                        Projectile.set(new LimePaintballArrowEntity(pLevel, pPlayer));
                    }
                    case PURPLE ->
                    {
                        Projectile.set(new PurplePaintballArrowEntity(pLevel, pPlayer));
                    }
                    case LIGHT_BLUE ->
                    {
                        Projectile.set(new LightBluePaintballArrowEntity(pLevel, pPlayer));
                    }
                }

            });
            if(Weapon.getDamageValue() == 16)
            {
                return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
            }
            else
            {
                if(Projectile.get() != null)
                {
                    AbstractArrow Proj = Projectile.get();
                    Proj.shootFromRotation(Player,Player.getXRot(),Player.getYRot(),0f,1.5f, MCPaintballConfig.PISTOL_INACCURACY.get().floatValue());
                    pLevel.addFreshEntity(Projectile.get());
                    pLevel.playSound(null,Player.blockPosition(), soundinit.SINGLE_SHOT.get(), SoundSource.PLAYERS,1f,1f);
                    int DV = Weapon.getDamageValue();
                    DV += 1;
                    Weapon.setDamageValue(DV);
                    Player.getCooldowns().addCooldown(Weapon.getItem(), 20);
                    return InteractionResultHolder.consume(Weapon);
                }
                else
                {
                    if(MCPaintball.DEV_MODE)
                    {
                        Projectile.set(new RedPaintballArrowEntity(pLevel,pPlayer));
                        AbstractArrow Proj = Projectile.get();
                        Proj.shootFromRotation(Player,Player.getXRot(),Player.getYRot(),0f,1.5f, MCPaintballConfig.PISTOL_INACCURACY.get().floatValue());
                        pLevel.addFreshEntity(Projectile.get());
                        pLevel.playSound(null,Player.blockPosition(), soundinit.SINGLE_SHOT.get(), SoundSource.PLAYERS,1f,1f);
                        Player.getCooldowns().addCooldown(Weapon.getItem(), 20);
                        return InteractionResultHolder.consume(Weapon);
                    }
                }
            }
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if(Screen.hasShiftDown())
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.pistol_spec").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
        else
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_RED));
        }
    }
}

package org.multicoder.mcpaintball.item.weapons.current;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.entity.base.RedPaintballArrowEntity;
import org.multicoder.mcpaintball.entity.heavy.*;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;
import org.multicoder.mcpaintball.util.Teams;
import org.multicoder.mcpaintball.util.config.MCPaintballConfig;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PaintballBazooka extends Item
{

    public PaintballBazooka()
    {
        super(new Properties().tab(tabinit.Weapons).durability(4));
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
                        Projectile.set(new RedPaintballHeavyArrowEntity(pLevel, pPlayer));
                    }
                    case BLUE -> {
                        Projectile.set(new BluePaintballHeavyArrowEntity(pLevel, pPlayer));
                    }
                    case GREEN -> {
                        Projectile.set(new GreenPaintballHeavyArrowEntity(pLevel, pPlayer));
                    }
                    case PINK ->
                    {
                        Projectile.set(new PinkPaintballHeavyArrowEntity(pLevel, pPlayer));
                    }
                    case MAGENTA ->
                    {
                        Projectile.set(new MagentaPaintballHeavyArrowEntity(pLevel, pPlayer));
                    }
                    case LIME ->
                    {
                        Projectile.set(new LimePaintballHeavyArrowEntity(pLevel, pPlayer));
                    }
                    case PURPLE ->
                    {
                        Projectile.set(new PurplePaintballHeavyArrowEntity(pLevel, pPlayer));
                    }
                    case LIGHT_BLUE ->
                    {
                        Projectile.set(new LightBluePaintballHeavyArrowEntity(pLevel, pPlayer));
                    }
                }
            });
            if(Weapon.getDamageValue() == 4)
            {
                return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
            }
            else
            {
                if(Projectile.get() != null)
                {
                    AbstractArrow Proj = Projectile.get();
                    Proj.shootFromRotation(Player,Player.getXRot(),Player.getYRot(),0f,1.5f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                    pLevel.addFreshEntity(Projectile.get());
                    pLevel.playSound(null,Player.blockPosition(), soundinit.BAZOOKA.get(), SoundSource.PLAYERS,1f,1f);
                    int DV = Weapon.getDamageValue();
                    DV += 1;
                    Weapon.setDamageValue(DV);
                    Player.getCooldowns().addCooldown(Weapon.getItem(), 40);
                    return InteractionResultHolder.consume(Weapon);
                }
                else
                {
                    if(MCPaintball.DEV_MODE)
                    {
                        Projectile.set(new RedPaintballHeavyArrowEntity(pLevel,pPlayer));
                        AbstractArrow Proj = Projectile.get();
                        Proj.shootFromRotation(Player,Player.getXRot(),Player.getYRot(),0f,1.5f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                        pLevel.addFreshEntity(Projectile.get());
                        pLevel.playSound(null,Player.blockPosition(), soundinit.BAZOOKA.get(), SoundSource.PLAYERS,1f,1f);
                        Player.getCooldowns().addCooldown(Weapon.getItem(), 40);
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
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.bazooka_spec").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
        else
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_RED));
        }
    }
}

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
import org.multicoder.mcpaintball.entity.base.*;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;
import org.multicoder.mcpaintball.util.Teams;
import org.multicoder.mcpaintball.util.config.MCPaintballConfig;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PaintballShotgun extends Item
{

    public PaintballShotgun()
    {
        super(new Properties().tab(tabinit.Weapons).durability(16));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        if(!pLevel.isClientSide())
        {
            AtomicReference<AbstractArrow> Projectile_1 = new AtomicReference<>();
            AtomicReference<AbstractArrow> Projectile_2 = new AtomicReference<>();
            AtomicReference<AbstractArrow> Projectile_3 = new AtomicReference<>();
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
                        Projectile_1.set(new RedPaintballArrowEntity(pLevel, pPlayer));
                        Projectile_2.set(new RedPaintballArrowEntity(pLevel, pPlayer));
                        Projectile_3.set(new RedPaintballArrowEntity(pLevel, pPlayer));
                    }
                    case BLUE -> {
                        Projectile_1.set(new BluePaintballArrowEntity(pLevel, pPlayer));
                        Projectile_2.set(new BluePaintballArrowEntity(pLevel, pPlayer));
                        Projectile_3.set(new BluePaintballArrowEntity(pLevel, pPlayer));
                    }
                    case GREEN -> {
                        Projectile_1.set(new GreenPaintballArrowEntity(pLevel, pPlayer));
                        Projectile_2.set(new GreenPaintballArrowEntity(pLevel, pPlayer));
                        Projectile_3.set(new GreenPaintballArrowEntity(pLevel, pPlayer));
                    }
                    case PINK ->
                    {
                        Projectile_1.set(new PinkPaintballArrowEntity(pLevel, pPlayer));
                        Projectile_2.set(new PinkPaintballArrowEntity(pLevel, pPlayer));
                        Projectile_3.set(new PinkPaintballArrowEntity(pLevel, pPlayer));
                    }
                    case MAGENTA ->
                    {
                        Projectile_1.set(new MagentaPaintballArrowEntity(pLevel, pPlayer));
                        Projectile_2.set(new MagentaPaintballArrowEntity(pLevel, pPlayer));
                        Projectile_3.set(new MagentaPaintballArrowEntity(pLevel, pPlayer));
                    }
                    case LIME ->
                    {
                        Projectile_1.set(new LimePaintballArrowEntity(pLevel, pPlayer));
                        Projectile_2.set(new LimePaintballArrowEntity(pLevel, pPlayer));
                        Projectile_3.set(new LimePaintballArrowEntity(pLevel, pPlayer));
                    }
                    case PURPLE ->
                    {
                        Projectile_1.set(new PurplePaintballArrowEntity(pLevel, pPlayer));
                        Projectile_2.set(new PurplePaintballArrowEntity(pLevel, pPlayer));
                        Projectile_3.set(new PurplePaintballArrowEntity(pLevel, pPlayer));
                    }
                    case LIGHT_BLUE ->
                    {
                        Projectile_1.set(new LightBluePaintballArrowEntity(pLevel, pPlayer));
                        Projectile_2.set(new LightBluePaintballArrowEntity(pLevel, pPlayer));
                        Projectile_3.set(new LightBluePaintballArrowEntity(pLevel, pPlayer));
                    }
                }

            });
            if(Weapon.getDamageValue() == 16)
            {
                return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
            }
            else
            {
                if(Projectile_1.get() != null)
                {
                    AbstractArrow Proj_1 = Projectile_1.get();
                    AbstractArrow Proj_2 = Projectile_2.get();
                    AbstractArrow Proj_3 = Projectile_3.get();
                    Proj_1.shootFromRotation(Player,Player.getXRot(),(Player.getYRot() - 16f),0f,1.5f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                    Proj_2.shootFromRotation(Player,Player.getXRot(),(Player.getYRot() + 0f),0f,1.5f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                    Proj_3.shootFromRotation(Player,Player.getXRot(),(Player.getYRot() + 16f),0f,1.5f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                    pLevel.addFreshEntity(Projectile_1.get());
                    pLevel.addFreshEntity(Projectile_2.get());
                    pLevel.addFreshEntity(Projectile_3.get());
                    pLevel.playSound(null,Player.blockPosition(), soundinit.SINGLE_SHOT.get(), SoundSource.PLAYERS,1f,1f);
                    int DV = Weapon.getDamageValue();
                    DV += 1;
                    Weapon.setDamageValue(DV);
                    Player.getCooldowns().addCooldown(Weapon.getItem(), 25);
                    return InteractionResultHolder.consume(Weapon);
                }
                else
                {
                    if(MCPaintball.DEV_MODE)
                    {
                        Projectile_1.set(new RedPaintballArrowEntity(pLevel,pPlayer));
                        Projectile_2.set(new RedPaintballArrowEntity(pLevel,pPlayer));
                        Projectile_3.set(new RedPaintballArrowEntity(pLevel,pPlayer));
                        AbstractArrow Proj_1 = Projectile_1.get();
                        AbstractArrow Proj_2 = Projectile_1.get();
                        AbstractArrow Proj_3 = Projectile_1.get();
                        Proj_1.shootFromRotation(Player,Player.getXRot(),(Player.getYRot() - 16f),0f,1.5f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                        Proj_2.shootFromRotation(Player,Player.getXRot(),(Player.getYRot() + 0f),0f,1.5f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                        Proj_3.shootFromRotation(Player,Player.getXRot(),(Player.getYRot() + 16f),0f,1.5f, MCPaintballConfig.SHOTGUN_INACCURACY.get().floatValue());
                        pLevel.addFreshEntity(Projectile_1.get());
                        pLevel.addFreshEntity(Projectile_2.get());
                        pLevel.addFreshEntity(Projectile_3.get());
                        pLevel.playSound(null,Player.blockPosition(), soundinit.SINGLE_SHOT.get(), SoundSource.PLAYERS,1f,1f);
                        Player.getCooldowns().addCooldown(Weapon.getItem(), 25);
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
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.shotgun_spec").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
        else
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.DARK_RED));
        }
    }
}

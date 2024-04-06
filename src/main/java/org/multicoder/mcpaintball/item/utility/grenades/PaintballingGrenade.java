package org.multicoder.mcpaintball.item.utility.grenades;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.entity.grenade.*;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;
import org.multicoder.mcpaintball.util.Teams;

import java.util.concurrent.atomic.AtomicReference;

public class PaintballingGrenade extends Item
{

    public PaintballingGrenade()
    {
        super(new Properties().tab(tabinit.Utility));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        if(!pLevel.isClientSide())
        {
            ServerPlayer Player = (ServerPlayer) pPlayer;
            ItemStack Grenade = Player.getItemInHand(pUsedHand);
            AtomicReference<ThrowableItemProjectile> GrenadeEntity = new AtomicReference<>();
            Player.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap -> {
                Teams Team = Teams.getTeam(cap.GetTeam());
                switch (Team)
                {
                    case NONE -> {return;}
                    case RED -> {GrenadeEntity.set(new RedGrenade(pPlayer,pLevel));}
                    case BLUE -> {GrenadeEntity.set(new BlueGrenade(pPlayer,pLevel));}
                    case GREEN -> {GrenadeEntity.set(new GreenGrenade(pPlayer,pLevel));}
                    case LIGHT_BLUE -> {GrenadeEntity.set(new LightBlueGrenade(pPlayer,pLevel));}
                    case PINK -> {GrenadeEntity.set(new PinkGrenade(pPlayer,pLevel));}
                    case LIME -> {GrenadeEntity.set(new LimeGrenade(pPlayer,pLevel));}
                    case PURPLE -> {GrenadeEntity.set(new PurpleGrenade(pPlayer,pLevel));}
                    case MAGENTA -> {GrenadeEntity.set(new MagentaGrenade(pPlayer,pLevel));}
                }
            });
            if(GrenadeEntity.get() != null)
            {
                ThrowableItemProjectile Proj = GrenadeEntity.get();
                Proj.shootFromRotation(Player,Player.getXRot(),Player.getYRot(),0f,3f,2.5f);
                pLevel.addFreshEntity(Proj);
                pLevel.playSound(null,Player.blockPosition(), soundinit.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                Grenade.shrink(1);
                Player.getCooldowns().addCooldown(Grenade.getItem(), 30);
                return InteractionResultHolder.consume(Grenade);
            }
            else
            {
                if(MCPaintball.DEV_MODE)
                {
                    GrenadeEntity.set(new RedGrenade(pPlayer,pLevel));
                    ThrowableItemProjectile Proj = GrenadeEntity.get();
                    Proj.shootFromRotation(Player,Player.getXRot(),Player.getYRot(),0f,3f,2.5f);
                    pLevel.addFreshEntity(Proj);
                    pLevel.playSound(null,Player.blockPosition(), soundinit.GRENADE.get(), SoundSource.PLAYERS,1f,1f);
                    Grenade.shrink(1);
                    Player.getCooldowns().addCooldown(Grenade.getItem(), 30);
                    return InteractionResultHolder.consume(Grenade);
                }
            }
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }
}

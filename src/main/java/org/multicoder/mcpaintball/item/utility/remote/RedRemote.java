package org.multicoder.mcpaintball.item.utility.remote;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import org.multicoder.mcpaintball.capability.PlayerTeamCapability;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.init.blockinit;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;
import org.multicoder.mcpaintball.network.Networking;
import org.multicoder.mcpaintball.network.packets.TeamPointS2CPacket;
import org.multicoder.mcpaintball.util.level.LevelUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RedRemote extends Item
{
    public RedRemote()
    {
        super(new Properties().tab(tabinit.main));
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        if(!pLevel.isClientSide())
        {
            ServerPlayer Shooter = (ServerPlayer) pPlayer;
            AtomicBoolean Team = new AtomicBoolean();
            LazyOptional<PlayerTeamCapability> Capability;
            Capability = Shooter.getCapability(PlayerTeamCapabilityProvider.CAPABILITY);
            Capability.ifPresent(cap -> {Team.set((cap.GetTeam() == 1));});
            if(Team.get())
            {
                CompoundTag tag = Shooter.getItemInHand(pUsedHand).getOrCreateTag();
                if(tag.contains("Targets") && Shooter.isCrouching())
                {
                    pLevel.playSound(null,Shooter.blockPosition(),soundinit.DET.get(),SoundSource.PLAYERS,0.5f,1f);
                    AtomicInteger Points = new AtomicInteger(0);
                    ListTag targets = tag.getList("Targets", Tag.TAG_STRING);
                    targets.forEach(target ->
                    {
                        String[] Vec = target.getAsString().split(",");
                        Explosion explosion = pLevel.explode(null,Double.parseDouble(Vec[0]),Double.parseDouble(Vec[1]),Double.parseDouble(Vec[2]),5f, Explosion.BlockInteraction.DESTROY);
                        LevelUtils.GetPointsFromExplosion(Points,explosion,Shooter);
                    });
                    Capability.ifPresent(cap ->
                    {
                        cap.AddPoints(Points.get());
                        Networking.sendToPlayer(new TeamPointS2CPacket(cap.GetPoints()),Shooter);
                    });

                }
                Shooter.getItemInHand(pUsedHand).setTag(null);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
    @Override
    public void appendHoverText(ItemStack pStack,Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if(Screen.hasShiftDown())
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.c4_remote_spec").withStyle(ChatFormatting.BOLD));
        }
        else
        {
            pTooltipComponents.add(new TranslatableComponent("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext)
    {
        ItemStack stack = pContext.getItemInHand();
        CompoundTag Tag = stack.getOrCreateTag();
        BlockPos Pos = pContext.getClickedPos();
        pContext.getPlayer().getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap -> {
            int Team = cap.GetTeam();
            if (Team == 1) {
                if (!pContext.getPlayer().isCrouching() && pContext.getLevel().getBlockState(Pos).getBlock() == blockinit.RED_EXPLOSIVE.get()) {
                    String Position = Pos.getX() + "," + Pos.getY() + "," + Pos.getZ();
                    if (Tag.contains("Targets")) {
                        ListTag Targets = Tag.getList("Targets", 8);
                        StringTag T = StringTag.valueOf(Position);
                        if (Targets.contains(T)) {
                            pContext.getLevel().playSound(null, pContext.getPlayer().blockPosition(), soundinit.REM.get(), SoundSource.PLAYERS, 0.5f, 1f);
                            Targets.remove(T);
                            Tag.put("Targets", Targets);
                        } else {
                            pContext.getLevel().playSound(null, pContext.getPlayer().blockPosition(), soundinit.SET.get(), SoundSource.PLAYERS, 0.5f, 1f);
                            Targets.add(T);
                            Tag.put("Targets", Targets);
                        }
                    } else {
                        pContext.getLevel().playSound(null, pContext.getPlayer().blockPosition(), soundinit.SET.get(), SoundSource.PLAYERS, 0.5f, 1f);
                        ListTag Targets = new ListTag();
                        Targets.add(StringTag.valueOf(Position));
                        Tag.put("Targets", Targets);
                    }
                }
                stack.setTag(Tag);
            }
        });
        return super.useOn(pContext);
    }
}

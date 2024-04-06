package org.multicoder.mcpaintball.item.utility.remote;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.block.Block;
import net.minecraftforge.gametest.BlockPosValueConverter;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.init.blockinit;
import org.multicoder.mcpaintball.init.soundinit;
import org.multicoder.mcpaintball.init.tabinit;
import org.multicoder.mcpaintball.util.MCPaintballUtilities;
import org.multicoder.mcpaintball.util.player.TeamUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LightBlueRemote extends Item
{
    public LightBlueRemote()
    {
        super(new Properties().tab(tabinit.Utility));
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        ItemStack item = player.getItemInHand(hand);
        if(!level.isClientSide)
        {
            ServerLevel serverLevel = (ServerLevel) level;
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if(TeamUtils.IsTeam(serverPlayer,8) || MCPaintball.DEV_MODE)
            {
                CompoundTag tag = item.getOrCreateTag();
                if(tag.contains("Targets") && serverPlayer.isCrouching())
                {
                    AtomicInteger Points = new AtomicInteger();
                    ListTag Targets = tag.getList("Targets",Tag.TAG_STRING);
                    if(Targets.size() == 0)
                    {
                        return super.use(level, player, hand);
                    }
                    Targets.forEach(position ->
                    {
                        BlockPosValueConverter blockPosValueConverter = new BlockPosValueConverter();
                        BlockPos Target = blockPosValueConverter.convert(position.getAsString());
                        if(serverLevel.getBlockState(Target).getBlock() == blockinit.LIGHT_BLUE_EXPLOSIVE.get())
                        {
                            Explosion exp = serverLevel.explode(serverPlayer,Target.getX(),Target.getY(),Target.getZ(),5f, Explosion.BlockInteraction.DESTROY);
                            MCPaintballUtilities.LevelUtils.GetPointsFromExplosion(Points,exp,serverPlayer);
                        }
                        else
                        {
                            serverPlayer.displayClientMessage(new TextComponent("One or more C4 blocks were destroyed").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED),true);
                        }
                    });
                    serverPlayer.getCapability(PlayerTeamCapabilityProvider.CAPABILITY).ifPresent(cap ->
                    {
                        cap.AddPoints(Points.get());
                    });
                    serverLevel.playSound(null,serverPlayer.blockPosition(),soundinit.DET.get(),SoundSource.PLAYERS,1f,1f);
                }
                item.setTag(null);
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos position = context.getClickedPos();
        Block hit = level.getBlockState(position).getBlock();
        ItemStack item = context.getItemInHand();
        if(!level.isClientSide)
        {
            ServerLevel serverLevel = (ServerLevel) level;
            ServerPlayer serverPlayer = (ServerPlayer) player;
                if((TeamUtils.IsTeam(serverPlayer,8) && hit == blockinit.LIGHT_BLUE_EXPLOSIVE.get()) || (MCPaintball.DEV_MODE && hit == blockinit.LIGHT_BLUE_EXPLOSIVE.get()))
            {
                CompoundTag tag = item.getOrCreateTag();
                boolean HasList = tag.contains("Targets");
                if(!HasList)
                {
                    ListTag Targets = new ListTag();
                    StringTag Position = StringTag.valueOf(position.toShortString());
                    Targets.add(Position);
                    tag.put("Targets",Targets);
                    item.setTag(tag);
                    serverLevel.playSound(null,serverPlayer.blockPosition(),soundinit.SET.get(),SoundSource.PLAYERS,1f,1f);
                }
                else
                {
                    ListTag Targets = tag.getList("Targets",Tag.TAG_STRING);
                    StringTag Position = StringTag.valueOf(position.toShortString());
                    if(Targets.contains(Position))
                    {
                        Targets.remove(Position);
                        serverLevel.playSound(null,serverPlayer.blockPosition(),soundinit.REM.get(),SoundSource.PLAYERS,1f,1f);
                    }
                    else
                    {
                        Targets.add(Position);
                        serverLevel.playSound(null,serverPlayer.blockPosition(),soundinit.SET.get(),SoundSource.PLAYERS,1f,1f);
                    }
                    tag.put("Targets",Targets);
                    item.setTag(tag);
                }
            }
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
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
}

package org.multicoder.mcpaintball.common.item.utility;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.RemoteUtility;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.config.MCPaintballConfig;
import org.multicoder.mcpaintball.common.init.soundinit;
import org.multicoder.mcpaintball.common.util.enums.Teams;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("all")
public class PaintballRemote extends Item {
    public Teams Team;

    public PaintballRemote(Teams In) {
        super(new Properties());
        Team = In;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("text.mcpaintball.c4_remote").withStyle(ChatFormatting.BOLD));
        } else {
            pTooltipComponents.add(Component.translatable("text.mcpaintball.press_shift").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        try{
            if (!level.isClientSide()) {
                if (player.isCrouching()) {
                    PaintballPlayer PPlayer = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                    if (Objects.equals(Team, PPlayer.Team)) {
                        CompoundTag nbt = player.getItemInHand(hand).getTag();
                        List<BlockPos> Targets = RemoteUtility.HandleDetonation(level, player.getItemInHand(hand), PPlayer.Team);
                        if (Objects.nonNull(Targets)) {
                            AtomicInteger Points = new AtomicInteger(0);
                            Targets.forEach(pos ->
                            {
                                Explosion Ex;
                                if (MCPaintballConfig.EXPLODE_BLOCKS.get()) {
                                    Ex = level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 2.5f, Level.ExplosionInteraction.TNT);
                                } else {
                                    Ex = level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 2.5f, Level.ExplosionInteraction.NONE);
                                    level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                                }
                                Ex.getHitPlayers().keySet().forEach(hit ->
                                {
                                    if (!Objects.equals(hit.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get().Team, Team)) {
                                        Points.getAndIncrement();
                                    }
                                });
                            });
                            PPlayer.Points += Points.get();
                            level.playSound(null, player.blockPosition(), soundinit.DET.get(), SoundSource.PLAYERS, 1f, 1f);
                            player.getItemInHand(hand).setTag(new CompoundTag());
                        }
                    }
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
        return super.use(level, player, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        try{
            Level level = context.getLevel();
            if (!level.isClientSide()) {
                Player player = context.getPlayer();
                PaintballPlayer PPlayer = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                if (Objects.equals(PPlayer.Team, Team)) {
                    BlockState Hit = level.getBlockState(context.getClickedPos());
                    RemoteUtility.HandleRemote(level, player, player.getItemInHand(context.getHand()), Team, Hit, context.getClickedPos());
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
        return InteractionResult.CONSUME;
    }
}

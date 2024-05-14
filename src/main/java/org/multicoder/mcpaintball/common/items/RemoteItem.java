package org.multicoder.mcpaintball.common.items;

import com.mojang.blaze3d.platform.ScreenManager;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.multicoder.mcpaintball.common.MCPaintballSounds;
import org.multicoder.mcpaintball.common.blocks.MCPaintballBlocks;
import org.multicoder.mcpaintball.common.data.MCPaintballWorldData;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.data.capability.PaintballPlayerProvider;

import java.rmi.AccessException;

public class RemoteItem extends Item
{
    public RemoteItem() {
        super(new Properties().setNoRepair().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        if(!level.isClientSide() && Screen.hasShiftDown())
        {
            ItemStack stack = player.getItemInHand(hand);
            CompoundTag nbt = stack.getOrCreateTag();
            if(nbt.contains("Targets"))
            {
                ListTag Targets = nbt.getList("Targets",Tag.TAG_LONG);
                Targets.forEach(pos ->
                {
                    LongTag T = (LongTag) pos;
                    BlockPos p = BlockPos.of(T.getAsLong());
                    if(level.getBlockState(p).getBlock() != Blocks.AIR)
                    {
                        level.explode(player,p.getX(),p.getY(),p.getZ(),5f, Level.ExplosionInteraction.TNT);
                    }
                });
                stack.setTag(new CompoundTag());
                level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_EXPLODE.get(),SoundSource.PLAYERS,1f,1f);
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
        ItemStack stack = context.getItemInHand();
        CompoundTag nbt = stack.getOrCreateTag();
        if(!level.isClientSide())
        {
            PaintballPlayer Cap = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
            try {
                if(MCPaintballWorldData.INSTANCE.StartedByName(Cap.getName(RemoteItem.class), RemoteItem.class))
                {
                    Block Ref = null;
                    switch (Cap.GetTeam(RemoteItem.class))
                    {
                        case RED -> Ref = MCPaintballBlocks.RED_EXPLOSIVE.get();
                        case BLUE -> Ref = MCPaintballBlocks.BLUE_EXPLOSIVE.get();
                        case GREEN -> Ref = MCPaintballBlocks.GREEN_EXPLOSIVE.get();
                        case CYAN -> Ref = MCPaintballBlocks.CYAN_EXPLOSIVE.get();
                        case MAGENTA -> Ref = MCPaintballBlocks.MAGENTA_EXPLOSIVE.get();
                        case YELLOW -> Ref = MCPaintballBlocks.YELLOW_EXPLOSIVE.get();
                        case LIME -> Ref = MCPaintballBlocks.LIME_EXPLOSIVE.get();
                        case LIGHT_BLUE -> Ref = MCPaintballBlocks.LIGHT_BLUE_EXPLOSIVE.get();
                        case PINK -> Ref = MCPaintballBlocks.PINK_EXPLOSIVE.get();
                        case PURPLE -> Ref = MCPaintballBlocks.PURPLE_EXPLOSIVE.get();
                    }
                    if(level.getBlockState(position).getBlock() == Ref)
                    {
                        ListTag Targets = new ListTag();
                        LongTag T = LongTag.valueOf(position.asLong());
                        if(nbt.contains("Targets"))
                        {
                            Targets = nbt.getList("Targets", Tag.TAG_LONG);
                            if(Targets.contains(T))
                            {
                                Targets.remove(Targets.indexOf(T));
                                level.playSound(null,player.blockPosition(), MCPaintballSounds.C4_REMOVED.get(), SoundSource.PLAYERS,1f,1f);
                            }
                            else
                            {
                                Targets.add(T);
                                level.playSound(null,player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS,1f,1f);
                            }
                        }
                        else
                        {
                            Targets.add(T);
                            level.playSound(null,player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.PLAYERS,1f,1f);
                        }
                        nbt.put("Targets",Targets);
                        stack.setTag(nbt);
                    }
                }
            } catch (AccessException e) {}
        }
        return super.useOn(context);
    }
}

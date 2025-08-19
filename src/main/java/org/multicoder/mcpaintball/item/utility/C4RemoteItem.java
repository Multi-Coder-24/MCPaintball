package org.multicoder.mcpaintball.item.utility;

import net.minecraft.core.BlockPos;
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
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.init.MCPaintballBlocks;
import org.multicoder.mcpaintball.data.component.ItemTeamDataComponent;
import org.multicoder.mcpaintball.init.MCPaintballDataComponents;
import org.multicoder.mcpaintball.data.component.RemoteDetonatorList;
import org.multicoder.mcpaintball.init.MCPaintballSounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class C4RemoteItem extends Item {
    public C4RemoteItem(int Team) {
        super(new Properties().stacksTo(1).component(MCPaintballDataComponents.ITEM_TEAM,new ItemTeamDataComponent(Team)));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand usedHand)
    {
        if(!level.isClientSide){
            if(player.isShiftKeyDown()){
                ItemStack Stack = player.getItemInHand(usedHand);
                if(Stack.has(MCPaintballDataComponents.REMOTE_DETONATOR.get())){
                    List<BlockPos> blockPosList = Objects.requireNonNull(Stack.get(MCPaintballDataComponents.REMOTE_DETONATOR.get())).positions();
                    blockPosList.forEach(blockPos ->{
                        level.explode(null,blockPos.getX(),blockPos.getY(),blockPos.getZ(),5F, Level.ExplosionInteraction.NONE);
                        level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
                    });
                    level.playSound(null,player.blockPosition(),MCPaintballSounds.C4_DETONATED.get(),SoundSource.PLAYERS,1F,1F);
                }
                Stack.remove(MCPaintballDataComponents.REMOTE_DETONATOR.get());
            }
        }
        return super.use(level, player, usedHand);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context)
    {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos blockPos = context.getClickedPos();
        ItemStack Stack = context.getItemInHand();
        if(!level.isClientSide && player != null)
        {
            List<BlockPos> Positions;
            try{
                Positions = Objects.requireNonNull(Stack.get(MCPaintballDataComponents.REMOTE_DETONATOR.get())).positions();
            }catch(Exception e){
                Positions = new ArrayList<>();
            }
            Block block = level.getBlockState(blockPos).getBlock();
            switch(Objects.requireNonNull(Stack.get(MCPaintballDataComponents.ITEM_TEAM.get())).team())
            {
                case 0:
                    return super.useOn(context);
                case 1:
                    if(block == MCPaintballBlocks.RED_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos, Positions);
                    }
                    break;
                case 2:
                    if(block == MCPaintballBlocks.GREEN_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos, Positions);
                    }
                    break;
                case 3:
                    if(block == MCPaintballBlocks.BLUE_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos, Positions);
                    }
                    break;
                case 4:
                    if(block == MCPaintballBlocks.CYAN_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos, Positions);
                    }
                    break;
                case 5:
                    if(block == MCPaintballBlocks.MAGENTA_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos, Positions);
                    }
                    break;
                case 6:
                    if(block == MCPaintballBlocks.YELLOW_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos, Positions);
                    }
                    break;
                case 7:
                    if(block == MCPaintballBlocks.LIME_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos, Positions);
                    }
                    break;
                case 8:
                    if(block == MCPaintballBlocks.LIGHT_BLUE_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos, Positions);
                    }
                    break;
                case 9:
                    if(block == MCPaintballBlocks.PINK_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos,  Positions);
                    }
                    break;
                case 10:
                    if(block == MCPaintballBlocks.WHITE_C4_EXPLOSIVE.get())
                    {
                        Positions = HandleRemote(level, player, blockPos, Positions);
                    }
                    break;
            }
            Stack.set(MCPaintballDataComponents.REMOTE_DETONATOR.get(),new RemoteDetonatorList(Positions));
        }
        return super.useOn(context);
    }

    private List<BlockPos> HandleRemote(Level level, Player player, BlockPos blockPos, List<BlockPos> positions) {
        BlockPos[] arr = positions.toArray(BlockPos[]::new);
        ArrayList<BlockPos> list = new ArrayList<>(Arrays.asList(arr));
        if(positions.contains(blockPos))
        {
            list.remove(blockPos);
            positions = list;
            level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_REMOVED.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
        }
        else{
            list.add(blockPos);
            positions = list;
            level.playSound(null, player.blockPosition(), MCPaintballSounds.C4_ADDED.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
        }
        return positions;
    }
}

package org.multicoder.mcpaintball.block.explosive_station;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.init.blockinit;
import org.multicoder.mcpaintball.init.iteminit;
import org.multicoder.mcpaintball.util.MCPaintballUtilities;
import org.multicoder.mcpaintball.util.player.TeamUtils;

public class GreenExplosiveStation extends Block
{

    public GreenExplosiveStation()
    {
        super(Properties.of(Material.HEAVY_METAL));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        return makeShape();
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit)
    {
        if(!pLevel.isClientSide())
        {
            ServerPlayer SP = (ServerPlayer) pPlayer;
            if(TeamUtils.IsTeam(SP,2))
            {
                if(MCPaintballUtilities.ClassUtils.IsStandardClass(SP))
                {
                    SP.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),16),true);
                } else if (MCPaintballUtilities.ClassUtils.IsMedicalClass(SP))
                {
                    SP.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),16),true);
                } else if (MCPaintballUtilities.ClassUtils.IsHeavyClass(SP))
                {
                    SP.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),16),true);
                    SP.drop(new ItemStack(blockinit.GREEN_EXPLOSIVE.get(),16),true);
                } else if (MCPaintballUtilities.ClassUtils.IsTraineeClass(SP))
                {
                    SP.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),16),true);
                    SP.drop(new ItemStack(blockinit.GREEN_EXPLOSIVE.get(),16),true);
                }
                else
                {
                    return InteractionResult.FAIL;
                }
                return InteractionResult.CONSUME;
            } else if (MCPaintball.DEV_MODE)
            {
                SP.drop(new ItemStack(iteminit.PAINTBALL_GRENADE.get(),16),true);
                SP.drop(new ItemStack(blockinit.GREEN_EXPLOSIVE.get(),16),true);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.FAIL;
    }

    public VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.0625, 0.9375, 0.5625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.5875, 0.04375, 0.9375, 0.7125, 0.91875), BooleanOp.OR);

        return shape;
    }
}

package org.multicoder.mcpaintball.block.pods;

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
import org.multicoder.mcpaintball.init.iteminit;
import org.multicoder.mcpaintball.util.MCPaintballUtilities;
import org.multicoder.mcpaintball.util.player.TeamUtils;

public class MagentaAmmoPod extends Block
{
    public VoxelShape makeShape(){VoxelShape shape = Shapes.empty();shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 0.125, 1), BooleanOp.OR);shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.375, 0.625, 1, 0.625), BooleanOp.OR);return shape;}
    public MagentaAmmoPod()
    {
        super(Properties.of(Material.HEAVY_METAL));
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {return makeShape();}


    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult result)
    {
        if(!level.isClientSide())
        {
            ServerPlayer Player = (ServerPlayer) player;
            if(TeamUtils.IsTeam(Player,4))
            {
                if(MCPaintballUtilities.ClassUtils.IsStandardClass(Player)) {
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                } else if (MCPaintballUtilities.ClassUtils.IsMedicalClass(Player)) {
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_SHELL.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                } else if (MCPaintballUtilities.ClassUtils.IsHeavyClass(Player)) {
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                } else if (MCPaintballUtilities.ClassUtils.IsTraineeClass(Player)) {
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_HEAVY.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                    Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_SHELL.get(),64),true);
                }
                else {
                    return InteractionResult.FAIL;
                }
                return InteractionResult.CONSUME;
            } else if (MCPaintball.DEV_MODE)
            {
                Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_HEAVY.get(),64),true);
                Player.drop(new ItemStack(iteminit.MAGENTA_AMMO.get(),64),true);
                Player.drop(new ItemStack(iteminit.MAGENTA_AMMO_SHELL.get(),64),true);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.FAIL;
    }
}

package org.multicoder.mcpaintball.common.item.utility;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;
import org.multicoder.mcpaintball.common.util.enums.Teams;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

import java.util.Objects;

@SuppressWarnings("all")
public class MedkitItem extends Item {
    public Teams Team;

    public MedkitItem(Teams In) {
        super(new Properties());
        Team = In;
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        try{
            if (!level.isClientSide()) {
                ServerPlayer SP = (ServerPlayer) player;
                PaintballPlayer PPlayer = SP.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
                if (Objects.equals(Team, PPlayer.Team)) {
                    if (!Objects.equals(player.getHealth(), 20f)) {
                        SP.heal(2.5f);
                        SP.getItemInHand(hand).shrink(1);
                        return InteractionResultHolder.consume(player.getItemInHand(hand));
                    }
                } else {
                    return InteractionResultHolder.fail(player.getItemInHand(hand));
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
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}

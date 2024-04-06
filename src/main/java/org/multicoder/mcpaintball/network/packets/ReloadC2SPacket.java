package org.multicoder.mcpaintball.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.capability.PlayerTeamCapabilityProvider;
import org.multicoder.mcpaintball.util.Teams;
import org.multicoder.mcpaintball.util.player.PlayerUtils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class ReloadC2SPacket
{
    public ReloadC2SPacket() {}
    public ReloadC2SPacket(FriendlyByteBuf buffer){}

    public void toBytes(FriendlyByteBuf buffer){}

    public boolean handlePacket(Supplier<NetworkEvent.Context> supplier)
    {
        NetworkEvent.Context ctx = supplier.get();
        ServerPlayer player = ctx.getSender();
        ItemStack Held = player.getItemInHand(InteractionHand.MAIN_HAND);
        if(MCPaintball.DEV_MODE || player.isCreative())
        {
           Held.setDamageValue(0);
        }
        else
        {
            PlayerUtils.ReloadManager.Reload(player,Held);
        }
        return true;
    }
}

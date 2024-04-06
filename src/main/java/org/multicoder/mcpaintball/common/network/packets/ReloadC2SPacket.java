package org.multicoder.mcpaintball.common.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.player.ReloadWeaponManager;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

import java.util.function.Supplier;

@SuppressWarnings("all")
public class ReloadC2SPacket {
    public ReloadC2SPacket() {
    }

    public ReloadC2SPacket(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public void HandlePacket(Supplier<NetworkEvent.Context> supplier)
    {
        try
        {
            ServerLevel Level = supplier.get().getSender().getLevel();
            ServerPlayer Player = supplier.get().getSender();
            ItemStack Held = Player.getItemInHand(InteractionHand.MAIN_HAND);
            ReloadWeaponManager.ReloadWeapon(Player, Held);
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
    }
}

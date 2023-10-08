package org.multicoder.mcpaintball.common.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.network.CustomPayloadEvent;
import net.minecraftforge.network.NetworkContext;
import org.multicoder.mcpaintball.client.player.ReloadWeaponManager;

import java.util.function.Supplier;

@SuppressWarnings("all")
public class ReloadC2SPacket {
    public ReloadC2SPacket() {
    }

    public ReloadC2SPacket(FriendlyByteBuf buf) {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public void HandlePacket(CustomPayloadEvent.Context context)
    {
        ServerLevel Level = context.getSender().serverLevel();
        ServerPlayer Player = context.getSender();
        ItemStack Held = Player.getItemInHand(InteractionHand.MAIN_HAND);
        ReloadWeaponManager.ReloadWeapon(Player, Held);
    }
}

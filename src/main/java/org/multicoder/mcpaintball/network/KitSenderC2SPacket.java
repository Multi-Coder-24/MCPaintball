package org.multicoder.mcpaintball.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.KitHandler;
import org.multicoder.mcpaintball.util.PaintballRole;
import org.multicoder.mcpaintball.util.PaintballTeam;


public record KitSenderC2SPacket() implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"kit_sender");
    public static final Type<KitSenderC2SPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, KitSenderC2SPacket> STREAM_CODEC = StreamCodec.unit(new KitSenderC2SPacket());
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(KitSenderC2SPacket ignored, ServerPlayNetworking.Context context) {
        if(MCPaintballGameEvents.INSTANCE.matchStarted && !MCPaintballGameEvents.INSTANCE.roundStarted){
            ServerPlayer player = context.player();
            MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            KitHandler.grantKit(player, PaintballTeam.values()[data.team], PaintballRole.values()[data.role]);
        }
    }
}

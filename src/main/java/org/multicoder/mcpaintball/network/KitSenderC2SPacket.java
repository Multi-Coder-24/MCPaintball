package org.multicoder.mcpaintball.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.KitHandler;
import org.multicoder.mcpaintball.util.PaintballRole;
import org.multicoder.mcpaintball.util.PaintballTeam;


public record KitSenderC2SPacket() implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"kit_sender");
    public static final Type<KitSenderC2SPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, KitSenderC2SPacket> STREAM_CODEC = StreamCodec.unit(new KitSenderC2SPacket());
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(KitSenderC2SPacket ignored, IPayloadContext context) {
        if(MCPaintballGameEvents.INSTANCE.MatchStarted && !MCPaintballGameEvents.INSTANCE.RoundStarted){
            ServerPlayer player = (ServerPlayer) context.player();
            MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            KitHandler.grantKit(player, PaintballTeam.values()[data.Team], PaintballRole.values()[data.Role]);
        }
    }
}

package org.multicoder.mcpaintball.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.RoleCheck;


public record RoleSelectC2SPacket(int Role) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"role_select");
    public static final Type<RoleSelectC2SPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, RoleSelectC2SPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, RoleSelectC2SPacket::Role,
            RoleSelectC2SPacket::new);
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(RoleSelectC2SPacket packet, ServerPlayNetworking.Context context) {
        if(MCPaintballGameEvents.INSTANCE.tournamentStarted && !MCPaintballGameEvents.INSTANCE.roundStarted){
            ServerPlayer player = context.player();
            MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            if(data.team == 0) {
                player.sendSystemMessage(Component.translatable("text.mcpaintball.set_team"));
            }
            else {
                if(packet.Role == 1 && RoleCheck.checkCaptainRole(context.server())){
                    player.sendSystemMessage(Component.translatable("text.mcpaintball.one_captain"));
                }else {
                    data.role = packet.Role;
                    player.setAttached(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
                    ServerPlayNetworking.send(player,new DataSyncS2CPacket(player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                }

            }
        }
    }
}

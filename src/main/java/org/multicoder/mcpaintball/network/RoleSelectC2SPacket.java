package org.multicoder.mcpaintball.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.event.MCPaintballGameEvents;
import org.multicoder.mcpaintball.util.RoleCheck;

@SuppressWarnings("unused")
public record RoleSelectC2SPacket(int Role) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"role_select");
    public static final Type<RoleSelectC2SPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, RoleSelectC2SPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, RoleSelectC2SPacket::Role,
            RoleSelectC2SPacket::new);
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(RoleSelectC2SPacket packet, IPayloadContext context) {
        if(MCPaintballGameEvents.INSTANCE.MatchStarted && !MCPaintballGameEvents.INSTANCE.RoundStarted){
            ServerPlayer player = (ServerPlayer) context.player();
            MCPaintballPlayerData data = player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER);
            if(data.Team == 0) {
                player.sendSystemMessage(Component.translatable("text.mcpaintball.set_team"));
            }
            else {
                if(packet.Role == 1 && RoleCheck.checkCaptainRole(player.level().getServer())){
                    player.sendSystemMessage(Component.translatable("text.mcpaintball.one_captain"));
                }else {
                    data.Role = packet.Role;
                    player.setData(MCPaintballDataAttachments.PAINTBALL_PLAYER,data);
                    PacketDistributor.sendToPlayer(player,new DataSyncS2CPacket(player.getData(MCPaintballDataAttachments.PAINTBALL_PLAYER)));
                }

            }
        }
    }
}

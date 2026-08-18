
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
import org.multicoder.mcpaintball.util.KitHandler;
import org.multicoder.mcpaintball.util.PaintballRole;
import org.multicoder.mcpaintball.util.PaintballTeam;


public record GiveKitC2SPacket() implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"give_kit");
    public static final StreamCodec<RegistryFriendlyByteBuf,GiveKitC2SPacket> STREAM_CODEC = StreamCodec.unit(new GiveKitC2SPacket());
    public static final Type<GiveKitC2SPacket> TYPE = new Type<>(ID);@Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(GiveKitC2SPacket ignored, ServerPlayNetworking.Context context) {
        ServerPlayer player = context.player();
        MCPaintballPlayerData data = player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
        PaintballTeam team = PaintballTeam.values()[data.team];
        PaintballRole role = PaintballRole.values()[data.role];
        KitHandler.grantKit(player, team, role);
    }
}

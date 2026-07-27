package org.multicoder.mcpaintball.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.data.MCPaintballGrenadeLauncherSetting;

public record CycleGLTypeC2SPacket(int Setting) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"gl_sync");
    public static final CustomPacketPayload.Type<CycleGLTypeC2SPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,CycleGLTypeC2SPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,CycleGLTypeC2SPacket::Setting,CycleGLTypeC2SPacket::new);
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void HandlePacket(CycleGLTypeC2SPacket packet, ServerPlayNetworking.Context context) {
        int T = packet.Setting;
        ServerPlayer player = context.player();
        if(T == 1){
            T = 2;
            player.sendSystemMessage(Component.translatable("text.mcpaintball.gl_smoke"));
        }else if(T == 2) {
            T = 3;
            player.sendSystemMessage(Component.translatable("text.mcpaintball.gl_emp"));
        }else if(T == 3) {
            T = 4;
            player.sendSystemMessage(Component.translatable("text.mcpaintball.gl_sight"));
        }else if(T == 4) {
            T = 1;
            player.sendSystemMessage(Component.translatable("text.mcpaintball.gl_default"));
        }
        context.player().getItemInHand(InteractionHand.MAIN_HAND).set(MCPaintballDataComponents.SETTING,new MCPaintballGrenadeLauncherSetting(T));
    }
}

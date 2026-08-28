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

public record CycleGLTypeC2SPacket(int setting) implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"gl_sync");
    public static final Type<CycleGLTypeC2SPacket> TYPE = new Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,CycleGLTypeC2SPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT,CycleGLTypeC2SPacket::setting,CycleGLTypeC2SPacket::new);
    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handlePacket(CycleGLTypeC2SPacket packet, ServerPlayNetworking.Context context) {
        int i = packet.setting;
        ServerPlayer player = context.player();
        if(i == 4){
            i = 1;
        }else{
            i++;
        }
        player.sendSystemMessage(fetchFromSetting(i));
        context.player().getItemInHand(InteractionHand.MAIN_HAND).set(MCPaintballDataComponents.SETTING,new MCPaintballGrenadeLauncherSetting(i));
    }

    public static Component fetchFromSetting(int setting) {
        return switch (setting){
            case 1 -> Component.translatable("text.mcpaintball.gl_default");
            case 2 -> Component.translatable("text.mcpaintball.gl_smoke");
            case 3 -> Component.translatable("text.mcpaintball.gl_emp");
            case 4 -> Component.translatable("text.mcpaintball.gl_sight");
            default -> throw new IllegalStateException("Unexpected value: " + setting);
        };
    }
}

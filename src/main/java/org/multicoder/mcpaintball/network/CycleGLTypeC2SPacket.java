package org.multicoder.mcpaintball.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.data.MCPaintballGrenadeLauncherSetting;

public record CycleGLTypeC2SPacket(int Setting) implements CustomPacketPayload {

    public static final Identifier ID = Identifier.fromNamespaceAndPath(MCPaintball.MODID,"gl_sync");
    public static final CustomPacketPayload.Type<CycleGLTypeC2SPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf,CycleGLTypeC2SPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,CycleGLTypeC2SPacket::Setting,
            CycleGLTypeC2SPacket::new
    );


    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void HandlePacket(CycleGLTypeC2SPacket packet, IPayloadContext context) {
        int setting = packet.Setting;
        ServerPlayer player = (ServerPlayer) context.player();
        ItemStack held = player.getMainHandItem();
        if(held.getItem() == MCPaintballItems.GRENADE_LAUNCHER.value()){
            if(setting == 1){
                setting = 2;
                player.sendSystemMessage(Component.translatable("text.mcpaintball.gl_smoke"));
            }else if(setting == 2){
                setting = 1;
                player.sendSystemMessage(Component.translatable("text.mcpaintball.gl_default"));
            }
            held.set(MCPaintballDataComponents.SETTING,new MCPaintballGrenadeLauncherSetting(setting));
        }
    }
}

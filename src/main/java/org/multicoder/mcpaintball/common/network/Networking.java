package org.multicoder.mcpaintball.common.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.*;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.network.packets.ReloadC2SPacket;
import org.multicoder.mcpaintball.common.network.packets.TeamDataSyncS2CPacket;

public class Networking {
    private static SimpleChannel INSTANCE;
    private static int id = 0;

    private static int ID() {
        return id++;
    }

    public static void Register() {
        //Create Channel
        SimpleChannel net = ChannelBuilder.named(new ResourceLocation(MCPaintball.MOD_ID, "messsage")).networkProtocolVersion(1).clientAcceptedVersions(Channel.VersionTest.exact(1))
                .serverAcceptedVersions(Channel.VersionTest.exact(1)).simpleChannel();

        //Assign Instance to created channel
        INSTANCE = net;

        //Register Packets
        net.messageBuilder(TeamDataSyncS2CPacket.class, ID(), NetworkDirection.PLAY_TO_CLIENT).decoder(TeamDataSyncS2CPacket::new).encoder(TeamDataSyncS2CPacket::toBytes).consumerMainThread(TeamDataSyncS2CPacket::HandlePacket).add();
        net.messageBuilder(ReloadC2SPacket.class, ID(), NetworkDirection.PLAY_TO_SERVER).decoder(ReloadC2SPacket::new).encoder(ReloadC2SPacket::toBytes).consumerMainThread(ReloadC2SPacket::HandlePacket).add();
    }

    public static <MSG> void SendToServer(MSG message) {
        INSTANCE.send(message,PacketDistributor.SERVER.with(null));
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(message,PacketDistributor.PLAYER.with(player));
    }
}

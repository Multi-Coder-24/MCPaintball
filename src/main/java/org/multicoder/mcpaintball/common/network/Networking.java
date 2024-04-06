package org.multicoder.mcpaintball.common.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.network.packets.ReloadC2SPacket;
import org.multicoder.mcpaintball.common.network.packets.TeamDataSyncS2CPacket;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

public class Networking {
    private static SimpleChannel INSTANCE;
    private static int id = 0;

    private static int ID() {
        return id++;
    }

    public static void Register()
    {
        try{
            //Create Channel
            SimpleChannel net = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(MCPaintball.MOD_ID, "messsage")).networkProtocolVersion(() -> "1.0.0").clientAcceptedVersions(s -> true)
                    .serverAcceptedVersions(s -> true).simpleChannel();

            //Assign Instance to created channel
            INSTANCE = net;

            //Register Packets
            net.messageBuilder(TeamDataSyncS2CPacket.class, ID(), NetworkDirection.PLAY_TO_CLIENT).decoder(TeamDataSyncS2CPacket::new).encoder(TeamDataSyncS2CPacket::toBytes).consumerMainThread(TeamDataSyncS2CPacket::HandlePacket).add();
            net.messageBuilder(ReloadC2SPacket.class, ID(), NetworkDirection.PLAY_TO_SERVER).decoder(ReloadC2SPacket::new).encoder(ReloadC2SPacket::toBytes).consumerMainThread(ReloadC2SPacket::HandlePacket).add();
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }

    public static <MSG> void SendToServer(MSG message)
    {
        try{
            INSTANCE.sendToServer(message);
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player)
    {
        try{
            INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
        }
        catch(Exception e) {
            MCPaintball.LOG_ERROR.throwing(e);
            try {
                ErrorLogGenerator.Generate(e);
            } catch (Exception ex) {
            }
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }
}

package org.multicoder.mcpaintball.common.networking;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.multicoder.mcpaintball.common.data.PaintballOverlay;

@SuppressWarnings("all")
public class TeamDataSyncPayloadHandler
{
    public static final TeamDataSyncPayloadHandler INSTANCE = new TeamDataSyncPayloadHandler();

    public static void Handle(final TeamsDataSyncPacket packet, final PlayPayloadContext context)
    {
        PaintballOverlay.PClass = packet.PClass();
        PaintballOverlay.PTeam = packet.PTeam();
        PaintballOverlay.TPoints = packet.Points();
    }
}

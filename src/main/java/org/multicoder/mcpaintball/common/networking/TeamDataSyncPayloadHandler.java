package org.multicoder.mcpaintball.common.networking;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.multicoder.mcpaintball.common.data.PaintballOverlay;

@SuppressWarnings("all")
public class TeamDataSyncPayloadHandler
{
    public static final TeamDataSyncPayloadHandler INSTANCE = new TeamDataSyncPayloadHandler();

    public static void Handle(final TeamsDataSyncPacket packet, final PlayPayloadContext context)
    {
        PaintballOverlay.Class = packet.PClass();
        PaintballOverlay.Team = packet.PTeam();
        PaintballOverlay.Points = packet.Points();
        PaintballOverlay.Type = packet.Type();
    }
}

package org.multicoder.mcpaintball.networking;

import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.multicoder.mcpaintball.data.PaintballOverlay;

@SuppressWarnings("all")
public class TeamDataSyncPayloadHandler
{

    public static void Handle(final TeamsDataSyncPacket packet, PlayPayloadContext context)
    {
        PaintballOverlay.Class = packet.PClass();
        PaintballOverlay.Team = packet.PTeam();
        PaintballOverlay.Points = packet.Points();
    }
}

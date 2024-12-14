package org.multicoder.mcpaintball.networking;

import net.neoforged.neoforge.network.handling.PlayPayloadContext;

import static org.multicoder.mcpaintball.data.PaintballOverlay.*;


public class TeamDataSyncPayloadHandler
{

    public static void Handle(final TeamsDataSyncPacket packet, PlayPayloadContext ignoredContext)
    {
        Team = packet.PTeam();
        Points = packet.Points();
    }
}

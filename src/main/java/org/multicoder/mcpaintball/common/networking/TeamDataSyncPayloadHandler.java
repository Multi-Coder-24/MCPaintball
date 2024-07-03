package org.multicoder.mcpaintball.common.networking;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import org.multicoder.mcpaintball.common.data.PaintballOverlay;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility;

@SuppressWarnings("all")
public class TeamDataSyncPayloadHandler implements IPayloadHandler<TeamsDataSyncPacket>
{
    public static final TeamDataSyncPayloadHandler INSTANCE = new TeamDataSyncPayloadHandler();

    public void handle(final TeamsDataSyncPacket packet, final IPayloadContext context)
    {
        PaintballOverlay.PClass =  PaintballDataUtility.Class.values()[packet.PClass()];
        PaintballOverlay.PTeam = PaintballDataUtility.Team.values()[packet.PTeam()];
        PaintballOverlay.TPoints = packet.Points();
    }
}

package org.multicoder.mcpaintball.common.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.ClientPlayerTeamData;
import org.multicoder.mcpaintball.common.util.enums.KitType;
import org.multicoder.mcpaintball.common.util.enums.Teams;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

import java.util.function.Supplier;

@SuppressWarnings("all")
public class TeamDataSyncS2CPacket {
    private Teams Team;
    private KitType Class;
    private int Points;
    private String Code;

    public TeamDataSyncS2CPacket(Teams team, KitType type, int points, String LoadCode) {
        Team = team;
        Class = type;
        Points = points;
        Code = LoadCode;
    }

    public TeamDataSyncS2CPacket(FriendlyByteBuf buffer) {
        Team = buffer.readEnum(Teams.class);
        Class = buffer.readEnum(KitType.class);
        Points = buffer.readInt();
        Code = buffer.readUtf();
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeEnum(Team);
        buffer.writeEnum(Class);
        buffer.writeInt(Points);
        buffer.writeUtf(Code);
    }

    public void HandlePacket(Supplier<NetworkEvent.Context> supplier)
    {
        try{
            DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> {
                ClientPlayerTeamData.SetTeam(Team);
                ClientPlayerTeamData.SetClass(Class);
                ClientPlayerTeamData.SetPoints(Points);
                ClientPlayerTeamData.SetCode(Code);
                return 1;
            });
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
}

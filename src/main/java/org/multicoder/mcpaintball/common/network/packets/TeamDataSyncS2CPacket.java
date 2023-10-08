package org.multicoder.mcpaintball.common.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.network.CustomPayloadEvent;
import net.minecraftforge.fml.DistExecutor;
import org.multicoder.mcpaintball.client.ClientPlayerTeamData;
import org.multicoder.mcpaintball.common.util.enums.KitType;
import org.multicoder.mcpaintball.common.util.enums.Teams;

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

    public void HandlePacket(CustomPayloadEvent.Context context)
    {
        DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> {
            ClientPlayerTeamData.SetTeam(Team);
            ClientPlayerTeamData.SetClass(Class);
            ClientPlayerTeamData.SetPoints(Points);
            ClientPlayerTeamData.SetCode(Code);
            return 1;
        });
    }
}

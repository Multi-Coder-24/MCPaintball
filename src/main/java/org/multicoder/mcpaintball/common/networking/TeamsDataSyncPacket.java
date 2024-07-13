package org.multicoder.mcpaintball.common.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Team;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Class;

@SuppressWarnings("all")
public record TeamsDataSyncPacket(int Points, Team PTeam, Class PClass, PaintballDataUtility.GameType Type) implements CustomPacketPayload
{
    public TeamsDataSyncPacket(final FriendlyByteBuf buffer)
    {
        this(buffer.readInt(),buffer.readEnum(Team.class),buffer.readEnum(Class.class),buffer.readEnum(PaintballDataUtility.GameType.class));
    }

    public static final ResourceLocation ID = new ResourceLocation(MCPaintball.MOD_ID,"teamdatasync");

    @Override
    public void write(FriendlyByteBuf buffer)
    {
        buffer.writeInt(Points);
        buffer.writeEnum(PTeam);
        buffer.writeEnum(PClass);
        buffer.writeEnum(Type);
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }
}

package org.multicoder.mcpaintball.common.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.multicoder.mcpaintball.MCPaintball;

@SuppressWarnings("all")
public record TeamsDataSyncPacket(int Points, int PTeam, int PClass, int Type) implements CustomPacketPayload
{
    public TeamsDataSyncPacket(final FriendlyByteBuf buffer)
    {
        this(buffer.readInt(),buffer.readInt(),buffer.readInt(),buffer.readInt());
    }

    public static final ResourceLocation ID = new ResourceLocation(MCPaintball.MOD_ID,"teamdatasync");

    @Override
    public void write(FriendlyByteBuf buffer)
    {
        buffer.writeInt(Points);
        buffer.writeInt(PTeam);
        buffer.writeInt(PClass);
        buffer.writeInt(Type);
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }
}

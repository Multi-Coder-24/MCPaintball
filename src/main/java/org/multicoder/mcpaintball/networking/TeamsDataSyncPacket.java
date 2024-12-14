package org.multicoder.mcpaintball.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static org.multicoder.mcpaintball.MCPaintball.MOD_ID;

public record TeamsDataSyncPacket(int Points, int PTeam) implements CustomPacketPayload
{
    public TeamsDataSyncPacket(final FriendlyByteBuf buffer)
    {
        this(buffer.readInt(),buffer.readInt());
    }

    public static final ResourceLocation ID = new ResourceLocation(MOD_ID,"teamdatasync");

    @Override
    public void write(FriendlyByteBuf buffer)
    {
        buffer.writeInt(Points);
        buffer.writeInt(PTeam);
    }

    @Override
    public @NotNull ResourceLocation id() {
        return ID;
    }
}

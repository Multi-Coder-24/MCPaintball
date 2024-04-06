package org.multicoder.mcpaintball.common.extra;

import de.maxhenkel.voicechat.api.*;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.LeaveGroupEvent;
import de.maxhenkel.voicechat.api.events.PlayerConnectedEvent;
import de.maxhenkel.voicechat.api.events.VoicechatServerStartedEvent;
import net.minecraft.server.level.ServerPlayer;
import org.checkerframework.checker.units.qual.A;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.common.utility.PaintballTeam;

import java.util.Objects;
import java.util.UUID;

@ForgeVoicechatPlugin
public class VoiceChatIntegration implements VoicechatPlugin
{
    public static Group RED;
    public static Group GREEN;
    public static Group BLUE;
    public static Group CYAN;
    public static Group MAGENTA;
    public static Group YELLOW;
    public static Group LIME;
    public static Group LIGHT_BLUE;
    public static Group PINK;
    public static Group PURPLE;
    public static VoicechatServerApi API;


    @Override
    public String getPluginId() {
        return "mcpaintball";
    }

    @Override
    public void initialize(VoicechatApi api)
    {

    }

    @Override
    public void registerEvents(EventRegistration registration)
    {
        VoicechatPlugin.super.registerEvents(registration);
        registration.registerEvent(VoicechatServerStartedEvent.class,VoiceChatIntegration::ServerStarted);
        registration.registerEvent(PlayerConnectedEvent.class,VoiceChatIntegration::PersistPlayer);
    }

    private static void PersistPlayer(PlayerConnectedEvent playerConnectedEvent)
    {
        ServerPlayer Player = (ServerPlayer) playerConnectedEvent.getConnection().getPlayer().getPlayer();
        AddPlayerToGroup(Player);
    }

    public static void RemoveGroup(ServerPlayer player){
        API.getConnectionOf(player.getUUID()).setGroup(null);
    }
    public static void AddPlayerToGroup(ServerPlayer player)
    {
        PaintballTeam Team = PaintballTeam.values()[player.getPersistentData().getCompound("mcpaintball.teamsTag").getInt("team")];
        switch (Team)
        {
            case RED -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(RED);
            case GREEN -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(GREEN);
            case BLUE -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(BLUE);
            case CYAN -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(CYAN);
            case MAGENTA -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(MAGENTA);
            case YELLOW -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(YELLOW);
            case LIME -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(LIME);
            case LIGHT_BLUE -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(LIGHT_BLUE);
            case PINK -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(PINK);
            case PURPLE -> Objects.requireNonNull(API.getConnectionOf(player.getUUID())).setGroup(PURPLE);
        }
    }
    private static void ServerStarted(VoicechatServerStartedEvent event)
    {
        API = event.getVoicechat();
        RED = event.getVoicechat().groupBuilder().setPersistent(true).setName("Red Team").setPassword("MCPaintball.RED").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
        GREEN = event.getVoicechat().groupBuilder().setPersistent(true).setName("Green Team").setPassword("MCPaintball.GREEN").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
        BLUE = event.getVoicechat().groupBuilder().setPersistent(true).setName("Blue Team").setPassword("MCPaintball.BLUE").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
        CYAN = event.getVoicechat().groupBuilder().setPersistent(true).setName("Cyan Team").setPassword("MCPaintball.CYAN").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
        MAGENTA = event.getVoicechat().groupBuilder().setPersistent(true).setName("Magenta Team").setPassword("MCPaintball.MAGENTA").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
        YELLOW = event.getVoicechat().groupBuilder().setPersistent(true).setName("Yellow Team").setPassword("MCPaintball.YELLOW").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
        LIME = event.getVoicechat().groupBuilder().setPersistent(true).setName("Lime Team").setPassword("MCPaintball.LIME").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
        LIGHT_BLUE = event.getVoicechat().groupBuilder().setPersistent(true).setName("Light Blue Team").setPassword("MCPaintball.LIGHT_BLUE").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
        PINK = event.getVoicechat().groupBuilder().setPersistent(true).setName("Pink Team").setPassword("MCPaintball.PINK").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
        PURPLE = event.getVoicechat().groupBuilder().setPersistent(true).setName("Purple Team").setPassword("MCPaintball.PURPLE").setId(UUID.randomUUID()).setType(Group.Type.NORMAL).build();
    }
}

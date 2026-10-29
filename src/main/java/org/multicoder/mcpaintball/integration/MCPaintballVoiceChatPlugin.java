package org.multicoder.mcpaintball.integration;

import de.maxhenkel.voicechat.api.Group;
import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.VoicechatServerApi;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.VoicechatServerStartedEvent;

import java.util.UUID;

public class MCPaintballVoiceChatPlugin implements VoicechatPlugin {
    public static Group RED;
    public static Group GREEN;
    public static Group BLUE;
    public static Group YELLOW;
    public static Group PINK;
    public static Group ORANGE;
    public static VoicechatServerApi SERVER;
    @Override
    public String getPluginId() {
        return "mcpaintball";
    }

    @Override
    public void initialize(VoicechatApi api) {
        VoicechatPlugin.super.initialize(api);
    }

    @Override
    public void registerEvents(EventRegistration registration) {
        VoicechatPlugin.super.registerEvents(registration);
        registration.registerEvent(VoicechatServerStartedEvent.class,MCPaintballVoiceChatPlugin::ServerStarted);
    }

    private static void ServerStarted(VoicechatServerStartedEvent event) {
        SERVER = event.getVoicechat();
        RED = event.getVoicechat().groupBuilder().setName("MCPaintball red team").setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        GREEN = event.getVoicechat().groupBuilder().setName("MCPaintball green team").setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        BLUE = event.getVoicechat().groupBuilder().setName("MCPaintball blue team").setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        YELLOW = event.getVoicechat().groupBuilder().setName("MCPaintball yellow team").setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        PINK = event.getVoicechat().groupBuilder().setName("MCPaintball pink team").setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        ORANGE = event.getVoicechat().groupBuilder().setName("MCPaintball orange team").setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
    }
}

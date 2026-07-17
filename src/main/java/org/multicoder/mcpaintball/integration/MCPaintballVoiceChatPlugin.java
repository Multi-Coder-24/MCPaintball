package org.multicoder.mcpaintball.integration;

import de.maxhenkel.voicechat.api.*;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.VoicechatServerStartedEvent;

import java.util.UUID;

@ForgeVoicechatPlugin
public class MCPaintballVoiceChatPlugin implements VoicechatPlugin {
    public static VoicechatServerApi SERVER;
    public static Group RED;
    public static Group GREEN;
    public static Group BLUE;
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
        RED = event.getVoicechat().groupBuilder().setName("MCPaintball Red Team").setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        GREEN = event.getVoicechat().groupBuilder().setName("MCPaintball Green Team").setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        BLUE = event.getVoicechat().groupBuilder().setName("MCPaintball Blue Team").setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
    }
}

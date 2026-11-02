package org.multicoder.mcpaintball.integration;

import de.maxhenkel.voicechat.api.Group;
import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.VoicechatServerApi;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.VoicechatServerStartedEvent;
import net.minecraft.network.chat.Component;

import java.awt.*;
import java.util.UUID;

public class MCPaintballVoiceChatPlugin implements VoicechatPlugin {
    public static Group RED;
    public static Group GREEN;
    public static Group BLUE;
    public static Group CYAN;
    public static Group MAGENTA;
    public static Group YELLOW;
    public static Group PINK;
    public static Group LIME;
    public static Group LIGHT_BLUE;
    public static Group LIGHT_GRAY;
    public static Group GRAY;
    public static Group WHITE;
    public static Group BLACK;
    public static Group BROWN;
    public static Group PURPLE;
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
        RED = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_red").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        GREEN = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_green").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        BLUE = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_blue").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        CYAN = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_cyan").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        MAGENTA = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_magenta").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        YELLOW = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_yellow").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        PINK = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_pink").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        LIME = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_lime").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        LIGHT_BLUE = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_light_blue").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        LIGHT_GRAY = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_light_gray").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        GRAY = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_gray").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        WHITE = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_white").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        BROWN = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_brown").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        BLACK = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_black").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        PURPLE = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_purple").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
        ORANGE = event.getVoicechat().groupBuilder().setName(Component.translatable("text.mcpaintball.team_orange").getString()).setPassword(UUID.randomUUID().toString()).setPersistent(true).setHidden(true).setType(Group.Type.ISOLATED).build();
    }
}

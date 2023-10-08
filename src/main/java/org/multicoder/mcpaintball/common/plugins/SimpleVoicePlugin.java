package org.multicoder.mcpaintball.common.plugins;

import de.maxhenkel.voicechat.api.ForgeVoicechatPlugin;
import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.VoicechatServerApi;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.PlayerConnectedEvent;
import de.maxhenkel.voicechat.api.events.VoicechatServerStartedEvent;
import net.minecraft.world.entity.player.Player;
import org.multicoder.mcpaintball.common.capability.PaintballPlayer;
import org.multicoder.mcpaintball.common.capability.PaintballPlayerProvider;

import java.util.UUID;

@SuppressWarnings("all")
@ForgeVoicechatPlugin
public class SimpleVoicePlugin implements VoicechatPlugin {
    public static VoicechatServerApi API = null;
    public static UUID RED = null;
    public static UUID GREEN = null;
    public static UUID BLUE = null;
    public static UUID CYAN = null;
    public static UUID MAGENTA = null;
    public static UUID PINK = null;
    public static UUID PURPLE = null;
    public static UUID LIME = null;
    public static UUID LIGHT_BLUE = null;

    @Override
    public String getPluginId() {
        return "mcpaintball_voice_chat";
    }

    @Override
    public void initialize(VoicechatApi api) {
        VoicechatPlugin.super.initialize(api);
    }

    @Override
    public void registerEvents(EventRegistration registration) {
        VoicechatPlugin.super.registerEvents(registration);
        registration.registerEvent(VoicechatServerStartedEvent.class, this::ServerStart);
        registration.registerEvent(PlayerConnectedEvent.class, this::playerConnect);
    }

    private void playerConnect(PlayerConnectedEvent event) {
        Player player = (Player) event.getConnection().getPlayer().getPlayer();
        PaintballPlayer PPlayer = player.getCapability(PaintballPlayerProvider.CAPABILITY).resolve().get();
        int T = PPlayer.Team.ordinal();
        AddPlayerToGroup(player, T);
    }

    public static void AddPlayerToGroup(Player player, int GI) {
        switch (GI) {
            case 1 -> {
                API.getConnectionOf(player.getUUID()).setGroup(API.getGroup(RED));
            }
            case 2 -> {
                API.getConnectionOf(player.getUUID()).setGroup(API.getGroup(GREEN));
            }
            case 3 -> {
                API.getConnectionOf(player.getUUID()).setGroup(API.getGroup(BLUE));
            }
            case 4 -> {
                API.getConnectionOf(player.getUUID()).setGroup(API.getGroup(MAGENTA));
            }
            case 5 -> {
                API.getConnectionOf(player.getUUID()).setGroup(API.getGroup(PINK));
            }
            case 6 -> {
                API.getConnectionOf(player.getUUID()).setGroup(API.getGroup(PURPLE));
            }
            case 7 -> {
                API.getConnectionOf(player.getUUID()).setGroup(API.getGroup(LIME));
            }
            case 8 -> {
                API.getConnectionOf(player.getUUID()).setGroup(API.getGroup(LIGHT_BLUE));
            }
            case 9 -> {
                API.getConnectionOf(player.getUUID()).setGroup(API.getGroup(CYAN));
            }
        }
    }

    private void ServerStart(VoicechatServerStartedEvent event) {
        API = event.getVoicechat();
        RED = event.getVoicechat().groupBuilder().setName("Red Team").setPassword("mcpaintball_red").setPersistent(true).build().getId();
        GREEN = event.getVoicechat().groupBuilder().setName("Green Team").setPassword("mcpaintball_green").setPersistent(true).build().getId();
        BLUE = event.getVoicechat().groupBuilder().setName("Blue Team").setPassword("mcpaintball_blue").setPersistent(true).build().getId();
        CYAN = event.getVoicechat().groupBuilder().setName("Cyan Team").setPassword("mcpaintball_cyan").setPersistent(true).build().getId();
        MAGENTA = event.getVoicechat().groupBuilder().setName("Magenta Team").setPassword("mcpaintball_magenta").setPersistent(true).build().getId();
        PINK = event.getVoicechat().groupBuilder().setName("Pink Team").setPassword("mcpaintball_pink").setPersistent(true).build().getId();
        PURPLE = event.getVoicechat().groupBuilder().setName("Purple Team").setPassword("mcpaintball_purple").setPersistent(true).build().getId();
        LIME = event.getVoicechat().groupBuilder().setName("Lime Team").setPassword("mcpaintball_lime").setPersistent(true).build().getId();
        LIGHT_BLUE = event.getVoicechat().groupBuilder().setName("Light Blue Team").setPassword("mcpaintball_light_blue").setPersistent(true).build().getId();
    }
}

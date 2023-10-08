package org.multicoder.mcpaintball.client.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.client.TeamClassOverlay;
import org.multicoder.mcpaintball.client.player.Keybindings;
import org.multicoder.mcpaintball.client.screen.ConfigScreen;
import org.multicoder.mcpaintball.common.network.Networking;
import org.multicoder.mcpaintball.common.network.packets.ReloadC2SPacket;

@SuppressWarnings("all")
public class ClientEvents {
    @Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {
        @SubscribeEvent
        public static void RegisterKeybindings(RegisterKeyMappingsEvent event) {
            event.register(Keybindings.CONFIG);
            event.register(Keybindings.RELOAD);
        }

        @SubscribeEvent
        public static void RegisterGUIOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("mcpaintball", TeamClassOverlay.TEAM_CLASS);
        }
    }

    @Mod.EventBusSubscriber(modid = MCPaintball.MOD_ID, value = Dist.CLIENT)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void OnKeyPressed(InputEvent.Key event) {
            if (Keybindings.CONFIG.consumeClick()) {
                if (Minecraft.getInstance().player.hasPermissions(2)) {
                    Minecraft.getInstance().setScreen(new ConfigScreen(Minecraft.getInstance()));
                } else if (Minecraft.getInstance().isSingleplayer()) {
                    Minecraft.getInstance().setScreen(new ConfigScreen(Minecraft.getInstance()));
                }
            } else if (Keybindings.RELOAD.consumeClick()) {
                Networking.SendToServer(new ReloadC2SPacket());
            }
        }
    }
}

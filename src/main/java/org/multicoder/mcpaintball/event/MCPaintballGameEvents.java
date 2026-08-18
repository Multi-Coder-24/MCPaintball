package org.multicoder.mcpaintball.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import org.multicoder.mcpaintball.client.gui.AdminScreen;
import org.multicoder.mcpaintball.client.gui.SelectRoleScreen;
import org.multicoder.mcpaintball.client.gui.SelectTeamScreen;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.core.MCPaintballDataComponents;
import org.multicoder.mcpaintball.core.MCPaintballItems;
import org.multicoder.mcpaintball.core.MCPaintballKeybinding;
import org.multicoder.mcpaintball.data.MCPaintballSaveData;
import org.multicoder.mcpaintball.network.CycleGLTypeC2SPacket;
import org.multicoder.mcpaintball.network.GiveKitC2SPacket;
import org.multicoder.mcpaintball.network.PointSyncS2CPacket;
import org.multicoder.mcpaintball.integration.MinecraftTeamSystem;

import java.util.Objects;

public class MCPaintballGameEvents {
    public static MCPaintballSaveData INSTANCE;
    public static int ticker = 0;
    public static void serverStart(MinecraftServer server) {
        INSTANCE = server.overworld().getDataStorage().computeIfAbsent(MCPaintballSaveData.TYPE);
        Objects.requireNonNull(server.overworld().getDataStorage().get(MCPaintballSaveData.TYPE)).setDirty();
        server.addTickable((() -> {
            if(ticker == 20){
                server.getPlayerList().getPlayers().forEach(player -> ServerPlayNetworking.send(player,new PointSyncS2CPacket(MCPaintballGameEvents.INSTANCE.redPoints,MCPaintballGameEvents.INSTANCE.greenPoints,MCPaintballGameEvents.INSTANCE.bluePoints,MCPaintballGameEvents.INSTANCE.yellowPoints,MCPaintballGameEvents.INSTANCE.pinkPoints,MCPaintballGameEvents.INSTANCE.orangePoints, MCPaintballGameEvents.INSTANCE.matchStarted,MCPaintballGameEvents.INSTANCE.roundStarted)));
                ticker = 0;
            }else{
                ticker++;
            }
        }));
        MinecraftTeamSystem.init(server);
    }

    public static void join(ServerPlayer player) {
        player.getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
    }

    public static void clientEndTick(Minecraft minecraft) {
        while(MCPaintballKeybinding.CYCLE_GRENADE_LAUNCHER_TYPE.consumeClick()){
            Player player =  minecraft.player;
            if(Objects.requireNonNull(player).getItemInHand(InteractionHand.MAIN_HAND).getItem() == MCPaintballItems.GRENADE_LAUNCHER){
                int i = Objects.requireNonNull(player.getItemInHand(InteractionHand.MAIN_HAND).get(MCPaintballDataComponents.SETTING)).setting();
                ClientPlayNetworking.send(new CycleGLTypeC2SPacket(i));
            }
        }
        while (MCPaintballKeybinding.OPEN_TEAM_SELECT.consumeClick()){
            Screen Parent = minecraft.screen;
            minecraft.setScreen(new SelectTeamScreen(Parent));
        }
        while (MCPaintballKeybinding.OPEN_ROLE_SELECT.consumeClick()){
            Screen Parent = minecraft.screen;
            minecraft.setScreen(new SelectRoleScreen(Parent));
        }
        while (MCPaintballKeybinding.OPEN_ADMIN_SCREEN.consumeClick()){
            Minecraft instance = Minecraft.getInstance();
            if(Objects.requireNonNull(instance.player).permissions().hasPermission(Permissions.COMMANDS_MODERATOR)){
                Screen Parent = minecraft.screen;
                minecraft.setScreen(new AdminScreen(Parent));
            }
        }
        while(MCPaintballKeybinding.GIVE_KIT.consumeClick()){
            ClientPlayNetworking.send(new GiveKitC2SPacket());
        }
    }
}

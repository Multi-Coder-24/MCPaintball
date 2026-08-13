package org.multicoder.mcpaintball.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import org.multicoder.mcpaintball.network.RoleSelectC2SPacket;

public class SelectRoleScreen extends Screen {
    public Screen parentScreen;

    public Button Captain = Button.builder(Component.translatable("screen.mcpaintball.text.captain_role"), _ -> {
        ClientPacketDistributor.sendToServer(new RoleSelectC2SPacket(1));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Gunner = Button.builder(Component.translatable("screen.mcpaintball.text.gunner_role"), _ -> {
        ClientPacketDistributor.sendToServer(new RoleSelectC2SPacket(2));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Heavy = Button.builder(Component.translatable("screen.mcpaintball.text.sniper_role"), _ -> {
        ClientPacketDistributor.sendToServer(new RoleSelectC2SPacket(3));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Specialist = Button.builder(Component.translatable("screen.mcpaintball.text.specialist_role"), _ -> {
        ClientPacketDistributor.sendToServer(new RoleSelectC2SPacket(4));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Grenadier = Button.builder(Component.translatable("screen.mcpaintball.text.grenadier_role"), _ -> {
        ClientPacketDistributor.sendToServer(new RoleSelectC2SPacket(5));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public SelectRoleScreen(Screen parent) {
        super(Component.translatable("screen.mcpaintball.select_role"));
        this.parentScreen = parent;
    }

    @Override
    protected void init() {
        super.init();
        Captain.setRectangle(75,30,50,50);
        Gunner.setRectangle(75,30,150,50);
        Heavy.setRectangle(75,30,250,50);
        Specialist.setRectangle(75,30,50,100);
        Grenadier.setRectangle(75,30,150,100);
        addRenderableWidget(Captain);
        addRenderableWidget(Gunner);
        addRenderableWidget(Heavy);
        addRenderableWidget(Specialist);
        addRenderableWidget(Grenadier);
    }

    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().setScreen(parentScreen);
    }
}

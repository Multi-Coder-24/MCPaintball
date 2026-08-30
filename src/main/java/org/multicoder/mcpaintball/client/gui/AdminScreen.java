package org.multicoder.mcpaintball.client.gui;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.multicoder.mcpaintball.network.AdminSelectionC2SPacket;

public class AdminScreen extends Screen {
    public Screen parentScreen;

    public Button StartGameButton = Button.builder(Component.translatable("screen.mcpaintball.text.game_start"), _ ->{
        ClientPlayNetworking.send(new AdminSelectionC2SPacket(0));
        this.minecraft.setScreen(parentScreen);
    }).build();
    public Button StopGameButton = Button.builder(Component.translatable("screen.mcpaintball.text.game_stop"), _ ->{
        ClientPlayNetworking.send(new AdminSelectionC2SPacket(1));
        this.minecraft.setScreen(parentScreen);
    }).build();
    public Button StartRoundButton = Button.builder(Component.translatable("screen.mcpaintball.text.round_start"), _ ->{
        ClientPlayNetworking.send(new AdminSelectionC2SPacket(2));
        this.minecraft.setScreen(parentScreen);
    }).build();
    public Button StopRoundButton = Button.builder(Component.translatable("screen.mcpaintball.text.round_stop"), _ ->{
        ClientPlayNetworking.send(new AdminSelectionC2SPacket(3));
        this.minecraft.setScreen(parentScreen);
    }).build();
    public Button RoundWinnerButton = Button.builder(Component.translatable("screen.mcpaintball.text.round_winner"), _ ->{
        ClientPlayNetworking.send(new AdminSelectionC2SPacket(4));
        this.minecraft.setScreen(parentScreen);
    }).build();

    public AdminScreen(Screen parent) {
        super(Component.translatable("screen.mcpaintball.admin"));
        this.parentScreen = parent;
    }

    @Override
    protected void init() {
        super.init();
        StartGameButton.setRectangle(100,30,50,50);
        StopGameButton.setRectangle(100,30,50,100);
        StartRoundButton.setRectangle(100,30,250,50);
        StopRoundButton.setRectangle(100,30,250,100);
        RoundWinnerButton.setRectangle(150,30,250,150);
        addRenderableWidget(StartGameButton);
        addRenderableWidget(StopGameButton);
        addRenderableWidget(StartRoundButton);
        addRenderableWidget(StopRoundButton);
        addRenderableWidget(RoundWinnerButton);
    }
    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().setScreen(parentScreen);
    }
}

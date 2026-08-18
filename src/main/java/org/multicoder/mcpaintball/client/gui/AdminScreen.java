package org.multicoder.mcpaintball.client.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class AdminScreen extends Screen {
    public Screen parentScreen;


    public Button StartGameButton = Button.builder(Component.translatable("screen.mcpaintball.text.game_start"),_ ->{}).build();
    public Button StopGameButton = Button.builder(Component.translatable("screen.mcpaintball.text.game_stop"),_ ->{}).build();
    public Button StartRoundButton = Button.builder(Component.translatable("screen.mcpaintball.text.round_start"),_ ->{}).build();
    public Button StopRoundButton = Button.builder(Component.translatable("screen.mcpaintball.text.round_stop"),_ ->{}).build();
    public Button RoundWinnerButton = Button.builder(Component.translatable("screen.mcpaintball.text.round_winner"),_ ->{}).build();

    public AdminScreen(Screen parent) {
        super(Component.translatable("screen.mcpaintball.select_role"));
        this.parentScreen = parent;
    }

    @Override
    protected void init() {
        super.init();
        StartGameButton.setRectangle(100,30,50,50);
        StopGameButton.setRectangle(100,30,50,100);
        StartRoundButton.setRectangle(100,30,175,50);
        StopRoundButton.setRectangle(100,30,175,100);
        RoundWinnerButton.setRectangle(150,30,75,150);
        addRenderableWidget(StartGameButton);
        addRenderableWidget(StopGameButton);
        addRenderableWidget(StartRoundButton);
        addRenderableWidget(StopRoundButton);
        addRenderableWidget(RoundWinnerButton);
    }
}

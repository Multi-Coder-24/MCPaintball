package org.multicoder.mcpaintball.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import org.multicoder.mcpaintball.network.TeamSelectC2SPacket;


public class SelectTeamScreen extends Screen {
    public Screen parentScreen;

    public Button Red = Button.builder(Component.translatable("screen.mcpaintball.text.red_team"), _ -> {
        ClientPacketDistributor.sendToServer(new TeamSelectC2SPacket(1));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Green = Button.builder(Component.translatable("screen.mcpaintball.text.green_team"), _ -> {
        ClientPacketDistributor.sendToServer(new TeamSelectC2SPacket(2));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Blue = Button.builder(Component.translatable("screen.mcpaintball.text.blue_team"), _ -> {
        ClientPacketDistributor.sendToServer(new TeamSelectC2SPacket(3));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Yellow = Button.builder(Component.translatable("screen.mcpaintball.text.yellow_team"), _ -> {
        ClientPacketDistributor.sendToServer(new TeamSelectC2SPacket(4));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Pink = Button.builder(Component.translatable("screen.mcpaintball.text.pink_team"), _ -> {
        ClientPacketDistributor.sendToServer(new TeamSelectC2SPacket(5));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Orange = Button.builder(Component.translatable("screen.mcpaintball.text.orange_team"), _ -> {
        ClientPacketDistributor.sendToServer(new TeamSelectC2SPacket(6));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public Button Admin = Button.builder(Component.translatable("screen.mcpaintball.text.admin_team"), _ -> {
        ClientPacketDistributor.sendToServer(new TeamSelectC2SPacket(7));
        Minecraft.getInstance().setScreen(parentScreen);
    }).build();
    public SelectTeamScreen(Screen parent) {
        super(Component.translatable("screen.mcpaintball.select_team"));
        this.parentScreen = parent;
    }

    @Override
    protected void init() {
        super.init();
        Red.setRectangle(75,30,50,50);
        Green.setRectangle(75,30,150,50);
        Blue.setRectangle(75,30,250,50);
        Yellow.setRectangle(75,30,50,100);
        Pink.setRectangle(75,30,150,100);
        Orange.setRectangle(75,30,250,100);
        Admin.setRectangle(75,30,50,150);
        addRenderableWidget(Red);
        addRenderableWidget(Green);
        addRenderableWidget(Blue);
        addRenderableWidget(Yellow);
        addRenderableWidget(Pink);
        addRenderableWidget(Orange);
        addRenderableWidget(Admin);
    }


    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().setScreen(parentScreen);
    }
}

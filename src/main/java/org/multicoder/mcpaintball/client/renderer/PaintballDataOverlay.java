package org.multicoder.mcpaintball.client.renderer;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.gui.GuiLayer;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.client.MCPaintballClient;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.util.PaintballTeam;
import org.multicoder.mcpaintball.util.PaintballType;

import java.awt.*;
import java.util.Objects;

public class PaintballDataOverlay implements GuiLayer {

    @Override
    public void render(@NonNull GuiGraphicsExtractor graphics, @NonNull DeltaTracker deltaTracker) {
        if(MCPaintballClient.gameRunning){
            MCPaintballPlayerData data = Objects.requireNonNull(Minecraft.getInstance().player).getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
            PaintballTeam team = PaintballTeam.values()[data.Team];
            PaintballType type = PaintballType.values()[data.Type];
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.red_points", MCPaintballClient.redPoints),20,20, Color.WHITE.getRGB());
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.green_points", MCPaintballClient.greenPoints),20,30, Color.WHITE.getRGB());
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.blue_points", MCPaintballClient.bluePoints),20,40, Color.WHITE.getRGB());
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.yellow_points", MCPaintballClient.yellowPoints),20,50, Color.WHITE.getRGB());
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.pink_points", MCPaintballClient.pinkPoints),20,60, Color.WHITE.getRGB());
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.orange_points", MCPaintballClient.orangePoints),20,70, Color.WHITE.getRGB());
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.team", Component.translatable(team.getSerializedName())),20,80, Color.WHITE.getRGB());
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.type", Component.translatable(type.getSerializedName())),20,90, Color.WHITE.getRGB());
            if(MCPaintballClient.roundRunning){
                graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.round_running"),20,100, Color.WHITE.getRGB());
            }
        }
    }
}

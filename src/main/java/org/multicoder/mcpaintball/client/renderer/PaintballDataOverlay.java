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
import org.multicoder.mcpaintball.util.PaintballRole;

import java.awt.*;
import java.util.Objects;

public class PaintballDataOverlay implements GuiLayer {

    @Override
    public void render(@NonNull GuiGraphicsExtractor graphics, @NonNull DeltaTracker deltaTracker) {
        if(MCPaintballClient.gameRunning){
            MCPaintballPlayerData data = Objects.requireNonNull(Minecraft.getInstance().player).getData(MCPaintballDataAttachments.PAINTBALL_PLAYER.get());
            PaintballTeam team = PaintballTeam.values()[data.Team];
            PaintballRole role = PaintballRole.values()[data.Role];
            int XPos = graphics.guiWidth() - 100;
            switch (team){
                case Red -> graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.red_points", MCPaintballClient.redPoints),20,20, Color.WHITE.getRGB());
                case Green -> graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.green_points", MCPaintballClient.greenPoints),20,20, Color.WHITE.getRGB());
                case Blue -> graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.blue_points", MCPaintballClient.bluePoints),20,20, Color.WHITE.getRGB());
                case Yellow -> graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.yellow_points", MCPaintballClient.yellowPoints),20,20, Color.WHITE.getRGB());
                case Pink -> graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.pink_points", MCPaintballClient.pinkPoints),20,20, Color.WHITE.getRGB());
                case Orange -> graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.orange_points", MCPaintballClient.orangePoints),20,20, Color.WHITE.getRGB());
            }
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.team", Component.translatable(team.getSerializedName())),XPos,20, Color.WHITE.getRGB());
            graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.role", Component.translatable(role.getSerializedName())),XPos,30, Color.WHITE.getRGB());
            if(MCPaintballClient.roundRunning){
                graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.round_running"),20,30, Color.WHITE.getRGB());
            }
        }
    }
}

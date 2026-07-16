package org.multicoder.mcpaintball.client.renderer;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.gui.GuiLayer;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.client.MCPaintballClient;

import java.awt.*;

public class PaintballDataOverlay implements GuiLayer {

    @Override
    public void render(GuiGraphicsExtractor graphics, @NonNull DeltaTracker deltaTracker) {
        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.red_points", MCPaintballClient.RedPoints),20,20, Color.WHITE.getRGB());
        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.green_points", MCPaintballClient.GreenPoints),20,30, Color.WHITE.getRGB());
        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.blue_points", MCPaintballClient.BluePoints),20,40, Color.WHITE.getRGB());

    }
}

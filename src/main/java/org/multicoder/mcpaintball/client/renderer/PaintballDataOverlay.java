package org.multicoder.mcpaintball.client.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.client.MCPaintballClient;

import java.awt.*;

public class PaintballDataOverlay implements HudElement {

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, @NonNull DeltaTracker deltaTracker) {
        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.red_points", MCPaintballClient.RedPoints),50,20, Color.WHITE.getRGB());
        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.green_points", MCPaintballClient.GreenPoints),50,30, Color.WHITE.getRGB());
        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.blue_points", MCPaintballClient.BluePoints),50,40, Color.WHITE.getRGB());
    }
}

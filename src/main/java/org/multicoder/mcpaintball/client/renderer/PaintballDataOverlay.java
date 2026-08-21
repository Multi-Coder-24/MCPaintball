package org.multicoder.mcpaintball.client.renderer;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.block.objectives.CapturePointBlock;
import org.multicoder.mcpaintball.client.MCPaintballClient;
import org.multicoder.mcpaintball.core.MCPaintballBlocks;
import org.multicoder.mcpaintball.core.MCPaintballDataAttachments;
import org.multicoder.mcpaintball.data.MCPaintballPlayerData;
import org.multicoder.mcpaintball.util.PaintballTeam;
import org.multicoder.mcpaintball.util.PaintballRole;

import java.awt.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unused")
public class PaintballDataOverlay implements HudElement {

    @Override
    public void extractRenderState(@NonNull GuiGraphicsExtractor graphics, @NonNull DeltaTracker deltaTracker) {
        try{
            if(MCPaintballClient.tournamentRunning) {
                MCPaintballPlayerData data = Objects.requireNonNull(Minecraft.getInstance().player).getAttachedOrCreate(MCPaintballDataAttachments.PAINTBALL_PLAYER);
                PaintballTeam team = PaintballTeam.values()[data.team];
                PaintballRole role = PaintballRole.values()[data.role];
                int W = graphics.guiWidth();
                int H = graphics.guiHeight();
                switch (team){
                    case Admin -> {
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.red_points", MCPaintballClient.redPoints), 20, 10, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.green_points", MCPaintballClient.greenPoints), 20, 20, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.blue_points", MCPaintballClient.bluePoints), 20, 30, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.yellow_points", MCPaintballClient.yellowPoints), 20, 40, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.pink_points", MCPaintballClient.pinkPoints), 20, 50, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.orange_points", MCPaintballClient.orangePoints), 20, 60, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.red_wins", MCPaintballClient.RedWins), 20, 70, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.green_wins", MCPaintballClient.GreenWins), 20, 80, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.blue_wins", MCPaintballClient.BlueWins), 20, 90, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.yellow_wins", MCPaintballClient.YellowWins), 20, 100, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.pink_wins", MCPaintballClient.PinkWins), 20, 110, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.orange_wins", MCPaintballClient.OrangeWins), 20, 120, Color.WHITE.getRGB());
                    }
                    case Red -> {
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.red_points", MCPaintballClient.redPoints), 20, 10, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font,Component.translatable("text.mcpaintball.red_wins",MCPaintballClient.RedWins),20,20,Color.WHITE.getRGB());
                    }
                    case Green -> {
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.green_points", MCPaintballClient.greenPoints), 20, 10, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font,Component.translatable("text.mcpaintball.green_wins",MCPaintballClient.GreenWins),20,20,Color.WHITE.getRGB());
                    }
                    case Blue -> {
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.blue_points", MCPaintballClient.bluePoints), 20, 10, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font,Component.translatable("text.mcpaintball.blue_wins",MCPaintballClient.BlueWins),20,20,Color.WHITE.getRGB());
                    }
                    case Yellow -> {
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.yellow_points", MCPaintballClient.yellowPoints), 20, 10, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font,Component.translatable("text.mcpaintball.yellow_wins",MCPaintballClient.YellowWins),20,20,Color.WHITE.getRGB());
                    }
                    case Pink -> {
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.pink_points", MCPaintballClient.pinkPoints), 20, 10, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font,Component.translatable("text.mcpaintball.pink_wins",MCPaintballClient.PinkWins),20,20,Color.WHITE.getRGB());
                    }
                    case Orange -> {
                        graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.orange_points", MCPaintballClient.orangePoints), 20, 10, Color.WHITE.getRGB());
                        graphics.text(Minecraft.getInstance().font,Component.translatable("text.mcpaintball.orange_wins",MCPaintballClient.OrangeWins),20,20,Color.WHITE.getRGB());
                    }
                }
                graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.team", Component.translatable(team.getSerializedName())), W - 75, 10, Color.WHITE.getRGB());
                graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.role", Component.translatable(role.getSerializedName())), W - 75, 20, Color.WHITE.getRGB());
                Level level = Minecraft.getInstance().level;
                AtomicInteger i = new AtomicInteger(1);
                MCPaintballClient.capture_points.forEach(point -> {
                    BlockState state = Objects.requireNonNull(level).getBlockState(point);
                    if(state.getBlock() == MCPaintballBlocks.CAPTURE_POINT){
                        int Value = state.getValue(CapturePointBlock.TEAM);
                        Identifier id = Identifier.fromNamespaceAndPath(MCPaintball.MOD_ID,"textures/item/objectives/capture_point_" + Value + ".png");
                        graphics.blit(RenderPipelines.GUI_TEXTURED,id,16* i.get() + 10,140,0,0,16,16,16,16);
                        i.addAndGet(1);
                    }
                });
                if (MCPaintballClient.roundRunning) {
                    graphics.text(Minecraft.getInstance().font, Component.translatable("text.mcpaintball.round_running"), 20, 130, Color.WHITE.getRGB());
                }
            }
        } catch (Exception e) {
            MCPaintball.LOGGER.error("Overlay",e);
        }
    }
}

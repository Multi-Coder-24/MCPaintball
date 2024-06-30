package org.multicoder.mcpaintball.common.data;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.network.chat.Component;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Team;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Class;

@SuppressWarnings("all")
public class PaintballOverlay implements LayeredDraw.Layer
{
    public static int TPoints = 2;
    public static Team PTeam = Team.BLUE;
    public static Class PClass = Class.SHOTGUNNER;


    @Override
    public void render(GuiGraphics p_316811_, DeltaTracker p_348559_)
    {
        Font font = Minecraft.getInstance().font;
        p_316811_.drawString(font, Component.translatable("text.mcpaintball.overlay.points",TPoints), 20,10,16777215);
        p_316811_.drawString(font, Component.translatable("text.mcpaintball.overlay.team",PTeam.name().toLowerCase()), 20,20,16777215);
        p_316811_.drawString(font, Component.translatable("text.mcpaintball.overlay.class",PClass.name().toLowerCase()), 20,30,16777215);
    }
}

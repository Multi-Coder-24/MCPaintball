package org.multicoder.mcpaintball.common.data;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Class;
import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Team;

import java.time.Duration;
import java.time.LocalDateTime;


public class PaintballOverlay implements IGuiOverlay
{
    public static int TPoints = 2;
    public static Team PTeam = Team.BLUE;
    public static Class PClass = Class.SHOTGUNNER;
    public static PaintballDataUtility.GameType Type = PaintballDataUtility.GameType.TEAM;
    public static LocalDateTime TimerObject = LocalDateTime.now();
    public static boolean ShouldTick = false;

    @Override
    public void render(ExtendedGui extendedGui, GuiGraphics guiGraphics, float v, int i, int i1)
    {
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.points",TPoints), 20,10,16777215);
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.team",PTeam.name().toLowerCase()), 20,20,16777215);
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.class",PClass.name().toLowerCase()), 20,30,16777215);
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.type",Type.name().toLowerCase().replace('_',' ')), 20,40,16777215);
        LocalDateTime LDT = LocalDateTime.now();
        Duration Remaining = Duration.between(LDT,TimerObject);
        int M = Remaining.toMinutesPart();
        int S = Remaining.toSecondsPart();
        if(!ShouldTick){
            guiGraphics.drawString(extendedGui.getFont(),Component.translatable("text.mcpaintball.overlay.timer",0,0),20,60,16777215);
        }
        else{
            guiGraphics.drawString(extendedGui.getFont(),Component.translatable("text.mcpaintball.overlay.timer",M,S),20,60,16777215);
        }

    }
}

package org.multicoder.mcpaintball.common.data;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Class;
import org.multicoder.mcpaintball.common.utility.PaintballDataUtility.Team;


public class PaintballOverlay implements IGuiOverlay
{
    public static int TPoints = 2;
    public static Team PTeam = Team.BLUE;
    public static Class PClass = Class.SHOTGUNNER;

    @Override
    public void render(ExtendedGui extendedGui, GuiGraphics guiGraphics, float v, int i, int i1)
    {
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.points",TPoints), 20,10,16777215);
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.team",PTeam.name().toLowerCase()), 20,20,16777215);
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.class",PClass.name().toLowerCase()), 20,30,16777215);
    }
}

package org.multicoder.mcpaintball.data;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.gui.overlay.ExtendedGui;
import net.neoforged.neoforge.client.gui.overlay.IGuiOverlay;
import org.jetbrains.annotations.NotNull;
import org.multicoder.mcpaintball.utility.enums.PaintballClass;
import org.multicoder.mcpaintball.utility.enums.PaintballTeam;

import java.util.Objects;


public class PaintballOverlay implements IGuiOverlay
{
    public static int Points = 0;
    public static int Team = 0;
    public static int Class = 0;

    @Override
    public void render(@NotNull ExtendedGui extendedGui, @NotNull GuiGraphics guiGraphics, float v, int i, int i1)
    {
        String TeamName;
        String ClassName;
        if(Objects.equals(Team, -1)) {
            TeamName = "None";
        }
        else{
            TeamName = PaintballTeam.getFromOrdinal(Team);
        }
        if(Objects.equals(Class, -1)) {
            ClassName = "None";
        }
        else{
            ClassName = PaintballClass.getFromOrdinal(Class);
        }
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.points",Points), 20,10,16777215);
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.team",TeamName), 20,20,16777215);
        guiGraphics.drawString(extendedGui.getFont(), Component.translatable("text.mcpaintball.overlay.class",ClassName), 20,30,16777215);
    }
}

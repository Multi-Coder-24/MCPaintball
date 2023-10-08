package org.multicoder.mcpaintball.client;

import net.minecraftforge.client.gui.overlay.IGuiOverlay;

@SuppressWarnings("all")
public class TeamClassOverlay {

    public static final IGuiOverlay TEAM_CLASS = (((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        int X = (screenWidth / 2) - 94;
        int Y = (screenHeight) - 64;
        String Team = "Team: " + ClientPlayerTeamData.GetTeam().toString();
        String Class = "Class: " + ClientPlayerTeamData.GetClass().toString();
        String Points = "Points: " + ClientPlayerTeamData.GetPoints();
        guiGraphics.drawString(gui.getFont(), Team, X, Y, 16777215);
        guiGraphics.drawString(gui.getFont(), Class, X, Y - 10, 16777215);
        guiGraphics.drawString(gui.getFont(), Points, X, Y - 20, 16777215);
    }));
}

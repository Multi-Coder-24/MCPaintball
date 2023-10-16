package org.multicoder.mcpaintball.client;

import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

@SuppressWarnings("all")
public class TeamClassOverlay {

    public static final IGuiOverlay TEAM_CLASS = (((gui, guiGraphics, partialTick, screenWidth, screenHeight) ->
    {
        try{
            int X = 0;
            int Y = screenHeight / 2;
            String Team = "Team: " + ClientPlayerTeamData.GetTeam().toString();
            String Class = "Class: " + ClientPlayerTeamData.GetClass().toString();
            String Points = "Points: " + ClientPlayerTeamData.GetPoints();
            guiGraphics.drawString(gui.getFont(), Team, X, Y, 16777215);
            guiGraphics.drawString(gui.getFont(), Class, X, Y - 10, 16777215);
            guiGraphics.drawString(gui.getFont(), Points, X, Y - 20, 16777215);
        }
        catch(Exception e)
        {
            MCPaintball.LOG_ERROR.throwing(e);
            try
            {
                ErrorLogGenerator.Generate(e);
            }
            catch (Exception ex){}
            MCPaintball.LOG_ERROR.info("Error Handled");
        }
    }));
}

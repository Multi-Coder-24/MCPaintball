package org.multicoder.mcpaintball.client;

import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import org.multicoder.mcpaintball.MCPaintball;
import org.multicoder.mcpaintball.util.ErrorLogGenerator;

import static net.minecraft.client.gui.GuiComponent.blit;
import static net.minecraft.client.gui.GuiComponent.drawString;

@SuppressWarnings("all")
public class TeamClassOverlay {

    public static final IGuiOverlay TEAM_CLASS = (((gui, poseStack, partialTick, screenWidth, screenHeight) ->
    {
        try
        {
            int X = 0;
            int Y = screenHeight / 2;
            String Team = "Team: " + ClientPlayerTeamData.GetTeam().toString();
            String Class = "Class: " + ClientPlayerTeamData.GetClass().toString();
            String Points = "Points: " + ClientPlayerTeamData.GetPoints();
            blit(poseStack,0,0,1,1,0,16777215);
            drawString(poseStack,gui.getFont(), Team, X, Y, 16777215);
            drawString(poseStack,gui.getFont(), Class, X, Y - 10, 16777215);
            drawString(poseStack,gui.getFont(), Points, X, Y - 20, 16777215);
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

package org.multicoder.mcpaintball.common.utility;

public class FormattingManagers
{
    public static PaintballDataUtility.Team FormatTypeToTeam(String TypeName)
    {
        if(TypeName.contains("red")){
            return PaintballDataUtility.Team.RED;
        } else if (TypeName.contains("green")) {
            return PaintballDataUtility.Team.GREEN;
        } else if (TypeName.contains("blue")) {
            return PaintballDataUtility.Team.BLUE;
        }else {
            return PaintballDataUtility.Team.RED;
        }
    }
}

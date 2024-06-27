package org.multicoder.mcpaintball.common.utility;

public class FormattingManagers
{
    public static PaintballTeam FormatTypeToTeam(String TypeName)
    {
        if(TypeName.contains("red")){
            return PaintballTeam.RED;
        } else if (TypeName.contains("green")) {
            return PaintballTeam.GREEN;
        } else if (TypeName.contains("blue")) {
            return PaintballTeam.BLUE;
        }else {
            return PaintballTeam.RED;
        }
    }
}

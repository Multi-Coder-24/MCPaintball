package org.multicoder.mcpaintball.common.utility;

import java.io.InvalidClassException;
import java.rmi.AccessException;

public class FormattingManagers
{
    public static PaintballTeam FormatTypeToTeam(String TypeName,Class<?> invoker) throws AccessException {
        if(invoker.getPackageName().startsWith("org.multicoder")){
            if (TypeName.contains("red")) {
                return PaintballTeam.RED;
            } else if (TypeName.contains("green")) {
                return PaintballTeam.GREEN;
            } else if (TypeName.contains("blue")) {
                return PaintballTeam.BLUE;
            } else if (TypeName.contains("cyan")) {
                return PaintballTeam.CYAN;
            } else if (TypeName.contains("magenta")) {
                return PaintballTeam.MAGENTA;
            } else if (TypeName.contains("yellow")) {
                return PaintballTeam.YELLOW;
            } else if (TypeName.contains("lime")) {
                return PaintballTeam.LIME;
            } else if (TypeName.contains("light_blue")) {
                return PaintballTeam.LIGHT_BLUE;
            } else if (TypeName.contains("pink")) {
                return PaintballTeam.PINK;
            } else if (TypeName.contains("purple")) {
                return PaintballTeam.PURPLE;
            } else {
                return PaintballTeam.RED;
            }
        }
        else{
            throw new AccessException("Cannot Access This Class");
        }
    }
}

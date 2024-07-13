package org.multicoder.mcpaintball.common.utility;

import org.multicoder.mcpaintball.common.data.PaintballDataUtility.Team;

public class FormattingManagers {
    public static Team FormatTypeToTeam(String TypeName) {
        if (TypeName.contains("red")) {
            return Team.RED;
        } else if (TypeName.contains("green")) {
            return Team.GREEN;
        } else if (TypeName.contains("blue")) {
            return Team.BLUE;
        } else {
            return Team.RED;
        }
    }
}

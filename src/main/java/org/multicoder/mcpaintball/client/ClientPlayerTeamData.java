package org.multicoder.mcpaintball.client;

import org.multicoder.mcpaintball.common.util.enums.KitType;
import org.multicoder.mcpaintball.common.util.enums.Teams;

@SuppressWarnings("all")
public class ClientPlayerTeamData {
    private static int Points;
    private static Teams Team;
    private static KitType Class;
    private static String LoadoutCode;

    public static void SetPoints(int P) {
        ClientPlayerTeamData.Points = P;
    }

    public static void SetCode(String C) {
        ClientPlayerTeamData.LoadoutCode = C;
    }

    public static void SetTeam(Teams T) {
        ClientPlayerTeamData.Team = T;
    }

    public static void SetClass(KitType Selected) {
        ClientPlayerTeamData.Class = Selected;
    }

    public static int GetPoints() {
        return Points;
    }

    public static String GetCode() {
        return LoadoutCode;
    }

    public static Teams GetTeam() {
        return Team;
    }

    public static KitType GetClass() {
        return Class;
    }
}

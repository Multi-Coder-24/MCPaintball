package org.multicoder.mcpaintball.client;

public class ClientPlayerTeamData {
    private static int Points;
    private static int Team;

    private static String Class;

    public static void SetPoints(int P) {
        ClientPlayerTeamData.Points = P;
    }

    public static void SetTeam(int T) {
        ClientPlayerTeamData.Team = T;
    }

    public static void SetClass(String Selected) {
        ClientPlayerTeamData.Class = Selected;
    }

    public static int GetPoints() {
        return Points;
    }

    public static int GetTeam() {
        return Team;
    }

    public static String GetClass() {
        return Class;
    }
}

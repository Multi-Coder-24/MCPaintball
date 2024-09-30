package org.multicoder.mcpaintball.common.utility.enums;

public enum GameType
{
    TEAM,
    SOLO,
    TEAM_DEATH,
    SOLO_DEATH;

    public static String getFromOrdinal(int Ordinal){
        GameType Type = GameType.values()[Ordinal];
        switch (Type){
            case TEAM -> {
                return "Team";
            }
            case SOLO -> {
                return "Solo";
            }
            case SOLO_DEATH -> {
                return "Solo Deathmatch";
            }
            case TEAM_DEATH -> {
                return "Team Deathmatch";
            }
        }
        return "Error";
    }
}

package org.multicoder.mcpaintball.util;

public enum Teams
{
    NONE,
    RED,
    GREEN,
    BLUE,
    MAGENTA,
    PINK,
    PURPLE,
    LIME,
    LIGHT_BLUE;

    public static Teams getTeam(int T)
    {
        switch(T)
        {
            case 0:
                return NONE;
            case 1:
                return RED;
            case 2:
                return GREEN;
            case 3:
                return BLUE;
            case 4:
                return MAGENTA;
            case 5:
                return PINK;
            case 6:
                return PURPLE;
            case 7:
                return LIME;
            case 8:
                return LIGHT_BLUE;
        }
        return NONE;
    }
    public static Teams getTeam(String team)
    {
        team = team.toLowerCase();
        team = team.trim();
        if(team.equals("red")) {
            return RED;
        } else if (team.equals("blue")) {
            return BLUE;
        }else if (team.equals("green")) {
            return GREEN;
        }else if (team.equals("lime")) {
            return LIME;
        }else if (team.equals("magenta")) {
            return MAGENTA;
        }else if (team.equals("purple")) {
            return PURPLE;
        }else if (team.equals("pink")) {
            return PINK;
        }else if (team.equals("lightblue")) {
            return LIGHT_BLUE;
        }
        return NONE;
    }

    public String GetTranslationKey()
    {
        switch(this)
        {
            case RED -> {return "text.mcpaintball.team_red";}
            case BLUE -> {return "text.mcpaintball.team_blue";}
            case GREEN -> {return "text.mcpaintball.team_green";}
            case LIME -> {return "text.mcpaintball.team_lime";}
            case PINK -> {return "text.mcpaintball.team_pink";}
            case PURPLE -> {return "text.mcpaintball.team_purple";}
            case MAGENTA -> {return "text.mcpaintball.team_magenta";}
            case LIGHT_BLUE -> {return "text.mcpaintball.team_light_blue";}
        }
        return "text.mcpaintball.nill";
    }
}

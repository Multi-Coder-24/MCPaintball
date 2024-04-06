package org.multicoder.mcpaintball.util;

public enum KitType
{
    NONE,
    STANDARD,
    MEDICAL,
    HEAVY,
    TRAINEE;
    
    public static KitType GetType(String Class)
    {
        Class = Class.toLowerCase();
        if(Class.equals("standard")) {
            return STANDARD;
        } else if (Class.equals("medic")) {
            return MEDICAL;
        } else if (Class.equals("heavy")) {
            return HEAVY;
        } else if (Class.equals("trainee")) {
            return TRAINEE;
        }
        return NONE;
    }

    public String GetTranslationKey()
    {
        switch(this)
        {
            case STANDARD -> {return "text.mcpaintball.team_standard";}
            case HEAVY -> {return "text.mcpaintball.team_heavy";}
            case MEDICAL -> {return "text.mcpaintball.team_medical";}
            case TRAINEE -> {return "text.mcpaintball.team_trainee";}
        }
        return "text.mcpaintball.nill";
    }
}

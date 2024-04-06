package org.multicoder.mcpaintball.common.util.enums;

@SuppressWarnings("all")
public enum KitType {
    NONE,
    STANDARD,
    MEDICAL,
    HEAVY,
    SNIPER,
    ENGINEER;

    public static KitType GetType(String Class) {
        Class = Class.toLowerCase();
        if (Class.equals("standard")) {
            return STANDARD;
        } else if (Class.equals("medic")) {
            return MEDICAL;
        } else if (Class.equals("heavy")) {
            return HEAVY;
        } else if (Class.equals("sniper")) {
            return SNIPER;
        } else if (Class.equals("engineer")) {
            return ENGINEER;
        }
        return NONE;
    }

    public static KitType GetType(int type) {
        switch (type) {
            case 0 -> {
                return KitType.NONE;
            }
            case 1 -> {
                return KitType.STANDARD;
            }
            case 2 -> {
                return KitType.MEDICAL;
            }
            case 3 -> {
                return KitType.HEAVY;
            }
            case 4 -> {
                return KitType.SNIPER;
            }
            case 5 -> {
                return KitType.ENGINEER;
            }
        }
        return KitType.NONE;
    }

    public String GetTranslationKey() {
        switch (this) {
            case STANDARD -> {
                return "text.mcpaintball.team_standard";
            }
            case HEAVY -> {
                return "text.mcpaintball.team_heavy";
            }
            case MEDICAL -> {
                return "text.mcpaintball.team_medical";
            }
            case SNIPER -> {
                return "text.mcpaintball.team_sniper";
            }
            case ENGINEER -> {
                return "text.mcpaintball.team_engineer";
            }
        }
        return "text.mcpaintball.nil";
    }

}

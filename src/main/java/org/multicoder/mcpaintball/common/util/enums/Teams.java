package org.multicoder.mcpaintball.common.util.enums;

import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import org.multicoder.mcpaintball.common.init.blockinit;
import org.multicoder.mcpaintball.common.init.entityinit;

public enum Teams {
    NONE,
    RED,
    GREEN,
    BLUE,
    MAGENTA,
    PINK,
    PURPLE,
    LIME,
    LIGHT_BLUE,
    CYAN;
    public static Teams getTeam(int T) {
        return switch (T) {
            case 0 -> NONE;
            case 1 -> RED;
            case 2 -> GREEN;
            case 3 -> BLUE;
            case 4 -> MAGENTA;
            case 5 -> PINK;
            case 6 -> PURPLE;
            case 7 -> LIME;
            case 8 -> LIGHT_BLUE;
            case 9 -> CYAN;
            default -> NONE;
        };
    }

    public static Teams getTeam(String team) {
        team = team.toLowerCase();
        team = team.trim();
        return switch (team) {
            case "red" -> RED;
            case "blue" -> BLUE;
            case "green" -> GREEN;
            case "lime" -> LIME;
            case "magenta" -> MAGENTA;
            case "purple" -> PURPLE;
            case "pink" -> PINK;
            case "lightblue" -> LIGHT_BLUE;
            case "cyan" -> CYAN;
            default -> NONE;
        };
    }

    public String GetTranslationKey() {
        switch (this) {
            case RED -> {
                return "text.mcpaintball.team_red";
            }
            case BLUE -> {
                return "text.mcpaintball.team_blue";
            }
            case GREEN -> {
                return "text.mcpaintball.team_green";
            }
            case LIME -> {
                return "text.mcpaintball.team_lime";
            }
            case PINK -> {
                return "text.mcpaintball.team_pink";
            }
            case PURPLE -> {
                return "text.mcpaintball.team_purple";
            }
            case MAGENTA -> {
                return "text.mcpaintball.team_magenta";
            }
            case LIGHT_BLUE -> {
                return "text.mcpaintball.team_light_blue";
            }
            case CYAN -> {
                return "text.mcpaintball.team_cyan";
            }
        }
        return "text.mcpaintball.nil";
    }

    public EntityType<?> GetPaintball() {
        switch (this) {
            case RED -> {
                return entityinit.RED_PAINTBALL.get();
            }
            case BLUE -> {
                return entityinit.BLUE_PAINTBALL.get();
            }
            case GREEN -> {
                return entityinit.GREEN_PAINTBALL.get();
            }
            case LIME -> {
                return entityinit.LIME_PAINTBALL.get();
            }
            case MAGENTA -> {
                return entityinit.MAGENTA_PAINTBALL.get();
            }
            case LIGHT_BLUE -> {
                return entityinit.LIGHT_BLUE_PAINTBALL.get();
            }
            case PURPLE -> {
                return entityinit.PURPLE_PAINTBALL.get();
            }
            case PINK -> {
                return entityinit.PINK_PAINTBALL.get();
            }
            case CYAN -> {
                return entityinit.CYAN_PAINTBALL.get();
            }
        }
        return null;
    }

    public EntityType<?> GetGrenade() {
        switch (this) {
            case RED -> {
                return entityinit.RED_GRENADE.get();
            }
            case BLUE -> {
                return entityinit.BLUE_GRENADE.get();
            }
            case GREEN -> {
                return entityinit.GREEN_GRENADE.get();
            }
            case LIME -> {
                return entityinit.LIME_GRENADE.get();
            }
            case MAGENTA -> {
                return entityinit.MAGENTA_GRENADE.get();
            }
            case LIGHT_BLUE -> {
                return entityinit.LIGHT_BLUE_GRENADE.get();
            }
            case PURPLE -> {
                return entityinit.PURPLE_GRENADE.get();
            }
            case PINK -> {
                return entityinit.PINK_GRENADE.get();
            }
            case CYAN -> {
                return entityinit.CYAN_GRENADE.get();
            }
        }
        return null;
    }

    public float GetModelIndex() {
        switch (this) {
            case RED -> {
                return 0.01f;
            }
            case BLUE -> {
                return 0.03f;
            }
            case GREEN -> {
                return 0.02f;
            }
            case LIME -> {
                return 0.07f;
            }
            case PINK -> {
                return 0.05f;
            }
            case MAGENTA -> {
                return 0.04f;
            }
            case PURPLE -> {
                return 0.06f;
            }
            case LIGHT_BLUE -> {
                return 0.08f;
            }
            case CYAN -> {
                return 0.09f;
            }
        }
        return 0f;
    }

    public EntityType<?> GetHeavy() {
        switch (this) {
            case RED -> {
                return entityinit.RED_PAINTBALL_HEAVY.get();
            }
            case BLUE -> {
                return entityinit.BLUE_PAINTBALL_HEAVY.get();
            }
            case GREEN -> {
                return entityinit.GREEN_PAINTBALL_HEAVY.get();
            }
            case LIME -> {
                return entityinit.LIME_PAINTBALL_HEAVY.get();
            }
            case MAGENTA -> {
                return entityinit.MAGENTA_PAINTBALL_HEAVY.get();
            }
            case LIGHT_BLUE -> {
                return entityinit.LIGHT_BLUE_PAINTBALL_HEAVY.get();
            }
            case PURPLE -> {
                return entityinit.PURPLE_PAINTBALL_HEAVY.get();
            }
            case PINK -> {
                return entityinit.PINK_PAINTBALL_HEAVY.get();
            }
            case CYAN -> {
                return entityinit.CYAN_PAINTBALL_HEAVY.get();
            }
        }
        return null;
    }

    public Block GetExplosive() {
        switch (this) {
            case RED -> {
                return blockinit.RED_EXPLOSIVE.get();
            }
            case BLUE -> {
                return blockinit.BLUE_EXPLOSIVE.get();
            }
            case GREEN -> {
                return blockinit.GREEN_EXPLOSIVE.get();
            }
            case LIME -> {
                return blockinit.LIME_EXPLOSIVE.get();
            }
            case MAGENTA -> {
                return blockinit.MAGENTA_EXPLOSIVE.get();
            }
            case LIGHT_BLUE -> {
                return blockinit.LIGHT_BLUE_EXPLOSIVE.get();
            }
            case PURPLE -> {
                return blockinit.PURPLE_EXPLOSIVE.get();
            }
            case PINK -> {
                return blockinit.PINK_EXPLOSIVE.get();
            }
            case CYAN -> {
                return blockinit.CYAN_EXPLOSIVE.get();
            }
        }
        return null;
    }

    public ChatFormatting getColor() {
        switch (this) {
            case RED -> {
                return ChatFormatting.DARK_RED;
            }
            case BLUE -> {
                return ChatFormatting.DARK_BLUE;
            }
            case GREEN -> {
                return ChatFormatting.DARK_GREEN;
            }
            case LIME -> {
                return ChatFormatting.GREEN;
            }
            case LIGHT_BLUE -> {
                return ChatFormatting.AQUA;
            }
            case CYAN -> {
                return ChatFormatting.DARK_AQUA;
            }
            case PURPLE -> {
                return ChatFormatting.BLUE;
            }
            case MAGENTA -> {
                return ChatFormatting.DARK_PURPLE;
            }
            case PINK -> {
                return ChatFormatting.LIGHT_PURPLE;
            }
        }
        return ChatFormatting.BLACK;
    }
}

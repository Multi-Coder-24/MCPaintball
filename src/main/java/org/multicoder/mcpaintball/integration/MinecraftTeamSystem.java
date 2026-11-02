package org.multicoder.mcpaintball.integration;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Team;

public class MinecraftTeamSystem {
    public static PlayerTeam RED;
    public static PlayerTeam GREEN;
    public static PlayerTeam BLUE;
    public static PlayerTeam CYAN;
    public static PlayerTeam MAGENTA;
    public static PlayerTeam YELLOW;
    public static PlayerTeam PINK;
    public static PlayerTeam LIME;
    public static PlayerTeam LIGHT_BLUE;
    public static PlayerTeam LIGHT_GRAY;
    public static PlayerTeam GRAY;
    public static PlayerTeam WHITE;
    public static PlayerTeam BLACK;
    public static PlayerTeam BROWN;
    public static PlayerTeam PURPLE;
    public static PlayerTeam ORANGE;

    public static void init(MinecraftServer server) {
        if(!server.getScoreboard().getTeamNames().contains(Component.translatable("text.mcpaintball.team_red").getString())){
            RED = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_red").getString());
            GREEN = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_green").getString());
            BLUE = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_blue").getString());
            CYAN= server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_cyan").getString());
            MAGENTA = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_magenta").getString());
            YELLOW = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_yellow").getString());
            PINK = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_pink").getString());
            LIME = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_lime").getString());
            LIGHT_BLUE = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_light_blue").getString());
            LIGHT_GRAY = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_light_gray").getString());
            GRAY = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_gray").getString());
            WHITE = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_white").getString());
            BLACK = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_black").getString());
            BROWN = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_brown").getString());
            PURPLE = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_purple").getString());
            ORANGE = server.getScoreboard().addPlayerTeam(Component.translatable("text.mcpaintball.team_orange").getString());
        }else {
            RED = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_red").getString());
            GREEN = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_green").getString());
            BLUE = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_blue").getString());
            CYAN = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_cyan").getString());
            MAGENTA = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_magenta").getString());
            YELLOW = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_yellow").getString());
            PINK = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_pink").getString());
            LIME = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_lime").getString());
            LIGHT_BLUE = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_light_blue").getString());
            LIGHT_GRAY = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_light_gray").getString());
            GRAY = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_gray").getString());
            WHITE = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_white").getString());
            BLACK = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_black").getString());
            BROWN = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_brown").getString());
            PURPLE = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_purple").getString());
            ORANGE = server.getScoreboard().getPlayerTeam(Component.translatable("text.mcpaintball.team_orange").getString());
        }
        RED.setColor(ChatFormatting.DARK_RED);
        GREEN.setColor(ChatFormatting.DARK_GREEN);
        BLUE.setColor(ChatFormatting.DARK_BLUE);
        CYAN.setColor(ChatFormatting.DARK_AQUA);
        MAGENTA.setColor(ChatFormatting.DARK_PURPLE);
        YELLOW.setColor(ChatFormatting.YELLOW);
        PINK.setColor(ChatFormatting.LIGHT_PURPLE);
        LIME.setColor(ChatFormatting.GREEN);
        LIGHT_BLUE.setColor(ChatFormatting.AQUA);
        LIGHT_GRAY.setColor(ChatFormatting.GRAY);
        GRAY.setColor(ChatFormatting.DARK_GRAY);
        WHITE.setColor(ChatFormatting.WHITE);
        BLACK.setColor(ChatFormatting.BLACK);
        BROWN.setColor(ChatFormatting.GOLD);
        WHITE.setColor(ChatFormatting.BLUE);
        ORANGE.setColor(ChatFormatting.RED);

        RED.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        GREEN.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        BLUE.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        BLUE.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        BLUE.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        YELLOW.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        PINK.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        LIME.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        LIGHT_BLUE.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        LIGHT_GRAY.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        GRAY.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        WHITE.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        BROWN.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        BLACK.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        PURPLE.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        ORANGE.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
    }
}

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
    public static PlayerTeam YELLOW;
    public static PlayerTeam PINK;
    public static PlayerTeam ORANGE;

    public static void init(MinecraftServer server) {
        if(!server.getScoreboard().getTeamNames().contains("Red")){
            RED = server.getScoreboard().addPlayerTeam("Red");
            GREEN = server.getScoreboard().addPlayerTeam("Green");
            BLUE = server.getScoreboard().addPlayerTeam("Blue");
            YELLOW = server.getScoreboard().addPlayerTeam("Yellow");
            PINK = server.getScoreboard().addPlayerTeam("Pink");
            ORANGE = server.getScoreboard().addPlayerTeam("Orange");
        }else {
            RED = server.getScoreboard().getPlayerTeam("Red");
            GREEN = server.getScoreboard().getPlayerTeam("Green");
            BLUE = server.getScoreboard().getPlayerTeam("Blue");
            YELLOW = server.getScoreboard().getPlayerTeam("Yellow");
            PINK = server.getScoreboard().getPlayerTeam("Pink");
            ORANGE = server.getScoreboard().getPlayerTeam("Orange");
        }
        RED.setColor(ChatFormatting.DARK_RED);
        GREEN.setColor(ChatFormatting.DARK_GREEN);
        BLUE.setColor(ChatFormatting.DARK_BLUE);
        YELLOW.setColor(ChatFormatting.YELLOW);
        PINK.setColor(ChatFormatting.LIGHT_PURPLE);
        ORANGE.setColor(ChatFormatting.GOLD);

        RED.setPlayerPrefix(Component.translatable("team.mcpaintball.pre"));
        GREEN.setPlayerPrefix(Component.translatable("team.mcpaintball.pre"));
        BLUE.setPlayerPrefix(Component.translatable("team.mcpaintball.pre"));
        YELLOW.setPlayerPrefix(Component.translatable("team.mcpaintball.pre"));
        PINK.setPlayerPrefix(Component.translatable("team.mcpaintball.pre"));
        ORANGE.setPlayerPrefix(Component.translatable("team.mcpaintball.pre"));

        RED.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        GREEN.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        BLUE.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        YELLOW.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        PINK.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
        ORANGE.setNameTagVisibility(Team.Visibility.HIDE_FOR_OWN_TEAM);
    }
}
